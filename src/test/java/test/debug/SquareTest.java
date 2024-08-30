package test.debug;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SquareTest {

    @Test
    void shouldReturnSquareArea() {
        // Given - Arrange
        Square square = new Square(3);

        // When - act
        double result = square.calculateArea();

        // Then - Assert
        assertEquals(9, result);
    }
}
