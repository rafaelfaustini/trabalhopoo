import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class JavaApplication5 {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		
		Cliente a = new Cliente("Daniel", 11147744, 999998888);
		Cliente b = new Cliente("Rafael", 11255566, 999999999);
		Cliente c = new Cliente ("André", 11377755, 777775555);
		
		Conexao con = new Conexao();
		
		Statement st = con.conexao.createStatement();
		
		st.executeUpdate("INSERT INTO Cliente(nome, cpf, telefone) VALUES (" + a.getNome() + "," + a.getCpf() + "," + a.getTelefone() + ")");
		st.executeUpdate("INSERT INTO Cliente(nome, cpf, telefone) VALUES (" + b.getNome() + "," + b.getCpf() + "," + b.getTelefone() + ")");
		st.executeUpdate("INSERT INTO Cliente(nome, cpf, telefone) VALUES (" + c.getNome() + "," + c.getCpf() + "," + c.getTelefone() + ")");
		st.executeQuery("Select * from Clientes");
		
		ResultSet rs = st.getResultSet();
		
		while(rs.next()) {
			System.out.println(rs.getString("cliente_nome")+ ","+ rs.getString("cliente_cpf") );
		}
		
	}

}
