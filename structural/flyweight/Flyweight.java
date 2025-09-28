package structural.flyweight;

public class Flyweight {
    private int row;
    public Flyweight(int row) {
        this.row = row;
        System.out.println("ctor: " + this.row);
    }
    public void report(int col) {
        System.out.print(" " + row + col);
    }
}
