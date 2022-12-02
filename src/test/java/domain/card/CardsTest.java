package domain.card;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.util.Lists.newArrayList;

class CardsTest {

    private Cards cards;

    @BeforeEach
    void setUp() {
        Card clovarTwo = new Card(Symbol.TWO, Type.CLOVAR);
        Card clovarKing = new Card(Symbol.EIGHT, Type.CLOVAR);
        cards = new Cards(newArrayList(clovarTwo, clovarKing));
    }

    @Test
    void 카드의_합을_계산() {
        assertThat(cards.calculateSum()).isEqualTo(10);
    }

    @Test
    void 카드합이_주어진_숫자와_같은지() {
        assertThat(cards.isSameScore(10)).isTrue();
    }

    @Test
    void 카드합이_주어진_숫자보다_큰지() {
        assertThat(cards.isBiggerScore(9)).isTrue();
    }

    @Test
    void 카드합이_주어진_숫자보다_작은지() {
        assertThat(cards.isSmallerScore(11)).isTrue();
    }

    @Test
    void 카드한장_추가() {
        cards.add(new Card(Symbol.FIVE, Type.DIAMOND));
        assertThat(cards.calculateSum()).isEqualTo(15);
    }

    @Test
    void 블랙잭인지_확인() {
        Cards cards = new Cards(List.of(new Card(Symbol.ACE, Type.DIAMOND), new Card(Symbol.KING, Type.DIAMOND)));
        assertThat(cards.isBlackJack()).isTrue();
    }

    @Test
    void 스코어가10일떄_Ace추가시_11로추가() {
        cards.add(new Card(Symbol.ACE, Type.DIAMOND));
        assertThat(cards.isSameScore(21)).isTrue();
    }
}