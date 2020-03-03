
package Model;


public class Pessoa {
    private long id;
    private String nome, email, senha;

    public Pessoa( String nome, String email, String senha) {
      
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }
    
public Pessoa(){
    
}
    public void mostraPessoa(){
        System.out.println("ID: "+getId());
        System.out.println("Nome: "+ getNome());
        System.out.println("Email: "+getEmail());
        System.out.println("Senha: "+getSenha());
    }

    /**
     * @return the id
     */
    public long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the senha
     */
    public String getSenha() {
        return senha;
    }

    /**
     * @param senha the senha to set
     */
    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    
}
