package behavioral.visitor;

public interface Visitor {
    void visit(SportCar sportCar);
    void visit(Engine engine);
    void visit(Whell whell);
}
