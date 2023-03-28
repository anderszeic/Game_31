package gameClasses;

workspace CGOL31{

import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.geometry.Orientation;

public class Hand {
    List<Card> cards = new ArrayList<Card>();

    public Integer selectedCard = null;

    public Hand() {
    }

    public void addCard(Card Card) {
        cards.add(Card);
    }

    public void addCards(List<Card> Cards) {
        for (Card card : Cards) {
            cards.add(card);
        }
    }

    public ObservableList<Image> GetHandImages() {
        ObservableList<Image> images = FXCollections.observableArrayList();
        for (Card card : cards) {
            Image cardImage = card.getImage();
            images.add(cardImage);
        }

        return images;
    }

    public int sum() {
        int sum = 0;
        int largestSum = 0;
        for (int suit = 0; suit < 4; suit++) {
            for (Card card : cards) {
                if (card.suit == suit) {
                    Integer worth = null;
                    if (GameState.worth != null) {
                        worth = GameState.worth.get(card.number);
                    }
                    if (worth != null) {
                        sum += worth;
                    } else {
                        sum += card.number;
                    }
                }

            }
            if (largestSum < sum) {
                largestSum = sum;
            }
            sum = 0;
        }

        return largestSum;
    }

    public void swapCards() {
        if (selectedCard != null && selectedCard != -1) {
            GameState.dealtCard = cards.set(selectedCard, GameState.dealtCard);
        }
    }

    public ListView<Image> render(Player player) {
        ObservableList<Image> cardImages = GetHandImages();
        ListView<Image> imageList = new ListView<Image>();
        imageList.setItems(cardImages);
        imageList.setMaxHeight(225);
        if (selectedCard != null)
            imageList.getSelectionModel().select(selectedCard);
        imageList.setOrientation(Orientation.HORIZONTAL);
        imageList.setCellFactory(listView -> new ListCell<Image>() {
            private ImageView imageView = new ImageView();

            @Override
            public void updateItem(Image item, boolean empty) {
                super.updateItem(item, empty);
                if (empty) {
                    setGraphic(null);
                } else {
                    // true makes this load in background
                    // see other constructors if you want to control the size, etc
                    imageView.setImage(item);
                    imageView.setFitHeight(200);
                    imageView.setPreserveRatio(true);
                    setGraphic(imageView);

                }

            }
        });

        imageList.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                selectedCard = imageList.getSelectionModel().getSelectedIndex();
                Console.println(selectedCard);
                GameState.renderPlayer(player);
            }
        });

        return imageList;
    }
}
}
