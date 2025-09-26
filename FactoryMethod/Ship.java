package FactoryMethod;

public class Ship implements Transport{
    @Override
    public void transportGoods() {
        System.out.println("It is ship");
    }
}
