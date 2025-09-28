package structural.decorator;

public class UnknownCarDec implements CarDecorator {
    public void draw() {
        System.out.println("UnknownCar");
    }
}
