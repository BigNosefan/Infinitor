package sellManagement;

import java.util.ArrayList;

public class SoldList {
	private ArrayList<ListItem> soldTable;
	private int sumPrice;
	public SoldList(){
		soldTable = new ArrayList<ListItem>();
		sumPrice = 0;
	}
	public void addListItem(ListItem li){
		soldTable.add(li);
		sumPrice += li.getSumPrice();
	}
	public int getSumPrice(){
		return sumPrice;
	}
	public void print(){
		for(ListItem li : soldTable){
			System.out.println(li);
		}
	}
}
