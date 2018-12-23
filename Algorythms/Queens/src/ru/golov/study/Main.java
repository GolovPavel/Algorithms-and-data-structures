package ru.golov.study;

public class Main {

    public static void main(String[] args) {
	    Board board = new Board();
        placeQueens(board);

        System.out.println(board);

    }

    public static Board placeQueens(Board board) {
        if (board.hasMaxQueens()) {
            return board;
        }

        for (Cell safeCell: board.getSafePositions()) {
            board.addQueen(safeCell);
            Board newBoard = placeQueens(board);

            if (newBoard != null) {
                return board;
            }

            board.removeQueen(safeCell);
        }

        return null;
    }
}
