package org.example;

import java.util.Scanner;

// render console interface
public class ConsoleRenderer {
    public static Scanner scanner = new Scanner(System.in);

    static void renderHanagman(int stage) {
        if (stage == 0) {
            System.out.println("  ( )====");
            System.out.println("   |    |");
            System.out.println("        |");
            System.out.println("        |");
            System.out.println("        #");

        } else if (stage == 1) {
            System.out.println("  ( )====");
            System.out.println("   |    |");
            System.out.println("   @    |");
            System.out.println("        |");
            System.out.println("        #");

        }  else if (stage == 2) {
            System.out.println("  ( )====");
            System.out.println("   |    |");
            System.out.println("   @    |");
            System.out.println("   |    |");
            System.out.println("        #");

        } else if (stage == 3) {
            System.out.println("  ( )====");
            System.out.println("   |    |");
            System.out.println("   @    |");
            System.out.println("   |\\   |");
            System.out.println("        #");
        } else if (stage == 4) {
            System.out.println("  ( )====");
            System.out.println("   |    |");
            System.out.println("   @    |");
            System.out.println("  /|\\   |");
            System.out.println("        #");
        } else if (stage == 5) {
            System.out.println("  ( )====");
            System.out.println("   |    |");
            System.out.println("   @    |");
            System.out.println("  /|\\   |");
            System.out.println("    \\   #");
        } else if (stage == 6) {
            System.out.println("  ( )====");
            System.out.println("   |    |");
            System.out.println("   @    |");
            System.out.println("  /|\\   |");
            System.out.println("  / \\   #");
        }
    }

    static void renderWordHolder(Word word) {
        for (Letter letter : word.getWord()) {
            if (letter.getInWord() == true) {
                System.out.print(letter.getChar());
            }
            else {
                System.out.print("_");
            }
        }
        System.out.println("");
    }

    static String inputLetter() {
        System.out.println("Введите латинскую букву в нижнем регистре: ");
        scanner = new Scanner(System.in);
        String letter = scanner.nextLine();
        return letter;
    }

    static int renderMenu() {
        System.out.println("1. Начать новую игру");
        System.out.println("2. Выйти");
        scanner = new Scanner(System.in);
        int menuItem = scanner.nextInt();
        return menuItem;
    }

    static void closeConsoleRenderer() {
        scanner.close();
    }

}
