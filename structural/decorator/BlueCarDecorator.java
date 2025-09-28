package structural.decorator;

public class BlueCarDecorator extends CarDecoratorImpl {
    public BlueCarDecorator(CarDecorator decorated) {
        super(decorated);
    }
    public void draw() {
        decorated.draw();
        setColor();
    }
    private void setColor(){
        System.out.println("Color: red");
    }
}
