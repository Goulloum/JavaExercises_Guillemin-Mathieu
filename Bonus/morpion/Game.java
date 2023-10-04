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

    public Integer evaluate(Integer[][] board) {

        for (int i = 0; i < 3; i++) {
            // Check for winning lines

            if (board[i][0] == board[i][1] && board[i][1] == board[i][2]) {
                if (board[i][0] != null) {
                    if (board[i][0] == 1) {
                        return 10;
                    } else if (board[i][0] == 2) {
                        return -10;
                    }
                }

            }
            // Check for winning columns
            if (board[0][i] == board[1][i] && board[1][i] == board[2][i]) {
                if (board[0][i] != null) {
                    if (board[0][i] == 1) {
                        return 10;
                    } else if (board[0][i] == 2) {
                        return -10;
                    }
                }
            }
        }
        // Check for wiining diagonals
        if (board[0][0] == board[1][1] && board[1][1] == board[2][2]) {
            if (board[0][0] != null) {
                if (board[0][0] == 1) {
                    return 10;
                } else if (board[0][0] == 2) {
                    return -10;
                }
            }
        } else if (board[0][2] == board[1][1] && board[1][1] == board[2][0]) {
            if (board[0][2] != null) {
                if (board[0][2] == 1) {
                    return 10;
                } else if (board[0][2] == 2) {
                    return -10;
                }
            }
        }
        // Check if space remaning
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == null) {
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

    public Integer[][] getBoard() {
        return this.board;
    }

    // Minmax implementation
    public Integer minmax(Integer[][] board, Integer depth, Boolean isMax) {
        int score = this.evaluate(board);
        // If Maximizer has won the game
        // return his/her evaluated score
        if (score == 10)
            return score * (1 / depth);

        // If Minimizer has won the game
        // return his/her evaluated score
        if (score == -10)
            return score * (1 / depth);

        // If there are no more moves and
        // no winner then it is a tie
        if (score == 0)
            return score;

        // If this maximizer's move
        if (isMax) {
            int best = -1000;

            // Traverse all cells
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    // Check if cell is empty
                    if (board[i][j] == null) {
                        // Make the move
                        board[i][j] = 1;

                        // Call minimax recursively and choose
                        // the maximum value
                        best = Math.max(best, minmax(board,
                                depth + 1, !isMax));

                        // Undo the move
                        board[i][j] = null;
                    }
                }
            }
            return best;
        }

        // If this minimizer's move
        else {
            int best = 1000;

            // Traverse all cells
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    // Check if cell is empty
                    if (board[i][j] == null) {
                        // Make the move
                        board[i][j] = 2;

                        // Call minimax recursively and choose
                        // the minimum value
                        best = Math.min(best, minmax(board,
                                depth + 1, !isMax));

                        // Undo the move
                        board[i][j] = null;
                    }
                }
            }
            return best;
        }
    }

    public Integer[] playBestMove(Integer[][] board) {
        int bestVal = -1000;
        Integer[] bestMove = { -1, -1 };

        // Traverse all cells, evaluate minimax function
        // for all empty cells. And return the cell
        // with optimal value.
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                // Check if cell is empty
                if (board[i][j] == null) {
                    // Make the move
                    board[i][j] = 1;

                    // compute evaluation function for this
                    // move.
                    int moveVal = minmax(board, 1, true);

                    // Undo the move
                    board[i][j] = null;
                    // If the value of the current move is
                    // more than the best value, then update
                    // best/
                    if (moveVal > bestVal) {
                        bestMove[0] = i;
                        bestMove[1] = j;
                        bestVal = moveVal;
                    }
                }
            }
        }

        this.board[bestMove[0]][bestMove[1]] = 2;
        this.isPlayerTurn = !this.isPlayerTurn;
        return bestMove;
    }

}
