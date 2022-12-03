package domain.user;

import domain.card.Card;
import domain.card.Cards;

import java.util.ArrayList;
import java.util.List;

import static domain.user.GameResultDto.GameResult;

/**
 * 게임 딜러를 의미하는 객체
 */
public class Dealer {

    private static final String DEALER_NAME = "딜러";
    private final Cards cards;

    public Dealer(List<Card> cards) {
        this.cards = new Cards(cards);
    }

    public void addCard(Card card) {
        cards.add(card);
    }

    public GameResultDto play(List<Player> players) {
        List<GameResult> gameResults = new ArrayList<>();

        for (Player player : players) {
            GameStatus gameStatus = player.play(cards);
            gameResults.add(player.toGameResult(gameStatus));
        }
        return createGameResultDto(gameResults);
    }

    private double calculateDealerMoney(List<GameResult> gameResults) {
        return gameResults.stream()
                .mapToDouble(GameResult::getPrice)
                .sum() * (-1);
    }

    private GameResultDto createGameResultDto(List<GameResult> gameResults) {
        gameResults.add(new GameResult(DEALER_NAME, calculateDealerMoney(gameResults)));
        return new GameResultDto(gameResults);
    }
}
