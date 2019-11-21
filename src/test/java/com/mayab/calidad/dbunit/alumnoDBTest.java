package com.mayab.calidad.dbunit;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import org.dbunit.DBTestCase;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.operation.DatabaseOperation;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.dbunit.PropertiesBasedJdbcDatabaseTester;
import org.dbunit.database.IDatabaseConnection;

public class alumnoDBTest extends DBTestCase{
	
	public alumnoDBTest(String name){
		super( name );
		System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_DRIVER_CLASS, "com.mysql.jdbc.Driver");
		System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_CONNECTION_URL, "jdbc:mysql://localhost:3306/Calidad"
		+ "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC");
		System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_USERNAME, "root");
		System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_PASSWORD, "cardinal");
		
		
		/*
		 * try{
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Calidad"
					+ "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "cardinal");
			Statement st;
			st = (Statement) conn.createStatement();
			boolean isEx = st.execute("INSERT INTO Alumno (name, lastName, age, avg) VALUES ("
					+ "'ramses', "
					+ "'martinez' ,"
					+ "19, " 
					+ "9.57);");
			conn.close();
		}catch(Exception e){
			e.printStackTrace();
			
		}*/
			
	}
	
	@Before
	public void importDataSet() throws Exception{
		IDatabaseConnection conn =getConnection();
		
		try{
			
			DatabaseOperation.CLEAN_INSERT.execute(conn, getDataSet());
			
		}finally{
			
			conn.close();
			
		}
	}
	
	@Override
	protected IDataSet getDataSet() throws Exception {
		InputStream xmlFile = getClass().getResourceAsStream("/data.xml");
		return new FlatXmlDataSetBuilder().build(xmlFile);
	}
	

	@Test
	public void test() throws Exception {
		IDatabaseConnection conn = getConnection();
		assertEquals(0, conn.getRowCount("Alumno"));
		conn.close();
	}
}