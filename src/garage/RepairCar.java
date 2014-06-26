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

		// ���hours��prices����
		Car[] carsArr = cars.toArray(new Car[carNum]); // setת����
		for (int i = 0; i < carNum; ++i) {
			Car car = carsArr[i];
			hours[i] = car.getRepairHours();
			prices[i] = car.getRepairPrice();
		}

		// ʹ��Knapsackģ�ͻ�ȡ�������
		Knapsack knapsack = new Knapsack(hours, prices, availableHours);
		knapsack.dynamicExecute();
		int[] resultArr = knapsack.getResult();

		// ����ŵ�selectedCars Set��
		Set<Car> selectedCars = new HashSet<Car>();
		for (int j = 0; j < resultArr.length; ++j) {
			if (resultArr[j] == 1) {
				selectedCars.add(carsArr[j]);
			}
		}

		return selectedCars;
	}

	// �����ļ����������Ļ
	public void printRepairCars(Set<Car> selectedCars) {
		System.out.println("Ҫ�޵ĳ��ǣ�");
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
