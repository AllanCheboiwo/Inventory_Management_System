package Inventory_Management_System;

import java.util.Scanner;

public class test {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		db app = new db();//creates an object of the db class so we can utilise its functions
		app.connect();//Creates a connection to the database
		boolean end=false;
		while(!end){
			System.out.println("Would you like to add a Product? (1)");
			System.out.println("Would you like to remove a Product? (2)");
			System.out.println("Would you like to see the inventory? (3)");
			System.out.println("Would you like the check if any of your inventory is low? (4)");
			System.out.println("Would you like to remove specific amount from an items quantity (5)");
			int t = sc.nextInt();
		switch(t){
			case 1: 
				System.out.println("enter product name: ");
				String q = sc.next();
				System.out.println("enter product expiration Date(YYYY-MM-DD): ");
				String w = sc.next();
				System.out.println("enter product quantity: ");
				int e = sc.nextInt();
				System.out.println("enter product Value (After tax): ");
				double r = sc.nextDouble();
				Product p1 = new Product(q, w, e, r);
				app.addProduct(p1);
				System.out.println("Succesfully added item: "+p1);
				break;
			case 2: //moved the logic for removing to remove function in ProductList
				System.out.println("What item would you like to remove? ");
				String rem = sc.next();
				app.removeProduct(rem);
				break;
			case 3:
				System.out.println(app.listProducts());
				break;		
			case 4:
				System.out.println(app.listLowInventryProducts());
				break;		
			case 5:
				System.out.println("Enter the name and quantity");
				String d = sc.next();
				app.modifyQuantity(d,sc.nextInt());
				break;
		}
		System.out.println("Would you like to perform another action? (Y/N) ");
		String yesNo = sc.next();
		if(yesNo.equalsIgnoreCase("y"))
		{}
		else
			end=true;
		}
		sc.close();
		app.close();
		
	}

}