package edu.geekhub.homework.task2;

import static edu.geekhub.homework.util.NotImplementedException.TODO_TYPE;

public class LosesStatistic {

    private final int tanks;
    private final int armouredFightingVehicles;
    private final int cannons;
    private final int multipleRocketLaunchers;
    private final int antiAirDefenseDevices;
    private final int planes;
    private final int helicopters;
    private final int drones;
    private final int cruiseMissiles;
    private final int shipsOrBoats;
    private final int carsAndTankers;
    private final int specialEquipment;
    private final int personnel;

    private LosesStatistic(
        int tanks,
        int armouredFightingVehicles,
        int cannons,
        int multipleRocketLaunchers,
        int antiAirDefenseDevices,
        int planes,
        int helicopters,
        int drones,
        int cruiseMissiles,
        int shipsOrBoats,
        int carsAndTankers,
        int specialEquipment,
        int personnel
    ) {
        this.tanks = tanks;
        this.armouredFightingVehicles = armouredFightingVehicles;
        this.cannons = cannons;
        this.multipleRocketLaunchers = multipleRocketLaunchers;
        this.antiAirDefenseDevices = antiAirDefenseDevices;
        this.planes = planes;
        this.helicopters = helicopters;
        this.drones = drones;
        this.cruiseMissiles = cruiseMissiles;
        this.shipsOrBoats = shipsOrBoats;
        this.carsAndTankers = carsAndTankers;
        this.specialEquipment = specialEquipment;
        this.personnel = personnel;
    }

    /**
     * User-friendly print version of data
     *
     * @return a user-friendly representation of statistic
     */
    public String asPrintVersion() {
        return "Втрати російської армії в Україні: " +
               "Танки - " + tanks +
               ", Бойові броньовані машини (різних типів) - " + armouredFightingVehicles +
               ", Гармати - " + cannons +
               ", Реактивні системи залпового вогню - " + multipleRocketLaunchers +
               ", Засоби ППО - " + antiAirDefenseDevices +
               ", Літаки - " + planes +
               ", Гелікоптери - " + helicopters +
               ", Безпілотні літальні апарати (оперативно-тактичного рівня) - " + drones +
               ", Крилаті ракети - " + cruiseMissiles +
               ", Кораблі (катери) - " + shipsOrBoats +
               ", Автомобілі та автоцистерни - " + carsAndTankers +
               ", Спеціальна техніка - " + specialEquipment +
               ", Особовий склад - близько " + personnel + " осіб"
            ;
    }

    /**
     * This method should return an "empty object" instance with 0 as default value for fields
     *
     * @return an "empty object" instance
     */
    public static LosesStatistic empty() {
        return TODO_TYPE("Return an Empty Object");
    }

    public static LosesStatisticBuilder newStatistic() {
        return new LosesStatisticBuilder();
    }

    public static final class LosesStatisticBuilder {
        private int tanks;
        private int armouredFightingVehicles;
        private int cannons;
        private int multipleRocketLaunchers;
        private int antiAirDefenseDevices;
        private int planes;
        private int helicopters;
        private int drones;
        private int cruiseMissiles;
        private int shipsOrBoats;
        private int carsAndTankers;
        private int specialEquipment;
        private int personnel;

        private LosesStatisticBuilder() {
        }

        public LosesStatisticBuilder withTanks(int tanks) {
            this.tanks = tanks;
            return this;
        }

        public LosesStatisticBuilder withArmouredFightingVehicles(int armouredFightingVehicles) {
            this.armouredFightingVehicles = armouredFightingVehicles;
            return this;
        }

        public LosesStatisticBuilder withCannons(int cannons) {
            this.cannons = cannons;
            return this;
        }

        public LosesStatisticBuilder withMultipleRocketLaunchers(int multipleRocketLaunchers) {
            this.multipleRocketLaunchers = multipleRocketLaunchers;
            return this;
        }

        public LosesStatisticBuilder withAntiAirDefenseDevices(int antiAirDefenseDevices) {
            this.antiAirDefenseDevices = antiAirDefenseDevices;
            return this;
        }

        public LosesStatisticBuilder withPlanes(int planes) {
            this.planes = planes;
            return this;
        }

        public LosesStatisticBuilder withHelicopters(int helicopters) {
            this.helicopters = helicopters;
            return this;
        }

        public LosesStatisticBuilder withDrones(int drones) {
            this.drones = drones;
            return this;
        }

        public LosesStatisticBuilder withCruiseMissiles(int cruiseMissiles) {
            this.cruiseMissiles = cruiseMissiles;
            return this;
        }

        public LosesStatisticBuilder withShipsOrBoats(int shipsOrBoats) {
            this.shipsOrBoats = shipsOrBoats;
            return this;
        }

        public LosesStatisticBuilder withCarsAndTankers(int carsAndTankers) {
            this.carsAndTankers = carsAndTankers;
            return this;
        }

        public LosesStatisticBuilder withSpecialEquipment(int specialEquipment) {
            this.specialEquipment = specialEquipment;
            return this;
        }

        public LosesStatisticBuilder withPersonnel(int personnel) {
            this.personnel = personnel;
            return this;
        }

        public LosesStatistic build() {
            return TODO_TYPE();
        }
    }
}
