package strategies;

import models.Board;

public class DefaultWinningStrategy implements WinningStrategy {
    @Override
    public boolean isWinner(Board board) {
        // we'll check from middle cell only
        for (int i = 0; i < board.getRows(); i++) {
            for (int j = 0; j < board.getColumns(); j++) {
                if (board.getBoardCells().get(i).get(j).getGameSymbol() == null)continue;
                // check if there is a winning combination in the row
                if (j-1 >= 0 && j+1 < board.getColumns()) {
                    if (board.getBoardCells().get(i).get(j).getGameSymbol() == board.getBoardCells().get(i).get(j-1).getGameSymbol() &&
                            board.getBoardCells().get(i).get(j).getGameSymbol() == board.getBoardCells().get(i).get(j+1).getGameSymbol()) {
                        return true;
                    }
                }

                // check if there is a winning combination in the column
                if (i-1 >= 0 && i+1 < board.getRows()) {
                    if (board.getBoardCells().get(i).get(j).getGameSymbol() == board.getBoardCells().get(i-1).get(j).getGameSymbol() &&
                            board.getBoardCells().get(i).get(j).getGameSymbol() == board.getBoardCells().get(i+1).get(j).getGameSymbol()) {
                        return true;
                    }
                }

                // check if there is a winning combination in the primary diagonal
                if (i-1 >= 0 && i+1 < board.getRows() && j-1 >= 0 && j+1 < board.getColumns()) {
                    if (board.getBoardCells().get(i).get(j).getGameSymbol() == board.getBoardCells().get(i-1).get(j-1).getGameSymbol() &&
                            board.getBoardCells().get(i).get(j).getGameSymbol() == board.getBoardCells().get(i+1).get(j+1).getGameSymbol()) {
                        return true;
                    }
                }

                // check if there is a winning combination in the secondary diagonal
                if (i-1 >= 0 && i+1 < board.getRows() && j-1 >= 0 && j+1 < board.getColumns()) {
                    if (board.getBoardCells().get(i).get(j).getGameSymbol() == board.getBoardCells().get(i-1).get(j+1).getGameSymbol() &&
                            board.getBoardCells().get(i).get(j).getGameSymbol() == board.getBoardCells().get(i+1).get(j-1).getGameSymbol()) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
