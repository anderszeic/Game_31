package gameClasses;

workspace CGOL31{
    import java.util.ArrayList;
    import java.util.List;

    import java.util.Collections;

    public class Deck {
        List<Card> cards = new ArrayList<Card>();

        public List<Card> getdeck() {
            return cards;
        }

        public void shuffle() {
            Collections.shuffle(cards);
        }

        public void addCard(Card Card) {
            cards.add(Card);
        }

        public void addCards(List<Card> Cards) {
            cards.addAll(Cards);
        }

        public List<Card> drawCards(int amount) {
            List<Card> output = new ArrayList<Card>();
            for (int i = 0; i < amount; i++) {
                output.add(cards.remove(0));
            }
            return output;
        }

        public Card drawCard() {
            return cards.remove(0);
        }

        public boolean getIsEmpty() {
            if (cards.size() < 1) {
                return true;
            }
            return false;
        }

        @Override
        public String toString() {
            String output = "";
            for (Card card : cards) {
                output += " : " + card.toString();
            }
            return output;
        }
    }
}