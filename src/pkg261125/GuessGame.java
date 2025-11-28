/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pkg261125;

/**
 *
 * @author megac
 */
public class GuessGame {
  

    private int secretNumber;
    private int attemptsLeft;
    private int attemptCounter;
    private final int maxAttempts;

    private final GuessLogEntry[] log;  // ← ARREGLO ESTÁTICO
    private boolean isGameOver;

    public GuessGame(int maxAttempts) {
        this.maxAttempts = maxAttempts;
        this.log = new GuessLogEntry[maxAttempts]; // tamaño fijo
        resetGame();
    }

    public final void resetGame() {
        secretNumber = (int) (Math.random() * 100) + 1;
        attemptsLeft = maxAttempts;
        attemptCounter = 0;
        isGameOver = false;

        // Limpiar arreglo
        for (int i = 0; i < log.length; i++) {
            log[i] = null;
        }
    }

    public String guess(int number) {
        if (isGameOver) {
            return "El juego ya terminó. Reinicia la partida.";
        }

        attemptCounter++;
        attemptsLeft--;

        String result;

        if (number == secretNumber) {
            result = "Correcto 🎉. Adivinaste el número.";
            isGameOver = true;
        } else if (number > secretNumber) {
            result = "Tu número es MAYOR.";
        } else {
            result = "Tu número es MENOR.";
        }

        // Registrar intento en el arreglo estático
        log[attemptCounter - 1] = new GuessLogEntry(attemptCounter, number, result);

        if (attemptsLeft == 0 && !isGameOver) {
            isGameOver = true;
            result += " | Sin intentos restantes. El número era: " + secretNumber;
        }

        imprimirLog();
        return result;
    }

    public int getAttemptsLeft() { return attemptsLeft; }
    public boolean isGameOver() { return isGameOver; }
    public int getSecretNumber() { return secretNumber; }

    // Devuelve el arreglo completo
    public GuessLogEntry[] getLog() { return log; }
    
    public void imprimirLog(){
        System.out.println("Log - Game");
        for(int i=0; i<attemptCounter; i++){
            System.out.println("" + log[i].toString());
        }
        System.out.println("-- fin de Log - game");
    }
}

