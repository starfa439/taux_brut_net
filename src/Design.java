import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.text.DecimalFormat;

public class Design extends Application {

    String btnSelected1 = "";
    String btnSelected2 = "";
    String resString = "0";

    Double resDoubleH, resDoubleM, resDoubleY;

    Label sensConversion = new Label("Sens de conversion");
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

    Button conversion = new Button("Conversion");
    Button smic = new Button("Smic");
    Button reset = new Button("Reset");

    ToggleGroup groupSens = new ToggleGroup();
    ToggleGroup groupSalary = new ToggleGroup();

    TextField txtFdHour = new TextField(resString);
    TextField txtFdMonth = new TextField(resString);
    TextField txtFdYear = new TextField(resString);

    @Override
    public void start(Stage stage) throws Exception {

        GridPane gridLayout = new GridPane();
        gridLayout.setPadding(new Insets(10));
        gridLayout.setVgap(5);
        gridLayout.setHgap(10);

        ColumnConstraints col1 = new ColumnConstraints();
        col1.setPrefWidth(110);
        ColumnConstraints col2 = new ColumnConstraints();
        col2.setPrefWidth(70);
        ColumnConstraints col3 = new ColumnConstraints();
        col3.setPrefWidth(70);
        ColumnConstraints col4 = new ColumnConstraints();
        col4.setPrefWidth(80);
        ColumnConstraints col5 = new ColumnConstraints();
        col5.setPrefWidth(80);
        gridLayout.getColumnConstraints().addAll(col1,col2,col3, col4, col5);

        gridLayout.add(sensConversion, 0, 0);

        conversion.setPrefWidth(80);
        smic.setPrefWidth(80);
        reset.setPrefWidth(80);



        brutToNet.setToggleGroup(groupSens);
        netToBrut.setToggleGroup(groupSens);

        gridLayout.add(brutToNet, 0, 1);
        gridLayout.add(netToBrut, 0, 2);

        btnHour.setToggleGroup(groupSalary);
        btnMonth.setToggleGroup(groupSalary);
        btnYear.setToggleGroup(groupSalary);

        txtFdHour.setDisable(true);
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

        gridLayout.add(conversion, 4, 1);
        gridLayout.add(smic, 4, 2);
        gridLayout.add(reset, 4, 3);

        Calc calc = new Calc();
        DecimalFormat df = new DecimalFormat("#.##");

        Scene scene = new Scene(gridLayout, 500, 150);

        stage.setTitle("Convertisseur Brut-Net (2020)");
        scene.setRoot(gridLayout);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();

        brutToNet.setOnAction(actionEvent -> {
            firstColumn.setText("Brut");
            secondColumn.setText("Net");
            RadioButton brutSelected = (RadioButton) groupSens.getSelectedToggle();
            btnSelected1 = brutSelected.getText();
            System.err.println(btnSelected1);
        });

        netToBrut.setOnAction(actionEvent -> {
            firstColumn.setText("Net");
            secondColumn.setText("Brut");
            RadioButton netSelected = (RadioButton) groupSens.getSelectedToggle();
            btnSelected1 = netSelected.getText();
            System.err.println(btnSelected1);
        });

        btnHour.setOnAction(actionEvent -> {
            txtFdHour.setDisable(false);
            txtFdMonth.setDisable(true);
            txtFdYear.setDisable(true);
            RadioButton hourSelected = (RadioButton) groupSalary.getSelectedToggle();
            btnSelected2 = hourSelected.getText();
            System.err.println(btnSelected2);
        });

        btnMonth.setOnAction(actionEvent -> {
            txtFdHour.setDisable(true);
            txtFdMonth.setDisable(false);
            txtFdYear.setDisable(true);
            RadioButton monthSelected = (RadioButton) groupSalary.getSelectedToggle();
            btnSelected2 = monthSelected.getText();
            System.err.println(btnSelected2);
        });

        btnYear.setOnAction(actionEvent -> {
            txtFdHour.setDisable(true);
            txtFdMonth.setDisable(true);
            txtFdYear.setDisable(false);
            RadioButton yearSelected = (RadioButton) groupSalary.getSelectedToggle();
            btnSelected2 = yearSelected.getText();
            System.err.println(btnSelected2);
        });

        smic.setOnAction(actionEvent -> {
                    if (btnSelected1.equals("Net vers Brut")) {
                        labelHour.setText(String.valueOf(calc.getSmicHorBrut()));
                        labelMonth.setText(String.valueOf(calc.getSmicMensBrut()));
                        labelYear.setText(String.valueOf(calc.getSmicAnnBrut()));

                        txtFdHour.setText(String.valueOf(calc.getSmicHorNet()));
                        txtFdMonth.setText(String.valueOf(calc.getSmicMensNet()));
                        txtFdYear.setText(String.valueOf(calc.getSmicAnnNet()));

                    } else if (btnSelected1.equals("Brut vers Net")) {
                        labelHour.setText(String.valueOf(calc.getSmicHorNet()));
                        labelMonth.setText(String.valueOf(calc.getSmicMensNet()));
                        labelYear.setText(String.valueOf(calc.getSmicAnnNet()));

                        txtFdHour.setText(String.valueOf(calc.getSmicHorBrut()));
                        txtFdMonth.setText(String.valueOf(calc.getSmicMensBrut()));
                        txtFdYear.setText(String.valueOf(calc.getSmicAnnBrut()));
                    }
                }
        );

        reset.setOnAction(actionEvent -> {
            labelHour.setText("");
            labelMonth.setText("");
            labelYear.setText("");

            txtFdHour.setText("");
            txtFdMonth.setText("");
            txtFdYear.setText("");
        });

        conversion.setOnAction(actionEvent -> {

            if (btnSelected1.equals("Brut vers Net") && btnSelected2.equals("Horaire")) {

                resDoubleH = Double.parseDouble(txtFdHour.getText());
                resDoubleM =  resDoubleH * 151.67;
                txtFdMonth.setText(String.valueOf(df.format(resDoubleM)));
                resDoubleY =  resDoubleH * 151.67 * 12;
                txtFdYear.setText(String.valueOf(df.format(resDoubleY)));

                labelHour.setText(String.valueOf(df.format(calc.HorBrutVersNet(resDoubleH))));
                labelMonth.setText(String.valueOf(df.format(calc.MensBrutVersNet(resDoubleM))));
                labelYear.setText(String.valueOf(df.format(calc.AnnBrutVersNet(resDoubleY))));
            }
            else if (btnSelected1.equals("Brut vers Net") && btnSelected2.equals("Mensuel")) {

                resDoubleM = Double.parseDouble(txtFdMonth.getText());
                resDoubleH =  resDoubleM / 151.67;
                txtFdHour.setText(String.valueOf(df.format(resDoubleH)));
                resDoubleY =  resDoubleH * 151.67 * 12;
                txtFdYear.setText(String.valueOf(df.format(resDoubleY)));

                labelHour.setText(String.valueOf(df.format(calc.HorBrutVersNet(resDoubleH))));
                labelMonth.setText(String.valueOf(df.format(calc.MensBrutVersNet(resDoubleM))));
                labelYear.setText(String.valueOf(df.format(calc.AnnBrutVersNet(resDoubleY))));
            }
            else if (btnSelected1.equals("Brut vers Net") && btnSelected2.equals("Annuel")) {

                resDoubleY = Double.parseDouble(txtFdYear.getText());
                resDoubleM =  resDoubleY / 12;
                txtFdMonth.setText(String.valueOf(df.format(resDoubleM)));
                resDoubleY =  resDoubleH * 151.67 * 12;
                txtFdHour.setText(String.valueOf(df.format(resDoubleH)));

                labelHour.setText(String.valueOf(df.format(calc.HorBrutVersNet(resDoubleH))));
                labelMonth.setText(String.valueOf(df.format(calc.MensBrutVersNet(resDoubleM))));
                labelYear.setText(String.valueOf(df.format(calc.AnnBrutVersNet(resDoubleY))));
            }
            else if (btnSelected1.equals("Net vers Brut") && btnSelected2.equals("Horaire")) {

                resDoubleH = Double.parseDouble(txtFdHour.getText());
                resDoubleM =  resDoubleH * 151.67;
                txtFdMonth.setText(String.valueOf(df.format(resDoubleM)));
                resDoubleY =  resDoubleH * 151.67 * 12;
                txtFdYear.setText(String.valueOf(df.format(resDoubleY)));

                labelHour.setText(String.valueOf(df.format(calc.HorNetVersBrut(resDoubleH))));
                labelMonth.setText(String.valueOf(df.format(calc.MensNetVersBrut(resDoubleM))));
                labelYear.setText(String.valueOf(df.format(calc.AnnNetVersBrut(resDoubleY))));
            }
            else if (btnSelected1.equals("Net vers Brut") && btnSelected2.equals("Mensuel")) {

                resDoubleM = Double.parseDouble(txtFdMonth.getText());
                resDoubleH =  resDoubleM / 151.67;
                txtFdHour.setText(String.valueOf(df.format(resDoubleH)));
                resDoubleY =  resDoubleH * 151.67 * 12;
                txtFdYear.setText(String.valueOf(df.format(resDoubleY)));

                labelHour.setText(String.valueOf(df.format(calc.HorNetVersBrut(resDoubleH))));
                labelMonth.setText(String.valueOf(df.format(calc.MensNetVersBrut(resDoubleM))));
                labelYear.setText(String.valueOf(df.format(calc.AnnNetVersBrut(resDoubleY))));
            }
            else if (btnSelected1.equals("Net vers Brut") && btnSelected2.equals("Annuel")) {

                resDoubleY = Double.parseDouble(txtFdYear.getText());
                resDoubleM =  resDoubleY / 12;
                txtFdMonth.setText(String.valueOf(df.format(resDoubleM)));
                resDoubleY =  resDoubleH * 151.67 * 12;
                txtFdHour.setText(String.valueOf(df.format(resDoubleH)));

                labelHour.setText(String.valueOf(df.format(calc.HorNetVersBrut(resDoubleH))));
                labelMonth.setText(String.valueOf(df.format(calc.MensNetVersBrut(resDoubleM))));
                labelYear.setText(String.valueOf(df.format(calc.AnnNetVersBrut(resDoubleY))));
            }
        });
    }
}


