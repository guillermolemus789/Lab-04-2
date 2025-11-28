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
 *
 * @author megac
 */
  public class GuessGameGUI extends JFrame {

    private final GuessGame game;
    private JTextField inputNumber;
    private JTextArea logArea;
    private JLabel lblAttempts;

    public GuessGameGUI() {
        game = new GuessGame(5); // máximo 5 intentos
        setupUI();
    }

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

    private void refreshLog() {
        logArea.setText("");
        for (GuessLogEntry entry : game.getLog()) {
            if (entry != null) {
                logArea.append(entry.toString() + "\n");
            }
        }
    }

    private void resetGame() {
        game.resetGame();
        logArea.setText("");
        lblAttempts.setText("Intentos restantes: " + game.getAttemptsLeft());
    }
}

