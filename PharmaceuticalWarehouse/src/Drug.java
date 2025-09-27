import java.util.UUID;

public class Drug {
	
	String id;
	
	String name;
	
	String code;
	
	int price;
	
	String stock;
	
	DrugCategory dc;
	
	Drug(String name, String code, int price, String stock, DrugCategory dc){
		this.id = UUID.randomUUID().toString();
		this.name = name;
		this.code = code;
		this.price = price;
		this.stock = stock;
		this.dc = dc;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getStock() {
		return stock;
	}

	public void setStock(String stock) {
		this.stock = stock;
	}

	public DrugCategory getDc() {
		return dc;
	}

	public void setDc(DrugCategory dc) {
		this.dc = dc;
	}

}
