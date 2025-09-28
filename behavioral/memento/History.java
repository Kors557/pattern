package behavioral.memento;

public class History {
    private final java.util.Stack<TextMemento> states = new java.util.Stack<>();

    public void save(TextEditor editor) {
        states.push(editor.save());
    }

    public void undo(TextEditor editor) {
        if (!states.isEmpty()) {
            editor.restore(states.pop());
        }
    }
}
