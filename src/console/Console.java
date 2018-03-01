package console;

import java.util.Scanner;

import prodcutManagement.PriceTable;
import sellManagement.SoldList;

public class Console {
	private PriceTable priceTable;
	private SoldList soldList;
	private String input;
	private String[] inputArray;
	public Console(){
		priceTable = new PriceTable();
		priceTable.load();
		soldList = new SoldList();
	}
	public void run(){
		Scanner in = new Scanner(System.in);
		while(!(input = in.nextLine()).equals("quit")){
			inputArray = input.split(" ");
			if(inputArray.length==1){
				soldList.addListItem(priceTable.getListItemByName(inputArray[0]));
			}else if(inputArray.length==2){
				soldList.addListItem(priceTable.getListItemByName(inputArray[0],Integer.parseInt(inputArray[1])));
			}else{
				System.out.println("Input Error!!!");
			}
		}
	}
	public void print(){

		System.out.println("****************************************商品清单****************************************");
		System.out.println("编号\t\t名称\t\t规格\t\t零售价\t优惠价\t点数\t个数\t总价");
		soldList.print();
		System.out.println("\n总价："+soldList.getSumPrice());
	}
	
	
}

