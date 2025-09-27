package Bridge;

public class UnknownCar extends Car {
    public UnknownCar(Engine engine) {
        super(engine);
    }
    public void setEngine() {
        System.out.print("UnknownCar engine: ");
        engine.setEngine();
    }
}
