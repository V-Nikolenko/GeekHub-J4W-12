package edu.geekhub.homework.analytics;

import edu.geekhub.homework.domain.LosesStatistic;

import java.util.List;

import static edu.geekhub.homework.util.NotImplementedException.TODO;
import static edu.geekhub.homework.util.NotImplementedException.TODO_TYPE;

/**
 * Service shows interesting analytics information
 */
public class AnalyticsService {

    public AnalyticsService() {
        TODO("Implement class");
    }

    public LosesStatistic findStatisticWithMaxLosesAmounts(List<LosesStatistic> losesStatistics) {
        return TODO_TYPE("Implement method");
    }

    public LosesStatistic findStatisticWithMinLosesAmounts(List<LosesStatistic> losesStatistics) {
        return TODO_TYPE("Implement method");
    }

    public int totalCountOfLosesForStatistic(LosesStatistic losesStatistic) {
        return TODO_TYPE("Implement method");
    }

    public int totalCountOfLosesForAllStatistics(List<LosesStatistic> losesStatistics) {
        return TODO_TYPE("Implement method");
    }

}
