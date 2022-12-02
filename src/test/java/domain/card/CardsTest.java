package domain.card;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CardsTest {

    private Cards cards;

    @BeforeEach
    void setUp() {
        Card clovarTwo = new Card(Symbol.TWO, Type.CLOVAR);
        Card clovarKing = new Card(Symbol.KING, Type.CLOVAR);
        cards = new Cards(List.of(clovarTwo, clovarKing));
    }

    @Test
    void 카드의_합을_계산() {

        assertThat(cards.calculateSum()).isEqualTo(12);
    }

    @Test
    void 카드합이_주어진_숫자와_같은지() {
        assertThat(cards.sameScore(12)).isTrue();
    }
}