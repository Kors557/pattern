import FactoryMethod.Transport;
import FactoryMethod.TransportFactory;

public class Program {
    public static void main(String[] args) {
        //Factory
        TransportFactory transportFactory = TransportFactory.createNewTransportFactory("Train");
        Transport transport=transportFactory.createTransport();
        transport.transportGoods();

        //Singleton

    }
}
