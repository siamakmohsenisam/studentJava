package databasePackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.swing.JOptionPane;

import personpackage.Address;
import personpackage.Person;
import studpackage.Lesson;
import studpackage.Student;
import testpackage.StudentList;

public class WriteToDatabase {
	

	public static Boolean sqliteDatabase(String DatabaseName, String sql) 
	{
		try{
			Connection connection = null; 
			Class.forName("org.sqlite.JDBC");
			connection=DriverManager.getConnection("jdbc:sqlite:"+DatabaseName);
			Statement statement = null; 
			statement = connection.createStatement(); 
			statement.executeUpdate(sql); 			
			statement.close();
			connection.close();	
		}catch(Exception eSqliteDatabase){
			JOptionPane.showMessageDialog(null, "Sorry some thing is wrong  ", "error misage", 0, null);
			return false;
			}
		return true;	
	}	
		
	public static Boolean writeToAddressTable(Address address)
	{
		String sql="";
		sql+="insert into Address (postalcode , appartment ,building ,city , country ,street ) ";
		sql+=" values ('";
		sql+=address.getPostalcode()+"','";
		sql+=address.getAppartment()+"','";
		sql+=address.getBuilding()+"','";
		sql+=address.getCity()+"','";
		sql+=address.getCountry()+"','";
		sql+=address.getStreet()+"');";
		sqliteDatabase("MyList.db", sql);
		return true;
	}		
	public static Boolean writeToPersonTables(Person person) 
	{
		String sql;
		sql="";
		sql+="insert into Person (personId , firstname , lastname ,birthday) ";
		sql+=" values ('";
		sql+=person.getPersonId()+"','";
		sql+=person.getFirstname()+"','";
		sql+=person.getLastname()+"','";
		sql+=person.getBirthday()+"');";	
		sqliteDatabase("MyList.db", sql);   
		return true;
	}
	public static Boolean writeToPersonAddressTables(Person person, Address address) 
	{
		String sql;
		sql="";
		sql+="insert into PersonAddress (personId , postalcode ) ";
		sql+=" values ('";
		sql+=person.getPersonId()+"','";
		sql+=address.getPostalcode()+"')";			
		sqliteDatabase("MyList.db", sql); 	 		
		return true;
	}
	public static Boolean writeToPersonMailTables(Person person, String mail ) 
	{
		String sql;
		sql="";
		sql+="insert into PersonMail (personId , mail )";
		sql+=" values ('";
		sql+=person.getPersonId()+"','";
		sql+=mail+"')";			
		sqliteDatabase("MyList.db", sql);		
		return true;
	}
	public static Boolean writeToPersonCellPhoneTables(Person person, String cellphone) 
	{
		String sql;
		sql="";
		sql+="insert into PersonCellPhone (personId , cellphone )";
		sql+=" values ('";
		sql+=person.getPersonId()+"','";
		sql+=cellphone+"')";			
		sqliteDatabase("MyList.db", sql);		
		return true;
	}
	public static Boolean writeToStudentTables(Student student) 
	{
		String sql;
		sql="";
		sql+="insert into Student (studentNumber, personId )";
		sql+=" values ('";
		sql+=student.getStudentNumber()+"','";
		sql+=student.getPersonId()+"')";			
		sqliteDatabase("MyList.db",sql);	
		return true;
	}
	public static Boolean writeToStudentLessonTables(Student student , Lesson lesson ) 
	{
		String sql;
		sql="";
		sql+="insert into StudentLesson (lessonName ,studentNumber , mintermExam ,FinalExam , Project )";
		sql+=" values ('";
		sql+=lesson.getLessonName()+"','";
		sql+=student.getStudentNumber()+"',";
		sql+=lesson.getMintermExam()+",";
		sql+=lesson.getFinalExam()+",";
		sql+=lesson.getProject()+");";
		sqliteDatabase("MyList.db", sql);	
		return true;
	}
	public static void writeAllListIntoDatabase()
	{
		for(Student student:StudentList.getStudentlist())
		{
			writeToPersonTables((Person)student);
			writeToStudentTables(student);
			for(Address address:student.getListAddress())
				writeToAddressTable(address);
			for(Address address:student.getListAddress())
				writeToPersonAddressTables(student, address);
			for(String mail:student.getListMail())
				writeToPersonMailTables(student, mail);
			for(Lesson lesson:student.getListgrade())
				writeToStudentLessonTables(student, lesson);			
			for(String cellphone:student.getListCellphone())
				writeToPersonCellPhoneTables(student, cellphone);				
		}
	}
}
