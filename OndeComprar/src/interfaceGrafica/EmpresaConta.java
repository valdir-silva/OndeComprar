package interfaceGrafica;

import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.SystemColor;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import programa.Endereco;
import programa.Fachada;
import programa.Cliente;

import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

public class EmpresaConta extends JFrame {

	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField txtCnpj;
	private JTextField txtEmail;
	private JTextField txtTelefone;
	private JTextField txtSenhaAtual;
	private JTextField txtNovaSenha;
	private JTextField txtCep;
	private JTextField txtCidade;
	private JTextField txtEstado;
	private JTextField txtEndereco;
	private JLabel lblAlterar;
	private JLabel lblAlterar2;
	private JLabel lblApagar;
	private JLabel lblApagar2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EmpresaConta frame = new EmpresaConta();
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
	public EmpresaConta() {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(EmpresaConta.class.getResource("/img/favicon.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 742, 453);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
this.setLocationRelativeTo(null); // JANELA FICA NO CENTRO
		
		//VOLTAR 2
		ImageIcon voltar2 = new ImageIcon(EmpresaConta.class.getResource("/img/empresaConta/voltar_bt2.png"));
		JLabel lblVoltar2 = new JLabel("");
		lblVoltar2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				EmpresaHome frame6 = new EmpresaHome(); frame6.setVisible(true);
				frame6.receber(Fachada.getInstance().buscarEmpresa(txtNome.getText()));
				dispose();
			}
		});
		lblVoltar2.setBounds(23, 5, 93, 33);
		Image imgVoltar2 = voltar2.getImage().getScaledInstance(lblVoltar2.getWidth(), lblVoltar2.getHeight(), Image.SCALE_SMOOTH);
		contentPane.setLayout(null);
		lblVoltar2.setIcon(new ImageIcon(imgVoltar2));
		contentPane.add(lblVoltar2);
		lblVoltar2.setVisible(false);
		//FIM VOLTAR 2
		
