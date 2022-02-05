package models;

import lombok.Getter;
import lombok.Setter;
import strategies.WinningStrategy;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Game {
    private Board board;
    private List<Player> players = new ArrayList<Player>();
    private WinningStrategy winningStrategy;
    private Player winner = null;
    private Integer nextPlayerIndex = 0;

    public void startGame() {
        Player player;
        while (winner == null && !board.isFull()) {
            player = getNextPlayer();
            BoardCell cell;
            do {
                cell = player.move(this.board);
            } while(this.board.getBoardCells().get(cell.getRow()).get(cell.getColumn()).getGameSymbol() != null);
            this.board.getBoardCells().get(cell.getRow()).get(cell.getColumn()).setGameSymbol(player.getGameSymbol());
            checkForWinner();
        }

        System.out.println("\nFinal board:");
        board.printBoard();
        if (winner == null) {
            System.out.println("\nIt's a draw!");
        } else {
            System.out.println("\n" + winner.getGameSymbol() + " wins!");
        }
    }

    public Player getNextPlayer() {
        Player nextPlayer = players.get(getNextPlayerIndex());
        setNextPlayerIndex((getNextPlayerIndex() + 1) % players.size());
        return nextPlayer;
    }

    public Player getPreviousPlayer() {
        return players.get((getNextPlayerIndex() + players.size() - 1) % players.size());
    }

    public void checkForWinner() {
        if (winningStrategy.isWinner(board)) {
            winner = getPreviousPlayer();
        }
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private Game game;

        Builder() {
            this.game = new Game();
        }

        public Builder withDimensions(Integer rows, Integer columns) {
            this.game.board = new Board(rows, columns);
            return this;
        }

        public Builder withPlayer(Player player) {
            this.game.players.add(player);
            return this;
        }

        public Builder withWinningStrategy(WinningStrategy winningStrategy) {
            this.game.winningStrategy = winningStrategy;
            return this;
        }

        public boolean isValid() {
            return this.game.board != null &&
                    this.game.players.size() == 2 &&
                    this.game.winningStrategy != null;
        }

        public Game build() {
            if (isValid()) {
                return this.game;
            } else {
                throw new IllegalStateException("Game is not valid");
            }
        }
    }

}
