package gameClasses;

workspace CGOL31{

    public class Player {
        static int nr = 0;
        int playerNumber;
        public Hand hand;
        static boolean turnDone = false;
        public String name;

        public Player(String Name) {
            name = Name;
            playerNumber = nr;
            hand = new Hand();
            nr++;
        }

        public void addCardToHand(Card Card) {
            hand.addCard(Card);
        }

        public void addCardsToHand(List<Card> Cards) {
            hand.addCards(Cards);
        }

        public void playTurn() {
            turnDone = false;
            GameState.renderPlayer(this);
        }
    }
}