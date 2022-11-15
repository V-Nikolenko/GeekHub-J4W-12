package edu.geekhub.homework.task2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static edu.geekhub.homework.util.NotImplementedException.TODO_TYPE;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SuppressWarnings("All")
class LosesInWarParserTest {

    /**
     * As of date is 14 November 2022
     */
    private static String STATISTIC_INPUT = """
        Танки — 2848
        ББМ — 5748
        Гармати — 1839
        РСЗВ — 393
        Засоби ППО — 206
        Літаки — 278
        Гелікоптери — 261
        БПЛА — 1509
        Крилаті ракети — 399
        Кораблі (катери) — 16
        Автомобілі та автоцистерни — 4316
        Спеціальна техніка — 160
        Особовий склад — близько 81370 осіб
        """;

    private LosesInWarParser losesInWarParser;

    @Test
    void failed_parse_null_input() {
        assertThrows(
            TODO_TYPE("Put most suitable exception"),
            () -> losesInWarParser.parseLosesStatistic(null)
        );
    }

    @Test
    void failed_parse_empty_input() {
        assertThrows(
            TODO_TYPE("Put most suitable exception"),
            () -> losesInWarParser.parseLosesStatistic("")
        );
    }

    @Test
    void parse_input_without_any_statistic_information() {
        LosesStatistic statistic = losesInWarParser.parseLosesStatistic("some long text without statistic data");

        assertEquals(LosesStatistic.empty(), statistic);
    }

    @Test
    void parse_input_without_values() {
        var statistic = losesInWarParser.parseLosesStatistic(
            """
                Танки —
                ББМ —
                Гармати —
                РСЗВ —
                Засоби ППО —
                Літаки —
                Гелікоптери —
                БПЛА —
                Крилаті ракети —
                Кораблі (катери) —
                Автомобілі та автоцистерни —
                Спеціальна техніка —
                Особовий склад —
                """
        );

        var expectedStatistic = LosesStatistic.newStatistic()
            .withTanks(0)
            .withArmouredFightingVehicles(0)
            .withCannons(0)
            .withMultipleRocketLaunchers(0)
            .withAntiAirDefenseDevices(0)
            .withPlanes(0)
            .withHelicopters(0)
            .withDrones(0)
            .withCruiseMissiles(0)
            .withShipsOrBoats(0)
            .withCarsAndTankers(0)
            .withSpecialEquipment(0)
            .withPersonnel(0)
            .build();

        assertEquals(expectedStatistic, statistic);
    }

    @Test
    void parse_input_with_zero_values() {
        var statistic = losesInWarParser.parseLosesStatistic(
            """
                Танки — 0
                ББМ — 0
                Гармати — 0
                РСЗВ — 0
                Засоби ППО — 0
                Літаки — 0
                Гелікоптери — 0
                БПЛА — 0
                Крилаті ракети — 0
                Кораблі (катери) — 0
                Автомобілі та автоцистерни — 0
                Спеціальна техніка — 0
                Особовий склад — близько 0 осіб
                """
        );

        var expectedStatistic = LosesStatistic.newStatistic()
            .withTanks(0)
            .withArmouredFightingVehicles(0)
            .withCannons(0)
            .withMultipleRocketLaunchers(0)
            .withAntiAirDefenseDevices(0)
            .withPlanes(0)
            .withHelicopters(0)
            .withDrones(0)
            .withCruiseMissiles(0)
            .withShipsOrBoats(0)
            .withCarsAndTankers(0)
            .withSpecialEquipment(0)
            .withPersonnel(0)
            .build();

        assertEquals(expectedStatistic, statistic);
    }

    @Test
    void parse_input_with_statistic_values() {
        var statistic = losesInWarParser.parseLosesStatistic(STATISTIC_INPUT);

        var expectedStatistic = LosesStatistic.newStatistic()
            .withTanks(2848)
            .withArmouredFightingVehicles(5748)
            .withCannons(1839)
            .withMultipleRocketLaunchers(393)
            .withAntiAirDefenseDevices(206)
            .withPlanes(278)
            .withHelicopters(261)
            .withDrones(1509)
            .withCruiseMissiles(399)
            .withShipsOrBoats(16)
            .withCarsAndTankers(4316)
            .withSpecialEquipment(160)
            .withPersonnel(81370)
            .build();

        assertEquals(expectedStatistic, statistic);
    }

    @Test
    void print_version_is_implemented_as_expected() {
        var statistic = losesInWarParser.parseLosesStatistic(STATISTIC_INPUT);
        var printVersion = statistic.asPrintVersion();

        var expectedPrintVersion = "Втрати російської армії в Україні: Танки - 2848, Бойові броньовані машини (різних типів) - 5748, Гармати - 1839, Реактивні системи залпового вогню - 393, Засоби ППО - 206, Літаки - 278, Гелікоптери - 261, Безпілотні літальні апарати (оперативно-тактичного рівня) - 1509, Крилаті ракети - 399, Кораблі (катери) - 16, Автомобілі та автоцистерни - 4316, Спеціальна техніка - 160, Особовий склад - близько 81370 осіб";

        assertEquals(expectedPrintVersion, printVersion);
    }

    @Test
    void pint_version_is_not_uses_toString_implementation_as_a_reference() {
        var statistic = losesInWarParser.parseLosesStatistic(STATISTIC_INPUT);
        var printVersion = statistic.asPrintVersion();

        assertNotEquals(printVersion, statistic.toString());
    }

