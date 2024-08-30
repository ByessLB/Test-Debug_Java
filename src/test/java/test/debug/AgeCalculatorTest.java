package test.debug;

import static org.junit.jupiter.api.Assertions.assertEquals;
// import static org.junit.jupiter.api.Assertions.assertNotNull;
// import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class AgeCalculatorTest {

    @Test
    void shouldReturnAge() {
        // Given - Arrange
        AgeCalculator ageCalculator = new AgeCalculator();

        // When - Act
        int age = ageCalculator.getAge("2000-06-23");

        // Then - Assert
        assertEquals(24, age);
    }

    @Test
    void shouldThrowException() {
        // Arrange
        AgeCalculator ageCalculator = new AgeCalculator();
        // Throwable throwable = null;

        // Act
        // try {
        //     int age = ageCalculator.getAge("200O-06-23");
        // } catch (Throwable e) {
        //     throwable = e;
        // }

        // Then
        // assertNotNull(throwable);
        // assertTrue(throwable instanceof NumberFormatException);
        assertThrows(NumberFormatException.class, () -> ageCalculator.getAge("200O-06-23"));
    }
}
