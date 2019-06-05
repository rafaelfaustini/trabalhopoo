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
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JRadioButton;
import javax.swing.JToggleButton;
import javax.swing.JTextPane;
import javax.swing.JSpinner;
import javax.swing.JList;
import javax.swing.JPasswordField;
import javax.swing.JTree;
import javax.swing.JProgressBar;
import javax.swing.JSeparator;
import javax.swing.JSlider;
import javax.swing.JTextArea;
import javax.swing.JTable;


public class InterfaceApp extends JFrame {

	private JPanel contentPane;
	
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
		setBounds(100, 100, 446, 351);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblSelecioneUmaOpo = new JLabel("Selecione uma op\u00E7\u00E3o abaixo");
		lblSelecioneUmaOpo.setFont(new Font("Arial", Font.BOLD, 28));
		
		JButton btnCadastrarCliente = new JButton("Cadastrar Cliente");
		btnCadastrarCliente.setFont(new Font("Arial", Font.PLAIN, 13));
		btnCadastrarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
		JButton btnListarClientes = new JButton("Listar Clientes");
		btnListarClientes.setFont(new Font("Arial", Font.PLAIN, 13));
		btnListarClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		
		JButton btnsair = new JButton("Sair");
		btnsair.setFont(new Font("Arial", Font.PLAIN, 13));
		
		JList list = new JList();
		
		JList list_1 = new JList();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(82)
					.addComponent(list_1)
					.addGap(83)
					.addComponent(list, GroupLayout.PREFERRED_SIZE, 1, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(255, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(lblSelecioneUmaOpo)
					.addContainerGap(24, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(btnCadastrarCliente, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 303, Short.MAX_VALUE)
						.addComponent(btnListarClientes, GroupLayout.DEFAULT_SIZE, 303, Short.MAX_VALUE)
						.addComponent(btnsair, GroupLayout.DEFAULT_SIZE, 303, Short.MAX_VALUE))
					.addGap(27))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(35)
					.addComponent(lblSelecioneUmaOpo)
					.addGap(70)
					.addComponent(btnCadastrarCliente)
					.addGap(18)
					.addComponent(btnListarClientes)
					.addGap(18)
					.addComponent(btnsair)
					.addGap(56)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(list_1)
						.addComponent(list, GroupLayout.PREFERRED_SIZE, 1, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(88, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
}