    @Test
    @DisplayName(
        "verification that of toString is implemented used only to teach that this method is important " +
        "for debuging puprouses during development and writing of tests"
    )
    void check_that_toString_is_implemented_for_debug_purpouses() {
        var statistic = losesInWarParser.parseLosesStatistic(STATISTIC_INPUT);
        String toStringResult = statistic.toString();

        assertFalse(toStringResult.contains("edu.geekhub.homework"));
        assertFalse(toStringResult.contains("@"));
    }

    @Test
    void parse_input_with_statistic_values_that_contains_new_entries_data() {
        var november14Input = """
            Танки — 2848 (+8)
            ББМ — 5748 (+6)
            Гармати — 1839 (+2)
            РСЗВ — 393
            Засоби ППО — 206
            Літаки — 278
            Гелікоптери — 261
            БПЛА — 1509 (+2)
            Крилаті ракети — 399
            Кораблі (катери) — 16
            Автомобілі та автоцистерни — 4316 (+21)
            Спеціальна техніка — 160
            Особовий склад — близько 81370 осіб (+510)
            """;

        var statistic = losesInWarParser.parseLosesStatistic(november14Input);

        var expectedStatistic = LosesStatistic.newStatistic()
            .withTanks(2848)
            .withArmouredFightingVehicles(5748)
            .withCannons(1839)
            .withMultipleRocketLaunchers(393)
            .withAntiAirDefenseDevices(206)
            .withPlanes(278)
            .withHelicopters(261)
            .withDrones(1509)
            .withCruiseMissiles(399)
            .withShipsOrBoats(16)
            .withCarsAndTankers(4316)
            .withSpecialEquipment(160)
            .withPersonnel(81370)
            .build();

        assertEquals(expectedStatistic, statistic);
    }

    @Test
    void parse_raw_data_input() {
        var november14Input = """
            Taнки — 2848 (+8)
            ББM — 5748 (+6)
            Гapмaти — 1839 (+2)
            PC3B — 393
            3acoби ПП0 — 206
            Лiтaки — 278
            Гeлiкoптepи — 261
            БПЛA — 1509 (+2)
            Kpилaтi paкeти — 399
            Koрaблi (кaтepи) — 16
            Aвтoмoбiлi тa aвтoциcтepни — 4316 (+21)
            Cпeцiaльнa тeхнiкa — 160
            Ocoбoвий cклaд — близькo 81370 oсiб (+510)
            """;

        var statistic = losesInWarParser.parseLosesStatistic(november14Input);

        var expectedStatistic = LosesStatistic.newStatistic()
            .withTanks(2848)
            .withArmouredFightingVehicles(5748)
            .withCannons(1839)
            .withMultipleRocketLaunchers(393)
            .withAntiAirDefenseDevices(206)
            .withPlanes(278)
            .withHelicopters(261)
            .withDrones(1509)
            .withCruiseMissiles(399)
            .withShipsOrBoats(16)
            .withCarsAndTankers(4316)
            .withSpecialEquipment(160)
            .withPersonnel(81370)
            .build();

        assertEquals(expectedStatistic, statistic);
    }

    @Test
    @DisplayName("parse_HTML_input - task with a *, that requires additional work")
    void parse_HTML_input() {
        var november14Input = """
                <div class="casualties">
                    <div>
                        <ul>
                            <li>Танки&nbsp;— 2848 <small>(+8)</small></li>
                            <li><abbr class="idx-help" title="Бойові броньовані машини (різних типів)">ББМ</abbr>&nbsp;— 5748 <small>(+6)</small>
                            </li>
                            <li>Гармати&nbsp;— 1839 <small>(+2)</small></li>
                            <li><abbr class="idx-help" title="Реактивні системи залпового вогню">РСЗВ</abbr>&nbsp;— 393</li>
                            <li>Засоби ППО&nbsp;— 206</li>
                            <li>Літаки&nbsp;— 278</li>
                            <li>Гелікоптери&nbsp;— 261</li>
                            <li><abbr class="idx-help" title="Безпілотні літальні апарати (оперативно-тактичного рівня)">БПЛА</abbr>&nbsp;—
                                1509 <small>(+2)</small></li>
                            <li>Крилаті <span class="idx-help" title="збито">ракети</span>&nbsp;— 399</li>
                            <li>Кораблі (катери)&nbsp;— 16</li>
                            <li>Автомобілі та автоцистерни&nbsp;— 4316 <small>(+21)</small></li>
                            <li>Спеціальна техніка&nbsp;— 160</li>
                            <li>Особовий склад&nbsp;— близько 81370 <span class="idx-help" title="ліквідовано">осіб</span>
                                <small>(+510)</small></li>
                        </ul>
                    </div>
                </div>
            """;

        var statistic = losesInWarParser.parseLosesStatistic(november14Input);

        var expectedStatistic = LosesStatistic.newStatistic()
            .withTanks(2848)
            .withArmouredFightingVehicles(5748)
            .withCannons(1839)
            .withMultipleRocketLaunchers(393)
            .withAntiAirDefenseDevices(206)
            .withPlanes(278)
            .withHelicopters(261)
            .withDrones(1509)
            .withCruiseMissiles(399)
            .withShipsOrBoats(16)
            .withCarsAndTankers(4316)
            .withSpecialEquipment(160)
            .withPersonnel(81370)
            .build();

        assertEquals(expectedStatistic, statistic);
    }

}