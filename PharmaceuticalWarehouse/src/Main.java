import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main {

	public static void main(String[] args) {

		// 1. Drug creation
		List<Drug> drugs = new ArrayList<>();
		drugs = createNewDrugs(4);
		// 2. Show Current Drugs
		showCurrentDrugs(drugs);
		List<Warehouse_Movement> wm = new ArrayList<>();
		// 3. Create Warehouse movements
		wm = createWarehouseMovement(4);
		try {
			// 4.Show Movements by Drug Category and Creation Date use format "yyyy-MM-dd"
			showCurrentMovementsByDrugCategoryAndCreationDate(wm, "Category1", "2025-09-11", "2025-09-27");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// 5. Calculate Balance from Movements
		calculateBalanceFromMovements(wm);

	}

	private static void calculateBalanceFromMovements(List<Warehouse_Movement> wms) {
		int balance = 0;
		for (Warehouse_Movement wm : wms) {
			int value = wm.getDrug().getPrice() * Integer.parseInt(wm.getQuantity());
			if (wm.getType().equals(Warehouse_Movement.MovementType.INCOMING)) {
				balance += value;
			} else {
				balance -= value;
			}
		}
		System.out.println("Current Balance from Movements is: " + balance + " EUR");

	}

	private static List<Warehouse_Movement> createWarehouseMovement(int numberOfMovements) {
		List<Warehouse_Movement> wm = new ArrayList<>();

		// Create Drugs prior movements
		List<Drug> drugs = createNewDrugs(4);

		for (int i = 0; i < numberOfMovements; i++) {
			String num = Integer.toString(i);
			Warehouse_Movement movement = new Warehouse_Movement(
					i % 2 == 0 ? Warehouse_Movement.MovementType.INCOMING : Warehouse_Movement.MovementType.OUTCOMING,
					drugs.get(i), "10", new Date());

			wm.add(movement);

			System.out.println("Created Movement: Type=" + movement.getType() + ", Drug=" + movement.getDrug().getName()
					+ ", Quantity=" + movement.getQuantity() + ", CreatedOn=" + movement.getCreatedOn());
		}

		return wm;
	}

	private static void showCurrentDrugs(List<Drug> drugs) {

		for (Drug drug : drugs) {
			System.out.println("Drug Details: Name: " + drug.getName() + ", Price: " + drug.getPrice() + " EUR, Code: "
					+ drug.getCode() + " Stock: " + drug.getStock() + " Category:" + drug.getDc().getDescription());
		}
	}

	private static List<Drug> createNewDrugs(int numberOfDrugs) {

		List<Drug> drugs = new ArrayList<>();
		for (int i = 0; i < numberOfDrugs; i++) {
			String num = Integer.toString(i);
			drugs.add(
					new Drug("Drug" + num, num, i + 5, num, new DrugCategory(i % 2 == 0 ? "Category1" : "Category2")));
		}

		return drugs;

	}

	private static void showCurrentMovementsByDrugCategoryAndCreationDate(List<Warehouse_Movement> wms,
			String drugCategory, String minDate, String maxDate) throws ParseException {
		//Include whole max date (Avoid issue with 00:00:00)
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date minimumDate = formatter.parse(minDate + " 00:00:00");
		Date maximumDate = formatter.parse(maxDate + " 23:59:59");

		for (Warehouse_Movement wm : wms) {
			if (wm.getDrug().getDc().getDescription().equals(drugCategory) && !wm.getCreatedOn().before(minimumDate)
					&& !wm.getCreatedOn().after(maximumDate)) {
				System.out.println("Warehouse Movements of Category:"+ drugCategory +", between " + minimumDate + "-" + maximumDate
						+ ": Movement Type: " + wm.getType().toString() + " Drug: " + wm.getDrug().getName()
						+ " Quantity: " + wm.getQuantity() + " Create On: " + wm.getCreatedOn());
			}
		}

	}
}
