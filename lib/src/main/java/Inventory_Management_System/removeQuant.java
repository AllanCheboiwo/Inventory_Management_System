package Inventory_Management_System;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.UIManager;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JButton;

public class removeQuant extends JFrame {
	private String q = null;
	private String r = null;
	private int w=0;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					removeQuant frame = new removeQuant();
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
	public removeQuant() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(UIManager.getColor("Button.darkShadow"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Changing Quantity");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		lblNewLabel.setForeground(UIManager.getColor("Button.highlight"));
		lblNewLabel.setBounds(75, 6, 297, 50);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Name:");
		lblNewLabel_1.setForeground(UIManager.getColor("Button.highlight"));
		lblNewLabel_1.setBounds(51, 83, 61, 16);
		contentPane.add(lblNewLabel_1);
		
		JTextField textField = new JTextField();
		textField.setBounds(124, 78, 130, 26);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Quantity:");
		lblNewLabel_2.setForeground(UIManager.getColor("Button.highlight"));
		lblNewLabel_2.setBounds(51, 111, 61, 16);
		contentPane.add(lblNewLabel_2);
		
		JTextField textField_1 = new JTextField();
		textField_1.setBounds(124, 106, 130, 26);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewButton = new JButton("Change quantity");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				db app = new db();
				try {
					app.connect();
					q = textField.getText();
					r = textField_1.getText();
					w = Integer.parseInt(r);
					app.modifyQuantity(q, w);
					JOptionPane.showMessageDialog(null,"Successful");
					textField.setText("");
					textField_1.setText("");
				} catch (SQLException e1) {
					textField.setText("");
					textField_1.setText("");
					JOptionPane.showMessageDialog(null, "Enter product name and quantity again", "no such record/incorrect quantity type", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnNewButton.setBounds(29, 174, 142, 29);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Home");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Options.main(null);
				}
		});
		btnNewButton_1.setBounds(236, 174, 117, 29);
		contentPane.add(btnNewButton_1);
	}

}
