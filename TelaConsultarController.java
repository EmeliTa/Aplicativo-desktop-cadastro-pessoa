/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.PessoaDAO;
import Execute.Main;
import Model.Pessoa;
import java.awt.event.MouseEvent;
import java.net.URL;
import java.util.Observable;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;


public class TelaConsultarController implements Initializable {

     @FXML
    private Button btExcluir;

    @FXML
    private TableColumn<Pessoa, Long> clnId;

    @FXML
    private Button btAlterar;

    @FXML
    private TableView< Pessoa > Tabela;

    @FXML
    private TableColumn<Pessoa, String> clnNome;

    @FXML
    private Button btSair;

    @FXML
    private TableColumn<Pessoa, String> clnEmail;
    
    @FXML private Pessoa selecionada; //Pessoa temporária
    
   @Override
    public void initialize(URL url, ResourceBundle rb) {
    iniciaTabela();
    Tabela.getSelectionModel().selectedItemProperty().addListener(new ChangeListener(){

        @Override
        public void changed(ObservableValue observable, Object oldValue, Object newValue) {
            System.out.println("SELECIONEI");
            selecionada = (Pessoa) oldValue;
            
        }
      
    });
    }  
      public ObservableList <Pessoa> atualizaTabela(){
      PessoaDAO dao = new PessoaDAO();
      return FXCollections.observableArrayList(dao.consulta());
     }   
       public void Excluir(){       
    if (selecionada != null){
        PessoaDAO dao = new PessoaDAO ();
        dao.remove(selecionada);
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setHeaderText("Usuário excluido com sucesso!");
        alert.show();
        atualizaTabela();
        
    }else{
       Alert alert = new Alert(Alert.AlertType.WARNING);
       alert.setHeaderText("Erro ao excluir usuário!");
       alert.show();
    }
    
    }  
      public void iniciaTabela (){          
      
      clnId.setCellValueFactory(new PropertyValueFactory("id"));
      clnNome.setCellValueFactory(new PropertyValueFactory("nome"));
      clnEmail.setCellValueFactory(new PropertyValueFactory("email"));
      
      Tabela.setItems(atualizaTabela());
      }

    
    public void Alterar(){
       if (selecionada != null){
        PessoaDAO dao = new PessoaDAO ();
        dao.altera(selecionada);
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setHeaderText("Usuário alterado com sucesso!");
        alert.show();
        atualizaTabela();
        
    }else{
       Alert alert = new Alert(Alert.AlertType.WARNING);
       alert.setHeaderText("Erro ao alterar usuário!");
       alert.show();
    }
     
    }
    
    
    }

    


    
    



