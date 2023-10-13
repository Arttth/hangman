package org.example;

import java.util.HashSet;
import java.util.Random;

public class Game {
    // store all words
    HashSet<String> words = new HashSet<>();
    // guessable word
    Word currentWord;
    // hangman's stage before losing
    int stage;

    Game() {
        // reading words from file
        WordFileReader.getWords(words);
        newGameInit();
    }

    // init new game
    private void newGameInit() {
        stage = 0;
        currentWord = getRandomWord();
    }

    // get random word from set words
    private Word getRandomWord() {
        Random random = new Random();
        int rnd = random.nextInt(words.size());
        String[] arrayWords = words.toArray(new String[words.size()]);
        return new Word(arrayWords[rnd]);
    }

    private boolean isWon() {
        boolean won = true;
        for (int i = 0; i < currentWord.getLength(); ++i) {
            won &= currentWord.getLetter(i).getInWord();
        }
        return won;
    }

    // check letter and open if character is occures
    private boolean checkLetter(Character letter) {
        if ((int)letter < 97 || (int)letter > 122 ||
                !currentWord.wordContains(new Letter(letter))) {
            return false;
        } else {
            currentWord.openLetters(new Letter(letter));
            return true;
        }
    }


    // main loop of game
    void play() {
        while (true) {
            // render menu interface
            int menuItem = ConsoleRenderer.renderMenu();
            if (menuItem == 2) break;
            else if (menuItem == 1) {
                while (true) {
                    // render game interface
                    ConsoleRenderer.renderHanagman(stage);
                    ConsoleRenderer.renderWordHolder(currentWord);
                    if (stage >= 6) {
                        System.out.println("Вы проиграли!!!");
                        break;
                    }
                    if (isWon()) {
                        System.out.println("Вы выйграли!!!");
                        break;
                    }
                    // input char and checking it
                    String in = ConsoleRenderer.inputLetter();
                    if (in.length() != 1) {
                        stage++;
                        continue;
                    }
                    Character letter = in.charAt(0);
                    if (!checkLetter(letter)) {
                        stage++;
                    }
                }
                // initializing new game after break
                newGameInit();
            }
        }
        // closing console renderer
        ConsoleRenderer.closeConsoleRenderer();
    }

}
