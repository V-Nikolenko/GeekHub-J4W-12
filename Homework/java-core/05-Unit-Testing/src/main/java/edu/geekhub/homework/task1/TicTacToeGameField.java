package edu.geekhub.homework.task1;

import static java.util.Objects.requireNonNull;
import static java.util.Objects.requireNonNullElse;

public class TicTacToeGameField {

    private static final int FIELD_INPUT_LENGTH = 9;
    private static final String GAME_FIELD_BORDER = "+-----+";

    private static final char X_CHAR = 'X';
    private static final char O_CHAR = 'O';
    private static final char EMPTY_CELL_CHAR = ' ';

    /**
     * Generate a field of <a href="https://en.wikipedia.org/wiki/Tic-tac-toe">Tic-tac-toe</a>
     * game from saved field state input. <br/><br/>
     * Example input:
     * <pre>XOX   OXO</pre>
     *
     * Expected output:
     * <pre>
     * +-----+
     * |X|O|X|
     * | | | |
     * |O|X|O|
     * +-----+
     * </pre>
     *
     * @param fieldInput saved state of game
     * @return graphical representation of field
     */
    String generateField(String fieldInput) {
        validateFieldState(fieldInput);

        var gameField = new StringBuilder(GAME_FIELD_BORDER);

        char[] playersTurns = fieldInput.toCharArray();
        for (int turnIndex = 0; turnIndex < playersTurns.length; turnIndex++) {
            if (turnIndex % 3 == 0) {
                gameField.append(System.lineSeparator());
                gameField.append('|');
            }

            gameField.append(playersTurns[turnIndex]);
            gameField.append("|");
        }

        gameField.append(System.lineSeparator());
        gameField.append(GAME_FIELD_BORDER);

        return gameField.toString();
    }

    private void validateFieldState(String fieldState) {
        checkFieldStateIsPresent(fieldState);
        checkFieldStateLength(fieldState);
        checkFieldStateContainsOnlyAllowedCharacters(fieldState);
    }

    private static void checkFieldStateIsPresent(String fieldState) {
        requireNonNull(fieldState);

        if (fieldState.isBlank()) {
            throw new IllegalArgumentException(
                "Cant process empty field state"
            );
        }
    }

    private static void checkFieldStateLength(String fieldState) {
        if (fieldState.length() != FIELD_INPUT_LENGTH) {
            throw new IllegalArgumentException(
                "Field length: " + fieldState.length() +
                " is not equal allowed length: " + FIELD_INPUT_LENGTH
            );
        }
    }

    private static void checkFieldStateContainsOnlyAllowedCharacters(
        String fieldState
    ) {
        char[] playersTurns = fieldState.toCharArray();
        for (char playerTurn : playersTurns) {
            if (playerTurn != X_CHAR && playerTurn != O_CHAR && playerTurn != ' ') {
                throw new IllegalArgumentException(
                    "Player turn: " + playerTurn +
                    " can be only '" + X_CHAR + "' or '" + O_CHAR + "' or '" + EMPTY_CELL_CHAR + "'"
                );
            }
        }
    }

    String saveFieldState(String gameField) {
        String gameFieldState = requireNonNullElse(gameField, "")
            .replace(GAME_FIELD_BORDER, "")
            .replace("|", "")
            .replace(System.lineSeparator(), "");

        validateFieldState(gameFieldState);

        return gameFieldState;
    }

}
