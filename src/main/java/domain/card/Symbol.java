package domain.card;

public enum Symbol {

    ACE(1),
    TWO(2),
    THREE(3),
    FOUR(4),
    FIVE(5),
    SIX(6),
    SEVEN(7),
    EIGHT(8),
    NINE(9),
    TEN(10),
    JACK(10),
    QUEEN(10),
    KING(10);

    private static final int BIG_ACE_SCORE = 11;
    private static final int SMALL_ACE_SCORE = 1;
    private static final int CRITERION_ACE_SCORE = 10;

    private final int score;

    Symbol(int score) {
        this.score = score;
    }

    public int getScore(int currentSum) {
        if (isAce()) {
            return calculateAceScore(currentSum);
        }
        return score;
    }

    private boolean isAce() {
        return this == ACE;
    }

    private static int calculateAceScore(int currentSum) {
        if (currentSum <= CRITERION_ACE_SCORE) {
            return BIG_ACE_SCORE;
        }
        return SMALL_ACE_SCORE;
    }

    public int add(Symbol symbol) {
        return this.score + symbol.score;
    }
}
