package Inventory_Management_System;

import java.io.*;
import java.util.ArrayList;
//class for the arrayList functions 
public class ProductList implements Serializable {

	private static final long serialVersionUID = 1L;
	private ArrayList<Product> productList=new ArrayList<Product>();

	public ArrayList<Product> getProductList() {
		return productList;
	}

	public void setProductList(ArrayList<Product> productList) {
		this.productList = productList;
	}
	public ProductList(String filename) {
		load(filename);
	}
	public void add(Product prod) {
		productList.add(prod);
	}
	public void remove(String p) {
		boolean removed=false;
		for(int i=0;i<length();i++)
		{
			if(productList.get(i).getName().equals(p)) {
				productList.remove(i);
				removed=true;
				}
		}
		if(!removed)
		{
			System.out.println("Product does not exist");
		}
	}
	public void modifyQuant(String nn, int pp) {
		boolean removed=false;
		for(int i=0;i<length();i++)
		{
			if(productList.get(i).getName().equals(nn)) {
				productList.get(i).setQuant(pp);
				removed=true;
				}
		}
		if(!removed)
		{
			System.out.println("Product does not exist");
		}
	}
	public int length() {
		return productList.size();
	}
	public String toString() {
		String s="";
		for(int i=0;i<length();i++)
			s+=productList.get(i).toString()+"\n";
		return s;
		
	}
	
	//function to store the data to a file before exiting
	public void exit(String filename) {
		try(ObjectOutput out= new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(filename)))){
			out.writeObject(productList);
			System.out.println("Successfully saved data to"+" filename");
		}
		catch(FileNotFoundException e) {
			System.err.println("Couldnt save data!"+e.getMessage());
		}
		catch(IOException e) {
			System.err.println("I/O errpr"+e.getMessage());
		}
	}
	@SuppressWarnings("unchecked")
	//function to load data before main executes
	public void load(String filename) {
		File file = new File(filename);
		try(ObjectInputStream in = new ObjectInputStream(new BufferedInputStream(new FileInputStream(file))))
				{
					productList = (ArrayList<Product>) in.readObject();
				} catch (FileNotFoundException e) {
					productList= new ArrayList<Product>();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	}
	public String lowInventory() {
		String low="";
		boolean notLow=true;
		for(int i=0;i<length();i++)
			if(productList.get(i).isLow())
				{low+=productList.get(i)+"\n";
				notLow=false;
				}
		if(notLow)
			System.out.println("No product is below the prescribed quantity threshold");
		return low;
	}


}
