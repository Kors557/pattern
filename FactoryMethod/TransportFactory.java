package FactoryMethod;

public abstract class TransportFactory {
    public abstract Transport createTransport();

    public static TransportFactory createNewTransportFactory(String value) {
        if (value.equalsIgnoreCase("Train")) {
            return new TrainFactory();
        } else if (value.equalsIgnoreCase("Truck")) {
            return new TruckFactory();
        } else if (value.equalsIgnoreCase("Ship")) {
            return new ShipFactory();
        } else throw new RuntimeException("Not result");
    }
}
