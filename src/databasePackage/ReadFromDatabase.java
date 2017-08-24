package databasePackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JOptionPane;

//import java.util.Date;
import personpackage.Address;
import personpackage.Person;
import studpackage.Lesson;
import studpackage.Student;

public class ReadFromDatabase {
		
	public static Object sqliteDatabase(String DatabaseName, String sql, Object object,String tableName) 
	{
		try{
			Connection connection = null; 
			Class.forName("org.sqlite.JDBC");
			connection=DriverManager.getConnection("jdbc:sqlite:"+DatabaseName);
			Statement stmt = null; 
			stmt = connection.createStatement(); 
			
			ResultSet resultSet = stmt.executeQuery( sql );	
			switch(tableName)
			{
			case "Address":
				object=readAddressFromResultSet(resultSet, object);
				break;
			case "Person":
				object=readPersonFromResultSet(resultSet, object);
				break;
			case "PersonAddress":
				object=readPersonAddressFromResultSet(resultSet, object);
				break;			
			case "PersonMail":
				object=readPersonMailFromResultSet(resultSet, object);
				break;
			case "PersonCellPhone":
				object=readPersonCellPhoneFromResultSet(resultSet, object);
				break;
			case "Student":
				object=readStudentFromResultSet(resultSet, object);
				break;
			case "StudentLesson":
				object=readStudentLessonFromResultSet(resultSet, object);
				break;
			case "StudentList":
				object=readStudentListFromResultSet(resultSet, object);
				break;
			}
			
			resultSet.close();					
			stmt.close();
			connection.close();	
		}catch(Exception eSqliteDatabase)
		{
			JOptionPane.showMessageDialog(null, "Sorry some thing is wrong  ", "error misage", 0, null);
		}
		return object;	
	}	
	// fill list of lesson
	@SuppressWarnings("unchecked")
	public static List<Lesson> readFromStudentLessonTable(String studentNumber)
	{
		Object object=new ArrayList<Lesson>();
		String sql;
		sql="select * from StudentLesson where    studentNumber " ;
		sql+=" in ('"+studentNumber +"');";
		object=sqliteDatabase("MyList.db", sql, object, "StudentLesson");
		
		return  (List<Lesson>) object;
	}
	@SuppressWarnings("unchecked")
	private static Object readStudentLessonFromResultSet(ResultSet resultSet, Object object)throws Exception
	{	
		Lesson lesson;
		while(resultSet.next())
		{    
			lesson=new Lesson();
			lesson.setLessonName(resultSet.getString("lessonName"));
			lesson.setProject(resultSet.getDouble("Project"));
			lesson.setMintermExam(resultSet.getDouble("mintermExam"));
			lesson.setFinalExam(resultSet.getDouble("FinalExam"));
			
			((List<Lesson>)object).add(lesson);
		}						
		return object;
	}
	//fill list of student
	@SuppressWarnings("unchecked")
	public static List<Student> readFromStudentListTable()
	{
		Object object=new ArrayList<Student>();
		String sql;
		sql="select * from Student ; " ;
		
		object=sqliteDatabase("MyList.db", sql, object, "StudentList");
		
		return  (List<Student>) object;
	}
	
