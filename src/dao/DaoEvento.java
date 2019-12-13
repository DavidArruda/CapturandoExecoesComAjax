package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connection.SingleConnection2;
import entidades.Evento;
import entidades.Usuario;

public class DaoEvento {
	
	private Connection connection;
	
	public DaoEvento() {
		connection = SingleConnection2.getConnection();
	}
	
	/** lista os usuários do banco */
	public List<Evento> getEventos() throws SQLException{
		
		List<Evento> eventos = new ArrayList<Evento>();
		
		String sql = "select * from eventos";
		PreparedStatement statement = connection.prepareStatement(sql);
		ResultSet resultSet = statement.executeQuery();
		
		while(resultSet.next()) {
			
			Evento evento = new Evento();
			evento.setCodEvento(resultSet.getLong("codEvento"));
			evento.setDataEvento(resultSet.getString("dataEvento"));
			evento.setDescricao(resultSet.getString("descricao"));
			
			eventos.add(evento);
		}
		
		return eventos;
		
	}

}
