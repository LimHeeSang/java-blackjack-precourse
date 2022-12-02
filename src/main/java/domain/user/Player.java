package domain.user;

import domain.card.Card;
import domain.card.Cards;

import java.util.List;

/**
 * 게임 참여자를 의미하는 객체
 */
public class Player {

    private final String name;
    private final double bettingMoney;
    private final Cards cards;

    public Player(String name, double bettingMoney, List<Card> cards) {
        this.name = name;
        this.bettingMoney = bettingMoney;
        this.cards = new Cards(cards);
    }

    public void addCard(Card card) {
        cards.add(card);
    }

    public GameStatus play(Cards dealerCards) {
        if (cards.isBlackJack() && !dealerCards.isBlackJack()) {
            return GameStatus.WIN;
        }
        if (!cards.isBlackJack() && dealerCards.isBlackJack()) {
            return GameStatus.LOSE;
        }

        if (isBiggerThan(dealerCards)) {
            return GameStatus.WIN;
        }
        if (isSmallerThan(dealerCards)) {
            return GameStatus.LOSE;
        }
        return GameStatus.DRAW;
    }

    private boolean isSmallerThan(Cards dealerCards) {
        return cards.calculateSum() < dealerCards.calculateSum();
    }

    private boolean isBiggerThan(Cards dealerCards) {
        return cards.calculateSum() > dealerCards.calculateSum();
    }
}
