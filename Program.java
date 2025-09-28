import behavioral.chainofresponsibility.PayPalPayment;
import behavioral.chainofresponsibility.Payment;
import behavioral.chainofresponsibility.VisaPayment;
import behavioral.command.CarCommand;
import behavioral.command.CarInvoker;
import behavioral.command.StartCar;
import behavioral.command.StopCar;
import structural.composite.Car;
import structural.composite.Drawing;
import structural.composite.SportCar;
import structural.composite.UnknownCar;
import structural.decorator.BlueCarDecorator;
import structural.decorator.CarDecorator;
import structural.decorator.SportCarDec;
import structural.decorator.UnknownCarDec;
import structural.facade.Facade;
import structural.flyweight.Factory;
import behavioral.interpreter.Expression;
import behavioral.interpreter.LowerExpression;
import behavioral.interpreter.UpperExpression;
import behavioral.iterator.Iterator;
import behavioral.iterator.Numbers;
import behavioral.mediator.User;
import behavioral.memento.History;
import behavioral.memento.TextEditor;
import behavioral.observer.Observer;
import behavioral.observer.Subscriber;
import behavioral.observer.YouTubeChannel;
import structural.proxy.Image;
import structural.proxy.ProxyImage;
import behavioral.state.PlayContext;
import behavioral.state.StartPlay;
import behavioral.state.State;
import behavioral.state.StopPlay;
import behavioral.strategy.Context;
import behavioral.strategy.DownloadLinuxStrategy;
import behavioral.strategy.DownloadWindownsStrategy;
import behavioral.templatemethod.CarTemp;
import behavioral.templatemethod.OneCar;
import behavioral.templatemethod.TwoCar;
import behavioral.visitor.CarVisitor;
import creational.builder.Build;
import creational.factorymethod.Transport;
import creational.factorymethod.TransportFactory;
import creational.prototype.ComplicatedObject;
import creational.singleton.Singleton;
import structural.adapter.ABank;
import structural.adapter.PBank;
import structural.adapter.PBankAdapter;


