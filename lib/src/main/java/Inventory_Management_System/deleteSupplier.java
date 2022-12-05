package Inventory_Management_System;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class deleteSupplier extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					deleteSupplier frame = new deleteSupplier();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public deleteSupplier() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Supplier Name");
		lblNewLabel.setBounds(58, 113, 113, 16);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(183, 108, 130, 26);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Delete Supplier");
		lblNewLabel_1.setBounds(128, 53, 113, 16);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Delete");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				db app = new db();
				try {
					app.connect();
					app.removeSupplier(textField.getText());
					JOptionPane.showMessageDialog(null, "Successfull");
					textField.setText("");
				} catch (SQLException e1) {
					textField.setText("");
					JOptionPane.showMessageDialog(null, "Enter Supplier name again", "No such supplier", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnNewButton.setBounds(54, 188, 117, 29);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Home");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Options.main(null);
			}
			
		});
		btnNewButton_1.setBounds(266, 188, 117, 29);
		contentPane.add(btnNewButton_1);
	}

}
