package clinicsadministration;

import java.sql.ResultSet;
import java.util.Vector;

public class Main {

    public static void main(String arg[]) {
//        Vector<String> v = new Vector();
//        for (int i = 0; i < 12; i++) {
//            v.add((i + 1) + "");
//        }
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new ClinicsAdministration(v).setVisible(true);
//            }
//        });
        ResultSet rs = Tools.select_query("SELECT * FROM settings ;");
        try{
            while(rs.next()){
                System.out.println(rs.getString(1) + "\t" + rs.getString(2) + "\t" + rs.getString(3));
            }
        }catch(Exception ex){}
        
    }
}
