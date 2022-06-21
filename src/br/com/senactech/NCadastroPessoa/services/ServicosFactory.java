/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.senactech.NCadastroPessoa.services;

/**
 *
 * @author Mauro BH Jr
 */
public class ServicosFactory {
    
    private static PessoaServicos pessoaServicos = new PessoaServicos();
    
    
    public static PessoaServicos getPessoaServicos(){
        return pessoaServicos;
    }
    
    
    
    
    
    
    
    
}
