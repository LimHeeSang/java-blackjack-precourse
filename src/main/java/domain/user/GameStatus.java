package domain.user;

public enum GameStatus {

    WIN, DRAW, LOSE;

    public boolean isWin() {
        return this == WIN;
    }
}
