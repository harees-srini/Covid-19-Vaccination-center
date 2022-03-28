package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class receiptcontrol {


    public Object rb;
    @FXML
    private Label datentime;

    @FXML
    private Label displayfname;

    @FXML
    private Label displaysname;

    @FXML
    private Label displayage;

    @FXML
    private Label displayvaccine;

    @FXML
    private Label displaycity;

    @FXML
    private Label displayidnum;

    @FXML
    private Label displaydatetime;


//using methods from first scene to set the user inputs into labels
    public void name1(String text) {
        displayfname.setText(text);
    }

    public void name2(String text) {
        displaysname.setText(text);
    }

    public void citymethod(String text) {displaycity.setText(text);
    }

    public void idmethod(String text) {displayidnum.setText(text);
    }

    public void agemethod(String text) {
        displayage.setText(text);
    }

    @FXML
    private Label displayboothnum;


    //Code below referenced from: https://stackoverflow.com/a/15474891 Author: Unknown
    public void initialize(){//setting datetime time
        String timeStamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime());
        displaydatetime.setText(timeStamp);

    }

    public void vaccinemethod(String text) {
        displayvaccine.setText(text);
    }

    public void displaybooth(String text) {
        displayboothnum.setText(text);
    }
}
