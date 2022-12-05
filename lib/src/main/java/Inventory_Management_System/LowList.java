package Inventory_Management_System;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class LowList extends JFrame {
	private JTable table;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Options frame1= new Options();
					frame1.setVisible(true);
					LowList frame = new LowList();
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
	public LowList() throws SQLException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("LOW ON INVENTORY");
		String[] fields = {"Product Name","Expiry Date","Quantity","Value"};
		db app = new db();
		app.connect();
		this.setSize(720,400);
		getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(6, 41, 708, 292);
		getContentPane().add(scrollPane);
		
		table = new JTable(app.listLowInventryProducts(),fields);
		scrollPane.setViewportView(table);
		
		JButton btnNewButton = new JButton("Home");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Options.main(null);
			}
		});
		btnNewButton.setBounds(267, 337, 117, 29);
		getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("List of Low Quantity products");
		lblNewLabel.setBounds(302, 6, 192, 23);
		getContentPane().add(lblNewLabel);
		this.setVisible(true);
	}

}
