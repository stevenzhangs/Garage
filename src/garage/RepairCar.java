package garage;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import garage.Car;
import garage.Knapsack;

/**
 * @author Steven Zhang
 * 
 */
public class RepairCar implements Garage {

	@Override
	public Set<Car> repair(Set<Car> cars, int availableHours) {
		int carNum = cars.size();
		int[] hours = new int[carNum];
		int[] prices = new int[carNum];

		// 填充hours和prices数组
		Car[] carsArr = cars.toArray(new Car[carNum]); // set转数组
		for (int i = 0; i < carNum; ++i) {
			Car car = carsArr[i];
			hours[i] = car.getRepairHours();
			prices[i] = car.getRepairPrice();
		}

		// 使用Knapsack模型获取最大利润
		Knapsack knapsack = new Knapsack(hours, prices, availableHours);
		knapsack.dynamicExecute();
		int[] resultArr = knapsack.getResult();

		// 结果放到selectedCars Set中
		Set<Car> selectedCars = new HashSet<Car>();
		for (int j = 0; j < resultArr.length; ++j) {
			if (resultArr[j] == 1) {
				selectedCars.add(carsArr[j]);
			}
		}

		return selectedCars;
	}

	// 将车的集合输出到屏幕
	public void printRepairCars(Set<Car> selectedCars) {
		System.out.println("要修的车是：");
		Iterator<Car> car_iter = selectedCars.iterator();
		while (car_iter.hasNext()) {
			Car car = car_iter.next();
			System.out.print(car.getRegistrationNumber());
			if (car_iter.hasNext()) {
				System.out.print(",");
			}
		}
		System.out.println();
	}

}
