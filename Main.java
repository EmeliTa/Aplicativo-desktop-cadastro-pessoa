/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Execute;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Aluno
 */
public class Main extends Application {
    private String caminhoTela = "TelaLogin.fxml";
    private String tituloTela = "Login";
    
    public static void main(String[] args) {
        launch(args);
    }
               @Override
    public void start(Stage stage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/View/"+caminhoTela));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        stage.setTitle(tituloTela);
    }
    public void abreTela (String nomeTela, String Titulo) {
        caminhoTela = nomeTela;
        tituloTela = Titulo;
        Stage stage = new Stage();
        try {
            start(stage);
            stage.setTitle(tituloTela);
        } catch (Exception e) {
            System.out.println("Erro ao abrir tela!" + e.getMessage());
        }
    }
    
}
