package edu.geekhub.lecture.testing.example2;

import edu.geekhub.lecture.testing.StudentScore;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StudentScoreCollectionTest {

    private StudentScoreCollection studentScoreCollection;

    @BeforeEach
    void setUp() {
        studentScoreCollection = new StudentScoreCollection(2);
    }

    @Test
    void calculate_arithmetic_mean_for_a_single_score() {
        // Arrange
        studentScoreCollection = new StudentScoreCollection(1);
        studentScoreCollection.add(new StudentScore(3));

        // Act
        int arithmeticMean = studentScoreCollection.arithmeticMean();

        // Assert
        assertEquals(3, arithmeticMean);
    }

    @Test
    void calculate_arithmetic_mean_for_a_multiple_scores() {
        studentScoreCollection.add(new StudentScore(3));
        studentScoreCollection.add(new StudentScore(7));

        int arithmeticMean = studentScoreCollection.arithmeticMean();

        assertEquals(5, arithmeticMean);
    }

    @Test
    void calculate_arithmetic_mean_for_a_lot_of_score_values() {
        studentScoreCollection = new StudentScoreCollection(3);

        studentScoreCollection.add(new StudentScore(5));
        studentScoreCollection.add(new StudentScore(10));
        studentScoreCollection.add(new StudentScore(3));

        int arithmeticMean = studentScoreCollection.arithmeticMean();

        assertEquals(6, arithmeticMean);
    }

    @Test
    void calculate_arithmetic_mean_with_a_negative_score_value() {
        studentScoreCollection.add(new StudentScore(-1));
        studentScoreCollection.add(new StudentScore(5));

        int arithmeticMean = studentScoreCollection.arithmeticMean();

        assertEquals(2, arithmeticMean);
    }

    @Test
    void calculate_arithmetic_mean_with_all_negative_score_values() {
        studentScoreCollection.add(new StudentScore(-10));
        studentScoreCollection.add(new StudentScore(-30));

        int arithmeticMean = studentScoreCollection.arithmeticMean();

        assertEquals(-20, arithmeticMean);
    }

    @Test
    void calculate_arithmetic_mean_with_all_zero_score_values() {
        studentScoreCollection.add(new StudentScore(0));
        studentScoreCollection.add(new StudentScore(0));

        int arithmeticMean = studentScoreCollection.arithmeticMean();

        assertEquals(0, arithmeticMean);
    }

}