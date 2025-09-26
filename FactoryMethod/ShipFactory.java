package FactoryMethod;

public class ShipFactory extends TransportFactory{
    @Override
    public Transport createTransport() {
        return new Ship();
    }
}
