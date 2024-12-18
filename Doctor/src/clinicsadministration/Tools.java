package clinicsadministration;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Vector;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class Tools {

    private static Connection con = null;
    private static DefaultTableCellRenderer renderer = null;

    public static Connection connectToSqlite() {
        try {
            Class.forName("org.sqlite.JDBC");
//            if (con == null) {
                con = DriverManager.getConnection("jdbc:sqlite:Clinc_Administration.db");
//            }
        } catch (Exception ex) {
        }
        return con;
    }

    public static void closeConnection() {
        try {
            con.close();
        } catch (Exception ex) {
        }
    }

    public static boolean ExecuteStatement(String statement) {
        try {
            connectToSqlite();
            PreparedStatement pstmt = con.prepareStatement(statement);
            pstmt.execute();
            closeConnection();
            return true;
        } catch (Exception e) {
            closeConnection();
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e, "ExecuteStatement Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    public static ResultSet select_query(String statement) {
        connectToSqlite();
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(statement);
            return rs;
        } catch (SQLException ex) {
            closeConnection();
            JOptionPane.showMessageDialog(null, ex, "select_query Error", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }

    public static byte[] getImageByte(String statement) {
        byte[] show = null;
        if (!statement.isEmpty()) {
            ResultSet rs = select_query(statement);
            try {
                while (rs.next()) {
                    show = rs.getBytes(1);
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return show;
    }

    public static ImageIcon getImageIcon(String statement) {
        ImageIcon image = null;
        try {
            byte[] show = getImageByte(statement);
            image = new ImageIcon(show);
        } catch (Exception ex) {
        }
        Tools.closeConnection();
        return image;
    }

    public static void importfile(String statement, String path, String filename) {
        String absolutepath = path + filename;
        try {
            byte[] show = getImageByte(statement);
            FileOutputStream out = new FileOutputStream(absolutepath);
            out.write(show);
            out.close();
        } catch (Exception ex) {
        }
    }

    public static boolean ExecuteStatementWithPicture(String statement, String fullpath) {
        //statement = "INSERT INTO product(name, price, date, file) VALUES ('mouse', '500', '31/8/2021', ?) ;";
        try {
            connectToSqlite();
            byte[] save_image = null;
            String path = fullpath;
            BufferedImage bufImg = null;
            File image = new File(path);
            FileInputStream fis = new FileInputStream(image);
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            byte[] buf = new byte[1024];
            for (int readnum; (readnum = fis.read(buf)) != -1;) {
                bos.write(buf, 0, readnum);
            }
            save_image = bos.toByteArray();
            PreparedStatement ps = con.prepareStatement(statement);
            ps.setBytes(1, save_image);
            ps.execute();
            closeConnection();
            return true;
        } catch (Exception e) {
            closeConnection();
            JOptionPane.showMessageDialog(null, e, "ExecuteStatement Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    public static String pathSelectFileChooser() {
        String path = "";
        try {
            JFileChooser chooser = new JFileChooser();
            FileNameExtensionFilter filter = new FileNameExtensionFilter("images", "jpg", "PNG");
            chooser.setFileFilter(filter);
            int returnedValue = chooser.showOpenDialog(null);
            if (returnedValue == JFileChooser.APPROVE_OPTION) {
                File fileToSave = chooser.getSelectedFile();
                path = fileToSave.getAbsolutePath();
                if (path.endsWith(".jpg") || path.endsWith(".JPG") || path.endsWith(".PNG") || path.endsWith(".png")) {
                    return path;
                } else {
                    JOptionPane.showMessageDialog(null, "you must select only images");
                }
            }
        } catch (Exception ex) {
        }
        return path;
    }

    public static String pathSelectDatabaseFile() {
        String path = "";
        try {
            JFileChooser chooser = new JFileChooser();
            FileNameExtensionFilter filter = new FileNameExtensionFilter("Database", "db");
            chooser.setFileFilter(filter);
            int returnedValue = chooser.showOpenDialog(null);
            if (returnedValue == JFileChooser.APPROVE_OPTION) {
                File fileToSave = chooser.getSelectedFile();
                path = fileToSave.getAbsolutePath();
                if (path.endsWith(".db")) {
                    return path;
                } else {
                    JOptionPane.showMessageDialog(null, "you must select only Database file");
                }
            }
        } catch (Exception ex) {
        }
        return path;
    }

    public static String pathSaveFileChooser(String name) {
        String path = "";
        try {
            JFileChooser chooser = new JFileChooser();
            chooser.setSelectedFile(new File(name));
            int returnedValue = chooser.showSaveDialog(null);
            if (returnedValue == JFileChooser.APPROVE_OPTION) {
                path = chooser.getSelectedFile().getAbsolutePath();
            }
        } catch (Exception ex) {
        }
        return path;
    }

    public static void copyDirectory(File sourceLocation, File targetLocation)
            throws IOException {
        if (sourceLocation.isDirectory()) {
            if (!targetLocation.exists()) {
                targetLocation.mkdir();
            }
            String[] children = sourceLocation.list();
            for (int i = 0; i < children.length; i++) {
                copyDirectory(new File(sourceLocation, children[i]),
                        new File(targetLocation, children[i]));
            }
        } else {
            InputStream in = new FileInputStream(sourceLocation);
            OutputStream out = new FileOutputStream(targetLocation);
            // Copy the bits from instream to outstream
            byte[] buf = new byte[1024];
            int len;
            while ((len = in.read(buf)) > 0) {
                out.write(buf, 0, len);
            }
            in.close();
            out.close();
        }
    }

    public static void tableUpdate(DefaultTableModel model, String statement, int column) {
        try {
            model.setRowCount(0);
            ResultSet rs = select_query(statement);
            while (rs.next()) {
                Vector arr_table = new Vector();
                for (int i = 1; i <= column; i++) {
                    arr_table.add(rs.getString(i));
                }
                model.addRow(arr_table);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        closeConnection();
    }

    public static void HeaderRendererCenter(JTable table) {
        renderer = (DefaultTableCellRenderer) table.getTableHeader().getDefaultRenderer();
        renderer.setHorizontalAlignment(JLabel.CENTER);
    }

    public static void rowRenderCenter(JTable table) {
        renderer = new DefaultTableCellRenderer();
        renderer.setHorizontalAlignment(JLabel.CENTER);
        for (int i = 0; i < table.getColumnCount(); i++) {
            table.getColumnModel().getColumn(i).setCellRenderer(renderer);
        }
    }

    public static String date() {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("d/M/y");
        return sdf.format(date);
    }

    public static String time() {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("h:m:s a");
        return sdf.format(date);
    }

    public static void main(String[] arg) {
        System.out.println(time());
        System.out.println(date());
    }

    public static String[] get7Days() {
        SimpleDateFormat sdf = new SimpleDateFormat("d/M/y");
        Calendar cal = Calendar.getInstance();
        Date date = cal.getTime();
        String[] days = new String[7];
        days[0] = sdf.format(date);
        for (int i = 1; i < 7; i++) {
            cal.add(Calendar.DAY_OF_MONTH, -1);
            date = cal.getTime();
            days[i] = sdf.format(date);
        }
        return days;
    }

    public static Vector getPanelBackGroundColor() {
        Vector arr = new Vector();
        String statement = "SELECT value FROM settings WHERE id = 5 OR id = 6 OR id = 7 ;";
        ResultSet rs = Tools.select_query(statement);
        try {
            while (rs.next()) {
                arr.add(rs.getString(1));
            }
            Tools.closeConnection();
        } catch (Exception ex) {
        }
        return arr;
    }

    public static void setComponentBackGroundColor(JComponent comp) {
        Vector arr = getPanelBackGroundColor();
        int r = Integer.parseInt(String.valueOf(arr.get(0)));
        int g = Integer.parseInt(String.valueOf(arr.get(1)));
        int b = Integer.parseInt(String.valueOf(arr.get(2)));
        comp.setBackground(new Color(r, g, b));
    }

    public static void setScrollBackGroundColor(JScrollPane pane) {
        Vector arr = getPanelBackGroundColor();
        int r = Integer.parseInt(String.valueOf(arr.get(0)));
        int g = Integer.parseInt(String.valueOf(arr.get(1)));
        int b = Integer.parseInt(String.valueOf(arr.get(2)));
        pane.getViewport().setBackground(new Color(r, g, b));
    }

    public static void setFrameBackGroundColor(JFrame frame) {
        Vector arr = getPanelBackGroundColor();
        int r = Integer.parseInt(String.valueOf(arr.get(0)));
        int g = Integer.parseInt(String.valueOf(arr.get(1)));
        int b = Integer.parseInt(String.valueOf(arr.get(2)));
        frame.getContentPane().setBackground(new Color(r, g, b));
    }

    public static void setImagePanel() {
        ClinicsAdministration.panel.removeAll();
        ClinicsAdministration.panel.revalidate();
        ClinicsAdministration.panel.repaint();
        ImagePanel Ip = new ImagePanel();
        Ip.setBounds(0, 0, 1100, 700);
        ClinicsAdministration.panel.add(Ip);
        Ip.setVisible(true);
    }

}
