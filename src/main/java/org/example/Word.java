package org.example;

public class Word {
    Letter[] word;

    Word(String word) {
        this.word = new Letter[word.length()];
        for (int i = 0; i < word.length(); ++i) {
            this.word[i] = new Letter(word.charAt(i));
        }
    }

    public Letter[] getWord() {
        return word;
    }

    public int getLength() {
        return word.length;
    }

    public Letter getLetter(int index) {
        if (index < 0 || index > word.length) {
            throw new IndexOutOfBoundsException();
        }
        return word[index];
    }

    // checking whether contains word letter
    public boolean wordContains(Letter letter) {

        for (int i = 0; i < word.length; ++i) {
            if (letter.getChar() == word[i].getChar()) {
                return true;
            }
        }
        return false;
    }

    // open letters from word that are equal letter param
    public void openLetters(Letter letter) {
        for (int i = 0; i < word.length; ++i) {
            if (letter.getChar() == word[i].getChar()) {
                word[i].setInWord(true);
            }
        }
    }

}
