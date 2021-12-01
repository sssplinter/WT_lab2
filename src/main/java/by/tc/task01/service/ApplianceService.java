package by.tc.task01.service;

import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.criteria.Criteria;

import java.util.Comparator;
import java.util.List;

public interface ApplianceService {
	/**
	 * Finds all appliances that fit criteria.
	 * @param criteria criteria for search
	 * @return list of found appliances
	 */
	List<Appliance> find(Criteria criteria);

	/**
	 * Sorts a list of appliances.
	 * @param comparator specifies property to sort by
	 * @param appliances limited list of appliances to search among
	 * @return sorted list of appliances
	 */
	List<Appliance> sort(Comparator<Appliance> comparator, List<Appliance> appliances);

	/**
	 * Sots all appliances.
	 * @param comparator specifies property to sort by
	 * @return sorted list of appliances
	 */
	List<Appliance> sort(Comparator<Appliance> comparator);

	/**
	 * Finds appliances with minimal value of some property.
	 * @param comparator specifies property to compare by
	 * @param appliances limited list of appliances to search among
	 * @return list of appliances with minimal value of desired property
	 */
	List<Appliance> getMin(Comparator<Appliance> comparator, List<Appliance> appliances);

	/** Finds appliances with minimal value of some property among all appliances.
	 * @param comparator specifies property to compare by
	 * @return list of appliances with minimal value of desired property
	 */
	List<Appliance> getMin(Comparator<Appliance> comparator);
	/**
	 * Finds appliances with maximal value of some property.
	 * @param comparator specifies property to compare by
	 * @param appliances limited list of appliances to search among
	 * @return list of appliances with maximal value of desired property
	 */
	List<Appliance> getMax(Comparator<Appliance> comparator, List<Appliance> appliances);
	/**
	 * Finds appliances with maximal value of some property among all appliances.
	 * @param comparator specifies property to compare by
	 * @return list of appliances with maximal value of desired property
	 */
	List<Appliance> getMax(Comparator<Appliance> comparator);

	/**
	 * Saves a list of appliances.
	 * @param appliances list to save
	 */
	void save(List<Appliance> appliances);

}
