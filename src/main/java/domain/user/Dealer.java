package domain.user;

import domain.card.Card;
import domain.card.Cards;

import java.util.List;

/**
 * 게임 딜러를 의미하는 객체
 */
public class Dealer {

    private final Cards cards;

    public Dealer(List<Card> cards) {
        this.cards = new Cards(cards);
    }

    public void addCard(Card card) {
        cards.add(card);
    }

    public GameStatus play(Player player) {
        return player.play(cards);
    }
}
