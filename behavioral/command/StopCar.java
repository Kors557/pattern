package behavioral.command;

public class StopCar implements Command {
    CarCommand car;
    public StopCar(CarCommand car) {
        this.car = car;
    }
    public void execute() {
        car.stopEngine();
    }
}
