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
        GameStatus gameStatus = checkBlackJack(dealerCards);

        if (isBiggerThan(dealerCards)) {
            gameStatus = GameStatus.WIN;
        }
        if (isSmallerThan(dealerCards) || cards.isBiggerScore(Cards.BLACKJACK_SCORE)) {
            gameStatus = GameStatus.LOSE;
        }
        if (isSameThan(dealerCards)) {
            gameStatus = GameStatus.DRAW;
        }
        return gameStatus;
    }

    private GameStatus checkBlackJack(Cards dealerCards) {
        if (cards.isBlackJack() && !dealerCards.isBlackJack()) {
            return GameStatus.WIN;
        }
        if (!cards.isBlackJack() && dealerCards.isBlackJack()) {
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

    private boolean isSameThan(Cards dealerCards) {
        return cards.calculateSum() == dealerCards.calculateSum();
    }
}
