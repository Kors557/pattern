package behavioral.chainofresponsibility;

public interface Payment {
    void setNext(Payment payment);
    void pay();
}
