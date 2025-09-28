package behavioral.templatemethod;

public abstract class CarTemp {
    abstract void startEngine();
    abstract void stopEngine();

    public final void start(){
        startEngine();
        stopEngine();
    }
}
