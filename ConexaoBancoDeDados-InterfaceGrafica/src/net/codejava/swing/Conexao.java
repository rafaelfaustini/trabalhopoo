package net.codejava.swing;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
String severName = "localhost:3306";//Caminho para servidor do BD
String mydatabase = "test"; //Nome do banco de dados
String url = "jdbc:mysql://" + severName + "/" + mydatabase;
String username = "root"; //Nome do usuário de seu BD
String password = ""; //Sua senha de acesso
Connection conexao;

public Conexao(){
    try {
    	
	DriverManager.registerDriver(new com.mysql.jdbc.Driver());
	
	conexao = DriverManager.getConnection(url, username, password);
    } catch(SQLException e) {
        e.printStackTrace();
        throw new RuntimeException(e);
     
}
}

}
