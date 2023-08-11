package view;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public interface Technicable {

    /** возвращает указанную в аргументе строку из файла workText.txt*/
    default String readText(int lineNumber){
        String line;
        Files Files = null;
        try {
            line = java.nio.file.Files.readAllLines(Paths.get("src/model/workText.txt")).get(lineNumber-1);
            return line;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    /** Возвращает список с вариантами выбора из интервала между указанными в аргументах строк из файла workText.txt
     * Позволяет ввести число из доступных вариантов*/
    default int menuStep(int begin, int end) {
        for (int i = begin; i < end+1; i++) {
            System.out.println(readText(i));
        }
        return correctInput(end-begin);
    }
    /** Позволяет ввести число от 1 до аргумента*/
    default int correctInput(int min,int max){
        boolean flag = true;
        int answer = -1;
        while (flag) {
            Scanner scanner = new Scanner(System.in);
            if (scanner.hasNextInt()) {
                answer = scanner.nextInt();
                if (answer >= min && answer <= max) {
                    flag = false;
                }
                else{
                    System.out.println("Некорректный ввод. Введите число от 1 до " + max);
                }
            } else {
                System.out.println("Некорректный ввод. Введите число от 1 до " + max);
            }
        }
        return answer;
    }

    default int correctInput(int max){
        return correctInput(1, max);
    }

}
