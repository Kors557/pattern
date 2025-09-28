package structural.bridge;

public class SportCar extends structural.bridge.Car {
    public SportCar(structural.bridge.Engine engine) {
        super(engine);
    }
    public void setEngine() {
        System.out.print("SportCar engine: ");
        engine.setEngine();
    }
}
