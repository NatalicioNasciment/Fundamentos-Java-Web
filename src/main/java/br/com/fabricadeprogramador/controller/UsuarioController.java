package br.com.fabricadeprogramador.controller;

import java.awt.List;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fabricadeprogramador.persistencia.entidades.Usuario;
import br.com.fabricadeprogramador.persistencia.jdbc.UsuarioDAO;

@WebServlet("/usuarioController.do")
public class UsuarioController extends HttpServlet {

	public UsuarioController() {
		System.out.println("Contrutor...");
	}

	@Override
	public void init() {
		System.out.println("init...");
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String acao = req.getParameter("acao");
		resp.setContentType("text/html");

		if (acao.equals("excluir")) {
			String id = req.getParameter("id");
			Usuario usuario = new Usuario();

			if (id != null)
				usuario.setId(Integer.parseInt(id));

			UsuarioDAO usuarioDAO = new UsuarioDAO();
			usuarioDAO.excluir(usuario);
			// resp.getWriter().println("Usuario excluído com Sucesso!!!");
			resp.sendRedirect("usuarioController.do?acao=listar");

		} else if (acao.equals("listar")) {
			UsuarioDAO usuarioDAO = new UsuarioDAO();
			ArrayList<Usuario> lista = usuarioDAO.buscarTodos();
			// estrutura map : com chave e valor . Atribuição da lista dentro do
			// request.
			req.setAttribute("lista", lista);
			//
			RequestDispatcher dispacher = req.getRequestDispatcher("WEB-INF/ListaUsuario.jsp");
			// faz o encaminhamento
			dispacher.forward(req, resp);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// String id = req.getParameter("id");
		String nome = req.getParameter("nome");
		String login = req.getParameter("login");
		String senha = req.getParameter("senha");

		Usuario usuario = new Usuario();
		if (usuario != null)
			// usuario.setId(Integer.parseInt(id));
			usuario.setNome(nome);
		usuario.setLogin(login);
		usuario.setSenha(senha);

		UsuarioDAO usuarioDAO = new UsuarioDAO();
		usuarioDAO.salvar(usuario);

		resp.getWriter().print("Usuario Cadastrado com sucesso!!!");
		resp.sendRedirect("usuarioController.do?acao=listar");
		// System.out.println("Sucesso!!!");
	}

	@Override
	public void destroy() {
		System.out.println("Destroy..");
	}
}
