package edu.geekhub.lecture.testing.example4;

import edu.geekhub.lecture.testing.StudentScore;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;

class StudentScoreCollectionTest {

    private StudentScoreCollection studentScoreCollection;

    @BeforeEach
    void setUp() {
        studentScoreCollection = new StudentScoreCollection(2);
    }

    @Test
    void can_create_students_collection_with_a_zero_amount_of_students() {
        assertThrowsExactly(
            IllegalArgumentException.class,
            () -> new StudentScoreCollection(0)
        );
    }

    @Test
    void failed_to_add_null_student_score() {
        assertThrowsExactly(
            IllegalArgumentException.class,
            () -> studentScoreCollection.add(null)
        );
    }

    @Test
    void failed_to_add_new_student_score_when_size_limit_is_reached() {
        studentScoreCollection.add(new StudentScore(1));
        studentScoreCollection.add(new StudentScore(2));

        assertThrowsExactly(
            IllegalArgumentException.class,
            () -> studentScoreCollection.add(new StudentScore(3))
        );
    }

    @Test
    void use_default_value_for_null_score() {
        studentScoreCollection.add(new StudentScore(0));
        studentScoreCollection.add(new StudentScore(4));

        int arithmeticMean = studentScoreCollection.arithmeticMean();

        assertEquals(2, arithmeticMean);
    }

    @Test
    void use_default_value_for_negative_score() {
        studentScoreCollection.add(new StudentScore(-2));
        studentScoreCollection.add(new StudentScore(4));

        int arithmeticMean = studentScoreCollection.arithmeticMean();

        assertEquals(2, arithmeticMean);
    }





    @Test
    @Disabled
    void one_last_test_case_or_not() {

    }
}