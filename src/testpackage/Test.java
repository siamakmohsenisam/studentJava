package testpackage;

import javax.swing.JOptionPane;

import databasePackage.CreateTable;
import databasePackage.Delete;
import databasePackage.ReadFromDatabase;
import formpackage.DetailForm;
import formpackage.StudentListForm;

public class Test {

	public static void main(String[] args) 
	{	
		CreateTable.createAllTables();
		StudentList.setStudentlist(ReadFromDatabase.loadAllStudentFromDatabase());
		try 
		{
			StudentListForm frame = new StudentListForm();
			frame.setVisible(true);
		} 
		catch (Exception e) 
		{
			JOptionPane.showMessageDialog(null, "Sorry some thing is wrong   ", "error misage", 0, null);
		}

	}

}
