package formpackage;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import testpackage.StudentList;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EditForm extends JFrame{
	private JList listCoursName;
	private JList listAddress;
	private JList listCellPhone;
	private JList listMail ;
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
	private JTextField tfAverage;
	private JTextField tfMinterm;
	private JTextField tfProject;
	private JTextField tfFinalExam;
	private JTextField tfYear;
	private JTextField tfMonth;
	private JTextField tfDay;
	private JTextField tfPersonID;

	public EditForm(int index) {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosed(WindowEvent arg0) {
				StudentListForm liststudent = new StudentListForm();
				liststudent.setVisible(true);
			}
			@Override
			public void windowActivated(WindowEvent e) {
				
				
				String d;
				d=String.valueOf(StudentList.getStudentlist().get(index).getBirthday().getYear()+1900);
				d+="/";
				d+=String.valueOf(StudentList.getStudentlist().get(index).getBirthday().getMonth()+1);
				d+="/";
				d+=String.valueOf(StudentList.getStudentlist().get(index).getBirthday().getDate());
				
				tfFirstName.setText(StudentList.getStudentlist().get(index).getFirstname());
				tfLastName.setText(StudentList.getStudentlist().get(index).getLastname());
				tfBirthday.setText(d);
				tfStudentId.setText(StudentList.getStudentlist().get(index).getStudentNumber());
				tfPersonID.setText(StudentList.getStudentlist().get(index).getPersonId());
				
				listAddress.setListData(StudentList.getStudentlist().get(index).getListAddress().toArray());			
				listCoursName.setListData(StudentList.getStudentlist().get(index).getListgrade().toArray());				
				listCellPhone.setListData(StudentList.getStudentlist().get(index).getListCellphone().toArray());
				listMail.setListData(StudentList.getStudentlist().get(index).getListMail().toArray());
				
				
				
				
			}
		});
		setResizable(false);

		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setSize(450, 500);
		setTitle("Student edit Information Form");
		getContentPane().setLayout(null);

 
		JLabel lbStudentId = new JLabel("Student ID :");
		lbStudentId.setHorizontalAlignment(SwingConstants.RIGHT);
		lbStudentId.setBounds(15, 14, 80, 14);
		getContentPane().add(lbStudentId);

		JLabel lbFirstName = new JLabel("First name :");
		lbFirstName.setHorizontalAlignment(SwingConstants.RIGHT);
		lbFirstName.setBounds(223, 14, 80, 14);
		getContentPane().add(lbFirstName);

		JLabel lbLastName = new JLabel("Last name :");
		lbLastName.setHorizontalAlignment(SwingConstants.RIGHT);
		lbLastName.setBounds(223, 39, 80, 14);
		getContentPane().add(lbLastName);

		JLabel lbBirthday = new JLabel("Birthday :");
		lbBirthday.setHorizontalAlignment(SwingConstants.RIGHT);
		lbBirthday.setBounds(15, 64, 80, 14);
		getContentPane().add(lbBirthday);

		JLabel lbCellPhone = new JLabel("Cell phone");
		lbCellPhone.setHorizontalAlignment(SwingConstants.LEFT);
		lbCellPhone.setBounds(271, 189, 138, 14);
		getContentPane().add(lbCellPhone);

		JLabel lbMail = new JLabel("Mail ");
		lbMail.setHorizontalAlignment(SwingConstants.LEFT);
		lbMail.setBounds(15, 204, 139, 14);
		getContentPane().add(lbMail);

		JLabel lbAddress = new JLabel("Address ( PostalCode )");
		lbAddress.setHorizontalAlignment(SwingConstants.LEFT);
		lbAddress.setBounds(15, 320, 161, 14);
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
		tfBirthday.setBounds(101, 64, 100, 20);
		getContentPane().add(tfBirthday);
		tfBirthday.setColumns(10);

		tfAppartment = new JTextField();
		tfAppartment.setEditable(false);
		tfAppartment.setColumns(10);
		tfAppartment.setBounds(323, 315, 86, 20);
		getContentPane().add(tfAppartment);

		tfBuilding = new JTextField();
		tfBuilding.setEditable(false);
		tfBuilding.setColumns(10);
		tfBuilding.setBounds(323, 340, 86, 20);
		getContentPane().add(tfBuilding);

		tfStreet = new JTextField();
		tfStreet.setEditable(false);
		tfStreet.setColumns(10);
		tfStreet.setBounds(323, 365, 86, 20);
		getContentPane().add(tfStreet);

		JLabel lbAppartment = new JLabel("Appartment :");
		lbAppartment.setHorizontalAlignment(SwingConstants.RIGHT);
		lbAppartment.setBounds(237, 315, 80, 14);
		getContentPane().add(lbAppartment);

		JLabel lbBuilding = new JLabel("Building :");
		lbBuilding.setHorizontalAlignment(SwingConstants.RIGHT);
		lbBuilding.setBounds(237, 340, 80, 14);
		getContentPane().add(lbBuilding);

		JLabel lbStreet = new JLabel("Street :");
		lbStreet.setHorizontalAlignment(SwingConstants.RIGHT);
		lbStreet.setBounds(237, 365, 80, 14);
		getContentPane().add(lbStreet);

		tfCity = new JTextField();
		tfCity.setEditable(false);
		tfCity.setColumns(10);
		tfCity.setBounds(323, 390, 86, 20);
		getContentPane().add(tfCity);

		tfCountry = new JTextField();
		tfCountry.setEditable(false);
		tfCountry.setColumns(10);
		tfCountry.setBounds(323, 415, 86, 20);
		getContentPane().add(tfCountry);

		JLabel lbCity = new JLabel("City :");
		lbCity.setHorizontalAlignment(SwingConstants.RIGHT);
		lbCity.setBounds(237, 390, 80, 14);
		getContentPane().add(lbCity);

		JLabel lbCountry = new JLabel("Country :");
		lbCountry.setHorizontalAlignment(SwingConstants.RIGHT);
		lbCountry.setBounds(237, 415, 80, 14);
		getContentPane().add(lbCountry);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(15, 219, 200, 63);
		getContentPane().add(scrollPane_1);

		listMail = new JList();
		scrollPane_1.setViewportView(listMail);

		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(15, 336, 200, 74);
		getContentPane().add(scrollPane_2);

		listAddress = new JList();
		listAddress.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				try{
					tfAppartment.setText(StudentList.getStudentlist().get(index).getListAddress().get(listAddress.getSelectedIndex()).getAppartment());			
					tfBuilding.setText(StudentList.getStudentlist().get(index).getListAddress().get(listAddress.getSelectedIndex()).getBuilding());
					tfCity.setText(StudentList.getStudentlist().get(index).getListAddress().get(listAddress.getSelectedIndex()).getCity());
					tfCountry.setText(StudentList.getStudentlist().get(index).getListAddress().get(listAddress.getSelectedIndex()).getCountry());
					tfStreet.setText(StudentList.getStudentlist().get(index).getListAddress().get(listAddress.getSelectedIndex()).getStreet());
				
				}
				catch(Exception e3){
					tfAppartment.setText("");
					tfBuilding.setText("");
					tfCity.setText("");
					tfCountry.setText("");
					tfStreet.setText("");
				}
				
			}
		});
		scrollPane_2.setColumnHeaderView(listAddress);

		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(271, 204, 139, 52);
		getContentPane().add(scrollPane_3);

		listCellPhone = new JList();
		scrollPane_3.setViewportView(listCellPhone);

		tfStudentId = new JTextField();
		tfStudentId.setColumns(10);
		tfStudentId.setBounds(101, 11, 100, 20);
		getContentPane().add(tfStudentId);

		JLabel lbCourseName = new JLabel("Course name");
		lbCourseName.setHorizontalAlignment(SwingConstants.LEFT);
		lbCourseName.setBounds(15, 104, 139, 14);
		getContentPane().add(lbCourseName);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(15, 118, 186, 60);
		getContentPane().add(scrollPane);

		listCoursName = new JList();
		listCoursName.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				try
				{
					tfAverage.setText(String.valueOf((StudentList.getStudentlist().get(index).getListgrade().get(listCoursName.getSelectedIndex()).finalgrade())));
					tfFinalExam.setText(String.valueOf((StudentList.getStudentlist().get(index).getListgrade().get(listCoursName.getSelectedIndex()).getFinalExam())));
					tfMinterm.setText(String.valueOf((StudentList.getStudentlist().get(index).getListgrade().get(listCoursName.getSelectedIndex()).getMintermExam())));
					tfProject.setText(String.valueOf((StudentList.getStudentlist().get(index).getListgrade().get(listCoursName.getSelectedIndex()).getProject())));
					
				}
				catch(Exception e2){
					tfAverage.setText("");
					tfFinalExam.setText("");
					tfMinterm.setText("");
					tfProject.setText("");
				}
			}
		});
		scrollPane.setViewportView(listCoursName);

		JLabel lbAverage = new JLabel("Average :");
		lbAverage.setHorizontalAlignment(SwingConstants.RIGHT);
		lbAverage.setBounds(223, 79, 80, 14);
		getContentPane().add(lbAverage);

		tfAverage = new JTextField();
		tfAverage.setEditable(false);
		tfAverage.setColumns(10);
		tfAverage.setBounds(309, 78, 100, 20);
		getContentPane().add(tfAverage);

		tfMinterm = new JTextField();
		tfMinterm.setEditable(false);
		tfMinterm.setColumns(10);
		tfMinterm.setBounds(309, 100, 100, 20);
		getContentPane().add(tfMinterm);

		JLabel lbMinterm = new JLabel("Minterm :");
		lbMinterm.setHorizontalAlignment(SwingConstants.RIGHT);
		lbMinterm.setBounds(223, 100, 80, 14);
		getContentPane().add(lbMinterm);

		JLabel lbProject = new JLabel("Project :");
		lbProject.setHorizontalAlignment(SwingConstants.RIGHT);
		lbProject.setBounds(223, 125, 80, 14);
		getContentPane().add(lbProject);

		tfProject = new JTextField();
		tfProject.setEditable(false);
		tfProject.setColumns(10);
		tfProject.setBounds(309, 125, 100, 20);
		getContentPane().add(tfProject);

		tfFinalExam = new JTextField();
		tfFinalExam.setEditable(false);
		tfFinalExam.setColumns(10);
		tfFinalExam.setBounds(309, 150, 100, 20);
		getContentPane().add(tfFinalExam);

		JLabel lbFinalExzam = new JLabel("Final exam :");
		lbFinalExzam.setHorizontalAlignment(SwingConstants.RIGHT);
		lbFinalExzam.setBounds(223, 150, 80, 14);
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
		btnClose.setBounds(271, 440, 89, 23);
		getContentPane().add(btnClose);
		
		JButton btnNewButton = new JButton("Add");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddCourseForm addCourseForm = new AddCourseForm(index);
				addCourseForm.setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton.setBounds(25, 180, 72, 23);
		getContentPane().add(btnNewButton);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(listCoursName.getSelectedIndex()>-1)
				{
					StudentList.getStudentlist().get(index).deleteListgrade(listCoursName.getSelectedIndex());
					listCoursName.setListData(StudentList.getStudentlist().get(index).getListgrade().toArray());
					
				}
			}
		});
		btnDelete.setBounds(114, 180, 72, 23);
		getContentPane().add(btnDelete);
		
		JButton button = new JButton("Delete");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(listMail.getSelectedIndex()>-1)
				{
					StudentList.getStudentlist().get(index).deleteListMail(listMail.getSelectedIndex());
					listMail.setListData(StudentList.getStudentlist().get(index).getListMail().toArray());
					
				}
			}
		});
		button.setBounds(114, 286, 72, 23);
		getContentPane().add(button);
		
		JButton button_1 = new JButton("Add");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddMailForm addMailForm = new AddMailForm(index);
				addMailForm.setVisible(true);
				setVisible(false);
			}
		});
		button_1.setBounds(25, 286, 72, 23);
		getContentPane().add(button_1);
		
		JButton button_2 = new JButton("Delete");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(listAddress.getSelectedIndex()>-1)
				{
					StudentList.getStudentlist().get(index).deleteAddress(listAddress.getSelectedIndex());
					listAddress.setListData(StudentList.getStudentlist().get(index).getListAddress().toArray());					
				}
			}
		});
		button_2.setBounds(129, 412, 72, 23);
		getContentPane().add(button_2);
		
		JButton button_3 = new JButton("Add");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddAddressForm addAddressForm = new AddAddressForm(index);
				addAddressForm.setVisible(true);
				setVisible(false);
			}
		});
		button_3.setBounds(40, 412, 72, 23);
		getContentPane().add(button_3);
		
		JButton button_4 = new JButton("Delete");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(listCellPhone.getSelectedIndex()>-1)
				{
					StudentList.getStudentlist().get(index).deleteCellPhone(listCellPhone.getSelectedIndex());
					listCellPhone.setListData(StudentList.getStudentlist().get(index).getListCellphone().toArray());
					
				}
			}
		});
		button_4.setBounds(351, 259, 72, 23);
		getContentPane().add(button_4);
		
		JButton button_5 = new JButton("Add");
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddCellForm addCellForm = new AddCellForm(index);
				addCellForm.setVisible(true);
				setVisible(false);
			}
		});
		button_5.setBounds(262, 259, 72, 23);
		getContentPane().add(button_5);
		
		JButton btnSave = new JButton("OK");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Date date=new Date();
				try{
					date.setYear(Integer.valueOf(tfYear.getText())-1900);
					date.setMonth(Integer.valueOf(tfMonth.getText())-1);
					date.setDate(Integer.valueOf(tfDay.getText()));
					}
					catch(Exception e5)
				{
					
				}
				tfBirthday.setText(tfYear.getText()+"/"+tfMonth.getText()+"/"+tfDay.getText());
				if(!(tfFirstName.getText().isEmpty() || tfLastName.getText().isEmpty() ||
						tfStudentId.getText().isEmpty()||tfPersonID.getText().isEmpty()))
				{
					StudentList.getStudentlist().get(index).setFirstname(tfFirstName.getText());
					StudentList.getStudentlist().get(index).setLastname(tfLastName.getText());
					StudentList.getStudentlist().get(index).setStudentNumber(tfStudentId.getText());
					StudentList.getStudentlist().get(index).setPersonId(tfPersonID.getText());
					StudentList.getStudentlist().get(index).setBirthday(date);
					StudentListForm liststudent = new StudentListForm();
					liststudent.setVisible(true);
					setVisible(false);
				
				}
				else JOptionPane.showMessageDialog(null, "Sorry please fill all star item", "error misage", 0, null);
				
			}
		});
		btnSave.setBounds(160, 440, 89, 23);
		getContentPane().add(btnSave);
		
		tfYear = new JTextField();
		tfYear.setBounds(82, 87, 36, 20);
		getContentPane().add(tfYear);
		tfYear.setColumns(10);
		
		tfMonth = new JTextField();
		tfMonth.setColumns(10);
		tfMonth.setBounds(128, 87, 36, 20);
		getContentPane().add(tfMonth);
		
		tfDay = new JTextField();
		tfDay.setColumns(10);
		tfDay.setBounds(174, 87, 36, 20);
		getContentPane().add(tfDay);
		
		tfPersonID = new JTextField();
		tfPersonID.setColumns(10);
		tfPersonID.setBounds(101, 39, 100, 20);
		getContentPane().add(tfPersonID);
		
		JLabel lblPersonId = new JLabel("Person ID :");
		lblPersonId.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPersonId.setBounds(15, 42, 80, 14);
		getContentPane().add(lblPersonId);

	}
}
