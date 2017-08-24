package formpackage;

import javax.swing.JFrame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import testpackage.StudentList;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddMailForm extends JFrame{
	private JTextField textField;
	
	public AddMailForm(int index) {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosed(WindowEvent e) {
				EditForm editForm = new EditForm(index);
				editForm.setVisible(true);
			}
		});
		
		setResizable(false);

		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setSize(465, 171);
		setTitle("Add New Mail");
		getContentPane().setLayout(null);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!textField.getText().isEmpty()){
					StudentList.getStudentlist().get(index).addListMail(textField.getText());
				}
				EditForm editForm = new EditForm(index);
				editForm.setVisible(true);
				setVisible(false);
			}
		});
		btnAdd.setBounds(105, 74, 89, 23);
		getContentPane().add(btnAdd);
		
		JButton button_1 = new JButton("Cancel");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EditForm editForm = new EditForm(index);
				editForm.setVisible(true);
				setVisible(false);
			}
		});
		button_1.setBounds(246, 74, 89, 23);
		getContentPane().add(button_1);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(159, 33, 234, 20);
		getContentPane().add(textField);
		
		JLabel lblNewEmail = new JLabel("new Email :");
		lblNewEmail.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewEmail.setBounds(48, 33, 101, 14);
		getContentPane().add(lblNewEmail);
	}

}
