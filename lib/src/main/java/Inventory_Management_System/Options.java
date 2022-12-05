package Inventory_Management_System;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.google.api.services.tasks.model.Task;

import javax.swing.UIManager;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.TextArea;
import java.awt.Label;
import java.awt.Button;
import java.awt.Color;
import javax.swing.JList;
import java.awt.List;

public class Options extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Options frame = new Options();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws GeneralSecurityException 
	 * @throws IOException 
	 */
	public Options() throws IOException, GeneralSecurityException {
		getContentPane().setForeground(new Color(39, 61, 253));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Options");
		JMenu mnNewMenu_1=new JMenu("Communications");
		JMenu mnNewMenu_2=new JMenu("Reports");
		JMenu mnNewMenu_3=new JMenu("Tasks");
		JMenu mnNewMenu_4=new JMenu("Events");
		menuBar.add(mnNewMenu);
		menuBar.add(mnNewMenu_2);
		menuBar.add(mnNewMenu_1);
		menuBar.add(mnNewMenu_3);
		menuBar.add(mnNewMenu_4);
		mnNewMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					Add.main(null);
			}
		});
	
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Add Product");
		mnNewMenu.add(mntmNewMenuItem_1);
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					Add.main(null);
			}
		});
		
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Remove Product");
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					Remove.main(null);
			}
		});
		mnNewMenu.add(mntmNewMenuItem_3);
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("Product Inventory");
		mntmNewMenuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					Look.main(null);
			}
		});
		mnNewMenu_2.add(mntmNewMenuItem_4);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Product Low Stock Items");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					LowList.main(null);
			}
		});
		mnNewMenu_2.add(mntmNewMenuItem_2);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Product Quantity Change");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					removeQuant.main(null);
			}
		});
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_6 = new JMenuItem("Add supplier");
		mntmNewMenuItem_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					addSupplier.main(null);
			}
		});
		mnNewMenu.add(mntmNewMenuItem_6);
		
		JMenuItem mntmNewMenuItem_7 = new JMenuItem("Add user");
		mntmNewMenuItem_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					addUser.main(null);
			}
		});
		mnNewMenu.add(mntmNewMenuItem_7);
		
		JMenuItem mntmNewMenuItem_8= new JMenuItem("Delete supplier");
		mntmNewMenuItem_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					deleteSupplier.main(null);
			}
		});
		mnNewMenu.add(mntmNewMenuItem_8);
		
		JMenuItem mntmNewMenuItem_9 = new JMenuItem("Delete User");
		mntmNewMenuItem_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					deleteUser.main(null);
			}
		});
		mnNewMenu.add(mntmNewMenuItem_9);
		
		JMenuItem mntmNewMenuItem_10 = new JMenuItem("List suppliers");
		mntmNewMenuItem_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					ListSuppliers.main(null);
			}
		});
		mnNewMenu_2.add(mntmNewMenuItem_10);
		
		JMenuItem mntmNewMenuItem_11 = new JMenuItem("List Users");
		mntmNewMenuItem_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					ListUsers.main(null);
			}
		});
		mnNewMenu_2.add(mntmNewMenuItem_11);
		
		JMenuItem mntmNewMenuItem_5 = new JMenuItem("Close");
		mntmNewMenuItem_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					System.exit(ABORT);
			}
		});
		mnNewMenu.add(mntmNewMenuItem_5);
		
		JMenuItem mntmNewMenuItem_12 = new JMenuItem("Send alert");
		mntmNewMenuItem_12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					Alert.main(null);
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_12);
		
	
		JMenuItem mntmNewMenuItem_13= new JMenuItem("Send Order");
		mntmNewMenuItem_13.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					//System.exit(ABORT);
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_13);
		
		JMenuItem mntmNewMenuItem_14= new JMenuItem("AddTransaction");
		mntmNewMenuItem_14.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					addTransaction.main(null);
			}
		});
		mnNewMenu.add(mntmNewMenuItem_14);

		JMenuItem mntmNewMenuItem_15= new JMenuItem("Delete Transaction");
		mntmNewMenuItem_15.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					deleteTransaction.main(null);
			}
		});
		mnNewMenu.add(mntmNewMenuItem_15);

		JMenuItem mntmNewMenuItem_16= new JMenuItem("Transaction Rate");
		mntmNewMenuItem_16.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					TransactionRate.main(null);
			}
		});
		mnNewMenu.add(mntmNewMenuItem_16);

		JMenuItem mntmNewMenuItem_17= new JMenuItem("	List Transactions");
		mntmNewMenuItem_17.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					ListTransactions.main(null);
			}
		});
		mnNewMenu_2.add(mntmNewMenuItem_17);
		
		
		JMenuItem mntmNewMenuItem_18= new JMenuItem("Create Task");
		mntmNewMenuItem_18.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					Create_task.main(null);
			}
		});
		mnNewMenu_3.add(mntmNewMenuItem_18);
		
		JMenuItem mntmNewMenuItem_19= new JMenuItem("CompleteTask");
		mntmNewMenuItem_19.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					CompleteTask.main(null);
			}
		});
		mnNewMenu_3.add(mntmNewMenuItem_19);
		
		JMenuItem mntmNewMenuItem_20= new JMenuItem("Create Event");
		mntmNewMenuItem_20.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					CreateEvent.main(null);
			}
		});
		mnNewMenu_4.add(mntmNewMenuItem_20);
		getContentPane().setLayout(null);
		
		
		getContentPane().setLayout(null);
		
		JList list = new JList(CalendarAPI.getEvent().toArray());
		list.setBounds(6, 49, 227, 195);
		getContentPane().add(list);
		
		JList list_1 = new JList(TasksAPI.getTasks().toArray());
		list_1.setBounds(242, 49, 208, 195);
		getContentPane().add(list_1);
		
		JLabel lblNewLabel = new JLabel("TO DO LIST");
		lblNewLabel.setBounds(288, 10, 122, 29);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("UPCOMING EVENTS");
		lblNewLabel_1.setBounds(6, 10, 148, 27);
		getContentPane().add(lblNewLabel_1);


	}

}
