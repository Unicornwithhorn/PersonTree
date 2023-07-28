import FamilyTree.FamilyTree;
import FileHandler.FileHandler;
import SaveData.FileForSave;

import java.io.File;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        String path = "src/SaveTree.out";
//        FileHandler fileHandler = new FileHandler();
//        FileForSave fileForSave = new FileForSave();
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Вы хотите сохранить дерево, описанное в файле 'FileForSave.java', в файл 'SaveTree.out'" +
//                " (введите 1) \n или загрузить данные из файла 'SaveTree.out' в объект  'loadedFamilyTree' (введите 2)");
//        boolean flag = false;
//        while (!flag){
//            String answer = scanner.nextLine();
//            if (answer.equals("1")){
//                System.out.println("Содержимое данного дерева записано в файл: ");
//                System.out.println(fileForSave.giveDataForSave());
//                fileHandler.saveTree(path, fileForSave.giveDataForSave());
//                flag = true;
//            } else if (answer.equals("2")){
//                File requestedFile = new File(path);
//                if(requestedFile.exists() && !requestedFile.isDirectory()){
//                    FamilyTree loadedFamilyTree = fileHandler.loadTree(path);
//                    System.out.println("Содержимое загруженного дерева: ");
//                    System.out.println(loadedFamilyTree);
//                    flag = true;
//                } else {
//                    System.out.println("Пока что такого файла не существует, сначала надо сохранить");
//                }
//            } else {
//                System.out.println("введите 1 или 2");
//            }
//        }
        FileForSave fileForSave = new FileForSave();
        FamilyTree currentTree = fileForSave.giveDataForSave();
        TreeService treeService = new TreeService(currentTree);
        System.out.println(treeService.currentTreeInfo());
        treeService.sortByName();
        System.out.println(treeService.currentTreeInfo());
        treeService.sortByAge();
        System.out.println(treeService.currentTreeInfo());


    }

}