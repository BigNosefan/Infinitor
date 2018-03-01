package prodcutManagement;

/**
 * 
 * @author BigFan
 * @version 0.0
 * @since 2018-3-1
 * 
 *		this class aim to describe a product of infinitus.
 */

public class Product {
	private String productCode;
	private String productName;
	private String productStandard;
	private int retailPrice;
	private int preferPrice;
	private int point;
	public Product(String productCode, String productName, int retailPrice,
			int preferPrice, int point) {
		//不包含产品规格的构造函数
		super();
		this.productCode = productCode;
		this.productName = productName;
		this.retailPrice = retailPrice;
		this.preferPrice = preferPrice;
		this.point = point;
	}
	public Product(String productCode, String productName,
			String productStandard, int retailPrice, int preferPrice, int point) {
		super();
		//包含产品规格的构造函数
		this.productCode = productCode;
		this.productName = productName;
		this.productStandard = productStandard;
		this.retailPrice = retailPrice;
		this.preferPrice = preferPrice;
		this.point = point;
	}
	public String toString(){
		String str = this.productCode+" "+this.productName+" "+this.retailPrice+" "+this.preferPrice+" "+this.point;
		return str;
	}
	
}
