package command;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 导向 相当于 terminal
 *
 * @author beigua
 */
public class Wizard {

    private Deque<Command> undoStack = new LinkedList<>();
    private Deque<Command> redoStack = new LinkedList<>();

    public Wizard() {
        // comment to ignore sonar issue: LEVEL critical
    }

    /**
     * Cast spell
     */
    public void castSpell(Command command, Target target) {
        System.out.println(String.format("%s casts %s at %s", this, command, target));

        command.execute(target);
        undoStack.offerLast(command);
    }

    /**
     * Undo last spell
     */
    public void undoLastSpell() {
        if (!undoStack.isEmpty()) {
            Command previousSpell = undoStack.pollLast();
            redoStack.offerLast(previousSpell);
            System.out.println(String.format("%s undoes %s", this, previousSpell));

            previousSpell.undo();
        }
    }

    /**
     * Redo last spell
     */
    public void redoLastSpell() {
        if (!redoStack.isEmpty()) {
            Command previousSpell = redoStack.pollLast();
            undoStack.offerLast(previousSpell);
            System.out.println(String.format("%s redoes %s", this, previousSpell));
            previousSpell.redo();
        }
    }

    @Override
    public String toString() {
        return "Wizard";
    }

}
