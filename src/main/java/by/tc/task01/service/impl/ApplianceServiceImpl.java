package by.tc.task01.service.impl;

import by.tc.task01.dao.ApplianceDAO;
import by.tc.task01.dao.DAOFactory;
import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.criteria.Criteria;
import by.tc.task01.service.ApplianceService;
import by.tc.task01.service.validation.Validator;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * The type of appliance xml service.
 */
public class ApplianceServiceImpl implements ApplianceService {
    /**
     * Finds all appliances that fit the criteria if criteria are valid.
     *
     * @param criteria criteria for search
     * @return list of found appliances
     */
    @Override
    public List<Appliance> find(Criteria criteria) {
        if (Validator.isValidCriteria(criteria)) {
            ApplianceDAO applianceDAO = DAOFactory.getInstance().getApplianceDAO();
            return applianceDAO.find(criteria);
        } else
            return null;
    }

    /**
     * Gets sorted by comparator appliances.
     *
     * @param comparator for sorting appliances
     * @return list of sorted by comparator appliances
     */
    @Override
    public List<Appliance> sort(Comparator<Appliance> comparator) {
        List<Appliance> appliances = DAOFactory.getInstance().getApplianceDAO().parseAll();
        appliances.sort(comparator);
        return appliances;
    }

    /**
     * Gets minimal appliances by criteria.
     *
     * @param comparator defines minimal value criteria
     * @return list of appliances with minimal criteria defined by comparator
     */
    @Override
    public List<Appliance> sort(Comparator<Appliance> comparator, List<Appliance> appliances) {
        appliances.sort(comparator);
        return appliances;
    }

    /**
     * Gets all appliances with minimum price.
     *
     * @param comparator specifies property to compare by
     * @return list of appliances with minimum price
     */
    @Override
    public List<Appliance> getMin(Comparator<Appliance> comparator) {
        List<Appliance> appliances = DAOFactory.getInstance().getApplianceDAO().parseAll();
        Appliance min = appliances.stream().min(comparator).orElse(null);
        if (min != null) {
            return appliances.stream()
                    .filter(p -> comparator.compare(p, min) == 0)
                    .collect(Collectors.toList());
        }

        return new ArrayList<>();
    }

    /**
     * Gets all appliances from given list with minimum price.
     *
     * @param comparator specifies property to compare by
     * @param appliances limited list of appliances to search among
     * @return list of appliances from given list with minimum price
     */
    @Override
    public List<Appliance> getMin(Comparator<Appliance> comparator, List<Appliance> appliances) {
        Appliance min = appliances.stream().min(comparator).orElse(null);
        if (min != null) {
            return appliances.stream()
                    .filter(p -> comparator.compare(p, min) == 0)
                    .collect(Collectors.toList());
        }

        return new ArrayList<>();
    }

    /**
     * Gets all appliances with maximum price.
     *
     * @param comparator specifies property to compare by
     * @return list of appliances with maximum price
     */
    @Override
    public List<Appliance> getMax(Comparator<Appliance> comparator) {
        List<Appliance> appliances = DAOFactory.getInstance().getApplianceDAO().parseAll();
        Appliance max = appliances.stream().max(comparator).orElse(null);
        if (max != null) {
            return appliances.stream()
                    .filter(p -> comparator.compare(p, max) == 0)
                    .collect(Collectors.toList());
        }

        return new ArrayList<>();
    }

    /**
     * Gets all appliances from given list with maximum price.
     *
     * @param comparator specifies property to compare by
     * @param appliances limited list of appliances to search among
     * @return list of appliances from given list with maximum price
     */
    @Override
    public List<Appliance> getMax(Comparator<Appliance> comparator, List<Appliance> appliances) {
        Appliance max = appliances.stream().max(comparator).orElse(null);
        if (max != null) {
            return appliances.stream()
                    .filter(p -> comparator.compare(p, max) == 0)
                    .collect(Collectors.toList());
        }

        return new ArrayList<>();
    }

    /**
     * Appends appliances to xml file.
     *
     * @param appliances the list of appliances to add to model
     */
    @Override
    public void save(List<Appliance> appliances) {
        DAOFactory.getInstance().getApplianceDAO().save(appliances);
    }
}

