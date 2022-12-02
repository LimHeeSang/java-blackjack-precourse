package domain.user;

import domain.card.Card;
import domain.card.Symbol;
import domain.card.Type;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.util.Lists.newArrayList;

class DealerTest {

    private Dealer dealer;

    @BeforeEach
    void setUp() {
        dealer = new Dealer(
                newArrayList(new Card(Symbol.FIVE, Type.DIAMOND), new Card(Symbol.KING, Type.DIAMOND)));

    }

    @Test
    void 플레이어와_비교시_플레이어승리() {
        Player player = new Player("pobi", 10000,
                newArrayList(new Card(Symbol.EIGHT, Type.HEART), new Card(Symbol.KING, Type.HEART)));
        GameStatus gameStatus = dealer.play(player);
        assertThat(gameStatus.isWin()).isTrue();
    }

    @Test
    void 플레이어와_비교시_플레이어패배() {
        Player player = new Player("pobi", 10000,
                newArrayList(new Card(Symbol.TWO, Type.HEART), new Card(Symbol.KING, Type.HEART)));
        GameStatus gameStatus = dealer.play(player);
        assertThat(gameStatus.isLose()).isTrue();
    }

    @Test
    void 플레이어와_비교시_플레이어비기기() {
        Player player = new Player("pobi", 10000,
                newArrayList(new Card(Symbol.FIVE, Type.HEART), new Card(Symbol.QUEEN, Type.HEART)));
        GameStatus gameStatus = dealer.play(player);
        assertThat(gameStatus.isDraw()).isTrue();
    }
}