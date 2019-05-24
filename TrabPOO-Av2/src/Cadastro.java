import java.sql.*;
public class Cadastro {
	static Connection conexao;
	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		/*
		Cliente a = new Cliente("Daniel", 11147744, 999998888);
		Cliente b = new Cliente("Rafael", 11255566, 999999999);
		Cliente c = new Cliente ("André", 11377755, 777775555);
	
		a.Status(a);
		b.Status(b);
		c.Status(c);
		*/
		conecta();
		System.out.println("Antes de executar");
		
		executa("INSERT INTO Cliente(nome, cpf, telefone) VALUES ('Daniel', 11147744, 999998888)");
		executa("INSERT INTO Cliente(nome, cpf, telefone) VALUES ('Rafael', 11255566, 999999999)");
		executa("INSERT INTO Cliente(nome, cpf, telefone) VALUES ('André', 13777555, 777775555)");
		
		System.out.println("Antes de listar Cliente");
		listar_cliente();
		executa("UPDATE Cliente SET nome = 'Joao' WHERE cpf =11147744" );
		executa("DELETE FROM Cliente WHERE cpf = 13777555");
		listar_cliente();
		desconecta();
	}


public static void conecta() {
	String driver = "com.mysql.jdbc.Drivers";//Endereço da classe do driver que corresponde ao banco de dados(Baixar - baixar conector jdbc mysql) - Aula 10 - 10:15 - https://www.youtube.com/watch?v=HOsdNP7Jutw 
	String url = "jdbc:mysql://localhost:0000/TrabPOO-Av2" ;//Padrão - Verificar Porta de localhost - Nome do banco
	String login = "root";//Verificar login
	String senha = "";//Verificar senha
	try {
		Class.forName(driver);
		conexao = DriverManager.getConnection(url, login, senha);
		System.out.println("Conexão Bem Sucedida");
		
	} catch (Exception e) {
		e.printStackTrace();//Nesta linha é impresso o erro!
	}
	}


public static void executa(String sql)throws Exception{
	Statement st = null;
	st = conexao.createStatement();
	st.executeUpdate(sql);
	}

public static void listar_cliente() throws Exception{
	Statement st;
	st = conexao.createStatement();
	ResultSet rs = st.executeQuery("SELECT cpf, nome, telefone FROM Cliente");
	System.out.println("----------------------------------------");
	while (rs.next()) {
		System.out.println("CPF:" +rs.getString(1) + "Nome: "+ rs.getString(2)+ "Telefone: " + rs.getString(3) );
		}
	}
public static void desconecta() throws Exception{
	conexao.close();
	}
}