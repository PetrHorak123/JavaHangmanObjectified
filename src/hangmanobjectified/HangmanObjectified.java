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
        Word word = new Word();
        int mistakesCount = 0;
        String[] graphics = {
            "   +---+\n   |   |\n       |\n       |\n       |\n       |\n =========",
            "   +---+\n   |   |\n   O   |\n       |\n       |\n       |\n =========",
            "   +---+\n   |   |\n   O   |\n   |   |\n       |\n       |\n =========",
            "   +---+\n   |   |\n   O   |\n  /|   |\n       |\n       |\n =========",
            "   +---+\n   |   |\n   O   |\n  /|\\  |\n       |\n       |\n =========",
            "   +---+\n   |   |\n   O   |\n  /|\\  |\n  /    |\n       |\n =========",
            "   +---+\n   |   |\n   O   |\n  /|\\  |\n  / \\  |\n       |\n ========="
        };
        final String WIN_PHRASE = "- YOU WON -\n";
        final String LOSE_PHRASE = "- YOU LOST -\n";
        boolean end = false;        

        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n");
        System.out.println("\n- NEW GAME -\n");
        while (!end)
        {
            System.out.println(graphics[mistakesCount]);
            System.out.println(word.getWord());
            System.out.println("\nYour guess:");

            //user input
            char guess = sc.next().toLowerCase().charAt(0);
            
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n");
            
            //porovnání inputu se slovem
            int charMatches = 0;
            for (Letter letter : word.lettersOfWord) {
                if (letter.letter == guess) {
                    letter.guessed = true;
                    charMatches++;
                }
            }            
            if (charMatches == 0)  mistakesCount++;

            //kontrola konce hry 
            if (word.checkIfGuessed()){
                end = true;
                System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n"); // Console.Clear()
                System.out.println(" ".repeat(((word.getWord().length() / 2) - (WIN_PHRASE.length() / 2)) > 0 ? (word.getWord().length() / 2) - (WIN_PHRASE.length() / 2) : 0) + WIN_PHRASE);
                System.out.println(word.getWord().toUpperCase());
                System.out.println("\n");
            } 
            else if(mistakesCount == 6){
                end = true;
                System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n"); // Console.Clear()
                System.out.println(graphics[mistakesCount]);
                word.revealWord();
                System.out.println(word.getWord().toUpperCase());
                System.out.println(" ".repeat(((word.getWord().length() / 2) - (LOSE_PHRASE.length() / 2)) > 0 ? (word.getWord().length() / 2) - (LOSE_PHRASE.length() / 2) : 0) + LOSE_PHRASE);
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




