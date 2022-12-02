package domain.card;

import java.util.List;

public class Cards {

    private final List<Card> cards;

    public Cards(List<Card> cards) {
        this.cards = cards;
    }

    public int calculateSum() {
        return cards.stream()
                .mapToInt(Card::getScore)
                .sum();
    }

    public boolean isSameScore(int score) {
        return calculateSum() == score;
    }

    public boolean isBiggerScore(int score) {
        return calculateSum() > score;
    }

    public boolean isSmallerScore(int score) {
        return calculateSum() < score;
    }
}
