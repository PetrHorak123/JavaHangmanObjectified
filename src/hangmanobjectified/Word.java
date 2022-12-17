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
    
    public void RevealWord(){ 
        for (Letter letter : _LettersOfWord) {
            letter.Guessed = true;
        }
    }
    
    public boolean CheckIfGuessed(){
        int guessed = 0;
        for (Letter letter : _LettersOfWord) {
            if (letter.Guessed) guessed++;           
        }
        return guessed == _LettersOfWord.size();
    }    
}
