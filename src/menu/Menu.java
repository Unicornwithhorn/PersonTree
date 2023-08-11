package menu;

import command.Command;
import view.Technicable;

import java.util.ArrayList;
import java.util.List;

public abstract class Menu implements Technicable {
    protected List<Command> commandList;
    public Menu() {
        this.commandList = new ArrayList<Command>();
    }
    public boolean emptyProtection() { //только для вывода списка деревьев, адо переписывать
        if (commandList.size() != 0) {
            return true;
        } else {
            System.out.println("Список пуст!");
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
            stringBuilder.append(commandList.get(i-1).getDescription());
            stringBuilder.append("\n");
        }
        System.out.println(stringBuilder.toString());
    }
    public void menu(){
        if (emptyProtection()){
            printMenu();
            choiceMenu();
        }
    }

    public List<Command> getCommandList(){
        return commandList;
    }
}
