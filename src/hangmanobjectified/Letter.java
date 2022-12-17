/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hangmanobjectified;

/**
 *
 * @author petrh
 */
public class Letter {
    char _Letter;
    boolean Guessed;
    
    public Letter(char letter, boolean guessed){
        _Letter = letter;
        Guessed = guessed;
    }
}
