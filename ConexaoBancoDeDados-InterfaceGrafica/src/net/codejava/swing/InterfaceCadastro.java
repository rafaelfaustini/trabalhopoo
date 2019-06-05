package net.codejava.swing;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.border.CompoundBorder;
import javax.swing.UIManager;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class InterfaceCadastro extends JFrame {

	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField txtCPF;
	private JTextField txtTEL;
	private String nome;//Campo adicionado manualmente
	private int cpf;//Campo adicionado manualmente
	private int telefone;//Campo adicionado manualmente
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterfaceCadastro frame = new InterfaceCadastro();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public void Construtor(JTextField txtNome,JTextField txtCPF,JTextField txtTEL) throws SQLException {
        Conexao con = new Conexao();
        String query = "INSERT INTO Cliente(nome, cpf, telefone) VALUES ('" + txtNome.getText() + "','" + Integer.parseInt(txtCPF.getText()) + "','" + Integer.parseInt(txtTEL.getText()) + "')";
        Statement st = con.conexao.createStatement();
        st.executeUpdate(query);
        }
		
	public InterfaceCadastro() {	
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(230, 230, 250));
		contentPane.setBorder(UIManager.getBorder("Button.border"));
		setContentPane(contentPane);
		
		JLabel lblCadastroDoCliente = new JLabel("Cadastro do Cliente");
		lblCadastroDoCliente.setFont(new Font("Arial", Font.BOLD, 28));
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBackground(new Color(169, 169, 169));
		lblNome.setFont(new Font("Cambria Math", Font.BOLD, 18));
		
		txtNome = new JTextField();
		txtNome.setColumns(10);
		
		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setFont(new Font("Cambria Math", Font.BOLD, 18));
		
		txtCPF = new JTextField();
		txtCPF.setColumns(10);
		
		JLabel lblTel = new JLabel("TEL:");
		lblTel.setFont(new Font("Cambria Math", Font.BOLD, 18));
		
		txtTEL = new JTextField();
		txtTEL.setColumns(10);
		
		JButton btnEnviar = new JButton("ENVIAR");
        btnEnviar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    Construtor(txtNome , txtCPF , txtTEL);
                    dispose();
                    JOptionPane.showMessageDialog(null,"Cadastro realizado com sucesso!");
                    System.exit(0);
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
        });
		btnEnviar.setBackground(new Color(255, 255, 224));
		btnEnviar.setForeground(new Color(0, 0, 0));
		btnEnviar.setFont(new Font("Arial", Font.BOLD, 16));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap(95, Short.MAX_VALUE)
					.addComponent(lblCadastroDoCliente)
					.addGap(78))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(34)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblNome)
						.addComponent(lblCpf)
						.addComponent(lblTel))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(txtTEL, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtCPF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtNome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(161, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap(183, Short.MAX_VALUE)
					.addComponent(btnEnviar)
					.addGap(162))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(lblCadastroDoCliente)
					.addGap(30)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNome)
						.addComponent(txtNome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCpf)
						.addComponent(txtCPF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblTel)
						.addComponent(txtTEL, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(34)
					.addComponent(btnEnviar)
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
		
		
	}
	
	
}