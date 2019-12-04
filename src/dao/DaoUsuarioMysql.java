package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import connection.SingleConnectionMysql;
import entidades.Usuario;

public class DaoUsuarioMysql {
	
	private Connection connection;
	
	public DaoUsuarioMysql() {
		connection = SingleConnectionMysql.getConnection();
	}
	
	/** lista os usuários do banco */
	public List<Usuario> getsuarios() throws SQLException{
		
		List<Usuario> usuarios = new ArrayList<Usuario>();
		
		String sql = "select * from usuario";
		PreparedStatement statement = connection.prepareStatement(sql);
		ResultSet resultSet = statement.executeQuery();
		
		while(resultSet.next()) {
			
			Usuario user = new Usuario();
			user.setCodUsuario(resultSet.getLong("codUsuario"));
			user.setNome(resultSet.getString("nome"));
			user.setSenha(resultSet.getString("senha"));
			
			usuarios.add(user);
		}
		
		return usuarios;
		
	}

}
