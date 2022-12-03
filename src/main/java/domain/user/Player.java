package domain.user;

import domain.card.Card;
import domain.card.Cards;

import java.util.List;

import static domain.user.GameResultDto.GameResult;

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
        if (cards.isBlackJack()) {
            return GameStatus.BLACKJACK;
        }
        if (isPlayerWin(dealerCards)) {
            return GameStatus.WIN;
        }
        if (isPlayerLose(dealerCards)) {
            return GameStatus.LOSE;
        }
        return GameStatus.DRAW;
    }

    private boolean isPlayerWin(Cards dealerCards) {
        return (cards.isBiggerThan(dealerCards) && !cards.isOverBlackJack())
                || dealerCards.isOverBlackJack();
    }

    private boolean isPlayerLose(Cards dealerCards) {
        return (dealerCards.isBiggerThan(cards) && !dealerCards.isOverBlackJack())
                || cards.isOverBlackJack();
    }

    public GameResult toGameResult(GameStatus gameStatus) {
        return new GameResult(name, gameStatus.calculatePrice(bettingMoney));
    }
}
