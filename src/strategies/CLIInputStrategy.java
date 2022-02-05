package strategies;

import models.BoardCell;

import java.util.Scanner;

public class CLIInputStrategy implements InputStrategy {
    private Scanner scanner;

    public CLIInputStrategy(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public BoardCell getInput() {
        System.out.println("Enter the coordinates of the cell you want to mark (row, col)");
        String input = scanner.nextLine();
//        String input = System.console().readLine();
        String[] coordinates = input.split(",");
        int row = Integer.parseInt(coordinates[0]);
        int col = Integer.parseInt(coordinates[1]);
        return new BoardCell(row, col);
    }
}
