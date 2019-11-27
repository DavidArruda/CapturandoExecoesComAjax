package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/pages/carregarDadosDataTable")
public class CarregarDadosDataTable extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CarregarDadosDataTable() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String json = "{"+
				  "\"draw\": 1,"+
				  "\"recordsTotal\": 57,"+
				  "\"recordsFiltered\": 57,"+
				  "\"data\": ["+			  
				   " [" +
				      "\"Cara\","+
				      "\"Stevens\","+
				      "\"Sales Assistant\","+
				      "\"New York\","+
				      "\"6th Dec 11\","+
				      "\"$145,600\""+
				    "],"+
				    "["+
				      "\"Cedric\","+
				      "\"Kelly\","+
				      "\"Senior Javascript Developer\","+
				      "\"Edinburgh\","+
				      "\"29th Mar 12\","+
				      "\"$433.060\""+
				    "]"+
				  "]"+
				"}";
		
		response.setStatus(200); //resposta completa ok
		response.getWriter().write(json); // json de resposta (escreve a resposta http)
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
