package by.tc.task01.entity.criteria;

/**
 * Class containing enums of all appliances type that specify appliance's criteria that can be searched for.
 */
public final class SearchCriteria {

    public static enum Oven implements ApplianceCriteria {
        NAME("name"),
        PRICE("price"),
        POWER_CONSUMPTION("powerConsumption"),
        WEIGHT("weight"),
        CAPACITY("capacity"),
        DEPTH("depth"),
        HEIGHT("height"),
        WIDTH("width");

        /**
         * String representation of criteria name.
         */
        private final String name;

        /**
         * Enum constructor specifying string representation
         *
         * @param name string representation
         */
        Oven(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return name;
        }

        /**
         * @return string representation of criteria name
         */
        @Override
        public String getName() {
            return null;
        }
    }

    public static enum Laptop {
        NAME("name"),
        PRICE("price"),
        BATTERY_CAPACITY("batteryCapacity"),
        OS("os"),
        MEMORY_ROM("memoryRom"),
        SYSTEM_MEMORY("systemMemory"),
        CPU("cpu"),
        DISPLAY_INCHES("displayInches");

        private final String name;

        Laptop(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return name;
        }
    }

    public static enum Refrigerator {
        NAME("name"),
        PRICE("price"),
        POWER_CONSUMPTION("powerConsumption"),
        WEIGHT("weight"),
        FREEZER_CAPACITY("freezerCapacity"),
        OVERALL_CAPACITY("overallCapacity"),
        HEIGHT("height"),
        WIDTH("width");

        private final String name;

        Refrigerator(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return name;
        }
    }

    public static enum VacuumCleaner {
        NAME("name"),
        PRICE("price"),
        POWER_CONSUMPTION("powerConsumption"),
        FILTER_TYPE("filterType"),
        BAG_TYPE("bagType"),
        WAND_TYPE("wandType"),
        MOTOR_SPEED_REGULATION("motorSpeedRegulation"),
        CLEANING_WIDTH("cleaningWidth");

        private final String name;

        VacuumCleaner(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return name;
        }
    }

    public static enum TabletPC {
        NAME("name"),
        PRICE("price"),
        BATTERY_CAPACITY("batteryCapacity"),
        DISPLAY_INCHES("displayInches"),
        MEMORY_ROM("memoryRom"),
        FLASH_MEMORY_CAPACITY("flashMemoryCapacity"),
        COLOR("Color");

        private final String name;

        TabletPC(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return name;
        }
    }

    public static enum Speakers {
        NAME("name"),
        PRICE("price"),
        POWER_CONSUMPTION("powerConsumption"),
        NUMBER_OF_SPEAKERS("numberOfSpeakers"),
        FREQUENCY_RANGE_MIN("frequencyRangeMin"),
        FREQUENCY_RANGE_MAX("frequencyRangeMax"),
        CORD_LENGTH("cordLength");

        private final String name;

        Speakers(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return name;
        }
    }

    public enum Kettle {
        NAME("name"),
        PRICE("price"),
        POWER_CONSUMPTION("powerConsumption"),
        WATER_CAPACITY("waterCapacity"),
        COLOR("color");

        private final String name;

        Kettle(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return name;
        }
    }

    private SearchCriteria() {
    }
}

