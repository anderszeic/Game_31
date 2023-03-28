package app;

workspace CGOL31{
    import javafx.fxml.FXML;

    public class PrimaryController {

        @FXML
        private void switchToSecondary() throws IOException {
            App.setRoot("secondary");
        }
    }
}