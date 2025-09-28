package behavioral.command;

public class StartCar implements Command {
    CarCommand car;
    public StartCar(CarCommand car) {
        this.car = car;
    }
    public void execute() {
        car.startEngine();
    }
}
