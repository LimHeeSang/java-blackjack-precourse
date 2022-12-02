package domain.user;

import domain.card.Card;
import domain.card.Cards;
import domain.card.Symbol;
import domain.card.Type;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.util.Lists.newArrayList;

class PlayerTest {

    private Cards dealerCards;

    @BeforeEach
    void setUp() {
        dealerCards = new Cards(newArrayList(
                new Card(Symbol.FIVE, Type.DIAMOND),
                new Card(Symbol.KING, Type.DIAMOND)));
    }

    @Test
    void 플레이어와_비교시_플레이어승리() {
        Player player = new Player("pobi", 10000, newArrayList(
                new Card(Symbol.EIGHT, Type.HEART),
                new Card(Symbol.KING, Type.HEART)));
        GameStatus gameStatus = player.play(dealerCards);
        assertThat(gameStatus.isWin()).isTrue();
    }

    @Test
    void 플레이어와_비교시_플레이어패배() {
        Player player = new Player("pobi", 10000, newArrayList(
                new Card(Symbol.TWO, Type.HEART),
                new Card(Symbol.KING, Type.HEART)));
        GameStatus gameStatus = player.play(dealerCards);
        assertThat(gameStatus.isLose()).isTrue();
    }

    @Test
    void 플레이어와_비교시_플레이어비기기() {
        Player player = new Player("pobi", 10000, newArrayList(
                new Card(Symbol.FIVE, Type.HEART),
                new Card(Symbol.QUEEN, Type.HEART)));
        GameStatus gameStatus = player.play(dealerCards);
        assertThat(gameStatus.isDraw()).isTrue();
    }

    @Test
    void 플레이어만_블랙잭일때_승리() {
        Player player = new Player("pobi", 10000, newArrayList(
                new Card(Symbol.ACE, Type.HEART),
                new Card(Symbol.QUEEN, Type.HEART)));
        assertThat(player.play(dealerCards).isBlackJack()).isTrue();
    }

    @Test
    void 딜러만_블랙잭일때_패배() {
        Cards dealerCards = new Cards(newArrayList(
                new Card(Symbol.ACE, Type.HEART),
                new Card(Symbol.KING, Type.DIAMOND)));
        Player player = new Player("pobi", 10000, newArrayList(
                new Card(Symbol.FIVE, Type.HEART),
                new Card(Symbol.QUEEN, Type.HEART)));
        assertThat(player.play(dealerCards).isLose()).isTrue();
    }

    @Test
    void 플레이어의점수만_21을_초과할때_패배() {
        Player player = new Player("pobi", 10000, newArrayList(
                new Card(Symbol.KING, Type.HEART),
                new Card(Symbol.QUEEN, Type.HEART),
                new Card(Symbol.FIVE, Type.DIAMOND)));
        assertThat(player.play(dealerCards).isLose()).isTrue();
    }

    @Test
    void 딜러의점수만_21을_초과할때_승리() {
        Player player = new Player("pobi", 10000, newArrayList(
                new Card(Symbol.KING, Type.HEART),
                new Card(Symbol.FIVE, Type.DIAMOND)));
        Cards dealerCards = new Cards(newArrayList(
                new Card(Symbol.FIVE, Type.DIAMOND),
                new Card(Symbol.QUEEN, Type.DIAMOND),
                new Card(Symbol.KING, Type.DIAMOND)));
        assertThat(player.play(dealerCards).isWin()).isTrue();
    }

    @Test
    void 둘다_21을_초과할때_승리() {
        Player player = new Player("pobi", 10000, newArrayList(
                new Card(Symbol.EIGHT, Type.HEART),
                new Card(Symbol.QUEEN, Type.DIAMOND),
                new Card(Symbol.FIVE, Type.DIAMOND)));
        Cards dealerCards = new Cards(newArrayList(
                new Card(Symbol.FIVE, Type.DIAMOND),
                new Card(Symbol.QUEEN, Type.DIAMOND),
                new Card(Symbol.KING, Type.DIAMOND)));
        assertThat(player.play(dealerCards).isWin()).isTrue();
    }
}