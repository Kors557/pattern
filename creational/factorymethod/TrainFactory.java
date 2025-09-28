package creational.factorymethod;

public class TrainFactory extends TransportFactory {
    @Override
    public Transport createTransport() {
        return new Train();
    }
}
