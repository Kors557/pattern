package structural.decorator;

public class CarDecoratorImpl implements CarDecorator {
    protected CarDecorator decorated;
    public CarDecoratorImpl(CarDecorator decorated){
        this.decorated = decorated;
    }
    public void draw(){
        decorated.draw();
    }
}
