package Feuille4;

import java.util.Random;
import java.util.Scanner;

public class exercice1 {
    public static void main(String[] args) {
        // Initialize empty board
        Integer[][] board = { { null, null, null }, { null, null, null }, { null, null, null } };

        // Initialize scanner
        Scanner scan = new Scanner(System.in);

        // Initialize currentPlayer true=Player turn false=Computer turn
        Boolean isPlayerTurn = true;

        // Print rules
        System.out.println(
                "Pour jouer il suffit de rentrer les coordonnées de la case désirée exemple je veux joueur dans la première ligne 2 ème case :");
        System.out.println("1 2");

        while (evaluate(board) == -1) {
            if (isPlayerTurn) {
                System.out.println("Au tour du joueur :");
                String playerMove = scan.nextLine();
                String[] moveCoordinates = playerMove.split(" ");

                try {
                    Integer[] moveCoordinatesInt = { Integer.parseInt(moveCoordinates[0]) - 1,
                            Integer.parseInt(moveCoordinates[1]) - 1 };
                    // Check if coordinates are in range 0 to 2
                    if (moveCoordinatesInt[0] > 2 || moveCoordinatesInt[1] > 2 || moveCoordinatesInt[0] < 0
                            || moveCoordinatesInt[1] < 0) {
                        System.out.println("Veuillez rentrer des coordonnées entre 1 et 3 compris !");
                    }
                    // Check if coordinates are empty
                    if (board[moveCoordinatesInt[0]][moveCoordinatesInt[1]] != null) {
                        System.out.println("La case est déjà occupée !");
                        continue;
                    }

                    // Play the move
                    board[moveCoordinatesInt[0]][moveCoordinatesInt[1]] = 1;

                    isPlayerTurn = !isPlayerTurn;
                    printBoardView(board);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                    System.out.println("Veuillez rentrer des coordonnées sous forme d'entier (ex: 1 0)");
                    continue;
                }
            } else {
                System.out.println("Au tour de l'ordinateur :");
                Integer[] computerCoordinates = getRandomNextMove(board);
                board[computerCoordinates[0]][computerCoordinates[1]] = 2;
                isPlayerTurn = !isPlayerTurn;
                printBoardView(board);
            }

        }

        scan.close();
        Integer result = evaluate(board);

        switch (result) {
            case 10:
                System.out.println("Le joueur à gagné !");
                break;
            case -10:
                System.out.println("L'ordinateur à gagné !");
                break;
            case 0:
                System.out.println("Egalitée !");
        }

    }

    private static Integer[] getRandomNextMove(Integer[][] board) {
        Random ran = new Random();
        Integer randomX = ran.nextInt(3);
        Integer randomY = ran.nextInt(3);
        while (board[randomX][randomY] != null) {
            randomX = ran.nextInt(3);
            randomY = ran.nextInt(3);
        }
        Integer[] computerCoodinates = { randomX, randomY };
        return computerCoodinates;

    }

    private static void printBoardView(Integer[][] board) {
        System.out.println("-------------");

        for (int i = 0; i < 3; i++) {
            String line = "| ";
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == null) {
                    line += "  | ";
                    continue;
                }
                line += (board[i][j] == 1) ? "X | " : "O | ";
            }
            System.out.println(line);
            System.out.println("-------------");

        }

    }

    private static Integer evaluate(Integer[][] board) {

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
}
