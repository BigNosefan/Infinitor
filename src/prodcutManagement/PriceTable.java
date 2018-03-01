package prodcutManagement;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class PriceTable {
	private int size;
	ArrayList<Product> productTable;
	public PriceTable(){
		size = 0;
		productTable = new ArrayList<Product>();
	}
	public void load(){
		String productCode;
		String productName;
		String productStandard;
		int preferPrice;
		int retailPrice;
		int point;
		Product p;
		String str;
		String[] arr;
		BufferedReader br = null;
		try {
			br = new BufferedReader(
					new FileReader(
							new File("priceTable.txt")));
			if(br!=null){
				System.out.println("loading....");
				while((str = br.readLine())!=null){
					arr = str.split("\t");
					productCode = arr[0];
					productName = arr[1];
					productStandard =arr[2];
					retailPrice = Integer.parseInt(arr[4]);
					preferPrice = Integer.parseInt(arr[5]);
					point = Integer.parseInt(arr[6]);
//					System.out.println(productCode+productName+retailPrice+" "+preferPrice+" "+point);
					p = new Product(productCode, productName, retailPrice, preferPrice, point);
					productTable.add(p);
					size++;
				}
				System.out.println("successfully loaded.");
			}
		} catch (FileNotFoundException e) {
			System.out.println("Cannot find the file!");
		} catch (IOException e){
			System.out.println("IO Failed!");	
		}
		
	}
}
