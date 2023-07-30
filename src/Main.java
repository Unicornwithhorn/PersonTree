import Creater.TreeCreater;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String path = "src/SaveTree.out";
        FileHandler fileHandler = new FileHandler();
        FileForSave fileForSave = new FileForSave();
        Scanner scanner = new Scanner(Tree.System.in);
        Tree.System.out.println("Вы хотите сохранить дерево, описанное в файле 'FileForSave.java', в файл 'SaveTree.out'" +
                " (введите 1) \n или загрузить данные из файла 'SaveTree.out' в объект  'loadedFamilyTree' (введите 2)");
        boolean flag = false;
        while (!flag){
            String answer = scanner.nextLine();
            if (answer.equals("1")){
                Tree.System.out.println("Содержимое данного дерева записано в файл: ");
                Tree.System.out.println(fileForSave.giveDataForSave());
                fileHandler.saveTree(path, fileForSave.giveDataForSave());
                flag = true;
            } else if (answer.equals("2")){
                File requestedFile = new File(path);
                if(requestedFile.exists() && !requestedFile.isDirectory()){
                    FamilyTree loadedFamilyTree = fileHandler.loadTree(path);
                    Tree.System.out.println("Содержимое загруженного дерева: ");
                    Tree.System.out.println(loadedFamilyTree);
                    flag = true;
                } else {
                    Tree.System.out.println("Пока что такого файла не существует, сначала надо сохранить");
                }
            } else {
                Tree.System.out.println("введите 1 или 2");
            }
        }
        DataFileOne fileForSave = new DataFileOne();
        FamilyTree currentTree = fileForSave.giveDataForSave();
        Creater.TreeService treeService = new Creater.TreeService(currentTree);
        Tree.System.out.println(treeService.currentTreeInfo());
        treeService.sortByName();
        Tree.System.out.println(treeService.currentTreeInfo());
        treeService.sortByAge();
        Tree.System.out.println(treeService.currentTreeInfo());

        TreeCreater treeCreater = new TreeCreater();
        treeCreater.createTree();



//        SuperClass superClass = new SuperClass("Федя", 66);
//        SubClass subClass = new SubClass("Петя", 11, "Кривой");
//        Tree.System.out.println(superClass.getAge());
//        Tree.System.out.println(subClass.getAge());
//        superClass.sentence();
//        subClass.sentence("морковка");
//        superClass.sayHello();
//        subClass.sayHello();
//        subClass.sayHello(" фуфуфу");

    }

}