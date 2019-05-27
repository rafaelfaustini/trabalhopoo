import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;



public class Cadastro {
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		Conexao con = new Conexao();
		menu();
	}
	public static void listar_cliente() throws Exception{
		Statement st;
		Conexao con = new Conexao();
		st = con.conexao.createStatement();
		ResultSet rs = st.executeQuery("SELECT cpf, nome, telefone FROM Cliente");
		System.out.println("----------------------------------------");
		while (rs.next()) {
			System.out.println("CPF:" +rs.getString(1) + "\tNome: "+ rs.getString(2)+ "\tTelefone: " + rs.getString(3) );
			}
		}
	private static void menu() throws Exception { // menu principal
        	Scanner scan=new Scanner(System.in);
	         System.out.println("Please enter 1-3\n1.Cadastrar cliente\n2.Ver clientes\n3.Sair");
	          int  input=scan.nextInt();
	           int check = input;
	            switch (check)
	            {
	            case 1 :
	                System.out.println("Insira o nome do cliente:");
	                String nome = scan.next();
	                System.out.println("Insira o cpf do cliente:");
	                int cpf = scan.nextInt();
	                System.out.println("Insira o telefone do cliente:");
	                int tel = scan.nextInt();
	                Cliente cliente = new Cliente(nome,cpf,tel);
	                check = -1;
	                break;
	            case 2 :
	                listar_cliente();
	                break;
	            case 3 :
	                System.exit(0);
	               break;
	                
	            default:
	            	menu();
	            	break;
	            }
	            if(check == -1) {
	            	menu();
	            }
	   
	}


}
