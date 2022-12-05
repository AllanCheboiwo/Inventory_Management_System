package Inventory_Management_System;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.UIManager;
import java.awt.List;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class Look extends JFrame {
	private JTable table;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					new Look();
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
	public Look() throws SQLException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("INVENTORY");
		getContentPane().setLayout(null);

		String[] fields = {"Product Name","Expiry Date","Quantity","Value"};
		db app = new db();
		app.connect();
		table = new JTable(app.listProducts(),fields);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(6, 48, 428, 175);
		getContentPane().add(scrollPane);
		scrollPane.setViewportView(table);
		
		JButton btnNewButton = new JButton("Home");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Options.main(null);
			}
		});
		btnNewButton.setBounds(137, 235, 117, 29);
		getContentPane().add(btnNewButton);
		this.setSize(440,296);
		this.setVisible(true);

		
		
	}
}
