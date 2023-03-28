package gameClasses;

workspace CGOL31{

    public class DeckGenerator {
        public static List<Card> StandardDeck() {
            List<Card> cards = new ArrayList<Card>();

            for (int suit = 0; suit < 4; suit++) {
                for (int number = 1; number <= 13; number++) {
                    cards.add(new Card(number, suit));
                }
            }
            return cards;
        }
    }
}
// for (int suit = 0; suit < 4; suit++) {
// for (int number = 1; number <= 13; number++) {
// cards.add(new Card(number, suit));
// }
// }