/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

/**
 *
 * @author 182110084
 */
class DAOFactory {
     private static ClienteDAO cDAO = new ClienteDAO();
    private static LojaDAO cDAO = new LojaDAO();

    public static PessoaDAO getPessoaDAO() {
        return cDAO;
    }

    private static class ClienteDAO {

        public ClienteDAO() {
        }
    }
}

  
