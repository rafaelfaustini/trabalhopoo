package net.codejava.swing;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JTabbedPane;
import javax.swing.JToolBar;
import javax.swing.JDesktopPane;


public class InterfaceApp extends JFrame {

	private JPanel contentPane;
	private JTextField input;
	
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
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterfaceApp frame = new InterfaceApp();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public InterfaceApp() {
		setTitle("Informa\u00E7\u00F5es de clientes");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 711, 156);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JLabel lblpleaseEnterncadastrar = new JLabel("\"Please enter 1-3\\n1.Cadastrar cliente\\n2.Ver clientes\\n3.Sair\"");
		lblpleaseEnterncadastrar.setFont(new Font("Verdana", Font.PLAIN, 17));
		contentPane.add(lblpleaseEnterncadastrar, BorderLayout.NORTH);
		
		input = new JTextField();
		contentPane.add(input, BorderLayout.CENTER);
		input.setColumns(10);
		
		JButton btnEnviar = new JButton("Enviar");//Botao Enviar
		btnEnviar.setFont(new Font("Verdana", Font.PLAIN, 13));
		btnEnviar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				//System.out.println(input.getText());//Teste
				String check = input.getText();
				 switch (check)
		            {
		            case "1" :
		             InterfaceCadastro frame = new InterfaceCadastro();
		             
		             frame.setVisible(true);
		            
		            case "2" :
		            	try {
		            		listar_cliente();
		            	} catch (Exception e) {
						
		            		e.printStackTrace();
					}
		                break;
		            case "3" :
		                System.exit(0);
		               break;
		                
		            /*default:
		            	//menu(); Não entrendo o uso do menu no código do trabalho 1
		            	break;*/
		            }
		            if(check == "-1") {
		            	//menu(); Não entrendo o uso do menu no código do trabalho 1
		            }
				}   
		           
			
		});
		contentPane.add(btnEnviar, BorderLayout.SOUTH);
	}

}
