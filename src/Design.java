import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Design extends Application {

    @Override
    public void start(Stage stage) throws Exception {

        GridPane gridLayout = new GridPane();
        gridLayout.setPadding(new Insets(10));
        gridLayout.setVgap(5);
        gridLayout.setHgap(10);

        Label sensDeConversion = new Label("Choisir le sens de conversion");
        gridLayout.add(sensDeConversion, 0, 0);

        ToggleGroup groupSens = new ToggleGroup();

        RadioButton brutVersNet = new RadioButton("Brut vers Net");
        brutVersNet.setToggleGroup(groupSens);
        brutVersNet.setSelected(true);
        RadioButton netVersBrut = new RadioButton("Net vers Brut");
        netVersBrut.setToggleGroup(groupSens);

        gridLayout.add(brutVersNet, 0, 1);
        gridLayout.add(netVersBrut, 0, 2);

        ToggleGroup groupTemp = new ToggleGroup();

        Label labelSalaire = new Label("Salaire");
        RadioButton btnHoraire = new RadioButton("Horaire");
        btnHoraire.setToggleGroup(groupTemp);
        btnHoraire.setSelected(true);
        RadioButton btnMensuel = new RadioButton("Mensuel");
        btnMensuel.setToggleGroup(groupTemp);
        RadioButton btnAnnuel = new RadioButton("Annuel");
        btnAnnuel.setToggleGroup(groupTemp);

        gridLayout.add(labelSalaire,1, 0);
        gridLayout.add(btnHoraire,1, 1);
        gridLayout.add(btnMensuel,1, 2);
        gridLayout.add(btnAnnuel,1, 3);

        Label premiereColonne = new Label("Label colonne 1");
        String steack = "test";
        TextField txtFdHoraire = new TextField(steack);
        TextField txtFdMensuel = new TextField();
        TextField txtFdAnnuel = new TextField();

        gridLayout.add(premiereColonne,2, 0);
        gridLayout.add(txtFdHoraire,2, 1);
        gridLayout.add(txtFdMensuel,2, 2);
        gridLayout.add(txtFdAnnuel,2, 3);

        Label secondeColonne = new Label("Label colonne 2");
        Label labelHoraire = new Label("1111111111");
        Label labelMensuel = new Label("2222222222");
        Label labelAnnuel = new Label("3333333333");

        gridLayout.add(secondeColonne,3, 0);
        gridLayout.add(labelHoraire,3, 1);
        gridLayout.add(labelMensuel,3, 2);
        gridLayout.add(labelAnnuel,3, 3);

        Scene scene = new Scene(gridLayout, 600,150);

        stage.setTitle("Convertisseur Brut-Net (2020)");
        scene.setRoot(gridLayout);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {

        launch(args);
    }
}
