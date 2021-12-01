package by.tc.task01.entity.criteria;

import java.util.HashMap;
import java.util.Map;

public class Criteria {
    private String groupSearchName;
    private Map<String, Object> criteria = new HashMap<String, Object>();

    /**
     * @param groupSearchName name for search group
     */
    public Criteria(String groupSearchName) {
        this.groupSearchName = groupSearchName;
    }

    /**
     * @return group search name
     */
    public String getGroupSearchName() {
        return groupSearchName;
    }

    /**
     * @return current criteria
     */
    public Map<String, Object> getCriteria() {
        return criteria;
    }

    /**
     * Adds a set of property and its desired value to map of criteria.
     * @param searchCriteria searched criteria
     * @param value desired value
     */
    public void add(String searchCriteria, Object value) {
        criteria.put(searchCriteria, value);
    }
}
