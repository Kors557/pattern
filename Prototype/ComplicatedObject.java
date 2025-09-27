package Prototype;

public class ComplicatedObject implements Copyable {
    private Type type;

    public enum Type {
        ONE, TWO
    }

    public ComplicatedObject copy() {
        ComplicatedObject complicatedobject = new ComplicatedObject();
        return complicatedobject;
    }

    @Override
    public String toString() {
        return "ComplicatedObject{" +
                "type=" + type +
                '}';
    }

    public void setType(Type type) {
        this.type = type;
    }
}
