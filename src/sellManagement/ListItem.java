package sellManagement;

import prodcutManagement.Product;

public class ListItem {
	Product product;
	int number;
	public ListItem(Product product,int number){
		this.product = product;
		this.number = number;
	}
	public ListItem(Product product){
		this.product = product;
		this.number = 1;
	}
	public int getSumPrice(){
		return product.getPreferPrice()*number;
	}
	public void setNumber(int num){
		this.number = num;
	}
	public String toString(){
		return this.product.toString()+"\t"+this.number+"\t"+this.getSumPrice();
	}
}
