
package DAO;
import Model.Pessoa;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import jdbc.ConexaoBD2;


public class PessoaDAO {

    private ConexaoBD2 conecta = new ConexaoBD2();
    public void adicionaPessoa(Pessoa pe) {
        conecta.criaConexao();

        String sql = "Insert into pessoa ( nome, email, senha) values (?,?,?)";

        try {
             PreparedStatement st = conecta.con.prepareStatement(sql);

           
            st.setString(1, pe.getNome());
            st.setString(2, pe.getEmail());
            st.setString(3, pe.getSenha());
            
            
            st.execute();
            System.out.println("Pessoa cadastrada com sucesso!");

        } catch (SQLException ex) {
            System.out.println("Erro ao cadastrar uma pessoa: " + ex);
        } finally {
            conecta.desconecta();
        }
    }

    public List<Pessoa> consulta() {
        conecta.criaConexao();
        try {
            List<Pessoa> Pessoa = new ArrayList<Pessoa>();

            String sql = "select * from Pessoa";
            PreparedStatement st = conecta.con.prepareStatement(sql);

            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                Pessoa pe = new Pessoa();
               
                pe.setId(rs.getLong("idPessoa"));
                pe.setNome(rs.getString("Nome"));
                pe.setEmail(rs.getString("Email"));
                pe.setSenha(rs.getString("Senha"));
                Pessoa.add(pe);
            }
            rs.close();
            st.close();
            System.out.println("sucesso");
            return Pessoa;

        } catch (SQLException ex) {
            System.out.println("Erro na consulta: " + ex.getMessage());
            throw new RuntimeException(ex);
        } finally {
            conecta.desconecta();
        }
    }

    public void remove(Pessoa pe) {
        conecta.criaConexao();
        try {
            PreparedStatement st = conecta.con.prepareStatement("delete "
                    + "from Pessoa where idPessoa = ?");
            st.setLong(1, pe.getId());

            st.execute();
            st.close();
        } catch (SQLException ex) {
            System.out.println("Erro na remoção: " + ex.getMessage());
        } finally {
            conecta.desconecta();
        }
    }

    public void altera(Pessoa pe) {
        conecta.criaConexao();
        String sql = "update Pessoa set "
                + " Nome=?, Email=?, Senha=? where IdPessoa=?,";

        try {
            PreparedStatement st = conecta.con.prepareStatement(sql);

            
            st.setString(1, pe.getNome());
            st.setString(2, pe.getEmail());
            st.setString(3, pe.getSenha());
           
            
            st.execute();
            st.close();

            System.out.println("Usuário alterado com sucesso! ");

        } catch (SQLException ex) {
            System.out.println("Erro na alteração: " + ex.getMessage());
        } finally {
            conecta.desconecta();
        }
    }


}   

