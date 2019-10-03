package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import user.UserLogado;

@WebServlet("/pages/ServletAutenticacao")
public class ServletAutenticacao extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ServletAutenticacao() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if (Boolean.parseBoolean(request.getParameter("deslogar"))) {

			HttpServletRequest req = (HttpServletRequest) request;
			HttpSession session = req.getSession();
			session.invalidate();
			response.sendRedirect("../index.jsp");
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);

		String login = request.getParameter("login");
		String senha = request.getParameter("senha");
		String url = request.getParameter("url");

		if (login.equals("admin") && senha.equals("admin")) {

			UserLogado logado = new UserLogado();
			logado.setLogin(login);
			logado.setSenha(senha);

			// adiciona Usuario logado a sessao
			HttpServletRequest req = (HttpServletRequest) request;
			HttpSession session = req.getSession();
			session.setAttribute("usuario", logado);

			RequestDispatcher dispatcher = request.getRequestDispatcher(url);
			dispatcher.forward(request, response);

		} else { // redireciona para a pagina login novamente
			RequestDispatcher dispatcher = request.getRequestDispatcher("/pages/autenticar.jsp");
			dispatcher.forward(request, response);
		}
	}

}
