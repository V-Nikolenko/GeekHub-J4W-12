package edu.geekhub.lecture.testing.example2;

import edu.geekhub.lecture.testing.StudentScore;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StudentScoreCollectionManualTest {

    @Test
    void calculate_arithmetic_mean_for_a_single_score() {
        // Arrange
        StudentScoreCollection studentScoreCollection = new StudentScoreCollection(1);
        studentScoreCollection.add(new StudentScore(3));

        // Act
        int arithmeticMean = studentScoreCollection.arithmeticMean();

        // Assert
        assertEquals(3, arithmeticMean);
    }

    @Test
    void calculate_arithmetic_mean_for_a_multiple_scores() {
        StudentScoreCollection studentScoreCollection = new StudentScoreCollection(2);
        studentScoreCollection.add(new StudentScore(3));
        studentScoreCollection.add(new StudentScore(7));

        int arithmeticMean = studentScoreCollection.arithmeticMean();

        assertEquals(5, arithmeticMean);
    }

}