
package jdbc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ConexaoBD2 {

    public Connection con; //estabele uma conexão com o BD
    public Statement st; //realiza uma pesquina no BD
    public ResultSet rs; //armazena o resultado da pesquisa
    private String driver = "org.postgresql.Driver"; //identifica o serviço de BD 
    private String caminho ="jdbc:postgresql://localhost:5432/Pessoa"; //onde o BD esta alocado
    private String usuario = "  "; //usuario postgresql
    private String senha = "  " ;//senha postgresql
    
    public void criaConexao(){
        System.setProperty("jdbc.Drivers", driver);
        try {
            con = DriverManager.getConnection(caminho, usuario, senha);
            System.out.println("Conexão com o Banco de dados estabelecida!");
        } catch (SQLException ex) {
            Logger.getLogger(ConexaoBD2.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Erro na conexão com o Banco de dados!");
        }
    }

    public void desconecta(){
        try {    
            con.close();
            System.out.println("Desconectado do BD com sucesso!");
        } catch (SQLException ex) {
            Logger.getLogger(ConexaoBD2.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Erro ao desconectar do BD");
        }
    }
}
