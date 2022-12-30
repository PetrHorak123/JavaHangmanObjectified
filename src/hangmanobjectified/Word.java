/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hangmanobjectified;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author petrh
 */
public class Word {

    final String FILE_NAME = "slova.txt";
    public List<Letter> lettersOfWord; // představuje slovo samotné 

    public Word() { // vytváří se nová instance slova
        lettersOfWord = new ArrayList<Letter>();
        for (char character : getRandomWord().toCharArray()) { // naplnění listu písmen slova podle náhodně vybraného slova ze souboru
            Letter letterToAdd = new Letter(character, false);
            lettersOfWord.add(letterToAdd);
        }
    }

    private String getRandomWord() {
        try {
            List<String> allLines = Files.readAllLines(Paths.get(FILE_NAME));
            Random random = new Random();
            return allLines.get(random.nextInt(1, allLines.size())).toLowerCase();
        } catch (IOException e) {
            System.out.println("Soubor " + FILE_NAME + " nebyl nalezen");
            e.printStackTrace();
        }
        return "";
    }

    public String getWord() { // vrací slovo zobrazované hráči
        String result = "";
        for (Letter letter : lettersOfWord) {
            if (letter.guessed) {
                result += (letter.letter + " ");
            } else {
                result += "_ ";
            }
        }
        return result;
    }

    public void revealWord() {
        for (Letter letter : lettersOfWord) {
            letter.guessed = true;
        }
    }

    public boolean checkIfGuessed() {
        int guessed = 0;
        for (Letter letter : lettersOfWord) {
            if (letter.guessed) {
                guessed++;
            }
        }
        return guessed == lettersOfWord.size();
    }
}
