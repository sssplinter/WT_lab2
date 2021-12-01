package by.tc.task01.dao;

import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.criteria.Criteria;

import java.util.List;

/**
 *
 */
public interface ApplianceDAO {

	/**
	 * Finds appliances that fit certain criteria.
	 * @param criteria criteria for search
	 * @return list of appliances that fit the criteria
	 */
	List<Appliance> find(Criteria criteria);

	/**
	 * Saves a list of appliances to storage.
	 * @param appliances list of appliances to save
	 */
	void save(List<Appliance> appliances);

	/**
	 * Gets all appliances from storage.
	 * @return list of all appliances
	 */
	List<Appliance> parseAll();
}
