package interfaceGrafica;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DataBase.BancoDeDados;
import programa.Produto;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class InserirProduto extends JFrame {

	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField txtMarca;
	private JTextField txtPreco;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InserirProduto frame = new InserirProduto();
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
	public InserirProduto() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(10, 11, 46, 14);
		contentPane.add(lblNome);
		
		txtNome = new JTextField();
		txtNome.setBounds(64, 8, 86, 20);
		contentPane.add(txtNome);
		txtNome.setColumns(10);
		
		JLabel lblMarca = new JLabel("Marca:");
		lblMarca.setBounds(10, 36, 46, 14);
		contentPane.add(lblMarca);
		
		txtMarca = new JTextField();
		txtMarca.setBounds(64, 33, 86, 20);
		contentPane.add(txtMarca);
		txtMarca.setColumns(10);
		
		JLabel lblPreo = new JLabel("Pre\u00E7o:");
		lblPreo.setBounds(10, 61, 46, 14);
		contentPane.add(lblPreo);
		
		txtPreco = new JTextField();
		txtPreco.setBounds(64, 58, 86, 20);
		contentPane.add(txtPreco);
		txtPreco.setColumns(10);
		
		JButton btnAdicionar = new JButton("Adicionar");
		btnAdicionar.addActionListener(new ActionListener() { //estudar como encapsular isto da maneira correta
			public void actionPerformed(ActionEvent arg0) {
				Produto produto = new Produto();
				produto.setNome(txtNome.getText());
				produto.setMarca(txtMarca.getText());
				produto.setPreco(Float.parseFloat(txtPreco.getText()));
				
				BancoDeDados bancoDeDados = new BancoDeDados();
				bancoDeDados.conectar();
				if(bancoDeDados.estaConectado()){
					bancoDeDados.inserirProduto(produto);
					bancoDeDados.desconectar();
					JOptionPane.showMessageDialog(null, "Produto cadastrado com sucesso!");
				} else {
					JOptionPane.showMessageDialog(null, "Não foi posível conectar ao banco de dados!");
				}
			}
		});
		btnAdicionar.setBounds(64, 89, 89, 23);
		contentPane.add(btnAdicionar);
	}
}
