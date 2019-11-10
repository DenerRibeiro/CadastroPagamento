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
import java.sql.*;
public class ConnectionFactory {
    //faz a conexão com o banco de dados
    public Connection getConnection(){
        String url = "jdbc:mysql://localhost/cadastro_pagamento";
        String uid = "root";
        String pass = "password";
        
        try{
            return DriverManager.getConnection(url, uid, pass);
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
        
    }
}
