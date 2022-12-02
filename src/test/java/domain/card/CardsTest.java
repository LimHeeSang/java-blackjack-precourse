package domain.card;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CardsTest {

    @Test
    void 카드의_합을_계산() {
        Card card = new Card(Symbol.TWO, Type.CLOVAR);
        Card card1 = new Card(Symbol.KING, Type.CLOVAR);
        Cards cards = new Cards(List.of(card, card1));
        assertThat(cards.calculateSum()).isEqualTo(12);
    }
}