	@SuppressWarnings("unchecked")
	private static Object readStudentListFromResultSet(ResultSet resultSet, Object object)throws Exception
	{	
		Student student;
		while(resultSet.next())
		{    
			student=new Student();
			student.setStudentNumber(resultSet.getString("studentNumber"));
			student.setPersonId(resultSet.getString("personId"));
			((List<Student>)object).add(student);
		}						
		return object;
	}
	// fill student
	public static Student readFromStudentTable(String studentNumber)
	{
		Object object=new Student();
		String sql;
		sql="select * from Student where studentNumber in ('";
		sql+=studentNumber + "');";
		object=sqliteDatabase("MyList.db", sql, object, "Student");
		
		return (Student) object;
	}
	private static Object readStudentFromResultSet(ResultSet resultSet, Object object)throws Exception
	{
		while(resultSet.next())
		{
			((Student) object).setStudentNumber(resultSet.getString("studentNumber"));
			((Student) object).setPersonId(resultSet.getString("personId"));
		}
					
		return object;
	}
	// fill list cell phone
	@SuppressWarnings("unchecked")
	public static List<String> readFromPersonCellPhoneTable(String personId)
	{
		Object object=new ArrayList<String>();
		String sql;
		sql="select * from PersonCellPhone where personId " ;
		sql+="='"+personId + "';";
		object=sqliteDatabase("MyList.db", sql, object, "PersonCellPhone");
		
		return  (List<String>) object;
	}
	@SuppressWarnings("unchecked")
	private static Object readPersonCellPhoneFromResultSet(ResultSet resultSet, Object object)throws Exception
	{	
		String cellphone;
		while(resultSet.next())
		{
			cellphone=resultSet.getString("cellphone");
			((List<String>)object).add(cellphone);
		}						
		return object;
	}
	// fill list mail 
	@SuppressWarnings("unchecked")
	public static List<String> readFromPersonMailTable(String personId)
	{
		Object object=new ArrayList<Address>();
		String sql;
		sql="select * from PersonMail where personId " ;
		sql+="in ('"+personId + "');";
		object=sqliteDatabase("MyList.db", sql, object, "PersonMail");
		return  (List<String>) object;
	}
	@SuppressWarnings("unchecked")
	private static Object readPersonMailFromResultSet(ResultSet resultSet, Object object)throws Exception
	{	
		String mail;
		while(resultSet.next())
		{
			mail=resultSet.getString("mail");
			((List<String>)object).add(mail);
		}						
		return object;
	}
	//  Fill Address List
	@SuppressWarnings("unchecked")
	public static List<Address> readFromPersonAddressTable(String personId)
	{
		Object object=new ArrayList<Address>();//personId , postalcode
		String sql;
		sql="select * from PersonAddress pa,Address a where a.postalcode=pa.postalcode and personId " ;
		sql+="in ('"+personId +"');";
		object=sqliteDatabase("MyList.db", sql, object, "PersonAddress");
		
		return  (List<Address>) object;
	}
	@SuppressWarnings("unchecked")
	private static Object readPersonAddressFromResultSet(ResultSet resultSet, Object object)throws Exception
	{	
		Address address;
		while(resultSet.next())
		{
			address=new Address();
			address.setAppartment(resultSet.getString("appartment"));
			address.setStreet(resultSet.getString("street"));
			address.setBuilding(resultSet.getString("building"));
			address.setCity(resultSet.getString("city"));
			address.setCountry(resultSet.getString("country"));
			address.setPostalcode(resultSet.getString("postalcode"));
			((List<Address>)object).add(address);
		}						
		return object;
	}
	// fill Address
	public static Address readFromAddressTable(String postalcode)
	{
		Object object=new Address();
		String sql;
		sql="select * from Address where postalcode in ('";
		sql+=postalcode + "');";
		object=sqliteDatabase("MyList.db", sql, object, "Address");
		
		return (Address) object;
	}
	private static Object readAddressFromResultSet(ResultSet resultSet, Object object)throws Exception
	{
		while(resultSet.next())
		{
			((Address) object).setAppartment(resultSet.getString("appartment"));
			((Address) object).setStreet(resultSet.getString("street"));
			((Address) object).setBuilding(resultSet.getString("building"));
			((Address) object).setCity(resultSet.getString("city"));
			((Address) object).setCountry(resultSet.getString("country"));
			((Address) object).setPostalcode(resultSet.getString("postalcode"));		
		}
					
		return object;
	}
	// fill person
	public static Person readFromPersonTable(String personId)
	{
		Object object=new Person();
		String sql;
		sql="select * from Person where personId in ('";
		sql+=personId + "');";
		object=sqliteDatabase("MyList.db", sql, object, "Person");
		
		return (Person) object;
	}
	private static Object readPersonFromResultSet(ResultSet resultSet, Object object)throws Exception
	{
		while(resultSet.next())
		{
			SimpleDateFormat format = new SimpleDateFormat("E MMM d HH:mm:ss z y");

			Date d=new Date();
			String s;
			s=(String) resultSet.getObject("birthday");
			d=format.parse(s);
			 
			((Person) object).setPersonId(resultSet.getString("personId"));
			((Person) object).setFirstname(resultSet.getString("firstname"));
			((Person) object).setLastname(resultSet.getString("lastname"));
			((Person) object).setBirthday(d);			
		}
		
		return object;
	}
	public static List<Student> loadAllStudentFromDatabase()
	{
		List<Student> listStudent;
		
		listStudent=readFromStudentListTable();
		
		for(Student student:listStudent)
		{		
			
			student.setFirstname(readFromPersonTable(student.getPersonId()).getFirstname());
			student.setLastname(readFromPersonTable(student.getPersonId()).getLastname());
			student.setBirthday(readFromPersonTable(student.getPersonId()).getBirthday());	
			
			student.setListAddress(readFromPersonAddressTable(student.getPersonId()));
			student.setListCellphone(readFromPersonCellPhoneTable(student.getPersonId()));
			student.setListMail(readFromPersonMailTable(student.getPersonId()));
			student.setListgrade(readFromStudentLessonTable(student.getStudentNumber()));			
		}		
		return listStudent;
	}
}











