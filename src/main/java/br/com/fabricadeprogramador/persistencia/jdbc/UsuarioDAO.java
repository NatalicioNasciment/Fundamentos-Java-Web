package br.com.fabricadeprogramador.persistencia.jdbc;

import java.net.ConnectException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.fabricadeprogramador.persistencia.entidades.Usuario;

public class UsuarioDAO {
	private Connection con = ConexaoFactory.getConection();
	
	public void cadastrar(Usuario usuario) {
		 
		String sql = "INSERT INTO usuario (nome, login, senha) VALUES(?,?,?)";
		
		try (PreparedStatement pst = con.prepareStatement(sql)){
			
			pst.setString(1, usuario.getNome());
			pst.setString(2, usuario.getLogin());
			pst.setString(3, usuario.getSenha());
			pst.executeUpdate();
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	public void alterar(Usuario usuario) {
		String sql = "UPDATE usuario SET nome = ?, login = ?, senha = ? WHERE id = ?";
		
		try (PreparedStatement pst = con.prepareStatement(sql)){
			
			pst.setString(1, usuario.getNome());
			pst.setString(2, usuario.getLogin());
			pst.setString(3, usuario.getSenha());
			pst.setInt(4, usuario.getId());
			pst.executeUpdate();
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void excluir(Usuario usuario){
		String sql = "DELETE FROM usuario WHERE id = ?";
		
		try (PreparedStatement pst = con.prepareStatement(sql)){
			
			pst.setInt(1, usuario.getId());
			pst.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