public class Program {
    public static void main(String[] args) {

        /**
         * Factory
         * Необходим для делегирования создания объектов т.е. определяет общий интерфейс
         * для создания объектов в суперклассе, позволяя подклассам изменять тип создаваемых обьектов.
         */
        System.out.println("*** Factory ***");
        TransportFactory transportFactory = TransportFactory.createNewTransportFactory("Train");
        Transport transport = transportFactory.createTransport();
        transport.transportGoods();
        System.out.println();

        /**
         * Singleton
         * ограничивает создание одного экземпляра класса, обеспечивает доступ к его единственному объекту.
         */
        System.out.println("*** Singleton ***");
        Singleton singleton = Singleton.getInstance();
        singleton.setUp();
        System.out.println();

        /**
         * Builder
         * Используется для создания сложного объекта с использованием простых объектов.
         * Постепенно он создает больший объект от малого и простого объекта.
         * Позволяет изменять внутреннее представление конечного продукта.
         */
        System.out.println("*** Builder ***");
        Build build = new Build(1);
        build.buildCar();
        System.out.println();

        /**
         * Prototype
         * Помогает создать дублированный объект с лучшей производительностью,
         * вместо нового создается возвращаемый клон существующего объекта.
         * Клонирует существующий объект.
         */
        System.out.println("*** Prototype ***");
        ComplicatedObject prototype = new ComplicatedObject();
        prototype.setType(ComplicatedObject.Type.ONE);
        System.out.println("prototype: " + prototype);
        ComplicatedObject clone = prototype.copy();
        System.out.println("clone: " + clone);
        clone.setType(ComplicatedObject.Type.TWO);
        System.out.println("clone after setType: " + clone);
        System.out.println();

        /**
         * Adapter
         * Используя паттерн, мы можем объединить два несовместимых объекта.
         * Конвертер между двумя несовместимыми объектами.
         */
        System.out.println("*** Adapter ***");
        PBank pbank = new PBank();
        pbank.getBalance();
        PBankAdapter abank = new PBankAdapter(new ABank());
        abank.getBalance();
        System.out.println();

        /**
         * Composite
         * Группирует несколько объектов в древовидную структуру используя один класс.
         * Позволяет работать с несколькими классами через один объект.
         */
        System.out.println("*** Composite ***");
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
        System.out.println();

        /**
         * Proxy
         * Представляет объекты, которые могут контролировать другие объекты перехватывая их вызовы.
         * Можно перехватить вызов оригинального объекта.
         */
        System.out.println("*** Proxy ***");
        Image image = new ProxyImage("test.jpg");
        image.display();
        image.display();
        System.out.println();


        /**
         * Flyweight
         * Вместо создания большого количества похожих объектов, объекты используются повторно.
         * Экономит память.
         */
        System.out.println("*** Flyweight ***");
        int rows = 5;
        Factory theFactory = new Factory(rows);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < rows; j++) {
                theFactory.getFlyweight(i).report(j);
            }
            System.out.println();
        }
        System.out.println();

        /**
         * Facade
         * Скрывает сложную систему классов приводя все вызовы к одному объекту.
         * Помещает вызов нескольких сложных объектов в один объект.
         */
        System.out.println("*** Facade ***");
        Facade facade = new Facade();
        facade.startCar();
        System.out.println();
        facade.stoptCar();
        System.out.println();

        /**
         * Bridge
         * Разделяет реализацию и абстракцию, дает возможность изменять их свободно друг от друга.
         * Делает конкретные классы независимыми от классов реализации интерфейса.
         */
        System.out.println("*** Bridge ***");
        structural.bridge.Car sportCarBridge = new structural.bridge.SportCar(new structural.bridge.SportEngine());
        sportCarBridge.setEngine();
        System.out.println();
        structural.bridge.Car unknownCarBridge = new structural.bridge.UnknownCar(new structural.bridge.UnknownEngine());
        unknownCarBridge.setEngine();
        System.out.println();


        /**
         * Decorator
         * Добавляет новые функциональные возможности существующего объекта без привязки его структуры.
         */
        System.out.println("*** Decorator ***");
        CarDecorator sportCarDec = new SportCarDec();
        CarDecorator blueUnknownCar = new BlueCarDecorator(new UnknownCarDec());
        sportCarDec.draw();
        System.out.println();
        blueUnknownCar.draw();
        System.out.println();

        /**
         * Template Method
         * Позволяет определить основу алгоритма и позволяющий подклассам переопределять определенные шаги алгоритма,
         * не изменяя его структуру в целом.
         */
        System.out.println("*** Template Method ***");
        CarTemp car1 = new OneCar();
        car1.start();
        System.out.println();
        CarTemp car2 = new TwoCar();
        car2.start();
        System.out.println();


        /**
         * Mediator
         * Посредник - предоставляет класс посредника, который обрабатывает все коммуникации между различными классами.
         */
        System.out.println("*** Mediator ***");
        User user1 = new User("user1");
        User user2 = new User("user2");
        user1.sendMessage("message1");
        user2.sendMessage("message2");
        System.out.println();

        /**
         * Chain of Responsibility
         * Цепочка обязанностей - позволяет избежать жесткой зависимости отправителя запроса от
         * его получателя, при этом запрос может быть обработан несколькими объектами.
         */
        System.out.println("*** Chain of Responsibility ***");
        Payment visaPayment = new VisaPayment();
        Payment payPalPayment = new PayPalPayment();
        visaPayment.setNext(payPalPayment);
        visaPayment.pay();
        System.out.println();

        /**
         * Observer
         * Позволяет одним объектам наблюдать за действиями что происходят в других объектах.
         */
        System.out.println("*** Observer ***");
        YouTubeChannel channel = new YouTubeChannel();

        Observer sasha = new Subscriber("Саша");
        Observer lyuba = new Subscriber("Люба");

        channel.attach(sasha);
        channel.attach(lyuba);

        channel.uploadVideo("Паттерн behavioral.Observer простыми словами");

        // Отписка
        channel.detach(lyuba);

        channel.uploadVideo("Второе видео");
        System.out.println();

        /**
         * Strategy
         * Определяет ряд алгоритмов позволяя взаимодействовать между ними.
         * Алгоритм стратегии может быть изменен во время выполнения программы.
         */
        System.out.println("*** Strategy ***");
        Context context = new Context(new DownloadWindownsStrategy());
        context.download("file.txt");
        context = new Context(new DownloadLinuxStrategy());
        context.download("file.txt");
        System.out.println();

        /**
         * Command
         * Команда - интерфейс команды объявляет метод для выполнения определенного действия.
         * Позволяет инкапсулировать различные операции в отдельные объекты.
         */
        System.out.println("*** Command ***");
        CarCommand car = new CarCommand();
        StartCar startCar = new StartCar(car);
        StopCar stopCar = new StopCar(car);
        CarInvoker carInvoker = new CarInvoker(startCar);
        carInvoker.execute();
        System.out.println();

        /**
         * State
         * Позволяет объекту изменять свое поведение в зависимости от его состояния.
         */
        System.out.println("*** State ***");
        PlayContext playContext = new PlayContext();
        State startPlay = new StartPlay();
        State stopPlay = new StopPlay();
        playContext.setState(startPlay);
        playContext.doAction();
        playContext.setState(stopPlay);
        playContext.doAction();
        System.out.println();

        /**
         * Visitor
         * Посетитель - используется для упрощения операций над группировками связанных объектов.
         */
        System.out.println("*** Visitor ***");
        behavioral.visitor.Car computer = new behavioral.visitor.SportCar();
        computer.accept(new CarVisitor());
        System.out.println();

        /**
         * Interpreter
         * Интерпретатор - определяет грамматику простого языка для проблемной области.
         */
        System.out.println("*** Interpreter ***");
        String str = "TesT";
        behavioral.interpreter.Context contextInter = new behavioral.interpreter.Context();
        Expression loverExpression = new LowerExpression(str);
        str = loverExpression.interpret(contextInter);
        System.out.println(str);
        Expression upperExpression = new UpperExpression(str);
        str = upperExpression.interpret(contextInter);
        System.out.println(str);
        System.out.println();

        /**
         * Iterator
         * Итератор - последовательно осуществляет доступ к элементам объекта коллекции,
         * не зная его основного представления.
         */
        System.out.println("*** Iterator ***");
        Numbers numbers = new Numbers();
        Iterator iterator = numbers.getIterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        System.out.println();

        /**
         * Memento
         * Хранитель - Это шаблон проектирования, который позволяет сохранять и восстанавливать состояние объекта, не раскрывая его внутренности.
         */
        System.out.println("*** Memento ***");
        TextEditor editor = new TextEditor();
        History history = new History();

        editor.type("Hello ");
        history.save(editor);

        editor.type("World!");
        System.out.println(editor.getText());

        history.undo(editor);
        System.out.println(editor.getText());

    }
}
