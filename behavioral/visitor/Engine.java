package behavioral.visitor;

public class Engine implements Car {
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
