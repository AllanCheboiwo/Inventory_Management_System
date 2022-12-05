package Inventory_Management_System;
public class Transaction {

	  String prodName;
		String transDate; 
		int transQuan;

		Transaction(String prodName, String transDate, int transQuan) {
			this.prodName = prodName;
			this.transDate = transDate;
			this.transQuan = transQuan;
		}

		//generated the getters and setter again for the class attributes
		public String getName() {
			return prodName;
		}


		public void setName(String prodName) {
			this.prodName = prodName;
		}


		public String getDate() {
			return transDate;
		}

		public void setDate(String transDate) {
			this.transDate = transDate;
		}

		public int getQuant() {
			return transQuan;
		}
		public void setQuant(int transQuan) {
			this.transQuan = transQuan;
		}
		

		//Modified toString method
		public String toString() {
			return getName() + ", " + getDate()+", "+getQuant();
		}

}
