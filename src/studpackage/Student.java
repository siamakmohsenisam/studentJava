package studpackage;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import personpackage.Address;
import personpackage.Person;

public class Student extends Person 
{	
	private String studentNumber;
	private List<Lesson> listgrade;
	
	
	public Student() {
		this("","", "",new ArrayList<Address>(),
				new Date() ,new ArrayList<String>(), new ArrayList<String>(),"",new ArrayList<Lesson>());
	}
	public Student(String personId,String firstname, String lastname, List<Address> listAddress,
			Date birthday, List<String> listCellphone, List<String> listMail,
			String studentNumber, List<Lesson> listgrade) {
		super(personId,firstname,  lastname,  listAddress, birthday,  listCellphone, listMail);
		this.studentNumber = studentNumber;
		this.listgrade = listgrade;
	}
	public String getStudentNumber() {
		return studentNumber;
	}
	public void setStudentNumber(String studentNumber) {
		this.studentNumber = studentNumber;
	}
	public List<Lesson> getListgrade() {
		return listgrade;
	}
	public void setListgrade(List<Lesson> listgrade) {
		this.listgrade = listgrade;
	}
	public void addListgrade(Lesson evaluation) {
		this.listgrade.add(evaluation);
	}
	public void deleteListgrade(int index) {
		this.listgrade.remove(index);
	}
	@Override
	public String toString() {
		String s="";		
		s+=String.format("Full Name : %-15s %-20s %-7d %-5d %-5d PostalCode : %-15s ",
				getFirstname().trim(),getLastname().trim(),((getBirthday().getYear())+1900),
				getBirthday().getMonth()+1,(getBirthday().getDate()), getListAddress().get(0).getPostalcode());
		return  s;
	}
}
