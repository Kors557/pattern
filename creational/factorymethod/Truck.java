package creational.factorymethod;

public class Truck implements Transport {
    @Override
    public void transportGoods() {
        System.out.println("It is truck");
    }
}
