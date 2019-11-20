package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import connection.SingleConnection;

public class DaoImagem {
	
	private Connection connection;
	
	public DaoImagem() {
		connection = SingleConnection.getConnection();
	}

	public void gravarImagem(String imagem) {
		
		String sql = "insert into imagem (imagem) values(?)";
		
		PreparedStatement preparedStatement;
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, imagem);
			preparedStatement.execute();
			
			connection.commit();
			
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
		
		
		
	}
	
	

}
