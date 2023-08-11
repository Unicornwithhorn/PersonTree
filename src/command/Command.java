package command;

import view.ConsoleUI;

public abstract class Command {
    private String description;
    private ConsoleUI consoleUI;

    public Command(ConsoleUI consoleUI, String description) {
        this.description = description;
        this.consoleUI = consoleUI;
    }

    public String getDescription(){
        return description;
    }
    public ConsoleUI getConsoleUI(){
        return consoleUI;
    }

    public abstract void useThisMethod();
}
