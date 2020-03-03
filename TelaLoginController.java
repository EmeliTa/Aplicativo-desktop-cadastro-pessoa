package Controller;

import Execute.Main;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.scene.input.KeyEvent;



public class TelaLoginController implements Initializable {

    @FXML private TextField txNome;
    @FXML private PasswordField txSenha;
    @FXML private Button btLogar;
    @FXML private Button btSair;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    btLogar.setOnMouseClicked((MouseEvent e)-> {
        Logar();
    });
    btSair.setOnMouseClicked((MouseEvent e)-> {
        //System.out.println("Você escolheu a opção sair!");   
       });   
    txSenha.setOnKeyPressed((KeyEvent e)-> {
        if (e.getCode() == KeyCode.ENTER){
            Logar();
        }
  
        
    });
}
    public void AbreMenu(){
            try {
            Main main = new Main();
            main.abreTela("TelaMenu.fxml", "Menu Principal");
            Stage stage = (Stage) btLogar.getScene().getWindow();
            stage.close();
            
        } catch (Exception ex) {
            System.out.println("Erro ao abrir tela"+ ex.getMessage());
        }
    }
   
    public void Logar() {
        if(txNome.getText().equals("admin") && txSenha.getText().equals("123")){
        try {
           Alert alert = new Alert (Alert.AlertType.CONFIRMATION);
        alert.setTitle("Sucesso");
        alert.setHeaderText("Login correto!");
         alert.showAndWait();  
         AbreMenu();
        } catch (Exception ex) {
           // Logger.getLogger(TelaLoginController.class.getName()).logger
        }
    } else {
        Alert alert = new Alert (Alert.AlertType.ERROR);
        alert.setTitle("Erro");
        alert.setHeaderText("Login e/ou senha inválidos!");
        alert.show();
    }
        }
    
}
    




