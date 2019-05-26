import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
String severName = "sql52.main-hosting.eu";//Caminho do servidor do BD
String mydatabase = "u557001243_poo";//Nome do banco de dados
String url = "jdbc:mysql//" + severName + " / " + mydatabase;
String username = "u557001243_poo";//Nome do usuário de seu BD
String password = "WIq9j8o0sM4l";//Sua senha de acesso
Connection conexao;

Conexao()throws SQLException{
	conexao = DriverManager.getConnection(url, username, password);
	}
}
