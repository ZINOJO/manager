package app;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTabPane;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;

public class MainController implements Initializable{

	    @FXML
	    private JFXTabPane View;

	    @FXML
	    private TableView<?> ProductosView;

	    @FXML
	    private JFXButton AñadirButton;

	    @FXML
	    private JFXButton BorrarButton;

	    @FXML
	    private JFXButton ModificarButton;

	    @FXML
	    void onAñadirAction(ActionEvent event) {

	    }

	    @FXML
	    void onBorrarAction(ActionEvent event) {

	    }

	    @FXML
	    void onModificarButton(ActionEvent event) {

	    }
	    
		// INITIALIZE
		@Override
		public void initialize(URL location, ResourceBundle resources) {
			//CARGAR DATOS DE JSON CON LOS DETALLES DE TODOS LOS PROCUTOS Y PROVEEDORES
			
		}

		// CONTROLLERS
		public MainController() throws IOException {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/resource/Main.fxml"));
			loader.setController(this);
			loader.load();

		}
		
		// GET VIEW
		public JFXTabPane getView() {
			return View;

		}

}


