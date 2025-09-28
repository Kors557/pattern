package structural.bridge;

public abstract class Car {
    protected structural.bridge.Engine engine;
    public Car(Engine engine){
        this.engine = engine;
    }
    abstract public void setEngine();
}
