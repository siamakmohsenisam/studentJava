package formpackage;

import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

import personpackage.Address;
import studpackage.Lesson;
import studpackage.Student;
import testpackage.StudentList;

import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class StudentAddForm extends JFrame
{
	private StudentList studentlist;
	private JTextField tfFirstName;
	private JTextField tfLastName;
	private JTextField tfBirthday;
	private JTextField tfAppartment;
	private JTextField tfBuilding;
	private JTextField tfStreet;
	private JTextField tfCity;
	private JTextField tfCountry;
	private JTextField tfStudentId;
	private JTextField tfMinterm;
	private JTextField tfProject;
	private JTextField tfFinalExam;
	private JTextField tfCourseName;
	private JTextField tfPostalCode;
	private JTextField tfMail;
	private JTextField tfCellPhone;
	private JTextField tfYear;
	private JTextField tfMonth;
	private JTextField tfDay;
	private JTextField tfPersonId;
	private JLabel lblPersonId;

	public StudentAddForm() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosed(WindowEvent arg0) {
				StudentListForm liststudent = new StudentListForm();
				liststudent.setVisible(true);
			}
		});
		setResizable(false);

		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setSize(450, 380);
		setTitle("Student Information Form");
		getContentPane().setLayout(null);

		studentlist = new StudentList();

		JLabel lbStudentId = new JLabel("* Student ID :");
		lbStudentId.setHorizontalAlignment(SwingConstants.RIGHT);
		lbStudentId.setBounds(15, 14, 80, 14);
		getContentPane().add(lbStudentId);

		JLabel lbFirstName = new JLabel("* First name :");
		lbFirstName.setHorizontalAlignment(SwingConstants.RIGHT);
		lbFirstName.setBounds(211, 14, 92, 14);
		getContentPane().add(lbFirstName);

		JLabel lbLastName = new JLabel("* Last name :");
		lbLastName.setHorizontalAlignment(SwingConstants.RIGHT);
		lbLastName.setBounds(223, 39, 80, 14);
		getContentPane().add(lbLastName);

		JLabel lbBirthday = new JLabel("Birthday :");
		lbBirthday.setHorizontalAlignment(SwingConstants.RIGHT);
		lbBirthday.setBounds(15, 95, 80, 14);
		getContentPane().add(lbBirthday);

		JLabel lbCellPhone = new JLabel("Cell phone :");
		lbCellPhone.setHorizontalAlignment(SwingConstants.RIGHT);
		lbCellPhone.setBounds(211, 64, 92, 14);
		getContentPane().add(lbCellPhone);

		JLabel lbMail = new JLabel("Mail :");
		lbMail.setHorizontalAlignment(SwingConstants.RIGHT);
		lbMail.setBounds(25, 70, 70, 14);
		getContentPane().add(lbMail);

		JLabel lbAddress = new JLabel("PostalCode :");
		lbAddress.setHorizontalAlignment(SwingConstants.RIGHT);
		lbAddress.setBounds(25, 228, 80, 14);
		getContentPane().add(lbAddress);

		tfFirstName = new JTextField();
		tfFirstName.setBounds(309, 14, 100, 20);
		getContentPane().add(tfFirstName);
		tfFirstName.setColumns(10);

		tfLastName = new JTextField();
		tfLastName.setBounds(309, 39, 100, 20);
		getContentPane().add(tfLastName);
		tfLastName.setColumns(10);

		tfBirthday = new JTextField();
		tfBirthday.setEditable(false);
		tfBirthday.setBounds(101, 95, 100, 20);
		getContentPane().add(tfBirthday);
		tfBirthday.setColumns(10);

		tfAppartment = new JTextField();
		tfAppartment.setColumns(10);
		tfAppartment.setBounds(323, 225, 86, 20);
		getContentPane().add(tfAppartment);

		tfBuilding = new JTextField();
		tfBuilding.setColumns(10);
		tfBuilding.setBounds(323, 250, 86, 20);
		getContentPane().add(tfBuilding);

		tfStreet = new JTextField();
		tfStreet.setColumns(10);
		tfStreet.setBounds(323, 275, 86, 20);
		getContentPane().add(tfStreet);

		JLabel lbAppartment = new JLabel("Appartment :");
		lbAppartment.setHorizontalAlignment(SwingConstants.RIGHT);
		lbAppartment.setBounds(211, 225, 106, 14);
		getContentPane().add(lbAppartment);

		JLabel lbBuilding = new JLabel("Building :");
		lbBuilding.setHorizontalAlignment(SwingConstants.RIGHT);
		lbBuilding.setBounds(237, 250, 80, 14);
		getContentPane().add(lbBuilding);

		JLabel lbStreet = new JLabel("Street :");
		lbStreet.setHorizontalAlignment(SwingConstants.RIGHT);
		lbStreet.setBounds(237, 275, 80, 14);
		getContentPane().add(lbStreet);

		tfCity = new JTextField();
		tfCity.setColumns(10);
		tfCity.setBounds(111, 250, 86, 20);
		getContentPane().add(tfCity);

		tfCountry = new JTextField();
		tfCountry.setColumns(10);
		tfCountry.setBounds(111, 275, 86, 20);
		getContentPane().add(tfCountry);

		JLabel lbCity = new JLabel("City :");
		lbCity.setHorizontalAlignment(SwingConstants.RIGHT);
		lbCity.setBounds(25, 250, 80, 14);
		getContentPane().add(lbCity);

		JLabel lbCountry = new JLabel("Country :");
		lbCountry.setHorizontalAlignment(SwingConstants.RIGHT);
		lbCountry.setBounds(25, 278, 80, 14);
		getContentPane().add(lbCountry);

		tfStudentId = new JTextField();
		tfStudentId.setColumns(10);
		tfStudentId.setBounds(101, 11, 100, 20);
		getContentPane().add(tfStudentId);

		JLabel lbCourseName = new JLabel("Course name :");
		lbCourseName.setHorizontalAlignment(SwingConstants.RIGHT);
		lbCourseName.setBounds(10, 153, 85, 14);
		getContentPane().add(lbCourseName);

		tfMinterm = new JTextField();
		tfMinterm.setColumns(10);
		tfMinterm.setBounds(309, 150, 100, 20);
		getContentPane().add(tfMinterm);

		JLabel lbMinterm = new JLabel("Minterm :");
		lbMinterm.setHorizontalAlignment(SwingConstants.RIGHT);
		lbMinterm.setBounds(223, 150, 80, 14);
		getContentPane().add(lbMinterm);

		JLabel lbProject = new JLabel("Project :");
		lbProject.setHorizontalAlignment(SwingConstants.RIGHT);
		lbProject.setBounds(223, 175, 80, 14);
		getContentPane().add(lbProject);

		tfProject = new JTextField();
		tfProject.setColumns(10);
		tfProject.setBounds(309, 175, 100, 20);
		getContentPane().add(tfProject);

		tfFinalExam = new JTextField();
		tfFinalExam.setColumns(10);
		tfFinalExam.setBounds(101, 175, 100, 20);
		getContentPane().add(tfFinalExam);

		JLabel lbFinalExzam = new JLabel("Final exam :");
		lbFinalExzam.setHorizontalAlignment(SwingConstants.RIGHT);
		lbFinalExzam.setBounds(15, 175, 80, 14);
		getContentPane().add(lbFinalExzam);

		JButton btnClose = new JButton("Close");
		btnClose.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				StudentListForm liststudent = new StudentListForm();
				liststudent.setVisible(true);
				setVisible(false);
			}
		});
		btnClose.setBounds(248, 317, 89, 23);
		getContentPane().add(btnClose);
		
		tfCourseName = new JTextField();
		tfCourseName.setColumns(10);
		tfCourseName.setBounds(100, 150, 100, 20);
		getContentPane().add(tfCourseName);
		
		JButton btnNewButton = new JButton("Add");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				Student stud=new Student();
				Address address=new Address();
				Date date=new Date();
				Lesson grade=new Lesson();
				
				try{
					date.setYear(Integer.valueOf(tfYear.getText())-1900);
					date.setMonth(Integer.valueOf(tfMonth.getText())-1);
					date.setDate(Integer.valueOf(tfDay.getText()));
					}
					catch(Exception e)
				{
						
				}
				tfBirthday.setText(tfYear.getText()+"/"+tfMonth.getText()+"/"+tfDay.getText());
				if(!(tfFirstName.getText().isEmpty() || tfLastName.getText().isEmpty() ||
						tfStudentId.getText().isEmpty()||tfPersonId.getText().isEmpty()))
				{
					stud.setFirstname(tfFirstName.getText());
					stud.setLastname(tfLastName.getText());
					stud.setStudentNumber(tfStudentId.getText());
					stud.setPersonId(tfPersonId.getText());
					
					address.setAppartment(tfAppartment.getText());
					address.setStreet(tfStreet.getText());
					address.setBuilding(tfBuilding.getText());
					address.setCity(tfCity.getText());
					address.setCountry(tfCountry.getText());
					address.setPostalcode(tfPostalCode.getText());					
					stud.addAddress(address);

					stud.setBirthday(date);
					tfBirthday.setText(tfYear.getText()+"/"+tfMonth.getText()+"/"+tfDay.getText());
					try
					{
						grade.setLessonName(tfCourseName.getText());
						grade.setFinalExam(Double.valueOf(tfFinalExam.getText()));
						grade.setMintermExam(Double.valueOf(tfMinterm.getText()));
						grade.setProject(Double.valueOf(tfProject.getText()));
						stud.addListgrade(grade);
					}
					catch(Exception e)
					{
						
					}
					stud.addCellPhone(tfCellPhone.getText());
					stud.addListMail(tfMail.getText());
					
					StudentList.addStudentlist(stud);
					StudentListForm liststudent = new StudentListForm();
					liststudent.setVisible(true);
					setVisible(false);
				}
				else JOptionPane.showMessageDialog(null, "Sorry please fill all star item", "error misage", 0, null);
			
				
			}
		});
		btnNewButton.setBounds(122, 317, 89, 23);
		getContentPane().add(btnNewButton);
		
		tfPostalCode = new JTextField();
		tfPostalCode.setColumns(10);
		tfPostalCode.setBounds(111, 225, 86, 20);
		getContentPane().add(tfPostalCode);
		
		tfMail = new JTextField();
		tfMail.setColumns(10);
		tfMail.setBounds(101, 70, 100, 20);
		getContentPane().add(tfMail);
		
		tfCellPhone = new JTextField();
		tfCellPhone.setColumns(10);
		tfCellPhone.setBounds(309, 64, 100, 20);
		getContentPane().add(tfCellPhone);
		
		tfYear = new JTextField();
		tfYear.setBounds(87, 119, 36, 20);
		getContentPane().add(tfYear);
		tfYear.setColumns(10);
		
		tfMonth = new JTextField();
		tfMonth.setColumns(10);
		tfMonth.setBounds(133, 119, 36, 20);
		getContentPane().add(tfMonth);
		
		tfDay = new JTextField();
		tfDay.setColumns(10);
		tfDay.setBounds(179, 119, 36, 20);
		getContentPane().add(tfDay);
		
		tfPersonId = new JTextField();
		tfPersonId.setColumns(10);
		tfPersonId.setBounds(101, 39, 100, 20);
		getContentPane().add(tfPersonId);
		
		lblPersonId = new JLabel("* Person ID :");
		lblPersonId.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPersonId.setBounds(15, 42, 80, 14);
		getContentPane().add(lblPersonId);
	}
}
