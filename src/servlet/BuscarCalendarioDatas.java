package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DaoEvento;
import entidades.Evento;

@WebServlet("/pages/buscarCalendarioDatas")
public class BuscarCalendarioDatas extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private DaoEvento daoEvento = new DaoEvento();

	public BuscarCalendarioDatas() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {

			List<Evento> eventos = daoEvento.getEventos();

			if (!eventos.isEmpty()) {
				
				int totalEventos = eventos.size();
				int index = 1;
				
				String datas = "[";
				
				
				for(Evento event : eventos) {
					datas += "{\"title\": \""+event.getDescricao()+"\", \"start\": \""+event.getDataEvento()+"\"} ";
					
					if (index < totalEventos) {
						datas += ",";
					}
					
					index++;
				}
				
				datas +="]";
				
				response.setStatus(200);
				response.getWriter().write(datas);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

}
