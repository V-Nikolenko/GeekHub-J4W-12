package edu.geekhub.homework.task2;

public class ApplicationStarter {

    public static final String TODAY_LOSES = """
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

    public static void main(String[] args) {
        var losesInWarParser = new LosesInWarParser();
        var losesStatistic = losesInWarParser.parseLosesStatistic(TODAY_LOSES);

        System.out.println(losesStatistic.asPrintVersion());
    }
}
