import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Design extends Application {

    Label sensConversion = new Label("Choisir le sens de conversion");
    Label labelSalary = new Label("Salaire");
    Label firstColumn = new Label("Brut");
    Label secondColumn = new Label("Net");
    Label labelHour = new Label("SMIC Horaire");
    Label labelMonth = new Label("SMIC Mensuel");
    Label labelYear = new Label("SMIC Annuel");

    RadioButton brutToNet = new RadioButton("Brut vers Net");
    RadioButton netToBrut = new RadioButton("Net vers Brut");
    RadioButton btnHour = new RadioButton("Horaire");
    RadioButton btnMonth = new RadioButton("Mensuel");
    RadioButton btnYear = new RadioButton("Annuel");

    TextField txtFdHour = new TextField();
    TextField txtFdMonth = new TextField();
    TextField txtFdYear = new TextField();

    Button calc = new Button("Calcul");
    Button smic = new Button("Smic");
    Button reset = new Button("Reset");

    ToggleGroup groupSens = new ToggleGroup();
    ToggleGroup groupSalary = new ToggleGroup();

    String btnSelected = "";


    @Override
    public void start(Stage stage) throws Exception {

        GridPane gridLayout = new GridPane();
        gridLayout.setPadding(new Insets(10));
        gridLayout.setVgap(5);
        gridLayout.setHgap(10);

        gridLayout.add(sensConversion, 0, 0);

        brutToNet.setToggleGroup(groupSens);
        //brutToNet.setSelected(true);
        netToBrut.setToggleGroup(groupSens);

        gridLayout.add(brutToNet, 0, 1);
        gridLayout.add(netToBrut, 0, 2);


        btnHour.setToggleGroup(groupSalary);
        btnHour.setSelected(true);
        btnMonth.setToggleGroup(groupSalary);
        btnYear.setToggleGroup(groupSalary);

        txtFdHour.setDisable(false);
        txtFdMonth.setDisable(true);
        txtFdYear.setDisable(true);

        gridLayout.add(labelSalary, 1, 0);
        gridLayout.add(btnHour, 1, 1);
        gridLayout.add(btnMonth, 1, 2);
        gridLayout.add(btnYear, 1, 3);

        gridLayout.add(firstColumn, 2, 0);
        gridLayout.add(txtFdHour, 2, 1);
        gridLayout.add(txtFdMonth, 2, 2);
        gridLayout.add(txtFdYear, 2, 3);

        gridLayout.add(secondColumn, 3, 0);
        gridLayout.add(labelHour, 3, 1);
        gridLayout.add(labelMonth, 3, 2);
        gridLayout.add(labelYear, 3, 3);

        gridLayout.add(calc, 4, 1);
        gridLayout.add(smic, 4, 2);
        gridLayout.add(reset, 4, 3);

        Calc calc = new Calc();

        Scene scene = new Scene(gridLayout, 600, 150);


        stage.setTitle("Convertisseur Brut-Net (2020)");
        scene.setRoot(gridLayout);
        stage.setScene(scene);
        stage.show();


        brutToNet.setOnAction(actionEvent -> {
            firstColumn.setText("Brut");
            secondColumn.setText("Net");
            RadioButton brutSelected = (RadioButton) groupSens.getSelectedToggle();
            btnSelected = brutSelected.getText();
            System.err.println(btnSelected);
        });

        netToBrut.setOnAction(actionEvent -> {
            firstColumn.setText("Net");
            secondColumn.setText("Brut");
            RadioButton netSelected = (RadioButton) groupSens.getSelectedToggle();
            btnSelected = netSelected.getText();
            System.err.println(btnSelected);
        });

        btnHour.setOnAction(actionEvent -> {
            txtFdHour.setDisable(false);
            txtFdMonth.setDisable(true);
            txtFdYear.setDisable(true);
        });

        btnMonth.setOnAction(actionEvent -> {
            txtFdHour.setDisable(true);
            txtFdMonth.setDisable(false);
            txtFdYear.setDisable(true);
        });

        btnYear.setOnAction(actionEvent -> {
            txtFdHour.setDisable(true);
            txtFdMonth.setDisable(true);
            txtFdYear.setDisable(false);
        });



        smic.setOnAction(actionEvent -> {
                    if (btnSelected.equals("Net vers Brut")) {
                        labelHour.setText(String.valueOf(calc.smicHorNet));
                        labelMonth.setText(String.valueOf(calc.smicMensNet));
                        labelYear.setText(String.valueOf(calc.smicAnnNet));

                        txtFdHour.setText(String.valueOf(calc.smicHorBrut));
                        txtFdMonth.setText(String.valueOf(calc.smicMensBrut));
                        txtFdYear.setText(String.valueOf(calc.smicAnnBrut));

                    } else if (btnSelected.equals("Brut vers Net")) {
                        labelHour.setText(String.valueOf(calc.smicHorBrut));
                        labelMonth.setText(String.valueOf(calc.smicMensBrut));
                        labelYear.setText(String.valueOf(calc.smicAnnBrut));

                        txtFdHour.setText(String.valueOf(calc.smicHorNet));
                        txtFdMonth.setText(String.valueOf(calc.smicMensNet));
                        txtFdYear.setText(String.valueOf(calc.smicAnnNet));
                    }
                }
        );

    }



    public static void main (String[]args){

        launch(args);
    }
}


