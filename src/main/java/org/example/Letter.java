package org.example;

// letter for hangman game incapsualate character and boolean variables
public class Letter {
    private Character letter;
    // boolean variable responsible for whether it was guessed or not
    private Boolean isInWord;

    Letter(Character letter) {
        this.letter = letter;
        isInWord = false;
    }

    public Character getChar() {
        return letter;
    }

    public Boolean getInWord() {
        return isInWord;
    }

    public void setLetter(Character letter) {
        this.letter = letter;
    }

    public void setInWord(Boolean inWord) {
        isInWord = inWord;
    }
}
