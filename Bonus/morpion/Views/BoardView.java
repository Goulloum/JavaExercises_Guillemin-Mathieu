package Bonus.morpion.Views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Bonus.morpion.Game;

public abstract class BoardView extends JFrame implements ActionListener {
    private JPanel boardPanel = new JPanel();
    private JButton[] gridButtons = new JButton[9];
    private JLabel textfield = new JLabel();
    private JPanel textPanel = new JPanel();
    private Game game = null;
    private String gamemode = null;

    public BoardView(String gamemode, Game game) {
        this.game = game;
        this.gamemode = gamemode;
        setSize(500, 700);
        setBackground(new Color(0, 0, 0));
        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.boardPanel.setLayout(new BoxLayout(this.boardPanel, BoxLayout.PAGE_AXIS));
        this.add(this.boardPanel);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500, 500);
        this.getContentPane().setBackground(new Color(0, 0, 0));
        this.setTitle("Morpion, mode " + gamemode.toUpperCase());
        this.setLayout(new BorderLayout());
        this.setVisible(true);

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

        this.add(this.boardPanel);
        this.add(this.textPanel, BorderLayout.NORTH);
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
                            this.textfield.setText("Tour de O");

                        }
                    } else {
                        if (this.game.setBoardSlot(i / 3, i % 3, 2)) {
                            this.gridButtons[i].setForeground(new Color(0, 188, 255));
                            this.gridButtons[i].setText("O");
                            this.game.setIsPlayerTurn(!this.game.getIsPlayerTurn());
                            this.textfield.setText("Tour de X");

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
                            this.game.setIsPlayerTurn(false);

                        }
                    }
                }
            }
            if (this.game.evaluate() == -1) {
                Integer[] computerCoordinates = this.game.playRandomNextMove();
                this.game.setBoardSlot(computerCoordinates[0], computerCoordinates[1], 2);
                this.gridButtons[computerCoordinates[0] * 3 + computerCoordinates[1]]
                        .setForeground(new Color(0, 188, 255));
                this.gridButtons[computerCoordinates[0] * 3 + computerCoordinates[1]].setText("O");
                this.textfield.setText("Tour de X");
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

    public void xWins() {

        for (int i = 0; i < 9; i++) {
            this.gridButtons[i].setEnabled(false);
        }
        this.textfield.setText("Victoire de X");
        this.gameOver("Victoire de X");
    }

    // Method to print that Player O wins
    public void oWins() {

        for (int i = 0; i < 9; i++) {
            this.gridButtons[i].setEnabled(false);
        }
        this.textfield.setText("Victoire de O");
        this.gameOver("Victoire de O");
    }

    public void tie() {
        for (int i = 0; i < 9; i++) {
            this.gridButtons[i].setEnabled(false);
        }
        this.textfield.setText("Egalitée");
        this.gameOver("Egalitée");
    }

    public void gameOver(String result) {
    };
}
