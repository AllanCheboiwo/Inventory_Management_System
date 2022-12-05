package Inventory_Management_System;

import java.awt.EventQueue;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ListUsers extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JButton btnNewButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListUsers frame = new ListUsers();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public ListUsers() throws SQLException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		String[] fields = {"Username","Email"};
		db app = new db();
		app.connect();
		table = new JTable(app.ListUsers(),fields);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(6, 36, 438, 189);
		contentPane.add(scrollPane);

		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel = new JLabel("List of Users");
		lblNewLabel.setBounds(133, 8, 117, 16);
		contentPane.add(lblNewLabel);
		
		btnNewButton = new JButton("Home");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Options.main(null);
			}
		});
		btnNewButton.setBounds(152, 237, 117, 29);
		contentPane.add(btnNewButton);
	}
}
