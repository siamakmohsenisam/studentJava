package sortpackage;

import java.util.Comparator;

import studpackage.Student;

public class SortBirthday implements Comparator<Student>{

	@Override
	public int compare(Student o1, Student o2) {
		if(o1.getBirthday().after(o2.getBirthday()))return 1;
		else return -1;

	}

}
