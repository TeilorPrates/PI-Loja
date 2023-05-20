/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Cliente;

/**
 *
 * @author 182110084
 */
public class ClienteDao {
    public void ClienteDAO(Cliente pVO) {
        try {
            //buscar conexão com BD
            Connection con = Conexao.getConexao();
            //criar script sql de insert
            String sql = "insert into pessoa values (null, ?,?,?,?)";
            //criar espaço para executar script
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, pVO.getidCliente());
            pst.setString(2, pVO.getendereco());
            pst.setString(3, pVO.getnome());
            pst.setString(4, pVO.gettelefone());
            pst.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erro ao cadastrar Pessoa.\n"
                    + e.getMessage());
        }
    }//fim cadastroPessoa
    
    public ArrayList<Cliente> getidCliente(){
        ArrayList<Cliente> pessoas = new ArrayList<>();
        try {
            Connection con = Conexao.getConexao();
            String sql = "select * from pessoa";
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                Cliente c = new Cliente();
                // lado do java |x| lado do banco
                c.setidCliente(rs.getInt("idCliente"));
                c.setnome(rs.getString("nome"));
                c.setendereco(rs.getString("endereco"));              
                c.settelefone(rs.getString("telefone"));
                Cliente.add(c);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao listar clientes.\n"
                    + e.getMessage());
        }
        return pessoas;
    }
    
    public Cliente getPessoaByDoc(String idCliente){
        Cliente c = new Cliente();
        try {
            Connection con = Conexao.getConexao();
            String sql = "select * from cliente where cpf = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, idCliente);
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                // lado do java |x| lado do banco
                c.setidCliente(rs.getInt("idPessoa"));
                c.setendereco(rs.getString("nome"));
                c.setnome(rs.getString("cpf"));
                c.settelefone(rs.getString("telefone"));
                
            }
        } catch (SQLException e) {
            System.out.println("Erro ao buscar CPF.\n"
                    + e.getMessage());
        }
        return c;
    }
    
    public void atualizarPessoaDAO(Pessoa pVO){
        try {
            Connection con = Conexao.getConexao();
            String sql = "update pessoa set nome = ?, endereco = ?, telefone = ?"
                    + " where cpf = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, pVO.getNome());
            pst.setString(2, pVO.getEndereco());
            pst.setString(3, pVO.getTelefone());
            pst.setString(4, pVO.getCpf());
            pst.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar Pessoa.\n"
                    + e.getMessage());
        }
    }
    
    public void deletarPessoaDAO(String cpf){
        try {
            Connection con = Conexao.getConexao();
            String sql = "delete from pessoa where cpf = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, cpf);
            pst.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erro ao deletar Pessoa.\n"
                    + e.getMessage());
        }
    }
    
}
}
