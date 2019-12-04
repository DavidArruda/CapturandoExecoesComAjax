package filter;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import connection.SingleConnection;
import connection.SingleConnection2;
import connection.SingleConnectionMysql;
import user.UserLogado;

@WebFilter(urlPatterns = { "/pages/*" })
public class FilterAltenticacao implements Filter {
	
	private static Connection connection;
	private static Connection connection2;
	private static Connection connectionMysql;

	// Faz alguma coisa quando a aplicação é derrubada
	@Override
	public void destroy() {
		
	}

	// Intercepta todas as requisições
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest req = (HttpServletRequest) request;
		HttpSession session = req.getSession();
		
		String urlParaAutenticar = req.getServletPath();
		
		UserLogado userLogado = (UserLogado) session.getAttribute("usuario");
		
		//Retorna null caso não esteja logado
		if (userLogado == null && !urlParaAutenticar.equalsIgnoreCase("/pages/ServletAutenticacao")) {//Usuário não logado
			RequestDispatcher dispatcher = request.getRequestDispatcher("/autenticar.jsp?url="+urlParaAutenticar);
			dispatcher.forward(request, response);
			return;
		}

		/*
		 * Sempre fazer essa chamada. Executa as ações do resquest e response
		 */
		chain.doFilter(request, response);

		System.out.println("Interceptando");
	}

	// Executa alguma coisa quando a aplicação é executada
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		
		connection = SingleConnection.getConnection();
		connection2 = SingleConnection2.getConnection();
		connectionMysql = SingleConnectionMysql.getConnection();

	}

}
