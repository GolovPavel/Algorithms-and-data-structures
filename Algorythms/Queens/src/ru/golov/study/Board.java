package ru.golov.study;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private int[][] cells;

    public Board() {
        cells = new int[8][8];
    }

    public Board(int[][] cells) {
        this.cells = cells;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (int[] row: cells) {
            for (int cell: row) {
                sb.append(cell)
                        .append(" ");
            }
            sb.append("\n");
        }

        return sb.toString();
    }

    public boolean hasMaxQueens() {
        int count = 0;

        for (int[] row: cells) {
            for (int cell: row) {
                if (cell == -1) {
                    count += 1;
                }
            }
        }

        return count == 8;
    }

    public List<Cell> getSafePositions() {
        List<Cell> result = new ArrayList<>();

        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[i].length; j++) {
                if (cells[i][j] == 0) {
                    result.add(new Cell(j, i));
                }
            }
        }

        return result;
    }

    public void addQueen(Cell queenCell) {
        this.cells[queenCell.getY()][queenCell.getX()] = -1;
        markDangerousCells(queenCell);
    }

    public void removeQueen(Cell queenCell) {
        this.cells[queenCell.getY()][queenCell.getX()] = 0;
        unmarkDangerousCells(queenCell);
    }

    private void markDangerousCells(Cell queenCell) {
        int positionSum = queenCell.getX() + queenCell.getY();
        int positionDiff = queenCell.getX() - queenCell.getY();

        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[i].length; j++) {
                if (queenCell.getX() == j && queenCell.getY() == i) {
                    continue;
                }

                if (j == queenCell.getX() || i == queenCell.getY()) {
                    this.cells[i][j] += 1;
                }
                if ((i + j) == positionSum || (j - i) == positionDiff) {
                    this.cells[i][j] += 1;
                }
            }
        }
    }

    private void unmarkDangerousCells(Cell queenCell) {
        int positionSum = queenCell.getX() + queenCell.getY();
        int positionDiff = queenCell.getX() - queenCell.getY();

        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[i].length; j++) {
                if (queenCell.getX() == j && queenCell.getY() == i) {
                    continue;
                }
                if (j == queenCell.getX() || i == queenCell.getY()) {
                    this.cells[i][j] -= 1;
                }
                if ((i + j) == positionSum || (j - i) == positionDiff) {
                    this.cells[i][j] -= 1;
                }
            }
        }
    }
}
