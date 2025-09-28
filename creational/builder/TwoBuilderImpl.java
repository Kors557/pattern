package creational.builder;

class TwoBuilderImpl extends Builder {
    public TwoBuilderImpl() {
        car = new Car();
    }

    public Car buildCar() {
        car.buildBase();
        car.buildWheels();
        Engine engine = new OneEngine();
        car.buildEngine(engine);
        car.buildWheels();
        engine = new TwoEngine();
        car.buildEngine(engine);
        return car;
    }
}
