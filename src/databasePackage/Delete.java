package databasePackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class Delete {

	public static Boolean sqliteDatabase(String DatabaseName, String sql) 
	{
		try{
			Connection c = null; 
			Class.forName("org.sqlite.JDBC");
			c=DriverManager.getConnection("jdbc:sqlite:"+DatabaseName);
			Statement stmt = null; 			
			stmt = c.createStatement(); 		
			stmt.executeUpdate(sql); 			
			stmt.close();
			c.close();	
		}catch(Exception eSqliteDatabase){
			JOptionPane.showMessageDialog(null, "Sorry some thing is wrong  ", "error misage", 0, null);
			return false;}
		return true;	
	}
	
	public static Boolean deleteFromAddressTable(String postalcode)
	{
		String sql;
		sql="delete from Address where postalcode in ('";
		sql+=postalcode + "');";
		sqliteDatabase("MyList.db", sql);				
		return true;
	}
		
	public static Boolean deleteFromPersonTables(String personId)
	{
		String sql;
		sql="delete from Person where personId in ('";
		sql+=personId + "');";						
		sqliteDatabase("MyList.db", sql);   
		return true;
	}
	public static Boolean deleteFromPersonAddressTables(String personId, String postalcode) 
	{
		String sql;
		sql="delete from PersonAddress where personId in ('";
		sql+=personId + "') and postalcode in('"+postalcode+"');";			
		sqliteDatabase("MyList.db", sql);  		
		return true;
	}
	public static Boolean deleteFromPersonMailTables(String personId, String mail ) 
	{
		String sql;
		sql="delete from PersonMail where personId in ('";
		sql+=personId + "') and mail in('"+mail+"');";			
		sqliteDatabase("MyList.db", sql);				
		return true;
	}
	public static Boolean deleteFromPersonCellPhoneTables(String personId, String cellphone) 
	{
		String sql;
		sql="delete from PersonCellPhone where personId in ('";
		sql+=personId + "') and cellphone in('"+cellphone+"');";			
		sqliteDatabase("MyList.db", sql);				
		return true;
	}
	public static Boolean deleteFromStudentTables(String studentNumber) 
	{
		String sql;
		sql="delete from student where studentNumber in ('";
		sql+=studentNumber +"');";
		sqliteDatabase("MyList.db",sql);
		return true;
	}
	public static Boolean deleteFromStudentLessonTables(String studentNumber, String lessonName) 
	{
		String sql;
		sql="delete from StudentLesson where studentNumber in ('";
		sql+=studentNumber + "') and lessonName in('"+lessonName+"');";
		sqliteDatabase("MyList.db", sql);
		return true;
	}
	public static Boolean deleteAllTable() 
	{
		String sql;
		sql="drop table address;";
		sql+="drop table Person;";
		sql+="drop table PersonAddress;";
		sql+="drop table PersonMail;";
		sql+="drop table PersonCellPhone;";
		sql+="drop table Student;";
		sql+="drop table StudentLesson;";
		
		sqliteDatabase("MyList.db", sql);
		return true;
	}

}
