/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.PessoaDAO;
import Execute.Main;
import Model.Pessoa;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Aluno
 */
public class TelaCadastroController implements Initializable {

        
    @FXML
    private TextField txNome2;

    @FXML
    private PasswordField txSenha2;

    @FXML
    private Button btCancelar2;

    @FXML
    private TextField txEmail2;

    @FXML
    private Button btCadastrar2;
    


    @Override
    public void initialize(URL url, ResourceBundle rb) {
         btCadastrar2.setOnMouseClicked((MouseEvent e)-> {
         Cadastrar();
        });
          btCancelar2.setOnMouseClicked((MouseEvent e)-> {
         Main main = new Main();
        Stage s = (Stage) btCancelar2.getScene().getWindow();
        main.abreTela("TelaMenu.fxml", "Menu Principal");
         s.close();
          });
       
          
         
    }    
    private void Cadastrar() {
        String nome =  txNome2.getText();
        String email = txEmail2.getText();
        String senha = txSenha2.getText();
        
        if(txNome2.getText().equals("")|| txEmail2.equals("") || txSenha2.equals("")){
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setHeaderText("Erro! Preencha todos os campos!");
        alert.show();
    
    }else {
    Pessoa p = new Pessoa(nome, email, senha);
    PessoaDAO dao = new PessoaDAO();
    dao.adicionaPessoa(p);
         
    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
    alert.setHeaderText("Pessoa cadastrada com sucesso!");
    alert.showAndWait();
    abreMenu();
               }
}
    public void abreMenu(){
    Main main = new Main();
    Stage s = (Stage) btCadastrar2.getScene().getWindow();
    main.abreTela("TelaMenu.fxml", "Menu Principal");
    s.close();
    }
    
}
