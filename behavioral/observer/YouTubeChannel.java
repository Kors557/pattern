package behavioral.observer;

public class YouTubeChannel implements Subject {
    private final java.util.List<Observer> subscribers = new java.util.ArrayList<>();

    @Override
    public void attach(Observer o) {
        subscribers.add(o);
    }

    @Override
    public void detach(Observer o) {
        subscribers.remove(o);
    }

    @Override
    public void notifyObservers(String message) {
        for (Observer o : subscribers) {
            o.update(message);
        }
    }

    public void uploadVideo(String title) {
        System.out.println("Новый ролик: " + title);
        notifyObservers("Вышло новое видео: " + title);
    }
}
