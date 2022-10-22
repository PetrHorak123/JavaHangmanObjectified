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
        boolean end = false;        

        System.out.println("\n- NEW GAME -");
        while (!end)
        {
            System.out.println(Graphics[mistakesCount]);
            System.out.println(_word.GetWord());
            System.out.println("DEBUG ONLY: " + _word.GetWordString());
            System.out.println("\nYour guess:");

            //user input
            char guess = sc.next().toLowerCase().charAt(0);
            
            //porovnání inputu se slovem
            int charMatches = 0;
            for (Letter letter : _word._LettersOfWord) {
                if (letter._Letter == guess) {
                    letter.Guessed = true;
                    charMatches++;
                }
            }            
            if (charMatches == 0)  mistakesCount++;

            //kontrola konce hry 
            if (_word.CheckIfGuessed() || mistakesCount == 6) end = true;

        }   

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

    public String GetWordString() // debug only 
    { 
        String result = "";
        for (Letter letter : _LettersOfWord)
        {
            result += letter._Letter;
        }
        return result.toLowerCase();
    }
    
    public String GetWord(){ // vrací slovo zobrazované hráči
        String result = "";
        for (Letter letter : _LettersOfWord) {
            if (letter.Guessed) {
                result += (letter._Letter + " ");
            }
            else{
                result += "_ ";
            }
        }
        return result;
    }
    
    public boolean CheckIfGuessed(){
        int guessed = 0;
        for (Letter letter : _LettersOfWord) {
            if (letter.Guessed) guessed++;           
        }
        return guessed == _LettersOfWord.size();
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


