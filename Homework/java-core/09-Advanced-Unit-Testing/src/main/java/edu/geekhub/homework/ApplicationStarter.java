package edu.geekhub.homework;

import edu.geekhub.homework.analytics.AnalyticsService;
import edu.geekhub.homework.domain.LosesStatisticService;

import static edu.geekhub.homework.util.NotImplementedException.TODO_TYPE;

public class ApplicationStarter {

    public static void main(String[] args) {
        // Write code here :)

        var losesStatisticService = new LosesStatisticService();

        var losesStatistic = losesStatisticService.getById(TODO_TYPE());
        losesStatisticService.create(losesStatistic);
        losesStatisticService.deleteById(losesStatistic.id());

        var analyticsService = new AnalyticsService();

        print(analyticsService.totalCountOfLosesForStatistic(TODO_TYPE()));
        print(analyticsService.totalCountOfLosesForAllStatistics(TODO_TYPE()));
        print(analyticsService.findStatisticWithMinLosesAmounts(TODO_TYPE()));
        print(analyticsService.findStatisticWithMaxLosesAmounts(TODO_TYPE()));

        losesStatisticService.deleteAll();
    }

    static void print(Object objectToPrint) {
        System.out.println(objectToPrint);
    }
}
