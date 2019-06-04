import java.sql.SQLException;
import java.sql.Statement;

public class Cliente {
	
	private String nome;
	private int cpf;
	private int telefone;
	
	public Cliente(String nome, int cpf, int telefone) throws SQLException {
		
		this.nome = nome;
		this.cpf = cpf;
		this.telefone = telefone;
		Conexao con = new Conexao();
		String query = "INSERT INTO Cliente(nome, cpf, telefone) VALUES ('" + this.getNome() + "','" + this.getCpf() + "','" + this.getTelefone() + "')";
		Statement st = con.conexao.createStatement();
		st.executeUpdate(query);
 
	}

	public void Status(Cliente a) {
		System.out.println("Nome: " + a.getNome() +" Cpf: "+ a.getCpf() + " Telefone: " + a.getTelefone());
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getCpf() {
		return cpf;
	}
	public void setCpf(int cpf) {
		this.cpf = cpf;
	}
	public int getTelefone() {
		return telefone;
	}
	public void setTelefone(int telefone) {
		this.telefone = telefone;
	}
	
	
}

