/*
Nome: Bruno Domingues, Dêner Ribeiro, Gustavo Veronez, Tayane Lopes.
Turma: TI-167.
Descrição: Sistema para fazer cadastro em banco de dados das contas à pagar da empresa.
Data de Termino: 24/08/2015.

*/
package factory;

/**
 *
 * @author GRUPO 2 JSE1
 */
import java.sql.Connection;
import java.sql.SQLException;
public class TestConnection {
    public static void main(String[] args) throws SQLException{
        //faz teste de conexão com o banco de dados
        Connection connection  = new ConnectionFactory().getConnection(); 
        System.out.println("Conexão aberta!");
        connection.close();
    }
}
