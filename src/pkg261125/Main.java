/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

package pkg261125;

/**
 * Clase principal que contiene el punto de entrada de la aplicación.
 *
 * @author megac
 */
public class Main {

    /**
     * Método principal (main) que inicia la aplicación.
     * Utiliza SwingUtilities.invokeLater para asegurar que la interfaz gráfica
     * se cree y actualice en el hilo de despacho de eventos (EDT).
     *
     * @param args los argumentos de la línea de comandos (no utilizados).
     */
    public static void main(String[] args) {
         javax.swing.SwingUtilities.invokeLater(() -> new GuessGameGUI());
    }

}
