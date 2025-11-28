/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pkg261125;

/**
 * Clase que representa una entrada en el registro de intentos del juego.
 * Almacena la información de un intento específico, incluyendo el número de intento,
 * el número adivinado y el resultado obtenido.
 *
 * @author megac
 */
public class GuessLogEntry {
    /** El número secuencial del intento (1, 2, 3, etc.). */
    private final int attemptNumber;

    /** El número que el usuario intentó adivinar. */
    private final int guess;

    /** El resultado del intento (ej. "Tu número es MAYOR"). */
    private final String result;

    /**
     * Constructor para crear una nueva entrada de registro.
     *
     * @param attemptNumber El número secuencial del intento.
     * @param guess El número ingresado por el usuario.
     * @param result El mensaje de resultado asociado a este intento.
     */
    public GuessLogEntry(int attemptNumber, int guess, String result) {
        this.attemptNumber = attemptNumber;
        this.guess = guess;
        this.result = result;
    }

    /**
     * Obtiene el número del intento.
     * @return El número secuencial del intento.
     */
    public int getAttemptNumber() { return attemptNumber; }

    /**
     * Obtiene el número adivinado en este intento.
     * @return El número ingresado por el usuario.
     */
    public int getGuess() { return guess; }

    /**
     * Obtiene el resultado textual del intento.
     * @return El mensaje de resultado.
     */
    public String getResult() { return result; }

    /**
     * Representación en cadena de la entrada del registro.
     * Útil para mostrar el historial en la interfaz o consola.
     *
     * @return Una cadena describiendo el intento y su resultado.
     */
    @Override
    public String toString() {
        return "Intento " + attemptNumber +
               ": número=" + guess +
               " → " + result;
    }
}
