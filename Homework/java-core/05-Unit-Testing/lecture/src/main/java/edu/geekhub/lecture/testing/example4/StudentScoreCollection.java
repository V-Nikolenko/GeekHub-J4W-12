package edu.geekhub.lecture.testing.example4;

import edu.geekhub.lecture.testing.StudentScore;

public class StudentScoreCollection {

    private int scoreIndex = 0;
    private final StudentScore[] scores;

    public StudentScoreCollection(int groupSize) {
        if (groupSize == 0) {
            throw new IllegalArgumentException("Group size cant be 0");
        }

        this.scores = new StudentScore[groupSize];
    }

    // TODO: Think why we need to REFACTOR those checks?
    public void add(StudentScore score) {
        if (score == null || scoreIndex >= scores.length) {
            throw new IllegalArgumentException(
                "Cant add score, because its is null or collection is full"
            );
        }

        scores[scoreIndex++] = score;
    }

    public int arithmeticMean() {
        int total = 0;

        for (StudentScore studentScore : scores) {
            Integer score = studentScore.score();

            if (score == null || score < 0) {
                score = 0;
            }

            total += score;
        }

        return total / scores.length;
    }

}
