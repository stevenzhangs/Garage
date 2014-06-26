import java.util.*;
import garage.*;


public class UseGarage {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		RepairCar repariCar = new RepairCar();
	    int availableHours = 8;
	    Set<Car> carSet = new HashSet<Car>();

	    Car[] cars = new Car[4];
	    cars[0] = new Car("ABC-123", 3, 100);
	    cars[1] = new Car("DEF-456", 5, 120);
	    cars[2] = new Car("GHI-789", 4, 80);
	    cars[3] = new Car("ZZZ-999", 1, 50);

	    carSet.add(cars[0]);
	    carSet.add(cars[1]);
	    carSet.add(cars[2]);
	    carSet.add(cars[3]);

	    // 选中的集合
	    Set<Car> selectedCars = repariCar.repair(carSet, availableHours);
	    repariCar.printRepairCars(selectedCars);
	}

}
