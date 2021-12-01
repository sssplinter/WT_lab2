package by.tc.task01.dao.impl;

import by.tc.task01.dao.ApplianceDAO;
import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.criteria.Criteria;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.*;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * DAO implementation using xml file as storage.
 */
public class ApplianceDAOImpl implements ApplianceDAO {

    /**
     * Path to xml file for storing and receiving data.
     */
    private static final String path = "src/main/resources/appliances.xml";

    /**
     * Finds appliances that fit certain criteria.
     *
     * @param criteria criteria for search
     * @return list of appliances that fit the criteria
     */
    public List<Appliance> find(Criteria criteria) {
        List<Appliance> foundAppliances = new ArrayList<Appliance>();
        Appliance appliance;

        try (XMLDecoder decoder = new XMLDecoder(new BufferedInputStream(new FileInputStream(path)))) {
            do {
                appliance = (Appliance) decoder.readObject();

                if (fitsCriteria(appliance, criteria)) {
                    foundAppliances.add(appliance);
                }

            } while (appliance != null);
        } catch (ArrayIndexOutOfBoundsException e) {
            // end of xml file
        } catch (FileNotFoundException e) {
            System.out.printf("Error trying read XML: %s%n", e.getMessage());
        } catch (IllegalAccessException e) {
            System.out.printf("Error with illegal access: %s%n", e.getMessage());
        }

        return foundAppliances;
    }

    /**
     * Saves list of appliances to storage.
     *
     * @param appliances list of appliances to save.
     */
    public void save(List<Appliance> appliances) {
        try (XMLEncoder encoder = new XMLEncoder(new BufferedOutputStream(new FileOutputStream(path)))) {
            for (Appliance appliance : appliances) {
                encoder.writeObject(appliance);
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Gets all appliances from storage
     * @return list of appliances from xml storage file.
     */
    public List<Appliance> parseAll() {
        List<Appliance> appliances = new ArrayList<>();
        try (XMLDecoder decoder = new XMLDecoder(new BufferedInputStream(new FileInputStream(path)))) {
            Appliance result;
            do {
                result = (Appliance) decoder.readObject();
                appliances.add(result);
            }
            while (result != null);
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (ArrayIndexOutOfBoundsException e) {
            //end of xml file;
        }
        return appliances;
    }

    /**
     * Checks whether the appliance's properties fit certain criteria.
     * @param appliance appliance which criteria need to be checked
     * @param criteria a set of criteria
     * @return true if appliance fits the specified criteria
     * @throws IllegalAccessException if access to appliance field is closed
     */
    private boolean fitsCriteria(Appliance appliance, Criteria criteria) throws IllegalAccessException {
        if (!appliance.getClass().getSimpleName().equals(criteria.getGroupSearchName())) {
            return false;
        }

        Set<String> properties = criteria.getCriteria().keySet();
        for (String property : properties) {
            try {
                Field field = appliance.getClass().getDeclaredField(property);
                field.setAccessible(true);
                Object fieldValue = field.get(appliance);
                if (!fieldValue.toString().equals(criteria.getCriteria().get(property).toString())) {
                    return false;
                }
            } catch (NoSuchFieldException e) {

            }
        }
        for (String property : properties) {
            try {
                Field parentField = appliance.getClass().getSuperclass().getDeclaredField(property);
                parentField.setAccessible(true);
                Object parentFieldValue = parentField.get(appliance);
                if (!parentFieldValue.toString().equals(criteria.getCriteria().get(property).toString())) {
                    return false;
                }
            } catch (NoSuchFieldException e) {
            }
        }
        return true;
    }
}
