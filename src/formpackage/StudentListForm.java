package formpackage;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import filepackage.SerializationUtil;
import personpackage.TypeOfSort;
import sortpackage.SortBirthday;
import sortpackage.SortFirstName;
import sortpackage.SortLastName;
import sortpackage.SortPostalCode;
import studpackage.Student;
import testpackage.StudentList;
import javax.swing.JList;
import javax.swing.ComboBoxEditor;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.ListSelectionModel;

import databasePackage.CreateTable;
import databasePackage.Delete;
import databasePackage.WriteToDatabase;
import javax.swing.JComboBox;
import javax.swing.JLabel;

public class StudentListForm extends JFrame {
	private String fileName="MyList.ser";
	private JScrollPane scrollPane;
	private JList list;
	private JButton btnNewButton;
	private JComboBox comboBox;

	public StudentListForm() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				list.setListData(StudentList.getStudentlist().toArray());		
			}
		});
		
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(800, 400);
		setTitle("list of student");
		getContentPane().setLayout(null);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 774, 257);
		getContentPane().add(scrollPane);
	
		list = new JList();
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(list);

		btnNewButton = new JButton("Add");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StudentAddForm studentaddform = new StudentAddForm();
				studentaddform.setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton.setBounds(347, 286, 89, 23);
		getContentPane().add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Delete");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(list.getSelectedIndex()>-1)
				{
					StudentList.deleteStudentlist(list.getSelectedIndex());
					list.setListData(StudentList.getStudentlist().toArray());
				}
				else JOptionPane.showMessageDialog(null, "Please choose one item of list \n ", "Help message", 1, null);
				
			}
		});
		btnNewButton_1.setBounds(347, 320, 89, 23);
		getContentPane().add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("Detail");
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(list.getSelectedIndex()>-1)
				{
					DetailForm detail = new DetailForm(list.getSelectedIndex());
					detail.setVisible(true);
					setVisible(false);
				}
				else JOptionPane.showMessageDialog(null, "Please choose one item of list \n ", "Help message", 1, null);
				
			}
		});
		btnNewButton_2.setBounds(467, 286, 89, 23);
		getContentPane().add(btnNewButton_2);

		JButton btnNewButton_3 = new JButton("Exit");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		btnNewButton_3.setBounds(609, 286, 89, 23);
		getContentPane().add(btnNewButton_3);

		JButton btnNewButton_4 = new JButton("Edit");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(list.getSelectedIndex()>-1)
				{
					EditForm editform = new EditForm(list.getSelectedIndex());
					editform.setVisible(true);
					setVisible(false);
				}
				else JOptionPane.showMessageDialog(null, "Please choose one item of list  ", "Help message", 1, null);
			}
		});
		btnNewButton_4.setBounds(467, 320, 89, 23);
		getContentPane().add(btnNewButton_4);
		
		JButton btnsave = new JButton("SAVE");
		btnsave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			//	WriteToDatabase.
				Delete.deleteAllTable();
				CreateTable.createAllTables();
				WriteToDatabase.writeAllListIntoDatabase();
				try {
					
					SerializationUtil.serialize(StudentList.getStudentlist(), fileName);
				} catch (IOException ee)
				{ 
					JOptionPane.showMessageDialog(null, "Sorry some thing is wrong ", "error misage", 0, null);
				}				
			}
		});
		btnsave.setBounds(10, 286, 89, 23);
		getContentPane().add(btnsave);
		
		JButton btnload = new JButton("LOAD");
		btnload.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			try {				
				StudentList.setStudentlist((List<Student>) SerializationUtil.deserialize(fileName));
				list.setListData(StudentList.getStudentlist().toArray());
			} 
			catch (Exception eee) 
			{		
				JOptionPane.showMessageDialog(null, "Sorry some thing is wrong ", "error misage", 0, null);
			}
			}
		});

		btnload.setBounds(10, 320, 89, 23);
		getContentPane().add(btnload);
		
		JButton btnSort = new JButton("Sort");
		btnSort.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
					switch(comboBox.getSelectedItem().toString()){
					case "LastName":
						SortLastName sortLastName= new SortLastName();						
						StudentList.sort(sortLastName);
						break;
					case "FirstName":
						SortFirstName sortFirstName= new SortFirstName();						
						StudentList.sort(sortFirstName);
						break;
					case "PostalCode":
						SortPostalCode sortPostalCode= new SortPostalCode();						
						StudentList.sort(sortPostalCode);
						break;
					case "Birthday":
						SortBirthday sortbirthday= new SortBirthday();						
						StudentList.sort(sortbirthday);
						break;
					case "FullName":
						Collections.sort(StudentList.getStudentlist());
						break;
						
					}
				
				list.setListData(StudentList.getStudentlist().toArray());
				
			}
		});
		btnSort.setBounds(125, 286, 89, 23);
		getContentPane().add(btnSort);
		
		comboBox = new JComboBox(TypeOfSort.values());
		comboBox.setMaximumRowCount(3);
		comboBox.setBounds(125, 340, 138, 20);
		
		getContentPane().add(comboBox);
		
		JLabel lblNewLabel = new JLabel("Type Of  Sort");
		lblNewLabel.setBounds(125, 315, 107, 14);
		getContentPane().add(lblNewLabel);

	}
}
