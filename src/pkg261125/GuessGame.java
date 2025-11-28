/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pkg261125;

/**
 * Clase que maneja la lógica principal del juego de adivinar el número.
 * Se encarga de generar el número secreto, validar los intentos del usuario
 * y mantener un registro de los intentos realizados.
 *
 * @author megac
 */
public class GuessGame {
  
    /** El número secreto que el jugador debe adivinar. */
    private int secretNumber;

    /** Cantidad de intentos que le quedan al jugador. */
    private int attemptsLeft;

    /** Contador de intentos realizados hasta el momento. */
    private int attemptCounter;

    /** Número máximo de intentos permitidos en una partida. */
    private final int maxAttempts;

    /** Arreglo estático para almacenar el historial de intentos. */
    private final GuessLogEntry[] log;

    /** Indica si el juego ha terminado. */
    private boolean isGameOver;

    /**
     * Constructor que inicializa el juego con un número máximo de intentos.
     *
     * @param maxAttempts El número máximo de intentos permitidos.
     */
    public GuessGame(int maxAttempts) {
        this.maxAttempts = maxAttempts;
        this.log = new GuessLogEntry[maxAttempts]; // tamaño fijo
        resetGame();
    }

    /**
     * Reinicia el juego, generando un nuevo número secreto y restableciendo
     * los contadores y el registro de intentos.
     */
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

    /**
     * Procesa un intento de adivinanza del usuario.
     * Compara el número ingresado con el número secreto y actualiza el estado del juego.
     *
     * @param number El número ingresado por el usuario.
     * @return Un mensaje indicando el resultado del intento (mayor, menor, correcto, o juego terminado).
     */
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

    /**
     * Obtiene la cantidad de intentos restantes.
     * @return El número de intentos que le quedan al jugador.
     */
    public int getAttemptsLeft() { return attemptsLeft; }

    /**
     * Verifica si el juego ha terminado.
     * @return true si el juego ha terminado, false en caso contrario.
     */
    public boolean isGameOver() { return isGameOver; }

    /**
     * Obtiene el número secreto actual.
     * @return El número secreto generado aleatoriamente.
     */
    public int getSecretNumber() { return secretNumber; }

    /**
     * Devuelve el registro completo de los intentos realizados.
     * @return Un arreglo de objetos GuessLogEntry con el historial.
     */
    public GuessLogEntry[] getLog() { return log; }
    
    /**
     * Imprime el registro de intentos en la consola para depuración.
     */
    public void imprimirLog(){
        System.out.println("Log - Game");
        for(int i=0; i<attemptCounter; i++){
            System.out.println("" + log[i].toString());
        }
        System.out.println("-- fin de Log - game");
    }
}
