/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pkg261125;

/**
 *
 * @author megac
 */
public class GuessLogEntry {
     private final int attemptNumber;
    private final int guess;
    private final String result;

    public GuessLogEntry(int attemptNumber, int guess, String result) {
        this.attemptNumber = attemptNumber;
        this.guess = guess;
        this.result = result;
    }

    public int getAttemptNumber() { return attemptNumber; }
    public int getGuess() { return guess; }
    public String getResult() { return result; }

    @Override
    public String toString() {
        return "Intento " + attemptNumber +
               ": número=" + guess +
               " → " + result;
    }
}
