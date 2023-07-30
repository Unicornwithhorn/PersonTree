package Creater;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public interface Technicable {
    default String readText(int lineNumber){
        String line;
        Files Files = null;
        try {
            line = java.nio.file.Files.readAllLines(Paths.get("src/Creater/workText.txt")).get(lineNumber-1);
            return line;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    default int menuStep(int begin, int end) {
        for (int i = begin; i < end+1; i++) {
            System.out.println(readText(i));
        }
        boolean flag = true;
        int answer = 0;
        while (flag) {
            Scanner scanner = new Scanner(System.in);
            if (scanner.hasNextInt()) {
                answer = scanner.nextInt();
                if (answer >= 1 && answer <= end-begin) {
                    flag = false;
                }
                else{
                    System.out.println("Некорректный ввод. Введите число от 1 до " + (end-begin));
                }
            } else {
                System.out.println("Некорректный ввод. Введите число от 1 до " + (end-begin));
            }
        }
        return answer;
    }
}
