package sortpackage;

import java.util.Comparator;

import studpackage.Student;

public class SortPostalCode implements Comparator<Student>{

	@Override
	public int compare(Student o1, Student o2) {
		if(o1.getListAddress().get(0).getPostalcode().compareTo(o2.getListAddress().get(0).getPostalcode())>0) return 1;
		if(o1.getListAddress().get(0).getPostalcode().compareTo(o2.getListAddress().get(0).getPostalcode())<0) return -1;
		return 0;
		
	}

}
