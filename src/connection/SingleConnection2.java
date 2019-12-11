package connection;

import java.sql.Connection;
import java.sql.DriverManager;

/**
Realiza conexao com o banco postgreSQL
 */

public class SingleConnection2 {
	
	private static String banco = "jdbc:postgresql://localhost:5432/datas?autoReconnect=true";
	private static String password = "admin";
	private static String user = "postgres";
	private static Connection connection = null;

	static {
		conectar();
	}

	public SingleConnection2() {
		conectar();
	}

	private static void conectar() {

		try {
			if (connection == null) {
				Class.forName("org.postgresql.Driver");
				connection = DriverManager.getConnection(banco, user, password);
				connection.setAutoCommit(false);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("Erro ao conectar com o banco de dados");
		}
	}

	public static Connection getConnection() {
		return connection;
	}

}