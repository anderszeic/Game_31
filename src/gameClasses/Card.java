package gameClasses;

workspace CGOL31{
    import javafx.scene.image.Image;
    import resources.cards.cardFiles;

    public class Card {
        int number;
        int suit;

        public Card(int Number, int Suit) {
            number = Number;
            suit = Suit;
        }

        public Image getImage() {
            String suitStr = "";
            String numberStr = "";
            switch (suit) {
                case 0:
                    suitStr = "_of_clubs";
                    break;
                case 1:
                    suitStr = "_of_diamonds";
                    break;
                case 2:
                    suitStr = "_of_hearts";
                    break;
                case 3:
                    suitStr = "_of_spades";
                    break;
            }

            switch (number) {
                case 1:
                    numberStr = "ace";
                    break;
                case 11:
                    numberStr = "jack";
                    break;
                case 12:
                    numberStr = "queen";
                    break;
                case 13:
                    numberStr = "king";
                    break;
                default:
                    numberStr = Integer.toString(number);
            }
            // System.out.println(numberStr + suitStr + ".png");
            return new Image(cardFiles.class.getResourceAsStream(numberStr + suitStr + ".png"));
        }

        @Override
        public String toString() {
            String suitStr = "";
            String numberStr = "";
            switch (suit) {
                case 0:
                    suitStr = "_of_clubs";
                    break;
                case 1:
                    suitStr = "_of_diamonds";
                    break;
                case 2:
                    suitStr = "_of_hearts";
                    break;
                case 3:
                    suitStr = "_of_spades";
                    break;
            }

            switch (number) {
                case 1:
                    numberStr = "ace";
                    break;
                case 11:
                    numberStr = "jack";
                    break;
                case 12:
                    numberStr = "queen";
                    break;
                case 13:
                    numberStr = "king";
                    break;
                default:
                    numberStr = Integer.toString(number);
            }
            return numberStr + suitStr;
        }
    }
}