/*
Nome: Bruno Domingues, Dêner Ribeiro, Gustavo Veronez, Tayane Lopes.
Turma: TI-167.
Descrição: Sistema para fazer cadastro em banco de dados das contas à pagar da empresa.
Data de Termino: 24/08/2015.

*/
package dao;

/**
 *
 * @author GRUPO 2 JSE1
 */

import factory.ConnectionFactory;
import gui.ContasGUI;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import modelo.Contas;

public class ContasDAO {
    private Connection connection;
    
    public ContasDAO(){
        this.connection = new ConnectionFactory().getConnection();
    }
    //método que adiciona os valores na tabela tb_boleto
    public void Adiciona(Contas contas){
        String sqlB = "INSERT INTO tb_boleto(boleto_cod,boleto_valor,boleto_data_vencimento) VALUES(?,?,?)";
        try{
            PreparedStatement stmt = this.connection.prepareStatement(sqlB);
            
            stmt.setInt(1, contas.getBoletoCod());
            stmt.setString(2, contas.getBoletoValor());
            stmt.setString(3, contas.getBoletoDataVencimento());  
            stmt.execute();            
            stmt.close();
            
        }catch(SQLException u){
            JOptionPane.showMessageDialog(null, "Erro na conexão com o Banco de Dados!");
            throw new RuntimeException(u);
        }
        
        
    }
    //método que adiciona os valores na tabela tb_acrecimo
     public void AdicionaAcrecimo(Contas contas){
        String sqlA = "INSERT INTO tb_acrecimo(acrecimo_multa,acrecimo_juros,acrecimo_novo_valor,fk_boleto_cod) VALUES(?,?,?,?)";
        try{
            PreparedStatement stmtA = this.connection.prepareStatement(sqlA);
            
            stmtA.setString(1, contas.getAcrecimoJuros());
            stmtA.setString(2, contas.getAcrecimoMulta());
            stmtA.setString(3, contas.getAcrecimoNovoValor());
            stmtA.setInt(4, contas.getBoletoCod());
            stmtA.execute();
            stmtA.close();
        }catch(SQLException u){
            JOptionPane.showMessageDialog(null, "Erro na conexão com o Banco de Dados!");
            throw new RuntimeException(u);
        }    
     }
     //método que faz a consulta do código do boleto no banco de dados
     public boolean Consulta(String consulta) throws SQLException{
         boolean find = true;
        try{
            ResultSet rs;
            Statement stmt;
            
            ConnectionFactory con = new ConnectionFactory();
            stmt = con.getConnection().createStatement();

            String sql = "select boleto_cod from tb_boleto where boleto_cod = ?";
            PreparedStatement stmtC = this.connection.prepareStatement(sql);
            
            stmtC.setInt(1, Integer.parseInt(consulta));
            stmtC.execute();
            
            rs = stmtC.executeQuery();
            find = rs.first();
            stmt.close();
            
            ContasGUI gui = new ContasGUI();
            
            return find;
            
        }catch(SQLException e){
            find = false;
            JOptionPane.showMessageDialog(null, e );            
        }
        return find;
               
     }
}
