package domain.user;

import java.util.function.Function;

public enum GameStatus {

    WIN(money -> money),
    DRAW(money -> 0D),
    LOSE(money -> money * (-1)),
    BLACKJACK(money -> money * 1.5);

    private final Function<Double, Double> expression;

    GameStatus(Function<Double, Double> expression) {
        this.expression = expression;
    }

    public double calculatePrice(double bettingMoney) {
        return expression.apply(bettingMoney);
    }

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
