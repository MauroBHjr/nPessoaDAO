/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.senactech.NCadastroPessoa.services;

import br.com.senactech.NCadastroPessoa.dao.CarroDAO;
import br.com.senactech.NCadastroPessoa.dao.DAOFactory;
import br.com.senactech.NCadastroPessoa.model.Carro;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Mauro BH Jr
 */
public class CarroServicos {
    public void cadCarro(Carro pVO) throws SQLException{
        CarroDAO carDAO = DAOFactory.getCarroDAO();
        carDAO.cadastrarCarro(pVO); 
    }
    public ArrayList<Carro> getCarros() throws SQLException{
        CarroDAO carDAO = DAOFactory.getCarroDAO();
        return carDAO.listarCarros();
    }    
    public boolean verCpfBD(String placa) throws SQLException{
        CarroDAO carDAO = DAOFactory.getCarroDAO();
        return carDAO.verPlaca(placa);
    }    
    public Carro buscarPessoa(String placa) throws SQLException{
        CarroDAO carDAO = DAOFactory.getCarroDAO();
        return carDAO.getByPlaca(placa);
    }
    public void deletarPessoaBD(int id) throws SQLException{
        CarroDAO carDAO = DAOFactory.getCarroDAO();
        carDAO.deletarCarro(id);
    }
    public void atualizarPessoaBD(Carro pVO) throws SQLException{
        CarroDAO carDAO = DAOFactory.getCarroDAO();
        carDAO.atualizarCarro(pVO);
    }
}
