import Adapter.ABank;
import Adapter.PBank;
import Adapter.PBankAdapter;
import Bridge.SportEngine;
import Bridge.UnknownEngine;
import Builder.Build;
import ChainOfResponsibility.PayPalPayment;
import ChainOfResponsibility.Payment;
import ChainOfResponsibility.VisaPayment;
import Composite.Car;
import Composite.Drawing;
import Composite.SportCar;
import Composite.UnknownCar;
import Decorator.BlueCarDecorator;
import Decorator.CarDecorator;
import Decorator.SportCarDec;
import Decorator.UnknownCarDec;
import Facade.Facade;
import FactoryMethod.Transport;
import FactoryMethod.TransportFactory;
import Flyweight.Factory;
import Mediator.User;
import Observer.Director;
import Observer.University;
import Prototype.ComplicatedObject;
import Proxy.Image;
import Proxy.ProxyImage;
import Singleton.Singleton;
import Strategy.Context;
import Strategy.DownloadLinuxStrategy;
import Strategy.DownloadWindownsStrategy;
import TemplateMethod.CarTemp;
import TemplateMethod.OneCar;
import TemplateMethod.TwoCar;


public class Program {
    public static void main(String[] args) {
        //Factory
        TransportFactory transportFactory = TransportFactory.createNewTransportFactory("Train");
        Transport transport = transportFactory.createTransport();
        transport.transportGoods();

        //Singleton
        Singleton singleton = Singleton.getInstance();
        singleton.setUp();

        //Builder
        Build build = new Build(1);
        build.buildCar();

        //Prototype
        ComplicatedObject prototype = new ComplicatedObject();
        prototype.setType(ComplicatedObject.Type.ONE);
        System.out.println("prototype: " + prototype);
        ComplicatedObject clone = prototype.copy();
        System.out.println("clone: " + clone);
        clone.setType(ComplicatedObject.Type.TWO);
        System.out.println("clone after setType: " + clone);

        //Adapter
        PBank pbank = new PBank();
        pbank.getBalance();
        PBankAdapter abank = new PBankAdapter(new ABank());
        abank.getBalance();

        //Composite
        Car sportCar = new SportCar();
        Car unknownCar = new UnknownCar();
        Drawing drawing = new Drawing();
        drawing.add(sportCar);
        drawing.add(unknownCar);
        drawing.draw("green");
        drawing.clear();
        drawing.add(sportCar);
        drawing.add(unknownCar);
        drawing.draw("white");

        //Proxy
        Image image = new ProxyImage("test.jpg");
        image.display();
        image.display();


        //Flyweight
        int rows = 5;
        Factory theFactory = new Factory(rows);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < rows; j++) {
                theFactory.getFlyweight(i).report(j);
            }
            System.out.println();
        }

        //Facade
        Facade facade = new Facade();
        facade.startCar();
        System.out.println();
        facade.stoptCar();

        //Bridge
        Bridge.Car sportCarBridge = new Bridge.SportCar(new SportEngine());
        sportCarBridge.setEngine();
        System.out.println();
        Bridge.Car unknownCarBridge = new Bridge.UnknownCar(new UnknownEngine());
        unknownCarBridge.setEngine();


        //Decorator
        CarDecorator sportCarDec = new SportCarDec();
        CarDecorator blueUnknownCar = new BlueCarDecorator(new UnknownCarDec());
        sportCarDec.draw();
        System.out.println();
        blueUnknownCar.draw();

        //Template Method
        CarTemp car1 = new OneCar();
        car1.start();
        System.out.println();
        CarTemp car2 = new TwoCar();
        car2.start();


        //Mediator
        User user1 = new User("user1");
        User user2 = new User("user2");
        user1.sendMessage("message1");
        user2.sendMessage("message2");

        //Chain of Responsibility
        Payment visaPayment = new VisaPayment();
        Payment payPalPayment = new PayPalPayment();
        visaPayment.setNext(payPalPayment);
        visaPayment.pay();

        //Observer
        University university = new University();
        Director director = new Director();
        university.addStudent("Vaska");
        university.addObserver(director);
        university.addStudent("Anna");
        university.removeStudent("Vaska");

        //Strategy
        Context context = new Context(new DownloadWindownsStrategy());
        context.download("file.txt");
        context = new Context(new DownloadLinuxStrategy());
        context.download("file.txt");
    }
}
