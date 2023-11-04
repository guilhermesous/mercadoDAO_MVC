package util;

public class conexao {
	private static String jdbcURL = "jdbc:mysql://localhost:3306/mercado";
	private static String user = "guilherme";
	private static String password = "789456";
	
	public static String getJdbcURL() {
		return jdbcURL;
	}
	public static String getUser() {
		return user;
	}
	public static String getPassword() {
		return password;
	}

}
