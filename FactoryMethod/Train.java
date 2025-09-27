package FactoryMethod;

public class Train implements Transport {
    @Override
    public void transportGoods() {
        System.out.println("It is train");
    }
}
