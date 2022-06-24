/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.senactech.NCadastroPessoa.dao;
import br.com.senactech.NCadastroPessoa.conexao.Conexao;
import br.com.senactech.NCadastroPessoa.model.Carro;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Mauro BH Jr
 */
public class CarroDAO {
    /*---------------------------------------------------------
    ------------------- Faltando idPessoa ---------------------
    ---------------------------------------------------------*/
    //revisar "verPlaca" no ValidaInputs
    public void cadastrarCarro(Carro pVO) throws SQLException{
        //Buscar conexão do Banco de Dados
        Connection con = Conexao.getConexao();
        /*cria espaço de trabalho sql 
        (área no Java onde vamos executar os scripts SQL)*/
        Statement stat = con.createStatement();
        
        try {
            String sql;
            /*Inserir conforme a lista de tables da classe
            conforme o BD SQL 
            no caso de carro, seria:
            idCarro
            placa
            marca
            modelo
            anoFabricacao
            anoModelo
            cor
            nPortas
            idPessoa*/
            sql = "insert into carro values "
                    + "(null, '" 
                    //null pois é autoincrement no idCarro
                    + pVO.getPlaca() + "', '"
                    + pVO.getMarca() + "', '"
                    + pVO.getModelo() + "', "
                    //por ser int, devo alterar sintaxe
                    //apenas não lembro no momento qual seria a alteração
                    + pVO.getAnoFabricacao() + ", "
                    + pVO.getAnoModelo() + ", '"
                    + pVO.getCor() + "', "
                    + pVO.getnPortas() + ", '"
                    //Preciso pegar o id da pessoa by CPF
                    //preciso encontrar onde isso se encontra
                    //+ pVO.getIdPessoa() + ");"
                    ;
            stat.execute(sql);
        } catch (SQLException e) {
            throw new SQLException("Erro ao inserir carro. \n"
            + e.getMessage());
        } finally {
            con.close();
            stat.close();
        }
    }
    
    public ArrayList<Carro> listarCarros() throws SQLException{
            //Buscar conexão do Banco de Dados
            Connection con = Conexao.getConexao();
            /*cria espaço de trabalho sql 
            (área no Java onde vamos executar os scripts SQL)*/
            Statement stat = con.createStatement();
            
            try {
                String sql;
                sql = "select * from pessoa";
                ResultSet rs = stat.executeQuery(sql);
                ArrayList<Carro> carros = new ArrayList<>();
                while (rs.next()){
                    Carro car = new Carro();
                    //lado do java |x| lado do banco
                    car.setIdCarro(rs.getInt("idCarro"));
                    car.setPlaca(rs.getString("placa"));
                    car.setMarca(rs.getString("marca"));
                    car.setModelo(rs.getString("modelo"));
                    car.setAnoFabricacao(rs.getInt("anoFabricacao"));
                    car.setAnoModelo(rs.getInt("anoModelo"));
                    car.setCor(rs.getString("cor"));
                    car.setnPortas(rs.getInt("nPortas"));
                    //novamente, rpeciso de um método para pesquisar id by cpf
                    //car.setIdPessoa(rs.getInt("idPessoa"));
                    carros.add(car);
                }
                return carros;
            } catch (SQLException e) {
                throw new SQLException("Erro ao buscar carros.\n"
                    + e.getMessage());
            } finally {
                con.close();
                stat.close();
            }
        } 
    
    public boolean verPlaca(String placa) throws SQLException{
        //Buscar conexão do Banco de Dados
        Connection con = Conexao.getConexao();
        /*cria espaço de trabalho sql 
        (área no Java onde vamos executar os scripts SQL)*/
        Statement stat = con.createStatement();
         
        boolean verPlaca = false;
        
        try {
            String sql;
            sql = "select placa from carro where placa = " + placa;
            ResultSet rs = stat.executeQuery(sql);  
            while (rs.next()){
                verPlaca = rs.wasNull();
            }
        } catch (SQLException e) {
            throw new SQLException("Placa não existente\n"
                + e.getMessage());
        } finally {
            con.close();
            stat.close();
        }
        return verPlaca;
    }
    
    public Carro getByPlaca(String placa) throws SQLException{
            //Buscar conexão do Banco de Dados
            Connection con = Conexao.getConexao();
            /*cria espaço de trabalho sql 
            (área no Java onde vamos executar os scripts SQL)*/
            Statement stat = con.createStatement();
            Carro car = new Carro();
            
            try {
                String sql;
                sql = "select * from carro where placa = " + placa;
                ResultSet rs = stat.executeQuery(sql);
                while (rs.next()){
                    //lado do java |x| lado do banco
                    //ainda não entendi muito bem esse lance do lado BD x JAVA
                    car.setIdCarro(rs.getInt("idCarro"));
                    car.setPlaca(rs.getString("placa"));
                    car.setMarca(rs.getString("marca"));
                    car.setModelo(rs.getString("modelo"));
                    car.setAnoFabricacao(rs.getInt("anoFabricacao"));
                    car.setAnoModelo(rs.getInt("anoModelo"));
                    car.setCor(rs.getString("cor"));
                    car.setnPortas(rs.getInt("nPortas"));
                    // fazer o idPessoa
                }
            } catch (SQLException e) {
                throw new SQLException("Carro com esta placa não existe.\n"
                    + e.getMessage());
            } finally {
                con.close();
                stat.close();
            }
            return car;
        }
    
    //criar método semelhante ao getbydoc, mas de nomeById
    
    public void deletarCarro(int id) throws SQLException{
            //Buscar conexão do Banco de Dados
            Connection con = Conexao.getConexao();
            /*cria espaço de trabalho sql 
            (área no Java onde vamos executar os scripts SQL)*/
            Statement stat = con.createStatement();
            
            try {
                String sql;
                sql = "Delete from carro where idCarro = "
                        + id;
                stat.execute(sql);
            } catch (SQLException e) {
                throw new SQLException("Erro ao remover Carro. \n"
                + e.getMessage());
            } finally {
                con.close();
                stat.close();
            }
        }
    
    public void atualizarCarro(Carro pVO) throws SQLException{
                //Buscar conexão do Banco de Dados
                Connection con = Conexao.getConexao();
                /*cria espaço de trabalho sql 
                (área no Java onde vamos executar os scripts SQL)*/
                Statement stat = con.createStatement();
                
                try {
                    String sql;
                    sql = "update carro set "
                            //rever os > "'" < de sintaxe.
                            + "placa = '" + pVO.getPlaca() + "', "
                            + "marca = '" + pVO.getMarca() + ", "
                            + "modelo = '" + pVO.getModelo() + ", "
                            + "anoFabricacao = '" + pVO.getAnoFabricacao() + ", "
                            + "anoModelo = '" + pVO.getAnoModelo() + ", "
                            + "cor = '" + pVO.getCor() + ", "
                            + "nPortas = '" + pVO.getnPortas() + ", "
                            //idPessoa?
                            ;
                    stat.executeUpdate(sql);
                } catch (SQLException e) {
                    throw new SQLException("Erro ao atualizar carro. \n"
                    + e.getMessage());
                } finally {
                    con.close();
                    stat.close();
                }
            }
}
