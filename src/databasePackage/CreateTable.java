package databasePackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class CreateTable {
	
	public static Boolean sqliteDatabase(String DatabaseName, String sql) 
	{
		try{
			Connection c = null; 
			Class.forName("org.sqlite.JDBC");
			c=DriverManager.getConnection("jdbc:sqlite:"+DatabaseName);
			Statement stmt = null; 			
			c.setAutoCommit(false);   
			stmt = c.createStatement(); 			
			stmt.executeUpdate(sql); 			
			stmt.close();
			c.commit();
			c.close();	
		}catch(Exception eSqliteDatabase)
		{
			JOptionPane.showMessageDialog(null, "Sorry some thing is wrong  ", "error misage", 0, null);
		                                
		                                return false;
		}
		return true;	
	}
	public static Boolean createAddressTables() 
	{
		String sql;
		sql="";
		sql+="create table if not exists Address (postalcode text primary key not null, appartment text ,building text,";
		sql+="city text, country text ,street text );";
		sqliteDatabase("MyList.db", sql);	
		return true;
	}
	public static Boolean createPersonTables() 
	{
		String sql;
		sql="";
		sql+="create table if not exists Person (personId text primary key not null, firstname text , ";
		sql+=" lastname text ,birthday date );";
		sqliteDatabase("MyList.db", sql);   
		return true;
	}
	public static Boolean createPersonAddressTables() 
	{
		String sql;
		sql="";
		sql+="create table if not exists PersonAddress (personId text  not null, postalcode text not null,";
		sql+="CONSTRAINT con1  primary KEY (personId, postalcode) ," ;
		sql+="CONSTRAINT con2  FOREIGN KEY (postalcode) REFERENCES Address (postalcode) ," ;
		sql+="CONSTRAINT con3  FOREIGN KEY (personId) REFERENCES Person (personId) );" ;
		sqliteDatabase("MyList.db", sql);  			
		return true;
	}
	public static Boolean createPersonMailTables() 
	{
		String sql;
		sql="";
		sql+="create table if not exists PersonMail (personId text  not null, mail text not null,";
		sql+="CONSTRAINT con4  primary KEY (personId, mail) ," ;
		sql+="CONSTRAINT con5  FOREIGN KEY (personId) REFERENCES Person (personId) );" ;
		sqliteDatabase("MyList.db", sql);		
		return true;
	}
	public static Boolean createPersonCellPhoneTables() 
	{
		String sql;
		sql="";
		sql+="create table if not exists PersonCellPhone (personId text not null , cellphone text not null,";
		sql+="CONSTRAINT con6  primary KEY (personId, cellphone) ," ;
		sql+="CONSTRAINT con7  FOREIGN KEY (personId) REFERENCES Person (personId) );" ;
		sqliteDatabase("MyList.db", sql);		
		return true;
	}
	public static Boolean createStudentTables() 
	{
		String sql;
		sql="";
		sql+="create table if not exists Student (studentNumber text primary key not null, personId text , ";	
		sql+="CONSTRAINT con8  FOREIGN KEY (personId) REFERENCES Person (personId) );" ;
		sqliteDatabase("MyList.db",sql );	
		return true;
	}
	public static Boolean createStudentLessonTables() 
	{
		String sql;
		sql="";
		sql+="create table if not exists StudentLesson (lessonName text not null,studentNumber text not null, mintermExam Double ,";
		sql+=" FinalExam Double , Project Double ,";
		sql+="CONSTRAINT con9  primary KEY (lessonName, studentNumber) ," ;
		sql+="CONSTRAINT con10  FOREIGN KEY (studentNumber) REFERENCES Student (studentNumber) );" ;
		sqliteDatabase("MyList.db", sql);	
		return true;
	}
	public static Boolean createAllTables() 
	{
		createAddressTables();
		createPersonTables();
		createPersonAddressTables();
		createPersonMailTables();
		createPersonCellPhoneTables();
		createStudentTables();
		createStudentLessonTables();			
		return true;
	}
}
