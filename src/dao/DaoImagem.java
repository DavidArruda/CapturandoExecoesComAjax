package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connection.SingleConnection;
import entidades.BeanImagem;

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
	
	public List<BeanImagem> listar() throws Exception {
		List<BeanImagem> lista = new ArrayList<BeanImagem>();

		String sql = "select * from imagem";

		PreparedStatement statement = connection.prepareStatement(sql);
		ResultSet resultSet = statement.executeQuery();

		while (resultSet.next()) {

			BeanImagem img = new BeanImagem();
			img.setCodImagem(resultSet.getLong("codImagem"));
			img.setImagem(resultSet.getString("imagem"));
			
			lista.add(img);

		}
		return lista;
	}

	public String buscarImagem(String codImagem) throws SQLException {
		
		try {
		
			String sql = "select imagem from imagem where codImagem = " + codImagem;
			
			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet resultSet = statement.executeQuery();
			
			while(resultSet.next()) {
				return resultSet.getString("imagem");
			}
		
		}catch (Exception e) {
			// TODO: handle exception
		}
		
		return null;
	}
	
	

}
