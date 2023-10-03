package Bonus.morpion;

import java.util.Random;
import java.util.Scanner;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Morpion implements ActionListener {
    // Initialize empty game
    private Game game = new Game();
    private JButton[] gridButtons = new JButton[9];
    private JLabel textfield = new JLabel();
    private JPanel t_panel = new JPanel();
    private JPanel bt_panel = new JPanel();
    private JFrame frame = new JFrame();

    public Morpion() {

        // Initialize window
        frame.setVisible(true);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.getContentPane().setBackground(new Color(250, 184, 97));
        frame.setTitle("Tic Tac Toe Game in Swing");
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);

        textfield.setBackground(new Color(0, 0, 0));
        textfield.setForeground(new Color(255, 0, 0));
        textfield.setFont(new Font("Serif", Font.BOLD, 75));
        textfield.setHorizontalAlignment(JLabel.CENTER);
        textfield.setText("Tic Tac Toe Game in Swing");
        textfield.setOpaque(true);

        t_panel.setLayout(new BorderLayout());
        t_panel.setBounds(0, 0, 800, 100);

        bt_panel.setLayout(new GridLayout(3, 3));
        bt_panel.setBackground(new Color(0, 0, 0));

        GridLayout grid = new GridLayout(3, 3);
        frame.setLayout(grid);
        for (int i = 0; i < 9; i++) {
            gridButtons[i] = new JButton();
            bt_panel.add(gridButtons[i]);
            gridButtons[i].setFont(new Font("Serif", Font.BOLD, 120));
            gridButtons[i].setFocusable(false);
            gridButtons[i].addActionListener(this);
            gridButtons[i].setBackground(Color.cyan);
        }

        t_panel.add(textfield);
        frame.add(t_panel, BorderLayout.NORTH);
        frame.add(bt_panel);
        // // Print rules
        // System.out.println(
        // "Pour jouer il suffit de rentrer les coordonnées de la case désirée exemple
        // je veux joueur dans la première ligne 2 ème case :");
        // System.out.println("1 2");

        // while (evaluate(this.board) == -1) {
        // if (isPlayerTurn) {
        // System.out.println("Au tour du joueur :");
        // String playerMove = scan.nextLine();
        // String[] moveCoordinates = playerMove.split(" ");

        // try {
        // Integer[] moveCoordinatesInt = { Integer.parseInt(moveCoordinates[0]) - 1,
        // Integer.parseInt(moveCoordinates[1]) - 1 };
        // // Check if coordinates are in range 0 to 2
        // if (moveCoordinatesInt[0] > 2 || moveCoordinatesInt[1] > 2 ||
        // moveCoordinatesInt[0] < 0
        // || moveCoordinatesInt[1] < 0) {
        // System.out.println("Veuillez rentrer des coordonnées entre 1 et 3 compris
        // !");
        // }
        // // Check if coordinates are empty
        // if
        // (board[Integer.parseInt(moveCoordinates[0])][Integer.parseInt(moveCoordinates[1])]
        // != null) {
        // System.out.println("La case est déjà occupée !");
        // continue;
        // }

        // // Play the move
        // board[moveCoordinatesInt[0]][moveCoordinatesInt[1]] = 1;

        // isPlayerTurn = !isPlayerTurn;
        // printBoardView(board);
        // } catch (Exception e) {
        // System.out.println("Veuillez rentrer des coordonnées sous forme d'entier (ex:
        // 1 0)");
        // continue;
        // }
        // } else {
        // System.out.println("Au tour de l'ordinateur :");
        // Integer[] computerCoordinates = getRandomNextMove(board);
        // board[computerCoordinates[0]][computerCoordinates[1]] = 2;
        // isPlayerTurn = !isPlayerTurn;
        // printBoardView(board);
        // }

        // }

        // scan.close();
        // Integer result = evaluate(board);

        // switch (result) {
        // case 10:
        // System.out.println("Le joueur à gagné !");
        // break;
        // case -10:
        // System.out.println("L'ordinateur à gagné !");
        // break;
        // case 0:
        // System.out.println("Egalitée !");
        // }

    }

    public void gameOver(String s) {
        Object[] option = { "Restart", "Exit" };
        int n = JOptionPane.showOptionDialog(frame, "Game Over\n" + s, "Game Over", JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE, null, option, option[0]);
        if (n == 0) {
            frame.dispose();
            new Morpion();
        } else {
            frame.dispose();
        }

    }

    public void xWins() {

        for (int i = 0; i < 9; i++) {
            gridButtons[i].setEnabled(false);
        }
        textfield.setText("Player X wins");
        gameOver("Player X Wins");
    }

    // Method to print that Player O wins
    public void oWins() {

        for (int i = 0; i < 9; i++) {
            gridButtons[i].setEnabled(false);
        }
        textfield.setText("Player O Wins");
        gameOver("Player O Wins");
    }

    public void tie() {
        for (int i = 0; i < 9; i++) {
            gridButtons[i].setEnabled(false);
        }
        textfield.setText("Tie");
        gameOver("Tie");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < 9; i++) {
            if (e.getSource() == gridButtons[i]) {
                if (game.getIsPlayerTurn()) {
                    if (this.game.setBoardSlot(i / 3, i % 3, 1)) {
                        gridButtons[i].setForeground(new Color(0, 188, 255));
                        gridButtons[i].setText("X");
                        this.game.setIsPlayerTurn(!this.game.getIsPlayerTurn());
                        textfield.setText("O turn");

                    }
                } else {
                    if (this.game.setBoardSlot(i / 3, i % 3, 2)) {
                        gridButtons[i].setForeground(new Color(0, 188, 255));
                        gridButtons[i].setText("O");
                        this.game.setIsPlayerTurn(!this.game.getIsPlayerTurn());
                        textfield.setText("X turn");

                    }
                }

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
