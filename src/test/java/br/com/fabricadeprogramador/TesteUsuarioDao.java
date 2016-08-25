package br.com.fabricadeprogramador;

import br.com.fabricadeprogramador.persistencia.entidades.Usuario;
import br.com.fabricadeprogramador.persistencia.jdbc.UsuarioDAO;

public class TesteUsuarioDao {

	public static void main(String[] args) {
		 //testCadastrar();
		//testAlterar();
		//testExcluir();
//		testSalvar();
		testBuscarPorId();
	}
	
	private static void testBuscarPorId() {
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		Usuario usuario = usuarioDAO.buscarPorId(2);
		System.out.println(usuario);
		
	}

	public static void testCadastrar(){
		
		Usuario usuario = new Usuario();
		//usuario.setId(1);
		usuario.setNome("Francisco");
		usuario.setLogin("jose");
		usuario.setSenha("xxjl");
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		usuarioDAO.cadastrar(usuario);
		System.out.println("Cadastrados  com sucesso!!!");
	}
	
	public static void testAlterar(){
		Usuario usuario = new Usuario();
		usuario.setId(1);
		usuario.setNome("NatalicioNascimento");
		usuario.setLogin("natalicio");
		usuario.setSenha("liciono");
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		usuarioDAO.alterar(usuario);
		System.out.println("Alterado  com sucesso!!!");
	}
	public static void testExcluir(){
		
		Usuario usuario = new Usuario();
		usuario.setId(8);
		
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		usuarioDAO.excluir(usuario);
		System.out.println("Excluido  com sucesso!!!");
	}
	public static void testSalvar(){
		Usuario usuario = new Usuario();
		usuario.setId(5);
		usuario.setNome("Francisco Natalicio Nascimento");
		usuario.setLogin("Natal");
		usuario.setSenha("123");
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		usuarioDAO.salvar(usuario);
		System.out.println("Salvo com sucesso!!");
	}
	}