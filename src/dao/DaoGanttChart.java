package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connection.SingleConnection2;
import entidades.Projeto;
import entidades.Series;

public class DaoGanttChart {

	private Connection connection;
	
	public DaoGanttChart() {
		connection = SingleConnection2.getConnection();
	}
	
	
	/** lista os usuários do banco */
	public List<Projeto> getProjetos() throws SQLException{
		
		List<Projeto> projetos = new ArrayList<Projeto>();
		
		String sql = "select * from projeto";
		PreparedStatement statement = connection.prepareStatement(sql);
		ResultSet resultSet = statement.executeQuery();
		
		while(resultSet.next()) {
			
			Projeto projeto = new Projeto();
			projeto.setCodProjeto(resultSet.getLong("codProjeto"));
			projeto.setNome(resultSet.getString("nome"));
			
			String sqlSeries = "select * from series where projeto = " + resultSet.getLong("codProjeto");
			PreparedStatement statementSeries = connection.prepareStatement(sqlSeries);
			ResultSet resultSetSeries = statementSeries.executeQuery();
			
			List<Series> listaSeries = new ArrayList<Series>();
			
			while(resultSetSeries.next()) {
				Series series = new Series();
				
				series.setCodSeries(resultSetSeries.getLong("codSeries"));
				series.setNome(resultSetSeries.getString("nome"));
				series.setDataFinal(resultSetSeries.getString("dataInicial"));
				series.setDataFinal(resultSetSeries.getString("dataFinal"));
				series.setProjeto(resultSetSeries.getLong("projeto"));
				
				listaSeries.add(series);
			}
			
			projeto.setListaSeries(listaSeries);
		}
		
		return projetos;
		
	}

}
