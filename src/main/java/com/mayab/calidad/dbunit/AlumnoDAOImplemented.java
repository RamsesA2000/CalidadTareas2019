package com.mayab.calidad.dbunit;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class AlumnoDAOImplemented implements AlumnoDao {

	public String addAlumno(Alumno alumno) {
		try{
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Calidad"
					+ "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "cardinal");
			Statement st;
			st = (Statement) conn.createStatement();
			boolean isEx = st.execute("INSERT INTO Alumno (name, lastName, age, avg) VALUES ("
					+ "'Jose', "
					+ "'Rasgado' ,"
					+ "20, " 
					+ "9.57);");
			conn.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return "Usuario agregado exitosamente";
	}
	

	public String removeAlumno(Alumno alumno) {
		try{
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Calidad"
					+ "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "cardinal");
			Statement st;
			st = (Statement) conn.createStatement();
			boolean isEx = st.execute("DELETE * FROM Alumno WHERE id = " + alumno.id);
			conn.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return "Usuario removido exitosamente";
	}

	public String updatePromedioAlumno(Alumno alumno) {
		// TODO Auto-generated method stub
		return null;
	}

	public String getAlumno(Alumno alumno) {
		// TODO Auto-generated method stub
		return null;
	}

}
