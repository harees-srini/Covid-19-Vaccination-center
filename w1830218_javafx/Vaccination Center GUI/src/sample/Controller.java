package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    private TextField getfname;

    @FXML
    private TextField getsname;

    @FXML
    private TextField getage;

    @FXML
    private TextField getcity;

    @FXML
    private TextField getid;

    @FXML
    private CheckBox acceptbox;

    @FXML
    private Button receiptbtn;


    @FXML
    private TextField boothnum;

    @FXML
    private ChoiceBox<String> choosevaccine;

    private String[] vaccineTypes={"AstraZeneca","Sinopharm", "Pfizer" };

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        choosevaccine.getItems().addAll(vaccineTypes);
    }//getting items of choicebox
    //Choice box codes referenced from: https://www.youtube.com/watch?v=hwCbXOM4_Qc Author: Bro Code (YouTube channel)

    @FXML
    void displaynext() throws IOException {
        FXMLLoader loader=new FXMLLoader(getClass().getResource("receipt.fxml"));//calling second scene
        Parent root=loader.load();
        receiptcontrol rcptcontrol=loader.getController();

        //creating methods to call user inputs in second scene
        rcptcontrol.name1(getfname.getText());
        rcptcontrol.name2(getsname.getText());
        rcptcontrol.citymethod(getcity.getText());
        rcptcontrol.idmethod(getid.getText());
        rcptcontrol.agemethod(getage.getText());
        rcptcontrol.vaccinemethod(choosevaccine.getValue());
        rcptcontrol.displaybooth(boothnum.getText());

        Stage stage = (Stage) receiptbtn.getScene().getWindow();
        stage.close();//closing present scene
        Stage primaryStage=new Stage();
        primaryStage.setTitle("New Window");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }


}