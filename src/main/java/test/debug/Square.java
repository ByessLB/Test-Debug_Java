package test.debug;

public record Square(double side) implements Shape {
    @Override
    public double calculateArea() { return side * side; }
}
