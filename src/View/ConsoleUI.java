package View;
import Menu.MainMenu;
import presenter.Presenter;
import java.util.Scanner;

public class ConsoleUI implements View, Technicable{
    private Presenter presenter;
    private Scanner scanner;
    private MainMenu mainMenu;
    private boolean work;
    public ConsoleUI() {
        scanner = new Scanner(System.in);
        presenter = new Presenter(this);
        mainMenu = new MainMenu(this);
        work = true;
    }
    public void start(){
        while (work){
            mainMenu.menu();
        }
        exitProgram();
    }

    public void showExistingTrees(){presenter.showExistingTrees();}

    public void createNewTree(int resultOfChoice){
        System.out.println("Введите название дерева");
        String treeName = scanner.nextLine();
        presenter.createNewTree(treeName, resultOfChoice);
    }

    public void addNewPerson(){

    }

    public void exitProgram() {
        presenter.exitProgram();
    }

//    private void showExistingTrees(){ //TODO а если сохранённых деревьев нет? получается ошибка=(
//        FileHandler fileHandler = new FileHandler();
//        int maxIndex = (int) fileHandler.loadObject("src/SaveFiles/numberOfCurrentTrees.out");
//        ArrayList<Integer> arrayList = new ArrayList<Integer>();
//        for (int i = 1; i <= maxIndex; i++) {
//            SimpleTree system = (SimpleTree) fileHandler.loadObject("src/SaveFiles/" + i + ".out");
//            arrayList.add(system.getSystemId());
//            System.out.println(i + ") " + system.getName() + " " + system.getClass());
//        }
//        System.out.println((maxIndex+1) + readText(33));
//        System.out.println((maxIndex+2) + readText(34));
//        System.out.println();
//        System.out.println(readText(1));
//        int choice = correctInput(arrayList.size()+2);
//        if (choice == maxIndex+1){
//            start();
//        }else if(choice == maxIndex +2){
//            System.exit(0);
//        }else {
////            System.out.println(arrayList.get(choice-1)); //это ID выбранного дерева, он же - название файла, где оно хранится
//            String linkChoosenFile = "src/SaveFiles/" + arrayList.get(choice-1) + ".out";
//            SimpleTree chosenSystem = (SimpleTree) fileHandler.loadObject(linkChoosenFile);
//            if (chosenSystem instanceof FamilyTree){
//                TreeService treeService = new TreeService();
//                treeService.workWithFamilyTree((FamilyTree) fileHandler.loadObject(linkChoosenFile));
//            }else {
//                System.out.println("Это что-то другое, не фэмилитри, раздел типа в разработке=)");
//            }
//        }
//    }









    @Override
    public void printAnswer(String text) {

    }
}










