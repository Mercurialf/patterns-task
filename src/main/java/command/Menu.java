package command;

import java.util.List;

public class Menu {
    private final List<Command> commands;

    public Menu(List<Command> commands) {
        this.commands = commands;
    }

    public void executeCommand(int index) {
        commands.get(index).execute();
    }
}