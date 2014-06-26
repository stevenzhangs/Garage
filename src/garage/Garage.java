package garage;

import java.util.Set;

/**
 * @author Steven Zhang
 *
 */
public interface Garage {
	
	/**
     * Takes a set of Car objects as a parameter, and returns the subset that
     * can be fixed in the given timeframe while generating as much revenue 
     * as possible.
     *
     * @param cars Set of cars waiting to be repaired
     * @param availableHours The number of hours you have to repair the cars
     * @return Set of cars that have been repaired
     */
    public Set<Car> repair(Set<Car> cars, int availableHours);

}
