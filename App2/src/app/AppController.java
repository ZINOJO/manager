package app;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class AppController implements Initializable {
	String ruta = "C:\\Users\\a_ch9\\Desktop\\Usuario.json";
	Gson gson = new Gson();
	Model model;
	App app;
	private Stage stage;

	@FXML
	private AnchorPane view;// Panel Principal
	@FXML
	private JFXPasswordField ContraseñaTextField;// Campo para Contraseña
	@FXML
	private JFXTextField UsuarioTextField;// Campo para Usuario
	@FXML
	private JFXButton AccederButton;// Botton para accerder
	@FXML
	private Label RegistroText;// Texto Registro

	@FXML
	void onAccerderButtonAction(ActionEvent event) {
		
		String nombre = UsuarioTextField.getText();
		String pass = ContraseñaTextField.getText();
		if(Model.BuscarUsuario(nombre) && Model.BuscarContraseña(nombre, pass)){
    		RegistroText.setText("Acceso Permitido");
    		RegistroText.setTextFill(Color.color(0, 1, 0));
    		Main(stage);
    		Producto producto1 = new Producto("Pruab1", "Pruab1", "Pruab1", 0, 0, null); 
    		FileWriter prueba2 = null;
			try {
				prueba2 = new FileWriter(ruta);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
    		try {
				gson.toJson(producto1,prueba2 );
			} catch (JsonIOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    		
    	}else if(nombre.equals("") && pass.equals("") ){
    		
    		RegistroText.setText("No ha introducido datos");
    	}else {
    		RegistroText.setText("Datos incorrectos");
    		RegistroText.setTextFill(Color.color(1, 0, 0));
    	}
		
	}

	public AnchorPane getView() {
		return view;

	}

	// INITIALIZE
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		RegistroText.setTextAlignment(TextAlignment.LEFT);
		RegistroText.setText("");
	}

	// CONTROLLERS
	public AppController() throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/resource/App.fxml"));
		loader.setController(this);
		loader.load();

	}
	
	public void Main(Stage stage) {
		try {
			MainController controller = new MainController();
			Scene scene = new Scene(controller.getView());
			stage = new Stage();
			stage.setTitle("Insertar");
			stage.setResizable(false);
			stage.setScene(scene);
			stage.show();

		} catch (IOException e) {

		}
	}
	
	// Getter and Setter
	
	public  JFXTextField getUsuarioTextField() {
		return this.UsuarioTextField;
	}
	public void setUsuarioTextField(String Texto) {
		this.UsuarioTextField.setText(Texto);
	}
	public  JFXPasswordField getContraseñaTextField() {
		return this.ContraseñaTextField;
	}
	public void setContraseñaTextField(String Texto) {
		this.ContraseñaTextField.setText(Texto);
	}
	public  Label getRegistroText() {
		return this.RegistroText;
	}
	public void setRegistroText(String Texto) {
		this.RegistroText.setText(Texto);
	}

}
