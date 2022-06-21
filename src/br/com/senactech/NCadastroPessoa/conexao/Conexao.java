/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.senactech.NCadastroPessoa.conexao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;

/**
 *
 * @author 182110041
 */
public class Conexao {
    //cria constante com endereço do Banco d eDados e Schema
    private static String url = "jdbc:mysql://localhost:3306/devn211";
    //cria constante com user do BD
    private static String user = "root";
    //cria uma constante com senha do BD
    private static String pass = "";
    
    public static Connection getConexao() throws SQLException{
        //inicia conexão nula, ainda não estabelecida
        Connection c = null;
        
        //tenta estabelecer conexão
        try {
            c = DriverManager.getConnection(url, user, pass);
            //tratamento, casa haja alguma falha entra em ação o catch
        } catch (SQLException e) {
            throw new SQLException("Erro ao conectar ao banco.\n"
                + e.getMessage());
        }
        return c;
    }
            
            
            
}
