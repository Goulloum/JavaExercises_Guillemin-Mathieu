package Bonus.morpion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import Bonus.morpion.Views.BoardView;
import Bonus.morpion.Views.MenuView;

public class Morpion {
    // Initialize empty game
    private Game game = new Game();
    private String gamemode = null;
    MenuView menuView = new MenuView();
    BoardView boardView = null;

    public Morpion() {

        this.menuView.setVisible(true);
        this.menuView.createButton("Joueur VS Joueur", new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                gamemode = "pvp";
                startGame();
            }

        });
        this.menuView.createButton("Joueur VS Ordi", new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                gamemode = "pve";
                startGame();

            }

        });

    }

    public void startGame() {
        this.boardView = new BoardView(this.gamemode, this.game) {
            @Override
            public void gameOver(String result) {
                Object[] option = { "Restart", "Exit" };
                int n = JOptionPane.showOptionDialog(this, "Game Over\n" + result, "Game Over",
                        JOptionPane.YES_NO_CANCEL_OPTION,
                        JOptionPane.QUESTION_MESSAGE, null, option, option[0]);
                if (n == 0) {
                    restart();

                } else {
                    System.exit(0);
                }

            }
        };

        this.menuView.setVisible(false);
        this.boardView.setVisible(true);
    }

    public void restart() {
        this.menuView.setVisible(true);
        this.boardView.setVisible(false);
        this.game.restart();
    }

}
