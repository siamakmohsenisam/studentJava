package formpackage;

import javax.swing.JFrame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import personpackage.Address;
import testpackage.StudentList;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddAddressForm extends JFrame{
	private JTextField tfAppartment;
	private JTextField tfBuilding;
	private JTextField tfStreet;
	private JTextField tfCity;
	private JTextField tfCountry;
	private JTextField tfPostalCode;
	
	public AddAddressForm(int index) {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosed(WindowEvent arg0) {
				EditForm editForm = new EditForm(index);
				editForm.setVisible(true);
			}
		});
		
		setResizable(false);

		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setSize(450, 200);
		setTitle("Add New Address");
		getContentPane().setLayout(null);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Address address=new Address();
				try{				
					address.setAppartment(tfAppartment.getText());
					address.setStreet(tfStreet.getText());
					address.setBuilding(tfBuilding.getText());
					address.setCity(tfCity.getText());
					address.setCountry(tfCountry.getText());
					address.setPostalcode(tfPostalCode.getText());					
					StudentList.getStudentlist().get(index).addAddress(address);					
				}
				catch(Exception e7)
				{
					JOptionPane.showMessageDialog(null, "Sorry some thing is wrong  ", "error misage", 0, null);
				}
				EditForm editForm = new EditForm(index);
				editForm.setVisible(true);
				setVisible(false);
			}
		});
		btnAdd.setBounds(115, 119, 89, 23);
		getContentPane().add(btnAdd);
		
		JButton button_1 = new JButton("Cancel");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EditForm editForm = new EditForm(index);
				editForm.setVisible(true);
				setVisible(false);
			}
		});
		button_1.setBounds(256, 119, 89, 23);
		getContentPane().add(button_1);
		
		tfAppartment = new JTextField();
		tfAppartment.setColumns(10);
		tfAppartment.setBounds(337, 22, 86, 20);
		getContentPane().add(tfAppartment);
		
		JLabel label_1 = new JLabel("Appartment :");
		label_1.setHorizontalAlignment(SwingConstants.RIGHT);
		label_1.setBounds(251, 22, 80, 14);
		getContentPane().add(label_1);
		
		JLabel label_2 = new JLabel("Building :");
		label_2.setHorizontalAlignment(SwingConstants.RIGHT);
		label_2.setBounds(251, 47, 80, 14);
		getContentPane().add(label_2);
		
		tfBuilding = new JTextField();
		tfBuilding.setColumns(10);
		tfBuilding.setBounds(337, 47, 86, 20);
		getContentPane().add(tfBuilding);
		
		tfStreet = new JTextField();
		tfStreet.setColumns(10);
		tfStreet.setBounds(337, 72, 86, 20);
		getContentPane().add(tfStreet);
		
		JLabel label_3 = new JLabel("Street :");
		label_3.setHorizontalAlignment(SwingConstants.RIGHT);
		label_3.setBounds(251, 72, 80, 14);
		getContentPane().add(label_3);
		
		JLabel label_4 = new JLabel("City :");
		label_4.setHorizontalAlignment(SwingConstants.RIGHT);
		label_4.setBounds(29, 47, 80, 14);
		getContentPane().add(label_4);
		
		tfCity = new JTextField();
		tfCity.setColumns(10);
		tfCity.setBounds(115, 47, 86, 20);
		getContentPane().add(tfCity);
		
		tfCountry = new JTextField();
		tfCountry.setColumns(10);
		tfCountry.setBounds(115, 72, 86, 20);
		getContentPane().add(tfCountry);
		
		JLabel label_5 = new JLabel("Country :");
		label_5.setHorizontalAlignment(SwingConstants.RIGHT);
		label_5.setBounds(29, 72, 80, 14);
		getContentPane().add(label_5);
		
		JLabel lblPostalcode = new JLabel("PostalCode :");
		lblPostalcode.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPostalcode.setBounds(10, 25, 99, 14);
		getContentPane().add(lblPostalcode);
		
		tfPostalCode = new JTextField();
		tfPostalCode.setColumns(10);
		tfPostalCode.setBounds(115, 22, 86, 20);
		getContentPane().add(tfPostalCode);
	}

}
