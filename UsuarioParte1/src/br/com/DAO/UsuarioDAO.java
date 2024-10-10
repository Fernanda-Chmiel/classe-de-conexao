
package br.com.DAO;

import br.com.VIEWS.TelaPrincipal;
import br.com.DTO.UsuarioDTO;
import br.com.VIEWS.TelaUsuario;
import java.awt.Color;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableColumnModel;


public class UsuarioDAO {
    
    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    
   public void IncluirUsuario(UsuarioDTO udto){
        String sql = "insert into tb_usuarios(id_usuario, usuario, login, senha) values(?,?,?,?)";
       
        conexao = new conexaoDAO().conector();
       
        try {
           
            pst = conexao.prepareStatement(sql);
            pst.setInt(1, udto.getId_usuario());
            pst.setString(2, udto.getNome_Usuario());
            pst.setString(3, udto.getLogin_Usuario());
            pst.setString(4, udto.getSenha_Usuario());
           
           
              int add = pst.executeUpdate();
            if(add > 0){
            pst.close();
            JOptionPane.showMessageDialog(null, "Usuários inserido com sucesso!");
            }
           
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "inserir usuário" + e);
        }
    }
   
    public void logar(UsuarioDTO objUsuarioDTO){
       
         
        String sql = "select * from tb_usuarios where login = ? and senha = ?";
        conexao = new conexaoDAO().conector();
        try{
            //preparar a consulta no banco, em função do que foi inserido nas caixas de texto
            pst = conexao.prepareStatement(sql);
            pst.setString(1, objUsuarioDTO.getLogin_Usuario());
            pst.setString(2, objUsuarioDTO.getSenha_Usuario());
           
            //executar a query
            rs = pst.executeQuery();
            if(rs.next()){
            TelaPrincipal principal = new TelaPrincipal();
            principal.setVisible(true);//mudamos a visualização da tela
            }else{
            JOptionPane.showMessageDialog(null, "Usuário e/ou senha inválidos!!!");
            }

           
        } catch(Exception e){
            JOptionPane.showMessageDialog(null,"Tela de login" + e);
        }
       
    }  
    
    public void editar(UsuarioDTO objusuarioDTO){
    String sql = "update tb_usuarios set usuario = ?, login = ?, senha = ? where id_usuario = ? ";
    conexao = conexaoDAO.conector();
    
        try {
            pst = conexao.prepareStatement(sql);
            pst.setInt(4, objusuarioDTO.getId_usuario());
            pst.setString(1, objusuarioDTO.getNome_Usuario());
            pst.setString(2, objusuarioDTO.getLogin_Usuario());
            pst.setString(3, objusuarioDTO.getSenha_Usuario());
            
            int add = pst.executeUpdate();
            if(add>0){
            conexao.close();
            JOptionPane.showMessageDialog(null, "Usuário Editado com Sucesso.");
            
            }
            
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Método Editar" + e);
        }
    
    }
    
    public void deletar(UsuarioDTO objUsuarioDTO){
        String sql = "delete from tb_usuarios where id_usuario = ?";
        conexao = new conexaoDAO().conector();
        
        try {
            pst = conexao.prepareStatement(sql);
            pst.setInt(1, objUsuarioDTO.getId_usuario());
            int add = pst.executeUpdate();
            if(add>0){
            conexao.close();
            JOptionPane.showMessageDialog(null, "Usuário Deletado.");
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Método Deletar(DAO)" + e);
        }
    
    }
    
    public void limpar(){
    TelaUsuario.txtIdUsuario.setText(null);
    TelaUsuario.txtNomeUsuario.setText(null);
    TelaUsuario.txtLogin.setText(null);
    TelaUsuario.txtSenha.setText(null);
    }

}
