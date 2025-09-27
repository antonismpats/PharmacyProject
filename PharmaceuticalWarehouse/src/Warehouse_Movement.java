import java.util.Date;
import java.util.UUID;

public class Warehouse_Movement {
	
	String id;
	
    MovementType type;

	enum MovementType{
		INCOMING,OUTCOMING
	}
		
	Drug drug;
	
	String quantity;
	
	Date createdOn;
	

	
	Warehouse_Movement(MovementType type , Drug drug , String quantity , Date createdOn){
		this.id = UUID.randomUUID().toString();
		this.type=type;
		this.drug = drug;
		this.quantity = quantity;
		this.createdOn = createdOn;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Drug getDrug() {
		return drug;
	}

	public void setDrug(Drug drug) {
		this.drug = drug;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}
	
	public MovementType getType() {
		return type;
	}

	public void setType(MovementType type) {
		this.type = type;
	}

}
