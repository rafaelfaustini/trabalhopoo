import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class JavaApplication5 {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		
		Cliente a = new Cliente("Daniel", 11147744, 999998888);
		Cliente b = new Cliente("Rafael", 11255566, 999999999);
		Cliente c = new Cliente ("André", 11377755, 777775555);


	}
	private static void menu() { // menu principal
		int opcao = 0;
		do {
			System.out
					.println("\n\n### SISCOM - Sistema Comercial de Controle de Compras e Vendas ###");
			System.out.println("\n                  =========================");
			System.out.println("                  |     1 - Venda         |");
			System.out.println("                  |     2 - Vendedor      |");
			System.out.println("                  |     3 - Compra        |");
			System.out.println("                  |     4 - Produto       |");
			System.out.println("                  |     5 - Cliente       |");
			System.out.println("                  |     6 - Fornecedor    |");
			System.out.println("                  |     0 - Sair          |");
			System.out.println("                  =========================\n");
			opcao = Console.readInt("Opção -> ");
			System.out.print("\n");
			switch (opcao) {
			case 1:
				break;
			case 2:
				fornecedor();
				break;
                       //case3 , 4  , etc...
			case 5:
				cliente();
				break;
			case 0:
				break;
			default:
				System.out.println("Opção Inválida!");
				break;
			}
		} while (opcao != 0);
	}

}
