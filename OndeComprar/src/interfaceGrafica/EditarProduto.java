package interfaceGrafica;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import interfaces.IBancoDeDados;
import programa.Produto;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DataBase.BancoDeDados;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EditarProduto extends JFrame {

	private JPanel contentPane;
	private JTextField txtPreco;
	private JTextField txtMarca;
	private JTextField txtNome;
	private JTextField txtId;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EditarProduto frame = new EditarProduto();
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
	public EditarProduto() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(10, 68, 46, 14);
		contentPane.add(lblNome);
		
		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				BancoDeDados banco = new BancoDeDados();
				Produto produto = new Produto();
				
				banco.conectar();
				if(banco.estaConectado()){
					produto.setId(Integer.parseInt(txtId.getText()));
					produto.setMarca(txtMarca.getText());
					produto.setNome(txtNome.getText());
					produto.setPreco(Float.parseFloat(txtPreco.getText()));
					banco.atualizarProduto(produto);
					banco.desconectar();
					JOptionPane.showConfirmDialog(null, "Produto atualizado com sucesso!");
				} else {
					JOptionPane.showMessageDialog(null, "Não foi posível conectar ao banco de dados!");
				}
			}
		});
		btnAtualizar.setBounds(64, 146, 89, 23);
		contentPane.add(btnAtualizar);
		
		txtPreco = new JTextField();
		txtPreco.setColumns(10);
		txtPreco.setBounds(64, 115, 86, 20);
		contentPane.add(txtPreco);
		
		txtMarca = new JTextField();
		txtMarca.setColumns(10);
		txtMarca.setBounds(64, 90, 86, 20);
		contentPane.add(txtMarca);
		
		txtNome = new JTextField();
		txtNome.setColumns(10);
		txtNome.setBounds(64, 65, 86, 20);
		contentPane.add(txtNome);
		
		JLabel label = new JLabel("Pre\u00E7o:");
		label.setBounds(10, 118, 46, 14);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("Marca:");
		label_1.setBounds(10, 93, 46, 14);
		contentPane.add(label_1);
		
		JLabel lblDigiteOid = new JLabel("Digite o 'id' do produto que deseja editar:");
		lblDigiteOid.setBounds(10, 24, 198, 14);
		contentPane.add(lblDigiteOid);
		
		txtId = new JTextField();
		txtId.setBounds(218, 21, 46, 20);
		contentPane.add(txtId);
		txtId.setColumns(10);
		
		JButton btnCarregar = new JButton("Carregar");
		btnCarregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				BancoDeDados banco = new BancoDeDados(); //Ver como fazer isso depois que criar a fachada (aaaaa, muita coisa)
				Produto produto = new Produto();
				banco.conectar();
				//implementar: quando clicar em carregar o Jtext do id deixa de ser editavel e o btnCarregar muda o texto para "Editar outro" que ao clicar libera a edição e apaga os outros campos
				if(banco.estaConectado()){
					produto = banco.buscarProduto(Integer.parseInt(txtId.getText()));
					txtNome.setText(produto.getNome());
					txtMarca.setText(produto.getMarca());
					txtPreco.setText(String.valueOf(produto.getPreco()));
					banco.desconectar();
				} else {
					JOptionPane.showMessageDialog(null, "Não foi posível conectar ao banco de dados!");
				}
			}
		});
		btnCarregar.setBounds(284, 20, 89, 23);
		contentPane.add(btnCarregar);
	}
}
