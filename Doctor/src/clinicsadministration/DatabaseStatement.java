package clinicsadministration;

import java.util.Vector;

public class DatabaseStatement {

    static Vector<String> databasestatement = new Vector();

    public static void initialVectordatabasestatement() {
//        databasestatement.add("CREATE TABLE clincname(\n"
//                + "	id INTEGER PRIMARY KEY AUTOINCREMENT,\n"
//                + " 	name VARCHAR(30) NOT NULL,\n"
//                + " 	price INT \n"
//                + "	);");
//        databasestatement.add("CREATE TABLE clincservice (\n"
//                + "	id INTEGER, \n"
//                + "	name VARCHAR(30) NOT NULL, \n"
//                + "	price INT,\n"
//                + "	description VARCHAR(50),\n"
//                + "	FOREIGN KEY(id) REFERENCES clincname(id) \n"
//                + "	);");
//        databasestatement.add("CREATE TABLE doctors(\n"
//                + "	id INTEGER PRIMARY KEY AUTOINCREMENT,\n"
//                + "	name VARCHAR(30),\n"
//                + "	address VARCHAR(30),\n"
//                + "	phone VARCHAR(20),\n"
//                + "	email VARCHAR(30),\n"
//                + "	special INTEGER,\n"
//                + "	sex INT,\n"
//                + "	salary INT,\n"
//                + "	period INT,\n"
//                + "	imagename VARCHAR(30),\n"
//                + "	imagefile MEDIUMBLOB,\n"
//                + "	FOREIGN KEY(special) REFERENCES clincname(id)\n"
//                + "	);");
//        databasestatement.add("CREATE TABLE employee(\n"
//                + "	id INTEGER PRIMARY KEY AUTOINCREMENT,\n"
//                + "	name VARCHAR(30),\n"
//                + "	address VARCHAR(30),\n"
//                + "	phone VARCHAR(20),\n"
//                + "	email VARCHAR(30),\n"
//                + "	jobname VARCHAR(30),\n"
//                + "	salary INT,\n"
//                + "	sex INT,\n"
//                + "	ssd VARCHAR(35),\n"
//                + "	datebegain VARCHAR(12),\n"
//                + "	imagename VARCHAR(30),\n"
//                + "	imagefile MEDIUMBLOB\n"
//                + "	);");
//        databasestatement.add("CREATE TABLE expenserecord(\n"
//                + "	id INTEGER PRIMARY KEY AUTOINCREMENT,\n"
//                + "	name VARCHAR(30),\n"
//                + "	price INT,\n"
//                + "	date VARCHAR(12),\n"
//                + "	description VARCHAR(50)\n"
//                + "	);");
//        databasestatement.add("CREATE TABLE patient(\n"
//                + "	id INTEGER PRIMARY KEY AUTOINCREMENT,\n"
//                + "	name VARCHAR(30),\n"
//                + "	address VARCHAR(30),\n"
//                + "	phone VARCHAR(20),\n"
//                + "	email VARCHAR(30),\n"
//                + "	birthdate VARCHAR(12),\n"
//                + "	sex INT\n"
//                + "	);");
//        databasestatement.add("CREATE TABLE patientclinic(\n"
//                + "	id INTEGER,\n"
//                + "	clinicid INTEGER,\n"
//                + "	visitdate VARCHAR(12),\n"
//                + "	visitnumber INT,\n"
//                + "	doctorid INTEGER,\n"
//                + "	notes VARCHAR(50),\n"
//                + "	FOREIGN KEY(id) REFERENCES patient(id),\n"
//                + "	FOREIGN KEY(clinicid) REFERENCES clincname(id),\n"
//                + "	FOREIGN KEY(doctorid) REFERENCES doctors(id)\n"
//                + "	);");
//        databasestatement.add("CREATE TABLE patientservice(\n"
//                + "	id INTEGER,\n"
//                + "	name VARCHAR(30) NOT NULL, \n"
//                + "	price INT,\n"
//                + "	FOREIGN KEY(id) REFERENCES patient(id)\n"
//                + "	);");
//        databasestatement.add("CREATE TABLE patientaccounts(\n"
//                + "	id INTEGER,\n"
//                + "	value INT,\n"
//                + "	rest INT,\n"
//                + "	FOREIGN KEY(id) REFERENCES patient(id)\n"
//                + "	);");
//        databasestatement.add("CREATE TABLE patientdoctor(\n"
//                + "	patientid INTEGER,\n"
//                + "	doctorid INTEGER,\n"
//                + "	price INT,\n"
//                + "	FOREIGN KEY(patientid) REFERENCES patient(id),\n"
//                + "	FOREIGN KEY(doctorid) REFERENCES doctors(id)\n"
//                + "	);");
//        databasestatement.add("CREATE TABLE next(\n"
//                + "	id INTEGER PRIMARY KEY AUTOINCREMENT,\n"
//                + "	name VARCHAR(30),\n"
//                + "	clinecname VARCHAR(30),\n"
//                + "	doctorname VARCHAR(30),\n"
//                + "	date VARCHAR(14),\n"
//                + "	time VARCHAR(14)\n"
//                + "	)");
//        databasestatement.add("CREATE TABLE users(\n"
//                + "	id INTEGER PRIMARY KEY AUTOINCREMENT,\n"
//                + "	name VARCHAR(50),\n"
//                + "	password VARCHAR(20),\n"
//                + "	states INT\n"
//                + "	);");
//        databasestatement.add("CREATE TABLE permistion (\n"
//                + "	id INTEGER,\n"
//                + "	btnnumber INT,\n"
//                + "	FOREIGN KEY(id) REFERENCES users(id)\n"
//                + "	);");
//        databasestatement.add("CREATE TABLE accountemployee(\n"
//                + "	id INTEGER,\n"
//                + "	value VARCHAR(5),\n"
//                + "	date VARCHAR(14),\n"
//                + "	notes VARCHAR(70),\n"
//                + "	FOREIGN KEY(id) REFERENCES employee(id)\n"
//                + "	);");
//        databasestatement.add("CREATE TABLE settings(\n"
//                + "	id INTEGER PRIMARY KEY AUTOINCREMENT,\n"
//                + "	name VARCHAR(50),\n"
//                + "	value VARCHAR(50)\n"
//                + "	);");
//        databasestatement.add("INSERT INTO settings(name, value) VALUES('clienc name', 'Doctorito');");
//        databasestatement.add("INSERT INTO settings(name, value) VALUES('backgroundred', '153');");
//        databasestatement.add("INSERT INTO settings(name, value) VALUES('backgroundgreen', '0');"); 
//        databasestatement.add("INSERT INTO settings(name, value) VALUES('backgroundblue', '153');");
//        databasestatement.add("INSERT INTO settings(name, value) VALUES('backgroundpanelred', '0');");
//        databasestatement.add("INSERT INTO settings(name, value) VALUES('backgroundpanelgreen', '204');");
//        databasestatement.add("INSERT INTO settings(name, value) VALUES('backgroundpanelblue', '204');"); 
//        databasestatement.add("INSERT INTO settings(name, value) VALUES('backgroundname', 'background.png');");
    }

    public static void main(String[] arg) {
        initialVectordatabasestatement();
        for (int i = 0; i < databasestatement.size(); i++) {
            boolean check = Tools.ExecuteStatement(databasestatement.get(i));
            if (check) {
                System.out.println((i + 1) + " -successfully");
            } else {
                System.out.println((i + 1) + " -failed");
            }
        }
    }

}
