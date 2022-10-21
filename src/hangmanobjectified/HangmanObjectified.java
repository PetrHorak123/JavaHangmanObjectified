/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package hangmanobjectified;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

/**
 *
 * @author Petr Horák
 */
public class HangmanObjectified {

    static void Game()
    {
        Scanner sc = new Scanner(System.in);
        Word _word = new Word();
        int mistakesCount = 0;
        String[] Graphics = {
            "   +---+\n   |   |\n       |\n       |\n       |\n       |\n =========",
            "   +---+\n   |   |\n   O   |\n       |\n       |\n       |\n =========",
            "   +---+\n   |   |\n   O   |\n   |   |\n       |\n       |\n =========",
            "   +---+\n   |   |\n   O   |\n  /|   |\n       |\n       |\n =========",
            "   +---+\n   |   |\n   O   |\n  /|\\  |\n       |\n       |\n =========",
            "   +---+\n   |   |\n   O   |\n  /|\\  |\n  /    |\n       |\n =========",
            "   +---+\n   |   |\n   O   |\n  /|\\  |\n  / \\  |\n       |\n ========="
        };
        String result = "_ ".repeat( _word._LettersOfWord.size());
        boolean end = false;

        System.out.println("\n- NEW GAME -");
//        while (!end)
//        {
            System.out.println(Graphics[mistakesCount]);
            System.out.println(result);
            System.out.println("\nYour guess:");

            //char guess = sc.next().charAt(0);

            
        //}   

    }
    
    public static void main(String[] args) {

        Game();
    }
    
}

class Word{
    public List<Letter> _LettersOfWord; // představuje slovo samotné 
    public Word() // vytváří se nová instance slova
    {
        _LettersOfWord = new ArrayList<Letter>(); 
        for (char character : GetRandomWord().toCharArray()) // naplnění listu písmen slova podle náhodně vybraného slova ze souboru
        {
            Letter letterToAdd = new Letter(character, false);
            _LettersOfWord.add(letterToAdd);
        }
        
    }

    private String GetRandomWord()
    {
        try {
            List<String> allLines = Files.readAllLines(Paths.get("slova.txt"));
            Random random = new Random();
            return allLines.get(random.nextInt(1, allLines.size())).toLowerCase();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }

    public String GetWordString() // možná potom
    { 
        String result = "";
        for (Letter letter : _LettersOfWord)
        {
            result += letter._Letter;
        }
        return result.toLowerCase();
    }
}

class Letter{
    char _Letter;
    boolean Guessed;
    
    public Letter(char letter, boolean guessed){
        _Letter = letter;
        Guessed = guessed;
    }
}