		//VOLTAR
		ImageIcon voltar = new ImageIcon(EmpresaConta.class.getResource("/img/empresaConta/voltar_bt1.png"));
		JLabel lblVoltar = new JLabel("");
		lblVoltar.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				lblVoltar2.setVisible(true);
				getContentPane().setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
		});
		lblVoltar.setBounds(23, 5, 93, 33);
		Image imgVoltar = voltar.getImage().getScaledInstance(lblVoltar.getWidth(), lblVoltar.getHeight(), Image.SCALE_SMOOTH);
		lblVoltar.setIcon(new ImageIcon(imgVoltar));
		contentPane.add(lblVoltar);
		// FIM ENDERECO
		
		// ENDERECO
		txtEndereco = new JTextField();
		txtEndereco.setForeground(SystemColor.controlDkShadow);
		txtEndereco.setBounds(417, 178, 166, 20);
		contentPane.add(txtEndereco);
		txtEndereco.setColumns(10);
		txtEndereco.setOpaque(false);
		txtEndereco.setBorder(null);
		// FIM ENDERECO
		
		// ESTADO
		txtEstado = new JTextField();
		txtEstado.setForeground(SystemColor.controlDkShadow);
		txtEstado.setBounds(610, 136, 70, 20);
		contentPane.add(txtEstado);
		txtEstado.setColumns(10);
		txtEstado.setOpaque(false);
		txtEstado.setBorder(null);
		// FIM ESTADO
		
		// CIDADE
		txtCidade = new JTextField();
		txtCidade.setForeground(SystemColor.controlDkShadow);
		txtCidade.setBounds(513, 136, 70, 20);
		contentPane.add(txtCidade);
		txtCidade.setColumns(10);
		txtCidade.setOpaque(false);
		txtCidade.setBorder(null);
		// FIM CIDADE
		
		// CEP
		txtCep = new JTextField();
		txtCep.setForeground(SystemColor.controlDkShadow);
		txtCep.setBounds(417, 136, 70, 20);
		contentPane.add(txtCep);
		txtCep.setColumns(10);
		txtCep.setOpaque(false);
		txtCep.setBorder(null);
		// FIM CEP
		
		// NOVA SENHA
		txtNovaSenha = new JTextField();
		txtNovaSenha.setForeground(SystemColor.controlDkShadow);
		txtNovaSenha.setBounds(102, 357, 210, 20);
		contentPane.add(txtNovaSenha);
		txtNovaSenha.setColumns(10);
		txtNovaSenha.setOpaque(false);
		txtNovaSenha.setBorder(null);
		// FIM NOVA SENHA
		
		// SENHA ATUAL
		txtSenhaAtual = new JTextField();
		txtSenhaAtual.setForeground(SystemColor.controlDkShadow);
		txtSenhaAtual.setBounds(102, 330, 210, 20);
		contentPane.add(txtSenhaAtual);
		txtSenhaAtual.setColumns(10);
		txtSenhaAtual.setOpaque(false);
		txtSenhaAtual.setBorder(null);
		// FIM SENHA ATUAL
		
		// TELEFONE
		txtTelefone = new JTextField();
		txtTelefone.setForeground(SystemColor.controlDkShadow);
		txtTelefone.setBounds(46, 276, 280, 20);
		contentPane.add(txtTelefone);
		txtTelefone.setColumns(10);
		txtTelefone.setOpaque(false);
		txtTelefone.setBorder(null);
		// FIM TELEFONE
		
		// EMAIL
		txtEmail = new JTextField();
		txtEmail.setForeground(SystemColor.controlDkShadow);
		txtEmail.setBounds(46, 238, 280, 20);
		contentPane.add(txtEmail);
		txtEmail.setColumns(10);
		txtEmail.setOpaque(false);
		txtEmail.setBorder(null);
		// FIM EMAIL
		
		// CNPJ
		txtCnpj = new JTextField();
		txtCnpj.setEditable(false);
		txtCnpj.setForeground(SystemColor.controlDkShadow);
		txtCnpj.setBounds(46, 201, 280, 20);
		contentPane.add(txtCnpj);
		txtCnpj.setColumns(10);
		txtCnpj.setOpaque(false);
		txtCnpj.setBorder(null);
		// FIM CNPJ
		
		// NOME
		txtNome = new JTextField();
		txtNome.setEditable(false);
		txtNome.setForeground(SystemColor.controlDkShadow);
		txtNome.setBounds(46, 165, 280, 20);
		contentPane.add(txtNome);
		txtNome.setColumns(10);
		txtNome.setOpaque(false);
		txtNome.setBorder(null);
		// FIM NOME
		
		// APAGAR 2
		ImageIcon apagar2 = new ImageIcon(ClienteConta.class.getResource("/img/usuarioConta/apagar_bt2.png"));
		lblApagar2 = new JLabel("");
		lblApagar2.setBounds(379, 359, 158, 49);
		Image imgApagar2 = apagar2.getImage().getScaledInstance(lblApagar2.getWidth(), lblApagar2.getHeight(), Image.SCALE_SMOOTH);
		lblApagar2.setIcon(new ImageIcon(imgApagar2));
		contentPane.add(lblApagar2);
		lblApagar2.setVisible(false);
		// FIM APAGAR 2
		
		// APAGAR
		ImageIcon apagar = new ImageIcon(ClienteConta.class.getResource("/img/usuarioConta/apagar_bt1.png"));
		lblApagar = new JLabel("");
		lblApagar.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent arg0) {
				getContentPane().setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				lblApagar2.setVisible(true);
				lblAlterar2.setVisible(false);
			}
		});
		lblApagar.setBounds(379, 359, 158, 49);
		Image imgApagar = apagar.getImage().getScaledInstance(lblApagar.getWidth(), lblApagar.getHeight(), Image.SCALE_SMOOTH);
		lblApagar.setIcon(new ImageIcon(imgApagar));
		contentPane.add(lblApagar);
		// FIM APAGAR
		
		// ALTERAR 2
		ImageIcon alterar2 = new ImageIcon(ClienteConta.class.getResource("/img/usuarioConta/alterar_bt2.png"));
		lblAlterar2 = new JLabel("");
		lblAlterar2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Cliente usuario = new Cliente();
			
				usuario.setNome(txtNome.getText());
				usuario.setId(Fachada.getInstance().buscarUsuario(usuario.getNome()).getId());
				usuario.setEmail(txtEmail.getText());
				usuario.setTelefone(txtTelefone.getText());
				//usuario.setCep(txtCep.getText());
				//usuario.setCidade(txtCidade.getText());
				//usuario.setEstado(txtEstado.getText());
				//usuario.setRua(txtEndereco.getText());
				//usuario.setEndereco_id(Fachada.getInstance().buscarUsuario(usuario.getNome()).getEndereco_id());
				
				Fachada.getInstance().atualizarUsuario(usuario);
				
			}
		});
		lblAlterar2.setBounds(537, 359, 184, 49);
		Image imgAlterar2 = alterar2.getImage().getScaledInstance(lblAlterar2.getWidth(), lblAlterar2.getHeight(), Image.SCALE_SMOOTH);
		lblAlterar2.setIcon(new ImageIcon(imgAlterar2));
		contentPane.add(lblAlterar2);
		lblAlterar2.setVisible(false);
		// FIM ALTERAR 2
		
		// ALTERAR
		ImageIcon alterar = new ImageIcon(ClienteConta.class.getResource("/img/usuarioConta/alterar_bt1.png"));
		lblAlterar = new JLabel("");
		lblAlterar.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent arg0) {
				getContentPane().setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				lblAlterar2.setVisible(true);
				lblApagar2.setVisible(false);
			}
		});
		lblAlterar.setBounds(537, 359, 184, 49);
		Image imgAlterar = alterar.getImage().getScaledInstance(lblAlterar.getWidth(), lblAlterar.getHeight(), Image.SCALE_SMOOTH);
		lblAlterar.setIcon(new ImageIcon(imgAlterar));
		contentPane.add(lblAlterar);
		// FIM ALTERAR
		
		//BG
		ImageIcon background = new ImageIcon(EmpresaConta.class.getResource("/img/empresaConta/Empresa_Conta.png"));
		JLabel lblBg = new JLabel("");
		lblBg.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				lblVoltar2.setVisible(false);
				lblAlterar2.setVisible(false);
				lblApagar2.setVisible(false);
				getContentPane().setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
			}
		});
		lblBg.setBounds(0, 0, 736, 421);
		Image imagem = background.getImage().getScaledInstance(lblBg.getWidth(), lblBg.getHeight(), Image.SCALE_SMOOTH);
		lblBg.setIcon(new ImageIcon(imagem));
		contentPane.add(lblBg);
		//FIM BG
	}
	public void receber(Cliente user){
		Endereco endereco = new Endereco();
		
		txtNome.setText(user.getNome());
		txtEmail.setText(user.getEmail());
		txtTelefone.setText(user.getTelefone());
		txtSenhaAtual.setText(user.getSenha());
		
		//endereco = Fachada.getInstance().buscarEndereco(user.getEndereco_id());
		txtCep.setText(endereco.getCep());
		txtCidade.setText(endereco.getCidade());
		txtEstado.setText(endereco.getEstado());
		txtEndereco.setText(endereco.getRua());
	}
}
