package edu.geekhub.homework.task1;

public class ApplicationStarter {

    public static void main(String[] args) {
        TicTacToeGameField ticTacToeGameField = new TicTacToeGameField();

        String field = ticTacToeGameField.generateField("XOX   OXO");
        System.out.println("Tic-tac-toe game field:");
        System.out.println(field);

        System.out.println();

        String fieldState = ticTacToeGameField.saveFieldState(field);
        System.out.println("Tic-tac-toe game field state:");
        System.out.println(fieldState);
    }
}
