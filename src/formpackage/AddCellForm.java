package formpackage;

import javax.swing.JFrame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import testpackage.StudentList;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddCellForm extends JFrame{
	private JTextField textField;
	
	public AddCellForm(int index) {
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
		setTitle("Add New cell Phone");
		getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(150, 32, 234, 20);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("new Cellphone :");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setBounds(39, 32, 101, 14);
		getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Add");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!textField.getText().isEmpty()){
					StudentList.getStudentlist().get(index).addCellPhone(textField.getText());
				}
				EditForm editForm = new EditForm(index);
				editForm.setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton.setBounds(96, 73, 89, 23);
		getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Cancel");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				EditForm editForm = new EditForm(index);
				editForm.setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton_1.setBounds(237, 73, 89, 23);
		getContentPane().add(btnNewButton_1);
	}
}
