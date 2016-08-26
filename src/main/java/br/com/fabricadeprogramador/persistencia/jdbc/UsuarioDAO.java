package br.com.fabricadeprogramador.persistencia.jdbc;

import java.awt.List;
import java.net.ConnectException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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
	
	public void salvar(Usuario usuario){
		if(usuario.getId() != null){
			alterar(usuario);
		}else{
			cadastrar(usuario);
		}
	}
	
	public Usuario buscarPorId(Integer id){
		
		String sql = "SELECT * FROM usuario WHERE id = ?";
		try(PreparedStatement pst = con.prepareStatement(sql)) {
			pst.setInt(1, id);
			ResultSet resultado = pst.executeQuery();	
			if(resultado.next()){
				
				Usuario usuario = new Usuario();
				usuario.setId(resultado.getInt("id"));
				usuario.setNome(resultado.getString("nome"));
				usuario.setLogin(resultado.getString("login"));
				usuario.setSenha(resultado.getString("senha"));
				return usuario;
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return null;
		
	}
	
/*	
public List<Usuario> buscarTodos(){
		
		String sql = "SELECT * FROM usuario";
		List<Usuario> lista = new ArrayList<Usuario>();
		try(PreparedStatement pst = con.prepareStatement(sql)) {
			ResultSet resultado = pst.executeQuery();	
			while(resultado.next()){
				
				Usuario usuario = new Usuario();
				usuario.setId(resultado.getInt("id"));
				usuario.setNome(resultado.getString("nome"));
				usuario.setLogin(resultado.getString("login"));
				usuario.setSenha(resultado.getString("senha"));
				lista.add(usuario);
				
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
		return lista;
	}
	*/
	public Usuario autentica(Usuario usuario){
		
		String sql = "SELECT * FROM usuario WHERE login = ? AND senha = ? ";
		try (PreparedStatement pst = con.prepareStatement(sql)){
			pst.setString(1, usuario.getLogin());
			pst.setString(2, usuario.getSenha());
			
			ResultSet resultado = pst.executeQuery();
			if(resultado.next()){
			Usuario user = new Usuario();
			user.setId(resultado.getInt("id"));
			user.setNome(resultado.getString("nome"));
			user.setLogin(resultado.getString("login"));
			user.setSenha(resultado.getString("senha"));
			return user;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
	
}
