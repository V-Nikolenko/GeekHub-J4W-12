package edu.geekhub.homework.task2;

public class ApplicationStarter {

    public static final String TODAY_LOSES = """
        Танки — 2861
        ББМ — 5773
        Гармати — 1850
        РСЗВ — 393
        Засоби ППО — 208
        Літаки — 278
        Гелікоптери — 261
        БПЛА — 1511
        Крилаті ракети — 399
        Кораблі (катери) — 16
        Автомобілі та автоцистерни — 4351
        Спеціальна техніка — 160
        Особовий склад — близько 82080 осіб
        """;

    public static void main(String[] args) {
        var losesInWarParser = new LosesInWarParser();
        var losesStatistic = losesInWarParser.parseLosesStatistic(TODAY_LOSES);

        System.out.println(losesStatistic.asPrintVersion());
    }
}
