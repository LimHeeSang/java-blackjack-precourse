package domain.user;

import domain.card.Card;
import domain.card.Symbol;
import domain.card.Type;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static domain.user.GameResultDto.GameResult;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.util.Lists.newArrayList;

class DealerTest {

    private Dealer dealer;

    @BeforeEach
    void setUp() {
        dealer = new Dealer(newArrayList(
                new Card(Symbol.THREE, Type.DIAMOND),
                new Card(Symbol.EIGHT, Type.DIAMOND),
                new Card(Symbol.NINE, Type.DIAMOND)));
    }

    @CsvSource(value = {"0,pobi,10000", "1,jason,-20000", "2,black,15000", "3,딜러,-5000"})
    @ParameterizedTest
    void 플레이어가_블랙잭일때_수익금액반환(int index, String name, double money) {
        GameResultDto result = dealer.play(createTestPlayers());
        List<GameResult> gameResults = result.getGameResults();

        assertThat(gameResults.get(index).getName()).isEqualTo(name);
        assertThat(gameResults.get(index).getPrice()).isEqualTo(money);
    }

    private List<Player> createTestPlayers() {
        Player pobi = new Player("pobi", 10000, newArrayList(
                new Card(Symbol.TWO, Type.CLOVAR),
                new Card(Symbol.EIGHT, Type.CLOVAR),
                new Card(Symbol.ACE, Type.CLOVAR)));
        Player jason = new Player("jason", 20000, newArrayList(
                new Card(Symbol.SEVEN, Type.HEART),
                new Card(Symbol.KING, Type.HEART)));
        Player black = new Player("black", 10000, newArrayList(
                new Card(Symbol.ACE, Type.CLOVAR),
                new Card(Symbol.KING, Type.DIAMOND)));
        return List.of(pobi, jason, black);
    }
}