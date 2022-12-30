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

    char letter;
    boolean guessed;

    public Letter(char let, boolean gues) {
        letter = let;
        guessed = gues;
    }
}
