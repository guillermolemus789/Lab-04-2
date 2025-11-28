/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pkg261125;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * Interfaz Gráfica de Usuario (GUI) para el juego de adivinar el número.
 * Hereda de JFrame y gestiona la visualización y la interacción con el usuario.
 *
 * @author megac
 */
  public class GuessGameGUI extends JFrame {

    /** Instancia de la lógica del juego. */
    private final GuessGame game;

    /** Campo de texto para que el usuario ingrese su número. */
    private JTextField inputNumber;

    /** Área de texto para mostrar el historial de intentos. */
    private JTextArea logArea;

    /** Etiqueta para mostrar los intentos restantes. */
    private JLabel lblAttempts;

    /**
     * Constructor que inicializa la lógica del juego y configura la interfaz gráfica.
     * Crea una nueva instancia de GuessGame con 5 intentos máximos.
     */
    public GuessGameGUI() {
        game = new GuessGame(5); // máximo 5 intentos
        setupUI();
    }

    /**
     * Configura los componentes de la interfaz de usuario.
     * Establece el título, tamaño, layout y agrega los controles necesarios.
     */
    private void setupUI() {
        setTitle("Juego Adivina el Número");
        setSize(400, 350);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel topPanel = new JPanel();
        topPanel.add(new JLabel("Ingresa un número 1-100:"));
        inputNumber = new JTextField(5);
        topPanel.add(inputNumber);

        JButton btnGuess = new JButton("Intentar");
        btnGuess.addActionListener(this::handleGuess);
        topPanel.add(btnGuess);

        lblAttempts = new JLabel("Intentos restantes: " + game.getAttemptsLeft());
        topPanel.add(lblAttempts);

        add(topPanel, BorderLayout.NORTH);

        logArea = new JTextArea();
        logArea.setEditable(false);
        add(new JScrollPane(logArea), BorderLayout.CENTER);

        JButton btnReset = new JButton("Reiniciar Juego");
        btnReset.addActionListener(e -> resetGame());
        add(btnReset, BorderLayout.SOUTH);

        setLocationRelativeTo(null);
        setVisible(true);
    }

    /**
     * Maneja el evento de intento de adivinanza (clic en el botón "Intentar").
     * Lee el número ingresado, llama a la lógica del juego y actualiza la interfaz.
     * Muestra mensajes de error si la entrada no es un número válido.
     *
     * @param e El evento de acción disparado por el botón.
     */
    private void handleGuess(ActionEvent e) {
        try {
            int number = Integer.parseInt(inputNumber.getText());
            String result = game.guess(number);

            refreshLog();
            lblAttempts.setText("Intentos restantes: " + game.getAttemptsLeft());
            inputNumber.setText("");

            if (game.isGameOver()) {
                JOptionPane.showMessageDialog(this,
                        "Juego terminado.\nNúmero correcto: " + game.getSecretNumber());
            }

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Ingresa un número válido.");
        }
    }

    /**
     * Actualiza el área de registro (logArea) con el historial de intentos actual del juego.
     */
    private void refreshLog() {
        logArea.setText("");
        for (GuessLogEntry entry : game.getLog()) {
            if (entry != null) {
                logArea.append(entry.toString() + "\n");
            }
        }
    }

    /**
     * Reinicia el juego y actualiza la interfaz a su estado inicial.
     */
    private void resetGame() {
        game.resetGame();
        logArea.setText("");
        lblAttempts.setText("Intentos restantes: " + game.getAttemptsLeft());
    }
}
