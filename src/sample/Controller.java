package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import model.CarDatabase;
import model.Vehicle;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

/**
 * @author Mathias Gnadlinger
 * @version 11, 14.01.2021
 */
public class Controller implements Initializable
{
    @FXML
    private TextField txtFi_Input;
    @FXML
    private TextArea txtAr_Output;

    private Stage stage;
    private CarDatabase CarDB = new CarDatabase();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
    }
    void setStage(Stage stage)
    {
        this.stage = stage;
    }

    public static void show(Stage stage)
    {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(Controller.class.getResource("sample.fxml"));
            Parent root = fxmlLoader.load();

            Controller controller = fxmlLoader.getController();
            controller.setStage(stage);

            stage.setTitle("Car Database");
            stage.getIcons().add(new Image("/sample/database.jpg"));
            stage.setScene(new Scene(root));
            stage.show();

        }
        catch (Exception exception)
        {
            System.out.printf("Eror while showing the stage");
        }
    }

    public void search()
    {
        txtAr_Output.setText("");
        ArrayList<Vehicle> vehicles = CarDB.search(txtFi_Input.getText());
        for (Vehicle vehicle:vehicles)
        {
            txtAr_Output.appendText(vehicle.toString() + "\n\n");
        }
    }

    public void exact_search()
    {
        txtAr_Output.clear();
        try
        {
            txtAr_Output.setText(CarDB.exact_search(txtFi_Input.getText()).toString());
        }
        catch (Exception ex)
        {
            System.out.printf("The Licence Plate was not found!" + "\n");
        }
    }
}
