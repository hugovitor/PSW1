/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Rafael.Soares
 */
public class Conexao {

    private String nome;
    private String sobrenome;
    private String telefone;
    private String endereco;
    private String cidade;

    public void salvar() {

        try {
            //Carrega o driver na memória
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            // Conecta ao banco
            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/sample", "app", "app");

            // Cria a transação
            java.sql.Statement transacao = con.createStatement();

            String query = "INSERT INTO CONTATOS VALUES ('" + nome + "', " + telefone + " ," + telefone + ", " + endereco + ", " + cidade + ")";

            //executa um update
            int linhas = transacao.executeUpdate(query);

            //*** Finaliza transação e conexão
            transacao.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }
    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    public String getCidade() {
        return endereco;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }
    

}
