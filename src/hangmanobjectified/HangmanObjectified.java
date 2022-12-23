/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package hangmanobjectified;

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

        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n");
        System.out.println("\n- NEW GAME -\n");
        while (!end)
        {
            System.out.println(Graphics[mistakesCount]);
            System.out.println(_word.GetWord());
            //System.out.println("DEBUG ONLY: " + _word.GetWordString());
            System.out.println("\nYour guess:");

            //user input
            char guess = sc.next().toLowerCase().charAt(0);
            
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n");
            
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
            if (_word.CheckIfGuessed()){
                end = true;
                System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n"); // Console.Clear()
                System.out.println(" ".repeat(((_word.GetWord().length() / 2) - 6) > 0 ? (_word.GetWord().length() / 2) - 6 : 0) + "- YOU WON -\n");
                System.out.println(_word.GetWord().toUpperCase());
                System.out.println("\n");
            } 
            else if(mistakesCount == 6){
                end = true;
                System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n"); // Console.Clear()
                System.out.println(Graphics[mistakesCount]);
                _word.RevealWord();
                System.out.println(_word.GetWord().toUpperCase());
                System.out.println(" ".repeat(((_word.GetWord().length() / 2) - 7) > 0 ? (_word.GetWord().length() / 2) - 7 : 0) + "- YOU LOST -\n");
                System.out.println("\n\n\n");
            }
        }   

    }
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        boolean play = true;
        while(play){
            Game();
            
            System.out.println("Play again? [a]");
            String input = sc.next();
            if(!"a".equals(input.toLowerCase())){
                play = false;
            }
        }
                
    }
    
}




