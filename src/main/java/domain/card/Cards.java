package domain.card;

import java.util.List;

public class Cards {

    private static final int BLACKJACK_SIZE = 2;
    private static final int BLACKJACK_SCORE = 21;

    private final List<Card> cards;

    public Cards(List<Card> cards) {
        this.cards = cards;
    }

    public int calculateSum() {
        int sum = 0;
        for (Card card : cards) {
            sum += card.getScore(sum);
        }
        return sum;
    }

    public boolean isBiggerThan(Cards cards) {
        return this.calculateSum() > cards.calculateSum();
    }

    public boolean isOverBlackJack() {
        return this.calculateSum() > BLACKJACK_SCORE;
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

    public void add(Card card) {
        cards.add(card);
    }

    public boolean isBlackJack() {
        return cards.size() == BLACKJACK_SIZE && calculateSum() == BLACKJACK_SCORE;
    }
}
