package edu.geekhub.lecture.testing.example1;

import edu.geekhub.lecture.testing.StudentScore;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StudentScoreCollectionTest {

    @Test
    void calculate_arithmetic_mean_for_a_single_score() {
        // Arrange
        StudentScoreCollection studentScoreCollection = new StudentScoreCollection();
        studentScoreCollection.add(new StudentScore(3));

        // Act
        int arithmeticMean = studentScoreCollection.arithmeticMean();

        // Assert
        assertEquals(3, arithmeticMean);
    }

}