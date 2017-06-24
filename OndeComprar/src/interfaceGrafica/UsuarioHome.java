package interfaceGrafica;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import programa.Fachada;
import programa.Produto;
import programa.Usuario;

import javax.swing.JLabel;
import java.awt.event.MouseMotionAdapter;
import java.util.Calendar;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;
import javax.swing.JTextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Toolkit;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.UIManager;

public class UsuarioHome extends JFrame {

	private JPanel contentPane;
	JLabel lblOpcao = new JLabel("");
	JLabel lblOpcao2 = new JLabel("");
	JLabel lblOpcao3 = new JLabel("");
	JLabel lblEditarPerfil = new JLabel("");
	JLabel lblSair = new JLabel("");
	JLabel lblPesquisarprodutos = new JLabel("");
	JLabel lblPesquisarprodutos2 = new JLabel("");
	private JTextField txtCampoPesquisa;
	private final JLabel lblMais = new JLabel("");
	private final JLabel lblMais2 = new JLabel("");
	JTable table;
	JTable table2;
	JLabel lblPendentes = new JLabel("0");
	JLabel lblAceitas = new JLabel("0");
	JLabel lblRecusadas = new JLabel("0");
	private final JLabel lblNickname = new JLabel("");
	private final JLabel lblPromoAtivas = new JLabel("0");
	private JLabel lblPromoAcabando = new JLabel("0");
	Calendar date = Calendar.getInstance();;
	String dataAtual = date.get(Calendar.DAY_OF_MONTH) + "/" + (date.get(Calendar.MONTH)+1) + "/" + date.get(Calendar.YEAR);
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UsuarioHome usuarioHome = new UsuarioHome();
					usuarioHome.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public UsuarioHome() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(UsuarioHome.class.getResource("/img/favicon.png")));
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 752, 460);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		this.setLocationRelativeTo(null); // JANELA FICA NO CENTRO
		lblNickname.setForeground(SystemColor.control);
		
		// NICKNAME
		lblNickname.setBounds(630, 9, 92, 25);
		contentPane.add(lblNickname);
		// FIM NICKNAME
		
		//CONTA 2
		ImageIcon conta3 = new ImageIcon(UsuarioHome.class.getResource("/img/usuarioHome/conta_bt3.png"));
		JLabel lblConta3 = new JLabel("");
		lblConta3.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				getContentPane().setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
		});
		lblConta3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				lblConta3.setVisible(false);
				lblOpcao.setVisible(false);
				lblEditarPerfil.setVisible(false);
				lblSair.setVisible(false);
			}
		});
		lblConta3.setBounds(582, 0, 165, 44);
		Image imgConta3 = conta3.getImage().getScaledInstance(lblConta3.getWidth(), lblConta3.getHeight(), Image.SCALE_SMOOTH);
		lblConta3.setIcon(new ImageIcon(imgConta3));
		contentPane.add(lblConta3);
		lblConta3.setVisible(false);
		//FIM CONTA
		
		//CONTA 2
		ImageIcon conta2 = new ImageIcon(UsuarioHome.class.getResource("/img/usuarioHome/conta_bt2.png"));
		JLabel lblConta2 = new JLabel("");
		lblConta2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				lblConta3.setVisible(true);
				lblOpcao.setVisible(true);
				lblEditarPerfil.setVisible(true);
				lblSair.setVisible(true);
			}
		});
		lblConta2.setBounds(582, 0, 165, 44);
		Image imgConta2 = conta2.getImage().getScaledInstance(lblConta2.getWidth(), lblConta2.getHeight(), Image.SCALE_SMOOTH);
		lblConta2.setIcon(new ImageIcon(imgConta2));
		contentPane.add(lblConta2);
		lblConta2.setVisible(false);
		//FIM CONTA
		
		//CONTA
		ImageIcon conta = new ImageIcon(UsuarioHome.class.getResource("/img/usuarioHome/conta_bt1.png"));
		JLabel lblConta = new JLabel("");
		lblConta.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent arg0) {
				lblConta2.setVisible(true);
				getContentPane().setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
		});
		lblConta.setBounds(582, 0, 165, 44);
		Image imgConta = conta.getImage().getScaledInstance(lblConta.getWidth(), lblConta.getHeight(), Image.SCALE_SMOOTH);
		lblConta.setIcon(new ImageIcon(imgConta));
		contentPane.add(lblConta);
		//FIM CONTA
		
		//EDITAR PERFIL
		lblEditarPerfil.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				lblOpcao2.setVisible(true);
				lblOpcao3.setVisible(false);
				getContentPane().setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
		});
		lblEditarPerfil.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				UsuarioConta frame3 = new UsuarioConta(); frame3.setVisible(true);
				frame3.receber(Fachada.getInstance().buscarUsuario(lblNickname.getText()));
				dispose();
			}
		});
		lblEditarPerfil.setBounds(592, 55, 146, 33);
		contentPane.add(lblEditarPerfil);
		lblEditarPerfil.setVisible(false);
		//FIM EDITAR PERFIL
		
		//SAIR
		lblSair.setBounds(592, 89, 145, 33);
		lblSair.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				lblOpcao3.setVisible(true);
				lblOpcao2.setVisible(false);
				getContentPane().setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
		});
		lblSair.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Login frame3 = new Login(); frame3.setVisible(true);
				dispose();
			}
		});
		contentPane.add(lblSair);
		lblSair.setVisible(false);
		//FIM SAIR
		
		//OPCAO 2
		ImageIcon opcao3 = new ImageIcon(UsuarioHome.class.getResource("/img/usuarioHome/conta_sair.png"));
		lblOpcao3.setBounds(591, 47, 147, 75);
		Image imgOpcao3 = opcao3.getImage().getScaledInstance(lblOpcao3.getWidth(), lblOpcao3.getHeight(), Image.SCALE_SMOOTH);
		lblOpcao3.setIcon(new ImageIcon(imgOpcao3));
		contentPane.add(lblOpcao3);
		lblOpcao3.setVisible(false);
		//FIM OPCAO 2
		
		//OPCAO 2
		ImageIcon opcao2 = new ImageIcon(UsuarioHome.class.getResource("/img/usuarioHome/conta_edit.png"));
		lblOpcao2.setBounds(591, 47, 147, 75);
		Image imgOpcao2 = opcao2.getImage().getScaledInstance(lblOpcao2.getWidth(), lblOpcao2.getHeight(), Image.SCALE_SMOOTH);
		lblOpcao2.setIcon(new ImageIcon(imgOpcao2));
		contentPane.add(lblOpcao2);
		lblOpcao2.setVisible(false);
		//FIM OPCAO 2
		
		//OPCAO
		ImageIcon opcao = new ImageIcon(UsuarioHome.class.getResource("/img/usuarioHome/conta_op.png"));
		lblOpcao.setBounds(591, 47, 147, 75);
		Image imgOpcao = opcao.getImage().getScaledInstance(lblOpcao.getWidth(), lblOpcao.getHeight(), Image.SCALE_SMOOTH);
		lblOpcao.setIcon(new ImageIcon(imgOpcao));
		contentPane.add(lblOpcao);
		lblOpcao.setVisible(false);
		//FIM OPCAO
		
		//PESQUISAR PRODUTOS
		ImageIcon pesquisar2 = new ImageIcon(UsuarioHome.class.getResource("/img/usuarioHome/pesquisar_bt2.png"));
		lblPesquisarprodutos2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				UsuarioCatalogo frame4 = new UsuarioCatalogo(); frame4.setVisible(true);
				frame4.receber(Fachada.getInstance().buscarUsuario(lblNickname.getText()));
				dispose();
			}
		});
		lblPesquisarprodutos2.setBounds(119, 53, 203, 46);
		Image imgPesquisar2 = pesquisar2.getImage().getScaledInstance(lblPesquisarprodutos2.getWidth(), lblPesquisarprodutos2.getHeight(), Image.SCALE_SMOOTH);
		lblPesquisarprodutos2.setIcon(new ImageIcon(imgPesquisar2));
		contentPane.add(lblPesquisarprodutos2);
		lblPesquisarprodutos2.setVisible(false);
		//FIM PESQUISAR PRODUTOS
		
		//PESQUISAR PRODUTOS
		ImageIcon pesquisar = new ImageIcon(UsuarioHome.class.getResource("/img/usuarioHome/pesquisar_bt1.png"));
		lblPesquisarprodutos.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				lblPesquisarprodutos2.setVisible(true);
				getContentPane().setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
		});
		lblPesquisarprodutos.setBounds(119, 53, 203, 46);
		Image imgPesquisar = pesquisar.getImage().getScaledInstance(lblPesquisarprodutos.getWidth(), lblPesquisarprodutos.getHeight(), Image.SCALE_SMOOTH);
		lblPesquisarprodutos.setIcon(new ImageIcon(imgPesquisar));
		contentPane.add(lblPesquisarprodutos);
		//FIM PESQUISAR PRODUTOS
		
		// CAMPO PESQUISA
		txtCampoPesquisa = new JTextField();
		txtCampoPesquisa.setForeground(SystemColor.controlDkShadow);
		txtCampoPesquisa.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				txtCampoPesquisa.setOpaque(true);
				arg0.getComponent().setBackground(new Color(246, 246, 246));
				
				char keyChar = arg0.getKeyChar();
				if (Character.isLowerCase(keyChar)) {
				      arg0.setKeyChar(Character.toUpperCase(keyChar));
				    }
			}
		});
		txtCampoPesquisa.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				txtCampoPesquisa.setOpaque(true);
				arg0.getComponent().setBackground(new Color(246, 246, 246));
			}
		});
		txtCampoPesquisa.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent arg0) {
				getContentPane().setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
			}
		});
		txtCampoPesquisa.setBounds(445, 60, 239, 33);
		contentPane.add(txtCampoPesquisa);
		txtCampoPesquisa.setColumns(10);
		txtCampoPesquisa.setOpaque(false);
		txtCampoPesquisa.setBorder(null);
		// FIM CAMPO PESQUISA
		
		//PESQ
		ImageIcon pesq2 = new ImageIcon(UsuarioHome.class.getResource("/img/usuarioHome/pesq_bt2.png"));
		JLabel lblPesq2 = new JLabel("");
		lblPesq2.setBounds(683, 56, 35, 39);
		Image imgPesq2 = pesq2.getImage().getScaledInstance(lblPesq2.getWidth(), lblPesq2.getHeight(), Image.SCALE_SMOOTH);
		lblPesq2.setIcon(new ImageIcon(imgPesq2));
		contentPane.add(lblPesq2);
		lblPesq2.setVisible(false);
		//FIM PESQ
		
		//PESQ
		ImageIcon pesq = new ImageIcon(UsuarioHome.class.getResource("/img/usuarioHome/pesq_bt1.png"));
		JLabel lblPesq = new JLabel("");
		lblPesq.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent arg0) {
				lblPesq2.setVisible(true);
				getContentPane().setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
		});
		lblPesq.setBounds(683, 56, 35, 39);
		Image imgPesq = pesq.getImage().getScaledInstance(lblPesq.getWidth(), lblPesq.getHeight(), Image.SCALE_SMOOTH);
		lblPesq.setIcon(new ImageIcon(imgPesq));
		contentPane.add(lblPesq);
		//FIM PESQ
		
		// MAIS 2
		ImageIcon mais2 = new ImageIcon(UsuarioHome.class.getResource("/img/usuarioHome/mais_bt2.png"));
		lblMais2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				UsuarioCatalogo frame4 = new UsuarioCatalogo(); frame4.setVisible(true);
				frame4.receber(Fachada.getInstance().buscarUsuario(lblNickname.getText()));
				dispose();
			}
		});
		lblMais2.setBounds(1, 390, 98, 29);
		Image imgMais2 = mais2.getImage().getScaledInstance(lblMais2.getWidth(), lblMais2.getHeight(), Image.SCALE_SMOOTH);
		lblMais2.setIcon(new ImageIcon(imgMais2));
		contentPane.add(lblMais2);
		lblMais2.setVisible(false);
		// FIM MAIS 2
		
		// MAIS
		ImageIcon mais = new ImageIcon(UsuarioHome.class.getResource("/img/usuarioHome/mais_bt1.png"));
		lblMais.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				lblMais2.setVisible(true);
				getContentPane().setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
		});
		lblMais.setBounds(1, 390, 98, 29);
		Image imgMais = mais.getImage().getScaledInstance(lblMais.getWidth(), lblMais.getHeight(), Image.SCALE_SMOOTH);
		lblMais.setIcon(new ImageIcon(imgMais));
		contentPane.add(lblMais);
		// FIM MAIS
		
		// TABELA PROMOCAO
		JScrollPane scrollPane2 = new JScrollPane();
		scrollPane2.setBounds(127, 135, 273, 217);
		contentPane.add(scrollPane2);
		table2 = new JTable();
		scrollPane2.setViewportView(table2);
		// FIM TABELA PROMOCAO
		
		// TABELA
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(442, 135, 273, 217);
		contentPane.add(scrollPane);
		table = new JTable();
		scrollPane.setViewportView(table);
		// FIM TABELA
		
		// RECUSADAS
		lblRecusadas.setForeground(UIManager.getColor("Button.shadow"));
		lblRecusadas.setFont(new Font("SansSerif", Font.BOLD, 35));
		lblRecusadas.setBounds(640, 370, 73, 33);
		contentPane.add(lblRecusadas);
		// FIM RECUSADAS
		
		// ACEITAS
		lblAceitas.setForeground(UIManager.getColor("Button.shadow"));
		lblAceitas.setFont(new Font("SansSerif", Font.BOLD, 35));
		lblAceitas.setBounds(553, 370, 73, 33);
		contentPane.add(lblAceitas);
		// FIM ACEITAS
		
		// PENDENTES
		lblPendentes.setForeground(UIManager.getColor("Button.shadow"));
		lblPendentes.setFont(new Font("SansSerif", Font.BOLD, 35));
		lblPendentes.setBounds(445, 370, 73, 33);
		contentPane.add(lblPendentes);
		lblNickname.setFont(new Font("SansSerif", Font.PLAIN, 17));
		// FIM PENDENTES
		
		// PROMO ACABANDO
		lblPromoAcabando.setForeground(SystemColor.controlShadow);
		lblPromoAcabando.setFont(new Font("SansSerif", Font.BOLD, 35));
		lblPromoAcabando.setBounds(287, 370, 73, 33);
		lblPromoAcabando.setForeground(new Color(149, 152, 154));
		contentPane.add(lblPromoAcabando);
		// FIM PROMO ACABANDO
		
		// PROMO ATIVAS
		lblPromoAtivas.setForeground(SystemColor.controlShadow);
		lblPromoAtivas.setFont(new Font("SansSerif", Font.BOLD, 35));
		lblPromoAtivas.setBounds(129, 370, 73, 33);
		lblPromoAtivas.setForeground(new Color(149, 152, 154));
		contentPane.add(lblPromoAtivas);
		// FIM PROMO ATIVAS
		
		//BG
		ImageIcon background = new ImageIcon(UsuarioHome.class.getResource("/img/usuarioHome/Usuario_Home.png"));
		JLabel lblBg = new JLabel("");
		lblBg.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				lblConta2.setVisible(false);
				lblOpcao2.setVisible(false);
				lblOpcao3.setVisible(false);
				lblPesquisarprodutos2.setVisible(false);
				lblPesq2.setVisible(false);
				lblMais2.setVisible(false);
				getContentPane().setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
			}
		});
		lblBg.setBounds(0, 0, 747, 431);
		Image imagem = background.getImage().getScaledInstance(lblBg.getWidth(), lblBg.getHeight(), Image.SCALE_SMOOTH);
		lblBg.setIcon(new ImageIcon(imagem));
		contentPane.add(lblBg);
		//FIM BG
		
	}
	
	public void receber (Usuario user){
		table.setModel(Fachada.getInstance().listarReservasUser(user.getId()));
		table2.setModel(Fachada.getInstance().listarPromocoesUser(user.getId()));
		lblNickname.setText(user.getNome());
		
		table2.getColumnModel().getColumn(0).setPreferredWidth(30);
		table2.getColumnModel().getColumn(1).setPreferredWidth(140); 
		table2.getColumnModel().getColumn(2).setPreferredWidth(180); 
		table2.getColumnModel().getColumn(3).setPreferredWidth(100);
		table2.getColumnModel().getColumn(4).setPreferredWidth(80);
		
		table.getColumnModel().getColumn(0).setPreferredWidth(30);
		table.getColumnModel().getColumn(1).setPreferredWidth(80); 
		table.getColumnModel().getColumn(2).setPreferredWidth(120); 
		table.getColumnModel().getColumn(3).setPreferredWidth(80);
		
		lblPendentes.setText(String.valueOf(Fachada.getInstance().reservasPendentesUser(user.getId())));
		lblAceitas.setText(String.valueOf(Fachada.getInstance().reservasAceitasUser(user.getId())));
		lblRecusadas.setText(String.valueOf(Fachada.getInstance().reservasRecusadasUser(user.getId())));
		lblPendentes.setForeground(new Color(149, 152, 154));
		lblAceitas.setForeground(new Color(149, 152, 154));
		lblRecusadas.setForeground(new Color(149, 152, 154));
		lblPromoAtivas.setText(String.valueOf(Fachada.getInstance().promocoesAtivas(dataAtual)));
		lblPromoAcabando.setText(String.valueOf(Fachada.getInstance().promocoesAcabando(dataAtual)));
	}
}
