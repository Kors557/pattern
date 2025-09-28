package behavioral.memento;

public class TextEditor {
    private String text = "";

    public void type(String words) {
        text += words;
    }

    public String getText() {
        return text;
    }

    public TextMemento save() {
        return new TextMemento(text); // создаём снимок
    }

    public void restore(TextMemento memento) {
        text = memento.getState(); // откат
    }
}
