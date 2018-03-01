package prodcutManagement;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import sellManagement.ListItem;

public class PriceTable {
	/*
	 * 价格表类
	 * 目的：可以通过此类查询货物价格等
	 * 
	 * 
	 */
	private int size;
	ArrayList<Product> productTable;
	public PriceTable(){
		//初始化
		size = 0;
		productTable = new ArrayList<Product>();
	}
	public void load(){
		//载入文本文档中的货品数据
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
					p = new Product(productCode, productName, productStandard, retailPrice, preferPrice, point);
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
	public int size(){
		return size;
	}
	public ListItem getListItemByCode(String Code){
		for(Product p : productTable){
			if(p.compareWithCode(Code)){
				return new ListItem(p);
			}
		}
		return null;
		
	}
	public ListItem getListItemByCode(String Code, int num){
		for(Product p : productTable){
			if(p.compareWithCode(Code)){
				return new ListItem(p,num);
			}
		}
		return null;
		
	}
	public ListItem getListItemByName(String Name){
		for(Product p : productTable){
			if(p.compareWithName(Name)){
				return new ListItem(p);
			}
		}
		return null;
		
	}
	public ListItem getListItemByName(String Name,int num){
		for(Product p : productTable){
			if(p.compareWithName(Name)){
				return new ListItem(p,num);
			}
		}
		return null;
		
	}
	
}
