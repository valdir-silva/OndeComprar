package interfaceGrafica;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
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
			}
		});
		btnCarregar.setBounds(284, 20, 89, 23);
		contentPane.add(btnCarregar);
	}
}
