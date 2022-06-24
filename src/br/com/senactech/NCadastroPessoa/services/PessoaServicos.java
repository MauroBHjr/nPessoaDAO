/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.senactech.NCadastroPessoa.services;
import br.com.senactech.NCadastroPessoa.dao.PessoaDAO;
import br.com.senactech.NCadastroPessoa.dao.DAOFactory;
import br.com.senactech.NCadastroPessoa.model.Pessoa;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Mauro BH Jr
 */
public class PessoaServicos {
    
    public void cadPessoa(Pessoa pVO) throws SQLException{
        PessoaDAO pDAO = DAOFactory.getPessoaDAO();
        pDAO.cadastrarPessoa(pVO); 
    }
    
    public ArrayList<Pessoa> getPessoas() throws SQLException{
        PessoaDAO pDAO = DAOFactory.getPessoaDAO();
        return pDAO.listarPessoas();
    }
    
    public boolean verCpfBD(String cpf) throws SQLException{
        PessoaDAO pDAO = DAOFactory.getPessoaDAO();
        return pDAO.verCPF(cpf);
    }
    
    public Pessoa buscarPessoa(String cpf) throws SQLException{
        PessoaDAO pDAO = DAOFactory.getPessoaDAO();
        return pDAO.getByDoc(cpf);
    }
    
    public void deletarPessoaBD(int id) throws SQLException{
        PessoaDAO pDAO = DAOFactory.getPessoaDAO();
        pDAO.deletarPessoa(id);
    }
    
    public void atualizarPessoaBD(Pessoa pVO) throws SQLException{
        PessoaDAO pDAO = DAOFactory.getPessoaDAO();
        pDAO.atualizarPessoa(pVO);
    }
    
    
    
    
    
    
    
    
}
