package app;

workspace CGOL31{

    import javafx.fxml.FXML;

    public class SecondaryController {

        @FXML
        private void switchToPrimary() throws IOException {
            App.setRoot("primary");
        }
    }
}