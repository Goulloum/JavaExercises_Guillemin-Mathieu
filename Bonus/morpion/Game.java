package Bonus.morpion;

import java.util.Random;

public class Game {
    private Integer[][] board = { { null, null, null }, { null, null, null }, { null, null, null } };
    private Boolean isPlayerTurn = true;

    public Integer[] playRandomNextMove() {
        Random ran = new Random();
        Integer randomX = ran.nextInt(3);
        Integer randomY = ran.nextInt(3);
        while (this.board[randomX][randomY] != null) {
            randomX = ran.nextInt(3);
            randomY = ran.nextInt(3);
        }
        this.board[randomX][randomY] = (isPlayerTurn) ? 1 : 2;
        this.isPlayerTurn = !this.isPlayerTurn;
        return new Integer[] { randomX, randomY };

    }

    public Integer evaluate() {

        for (int i = 0; i < 3; i++) {
            // Check for winning lines

            if (this.board[i][0] == this.board[i][1] && this.board[i][1] == this.board[i][2]) {
                if (this.board[i][0] != null) {
                    if (this.board[i][0] == 1) {
                        return 10;
                    } else if (this.board[i][0] == 2) {
                        return -10;
                    }
                }

            }
            // Check for winning columns
            if (this.board[0][i] == this.board[1][i] && this.board[1][i] == this.board[2][i]) {
                if (this.board[0][i] != null) {
                    if (this.board[0][i] == 1) {
                        return 10;
                    } else if (this.board[0][i] == 2) {
                        return -10;
                    }
                }
            }
        }
        // Check for wiining diagonals
        if (this.board[0][0] == this.board[1][1] && this.board[1][1] == this.board[2][2]) {
            if (this.board[0][0] != null) {
                if (this.board[0][0] == 1) {
                    return 10;
                } else if (this.board[0][0] == 2) {
                    return -10;
                }
            }
        } else if (this.board[0][2] == this.board[1][1] && this.board[1][1] == this.board[2][0]) {
            if (this.board[0][2] != null) {
                if (this.board[0][2] == 1) {
                    return 10;
                } else if (this.board[0][2] == 2) {
                    return -10;
                }
            }
        }
        // Check if space remaning
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (this.board[i][j] == null) {
                    return -1;
                }
            }
        }
        // no winner no space left so tie
        return 0;
    }

    public boolean setBoardSlot(Integer x, Integer y, Integer val) {
        if (this.board[x][y] != null) {
            return false;
        }
        this.board[x][y] = val;
        return true;
    }

    public Boolean getIsPlayerTurn() {
        return this.isPlayerTurn;
    }

    public void setIsPlayerTurn(Boolean _isPlayerTurn) {
        this.isPlayerTurn = _isPlayerTurn;
    }

    public void restart() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                this.board[i][j] = null;
            }
        }
        this.isPlayerTurn = true;
    }

}
