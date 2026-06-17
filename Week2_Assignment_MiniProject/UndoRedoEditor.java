package Week2_Assignment_MiniProject;

import java.util.*;

public class UndoRedoEditor {

    Stack<String> undo = new Stack<>();
    Stack<String> redo = new Stack<>();
    String text = "";

    void type(String word) {
        undo.push(text);
        text += word;
        redo.clear();
    }

    void undo() {
        if (!undo.isEmpty()) {
            redo.push(text);
            text = undo.pop();
        }
    }

    void redo() {
        if (!redo.isEmpty()) {
            undo.push(text);
            text = redo.pop();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        UndoRedoEditor editor = new UndoRedoEditor();

        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {
            String command = sc.nextLine();

            if (command.startsWith("type ")) {
                editor.type(command.substring(5));
            } else if (command.equals("undo")) {
                editor.undo();
            } else if (command.equals("redo")) {
                editor.redo();
            }

            System.out.println(editor.text);
        }

        sc.close();
    }
}
