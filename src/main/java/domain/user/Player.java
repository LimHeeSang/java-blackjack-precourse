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
        if (cards.calculateSum() > dealerCards.calculateSum()) {
            return GameStatus.WIN;
        }
        if (cards.calculateSum() < dealerCards.calculateSum()) {
            return GameStatus.LOSE;
        }
        return null;
    }
}
