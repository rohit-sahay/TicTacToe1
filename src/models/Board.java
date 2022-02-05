package models;

import lombok.Getter;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Board {
    private Integer rows;
    private Integer columns;
    private List<List<BoardCell>> boardCells = new ArrayList<>();
    private int emptyCells;

    public Board(Integer rows, Integer columns) {
        this.rows = rows;
        this.columns = columns;
        for (int i = 0; i < rows; i++) {
            List<BoardCell> row = new ArrayList<>();
            for (int j = 0; j < columns; j++) {
                row.add(new BoardCell(i, j));
            }
            boardCells.add(row);
        }
        emptyCells = rows * columns;
    }

    public void setCell(@NotNull BoardCell cell) {
        boardCells.get(cell.getRow())
                .get(cell.getColumn())
                .setGameSymbol(cell.getGameSymbol());
        emptyCells--;
    }

    public void printBoard() {
        for (List<BoardCell> row : boardCells) {
            for (BoardCell cell : row) {
                if (cell.getGameSymbol() != null) {
                    System.out.print(cell.getGameSymbol() + " ");
                } else {
                    System.out.print("_ ");
                }
            }
            System.out.println();
        }
    }

    public BoardCell getFirstAvailableCell() {
        for (List<BoardCell> row : boardCells) {
            for (BoardCell cell : row) {
                if (cell.getGameSymbol() == null) {
                    return cell;
                }
            }
        }
        throw new RuntimeException("No available cells");
    }

    public BoardCell getRandomAvailableCell() {
        List<BoardCell> availableCells = new ArrayList<>();
        int count = 0;
        for (List<BoardCell> row : boardCells) {
            for (BoardCell cell : row) {
                if (cell.getGameSymbol() == null) {
                    availableCells.add(cell);
                    count++;
                }
            }
        }
        int selectedCell = (int) (Math.random() * count);
//        System.out.println("Selected cell: " + selectedCell);
        BoardCell cell = availableCells.get(selectedCell);
        // return a copy of the cell
        return new BoardCell(cell.getRow(), cell.getColumn());
    }

    public boolean isFull() {
        return this.getEmptyCells() == 0;
    }
}
