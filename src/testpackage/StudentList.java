package testpackage;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import sortpackage.SortBirthday;
import sortpackage.SortFirstName;
import sortpackage.SortLastName;
import sortpackage.SortPostalCode;
import studpackage.Student;

public class StudentList implements Serializable {
	
	private static List<Student> studentlist=new ArrayList<>();
	
	public static List<Student> getStudentlist() {
		return studentlist;
	}
	public static void setStudentlist(List<Student> studentlist) {
		StudentList.studentlist = studentlist;
	}	
	public static void addStudentlist(Student student) {
		studentlist.add(student);
	}
	public static void deleteStudentlist(int index) {
		studentlist.remove(index);
	}
	public static void sort(SortLastName sortLastName){
		Collections.sort(studentlist, sortLastName);
	}
	public static void sort(SortFirstName sortFirstName){
		Collections.sort(studentlist, sortFirstName);
	}
	public static void sort(SortPostalCode sortPostalCode){
		Collections.sort(studentlist, sortPostalCode);
	}
	public static void sort(SortBirthday sortBirthday){
		Collections.sort(studentlist, sortBirthday);
	}

	

}
