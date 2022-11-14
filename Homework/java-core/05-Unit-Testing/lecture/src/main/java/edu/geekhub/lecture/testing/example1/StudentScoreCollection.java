package edu.geekhub.lecture.testing.example1;

import edu.geekhub.lecture.testing.StudentScore;

public class StudentScoreCollection {

    private int scoreIndex = 0;
    private final StudentScore[] scores = new StudentScore[0];

    public void add(StudentScore score) {
        scores[scoreIndex++] = score;
    }

    public int arithmeticMean() {
        int total = 0;

        for (StudentScore studentScore : scores) {
            int score = studentScore.score();
            total += score;
        }

        return total / scores.length;
    }

}
