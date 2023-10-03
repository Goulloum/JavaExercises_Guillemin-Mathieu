package Bonus.morpion;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Morpion implements ActionListener {
    // Initialize empty game
    private Game game = new Game();
    private JButton[] gridButtons = new JButton[9];

    private JLabel textfield = new JLabel();
    private JPanel textPanel = new JPanel();
    private JPanel boardPanel = new JPanel();
    private JFrame frame = new JFrame();

    private String gamemode = null;

    public Morpion() {

        // Initialize window
        this.frame.setVisible(true);

        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frame.setSize(500, 500);
        this.frame.getContentPane().setBackground(new Color(0, 0, 0));
        this.frame.setTitle("Morpion");
        this.frame.setLayout(new BorderLayout());
        this.frame.setVisible(true);

        // Init text panel
        this.textfield.setBackground(new Color(0, 0, 0));
        this.textfield.setForeground(new Color(255, 255, 255));
        this.textfield.setFont(new Font("Serif", Font.BOLD, 75));
        this.textfield.setHorizontalAlignment(JLabel.CENTER);
        this.textfield.setText("Morpion");
        this.textfield.setOpaque(true);

        this.textPanel.setLayout(new BorderLayout());
        this.textPanel.setBounds(0, 0, 800, 100);
        this.textPanel.add(this.textfield);

        // Init boardPanel
        this.boardPanel.setLayout(new GridLayout(3, 3));
        this.boardPanel.setBackground(new Color(0, 0, 0));

        for (int i = 0; i < 9; i++) {
            this.gridButtons[i] = new JButton();
            this.boardPanel.add(this.gridButtons[i]);
            this.gridButtons[i].setFont(new Font("Serif", Font.BOLD, 120));
            this.gridButtons[i].setFocusable(false);
            this.gridButtons[i].addActionListener(this);
            this.gridButtons[i].setBackground(Color.cyan);
        }

        this.frame.add(this.boardPanel);
        this.frame.add(this.textPanel, BorderLayout.NORTH);
        this.startGame();

    }

    public void startGame() {

        Object[] option = { "Joueur VS Joueur", "Joueur VS Ordi" };
        int n = JOptionPane.showOptionDialog(frame, "Choisissez un mode de jeu :", "Morpion", JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE, null, option, option[0]);
        if (n == 0) {
            this.gamemode = "pvp";
        } else {
            this.gamemode = "pve";
        }

    }

    public void gameOver(String s) {
        Object[] option = { "Restart", "Exit" };
        int n = JOptionPane.showOptionDialog(frame, "Game Over\n" + s, "Game Over", JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE, null, option, option[0]);
        if (n == 0) {
            this.frame.dispose();
            new Morpion();
        } else {
            this.frame.dispose();
        }

    }

    public void xWins() {

        for (int i = 0; i < 9; i++) {
            this.gridButtons[i].setEnabled(false);
        }
        this.textfield.setText("Player X wins");
        this.gameOver("Player X Wins");
    }

    // Method to print that Player O wins
    public void oWins() {

        for (int i = 0; i < 9; i++) {
            this.gridButtons[i].setEnabled(false);
        }
        this.textfield.setText("Player O Wins");
        this.gameOver("Player O Wins");
    }

    public void tie() {
        for (int i = 0; i < 9; i++) {
            this.gridButtons[i].setEnabled(false);
        }
        this.textfield.setText("Tie");
        this.gameOver("Tie");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (this.gamemode.equals("pvp")) {

            for (int i = 0; i < 9; i++) {
                if (e.getSource() == this.gridButtons[i]) {
                    if (this.game.getIsPlayerTurn()) {
                        if (this.game.setBoardSlot(i / 3, i % 3, 1)) {
                            this.gridButtons[i].setForeground(new Color(0, 188, 255));
                            this.gridButtons[i].setText("X");
                            this.game.setIsPlayerTurn(!this.game.getIsPlayerTurn());
                            this.textfield.setText("O turn");

                        }
                    } else {
                        if (this.game.setBoardSlot(i / 3, i % 3, 2)) {
                            this.gridButtons[i].setForeground(new Color(0, 188, 255));
                            this.gridButtons[i].setText("O");
                            this.game.setIsPlayerTurn(!this.game.getIsPlayerTurn());
                            this.textfield.setText("X turn");

                        }
                    }

                }
            }
        } else if (this.gamemode.equals("pve")) {
            for (int i = 0; i < 9; i++) {
                if (e.getSource() == this.gridButtons[i]) {
                    if (this.game.getIsPlayerTurn()) {
                        if (this.game.setBoardSlot(i / 3, i % 3, 1)) {
                            this.gridButtons[i].setForeground(new Color(0, 188, 255));
                            this.gridButtons[i].setText("X");

                        }
                    }
                }
            }
            if (this.game.evaluate() == -1) {
                Integer[] computerCoordinates = this.game.getRandomNextMove();
                this.game.setBoardSlot(computerCoordinates[0], computerCoordinates[1], 2);
                this.gridButtons[computerCoordinates[0] * 3 + computerCoordinates[1]]
                        .setForeground(new Color(0, 188, 255));
                this.gridButtons[computerCoordinates[0] * 3 + computerCoordinates[1]].setText("O");
                this.textfield.setText("X turn");
            }
        }

        Integer eval = this.game.evaluate();
        switch (eval) {
            case 10:
                xWins();
                break;
            case -10:
                oWins();
                break;
            case 0:
                tie();
                break;

        }

    }

}
