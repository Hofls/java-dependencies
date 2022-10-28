package hello;

public class Purchase {

	private String userName;
	private String product;

	public Purchase() {
	}

	public Purchase(String userName, String product) {
		this.userName = userName;
		this.product = product;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	@Override
	public String toString() {
		return String.format("Purchase{user=%s, product=%s}", getUserName(), getProduct());
	}

}
