import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
String severName = "localhost";//Caminho do servidor do BD
String mydatabase = "teste";//Nome do banco de dados
String url = "jdbc:mysql//" + severName + " / " + mydatabase;
String username = "root";//Nome do usuário de seu BD
String password = "";//Sua senha de acesso
Connection conexao;

Conexao()throws SQLException{
	conexao = DriverManager.getConnection(url, username, password);
	}
}
