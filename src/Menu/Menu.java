package Menu;

import command.Command;
import View.Technicable;

import java.util.ArrayList;
import java.util.List;

public abstract class Menu implements Technicable {
    protected List<Command> commandList;
    public Menu() {
        this.commandList = new ArrayList<Command>();
    }
    public boolean emptyTreeProtection() {
        if (commandList.size() != 0) {
            return true;
        } else {
            System.out.println("Нет ни одного сохранённого дерева!");
            return false;
        }
    }
    public void choiceMenu(){
        int answer = correctInput(1, commandList.size());
        commandList.get(answer-1).useThisMethod();
    }
    public void printMenu(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Выберите интересующий вас пункт\n");
        for (int i = 1; i <=commandList.size(); i++) {
            stringBuilder.append("  ");
            stringBuilder.append(i);
            stringBuilder.append(") ");
            stringBuilder.append(commandList.get(i).getDescription());
            stringBuilder.append("\n");
        }
    }
    public void menu(){
        if (emptyTreeProtection()){
            printMenu();
            choiceMenu();
        }
    }
}
