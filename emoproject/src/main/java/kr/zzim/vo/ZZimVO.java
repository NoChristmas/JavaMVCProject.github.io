package kr.zzim.vo;

public class ZZimVO {
	private int zzim_num;
	private int mem_num;
	private int product_num;
	private String Product_title;
	private String Product_info;
	private String Product_photo1;
	private String Product_price;
	private int Product_status;
	private int Product_quantity;
	private String Order_date;
	private int Order_num;
	private String Product_name;
	private int Order_status;
	private String product_price_sales;
	private int review_num;
	private int Order_detail_num;
	private int Review_score;

	public ZZimVO() {}
	
	
	
	public int getReview_num() {
		return review_num;
	}



	public void setReview_num(int review_num) {
		this.review_num = review_num;
	}



	//생성자 정의
	public int getOrder_status() {
		return Order_status;
	}

	public void setOrder_status(int order_status) {
		Order_status = order_status;
	}

	public int getOrder_num() {
		return Order_num;
	}

	public int getReview_score() {
		return Review_score;
	}



	public void setReview_score(int review_score) {
		Review_score = review_score;
	}



	public int getOrder_detail_num() {
		return Order_detail_num;
	}



	public void setOrder_detail_num(int order_detail_num) {
		Order_detail_num = order_detail_num;
	}



	public void setOrder_num(int order_num) {
		Order_num = order_num;
	}

	public String getProduct_name() {
		return Product_name;
	}

	public void setProduct_name(String product_name) {
		Product_name = product_name;
	}
	public String getOrder_date() {
		return Order_date;
	}

	public void setOrder_date(String order_date) {
		Order_date = order_date;
	}

	public int getProduct_quantity() {
		return Product_quantity;
	}

	public void setProduct_quantity(int product_quantity) {
		Product_quantity = product_quantity;
	}
	public ZZimVO(int mem_num, int product_num) {
		this.mem_num = mem_num;
		this.product_num = product_num;
	}

	public int getZzim_num() {
		return zzim_num;
	}

	public String getProduct_title() {
		return Product_title;
	}

	public void setProduct_title(String product_title) {
		Product_title = product_title;
	}

	public String getProduct_info() {
		return Product_info;
	}

	public void setProduct_info(String product_info) {
		Product_info = product_info;
	}

	public String getProduct_photo1() {
		return Product_photo1;
	}

	public void setProduct_photo1(String product_photo1) {
		Product_photo1 = product_photo1;
	}

	public String getProduct_price() {
		return Product_price;
	}

	public void setProduct_price(String product_price) {
		Product_price = product_price;
	}

	public int getProduct_status() {
		return Product_status;
	}

	public void setProduct_status(int product_status) {
		Product_status = product_status;
	}

	public void setZzim_num(int zzim_num) {
		this.zzim_num = zzim_num;
	}

	public int getMem_num() {
		return mem_num;
	}

	public void setMem_num(int mem_num) {
		this.mem_num = mem_num;
	}

	public int getProduct_num() {
		return product_num;
	}

	public void setProduct_num(int product_num) {
		this.product_num = product_num;
	}

	public String getProduct_price_sales() {
		return product_price_sales;
	}

	public void setProduct_price_sales(String product_price_sales) {
		this.product_price_sales = product_price_sales;
	}

}
