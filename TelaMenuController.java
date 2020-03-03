/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Execute.Main;
import Model.Pessoa;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Aluno
 */
public class TelaMenuController implements Initializable {

        @FXML private Button btCadastrar;
        @FXML private Button btConsultar;
        @FXML private Button btSair2;
        private Pessoa selecionada;
        
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       btCadastrar.setOnMouseClicked((MouseEvent ex)-> {
         AbreCadastro();
        }); 
         btSair2.setOnMouseClicked((MouseEvent ex)-> {
         Main main = new Main();
        Stage s = (Stage) btSair2.getScene().getWindow();
        main.abreTela("TelaLogin.fxml", "Menu Login");
         s.close();
          });
        btConsultar.setOnMouseClicked((MouseEvent ex )->{
        AbreConsultar();
        });
    }    
    
    public void AbreCadastro(){
            try {
            Main main = new Main();
            main.abreTela("TelaCadastro.fxml", "Cadastrar");
            Stage stage = (Stage) btCadastrar.getScene().getWindow();
            stage.close();
            
        } catch (Exception ex) {
            System.out.println("Erro ao abrir tela"+ ex.getMessage());
        }
          
    }

  public void AbreConsultar(){
      try {
            Main main = new Main();
            Stage stage = (Stage) btConsultar.getScene().getWindow();
            main.abreTela("TelaConsultar.fxml", "Consultar");
            stage.close();
            
        } catch (Exception ex) {
            System.out.println("Erro ao abrir tela"+ ex.getMessage());
        }  
  }

    
}
