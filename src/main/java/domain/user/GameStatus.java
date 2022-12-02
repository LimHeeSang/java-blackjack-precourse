package domain.user;

public enum GameStatus {

    WIN, DRAW, LOSE, BLACKJACK;

    public boolean isWin() {
        return this == WIN;
    }

    public boolean isDraw() {
        return this == DRAW;
    }

    public boolean isLose() {
        return this == LOSE;
    }

    public boolean isBlackJack() {
        return this == BLACKJACK;
    }
}
