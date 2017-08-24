package formpackage;

import javax.swing.JFrame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import studpackage.Lesson;
import testpackage.StudentList;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddCourseForm extends JFrame{
	private JTextField tfCourseName;
	private JTextField tfMinterm;
	private JTextField tfProject;
	private JTextField tfExam;
	
	public AddCourseForm(int index) {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosed(WindowEvent e) {
				EditForm editForm = new EditForm(index);
				editForm.setVisible(true);
			}
		});
		
		setResizable(false);

		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setSize(450, 250);
		setTitle("Add New Course");
		getContentPane().setLayout(null);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Lesson grade=new Lesson();
				try{				
					grade.setLessonName(tfCourseName.getText());
					grade.setFinalExam(Double.valueOf(tfExam.getText()));
					grade.setMintermExam(Double.valueOf(tfMinterm.getText()));
					grade.setProject(Double.valueOf(tfProject.getText()));
					StudentList.getStudentlist().get(index).addListgrade(grade);					
				}
				catch(Exception e7)
				{
					
				}
				EditForm editForm = new EditForm(index);
				editForm.setVisible(true);
				setVisible(false);
			}
		});
		btnAdd.setBounds(95, 171, 89, 23);
		getContentPane().add(btnAdd);
		
		JButton button_1 = new JButton("Cancel");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EditForm editForm = new EditForm(index);
				editForm.setVisible(true);
				setVisible(false);
			}
		});
		button_1.setBounds(236, 171, 89, 23);
		getContentPane().add(button_1);
		
		tfCourseName = new JTextField();
		tfCourseName.setColumns(10);
		tfCourseName.setBounds(148, 35, 200, 20);
		getContentPane().add(tfCourseName);
		
		tfMinterm = new JTextField();
		tfMinterm.setColumns(10);
		tfMinterm.setBounds(149, 66, 200, 20);
		getContentPane().add(tfMinterm);
		
		JLabel label_2 = new JLabel("Minterm :");
		label_2.setHorizontalAlignment(SwingConstants.RIGHT);
		label_2.setBounds(63, 66, 80, 14);
		getContentPane().add(label_2);
		
		JLabel label_3 = new JLabel("Project :");
		label_3.setHorizontalAlignment(SwingConstants.RIGHT);
		label_3.setBounds(63, 96, 80, 14);
		getContentPane().add(label_3);
		
		tfProject = new JTextField();
		tfProject.setColumns(10);
		tfProject.setBounds(149, 96, 200, 20);
		getContentPane().add(tfProject);
		
		tfExam = new JTextField();
		tfExam.setColumns(10);
		tfExam.setBounds(149, 126, 200, 20);
		getContentPane().add(tfExam);
		
		JLabel label_4 = new JLabel("Final exam :");
		label_4.setHorizontalAlignment(SwingConstants.RIGHT);
		label_4.setBounds(63, 126, 80, 14);
		getContentPane().add(label_4);
		
		JLabel lblNewCourseName = new JLabel("New Course name :");
		lblNewCourseName.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewCourseName.setBounds(10, 35, 131, 14);
		getContentPane().add(lblNewCourseName);
	}

}
