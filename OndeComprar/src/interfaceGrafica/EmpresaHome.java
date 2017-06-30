package interfaceGrafica;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import programa.Empresa;
import programa.Fachada;
import programa.Produto;
import programa.Reserva;
import programa.Cliente;

import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.text.DecimalFormat;
import java.util.Calendar;
import java.awt.event.MouseAdapter;
import java.awt.SystemColor;
import javax.swing.JTextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class EmpresaHome extends JFrame {

	private JPanel contentPane;
	JTable table;
	JScrollPane scrollPane2 = new JScrollPane();
	JTable table2;
	JLabel lblOpcao = new JLabel("");
	JLabel lblOpcao2 = new JLabel("");
	JLabel lblOpcao3 = new JLabel("");
	JLabel lblEditarPerfil = new JLabel("");
	JLabel lblSair = new JLabel("");
	JLabel lblPesquisarprodutos = new JLabel("");
	JLabel lblPesquisarprodutos2 = new JLabel("");
	JLabel lblPendentes = new JLabel("0");
	JLabel lblAceitas = new JLabel("0");
	JLabel lblRecusadas = new JLabel("0");
	JLabel lblNome = new JLabel("");
	JLabel lblData = new JLabel("");
	JLabel lblDadosreserva = new JLabel("");
	JLabel lblBg = new JLabel("");
	JLabel lblFechar = new JLabel("");
	JLabel lblFechar2 = new JLabel("");
	JLabel lblCategoria = new JLabel("");
	JLabel lblPreco = new JLabel("");
	JLabel lblProduto = new JLabel("");
	JLabel lblEstoque = new JLabel("");
	JLabel lblAceitar = new JLabel("");
	JLabel lblAceitar2 = new JLabel("");
	JLabel lblAceitar3 = new JLabel("");
	JLabel lblRecusar = new JLabel("");
	JLabel lblRecusar2 = new JLabel("");
	JLabel lblPromoAtivas = new JLabel("0");
	JLabel lblPromoAcabando = new JLabel("0");
	Reserva reserva;
	Calendar date = Calendar.getInstance();;
	String dataAtual = date.get(Calendar.DAY_OF_MONTH) + "/" + (date.get(Calendar.MONTH)+1) + "/" + date.get(Calendar.YEAR);
	private JTextField txtCodigoProduto;
	private JTextField txtValidade;
	private JTextField txtNomeProduto;
	private JTextField txtPrecoProduto;
	private JTextField txtNovoPreco;
	private JTextField txtDesconto;
	private JLabel lblBuscarproduto = new JLabel("");
	private JLabel lblBuscarproduto2 = new JLabel("");
	private JLabel lblNickname = new JLabel("");
	JLabel lblApagar2 = new JLabel("");
	JLabel lblNovapromocao = new JLabel("");
	JLabel lblApagar = new JLabel("");
	JLabel lblSalvar = new JLabel("");
	private final JLabel lblCriarpromocao = new JLabel("");
	private JTextField txtCampoPesquisa;
	private final JLabel lblFiltrar = new JLabel("");
	private final JLabel lblFiltrar2 = new JLabel("");
	
	/**
	 * Launch the application
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EmpresaHome frame = new EmpresaHome();
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
	public EmpresaHome() {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(EmpresaHome.class.getResource("/img/favicon.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 743, 448);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		this.setLocationRelativeTo(null); // COLOCA A JANELA NO CENTRO DA TELA
		
		// CRIAR PROMOCAO
		lblCriarpromocao.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				getContentPane().setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
		});
		lblCriarpromocao.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				novaPromocao(true);
				txtValidade.setText(dataAtual);
			}
		});
				
		lblCriarpromocao.setBounds(255, 105, 111, 23);	
		contentPane.add(lblCriarpromocao);
		lblNickname.setFont(new Font("SansSerif", Font.PLAIN, 17));
		// FIM CRIAR PROMOCAO
		
		// NICKNAME
		lblNickname.setBounds(619, 9, 92, 25);
		lblNickname.setForeground(SystemColor.control);
		contentPane.add(lblNickname);
		// FIM NICKNAME
		
		//CONTA 3
		ImageIcon conta3 = new ImageIcon(EmpresaHome.class.getResource("/img/empresaHome/conta_bt3.png"));
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
		lblConta3.setBounds(571, 0, 165, 44);
		Image imgConta3 = conta3.getImage().getScaledInstance(lblConta3.getWidth(), lblConta3.getHeight(), Image.SCALE_SMOOTH);
		lblConta3.setIcon(new ImageIcon(imgConta3));
		contentPane.add(lblConta3);
		lblConta3.setVisible(false);
		//FIM CONTA 3
		
		//CONTA 2
		ImageIcon conta2 = new ImageIcon(EmpresaHome.class.getResource("/img/empresaHome/conta_bt2.png"));
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
		lblConta2.setBounds(571, 0, 165, 44);
		Image imgConta2 = conta2.getImage().getScaledInstance(lblConta2.getWidth(), lblConta2.getHeight(), Image.SCALE_SMOOTH);
		lblConta2.setIcon(new ImageIcon(imgConta2));
		contentPane.add(lblConta2);
		lblConta2.setVisible(false);
		//FIM CONTA 2
		
		//CONTA
		ImageIcon conta = new ImageIcon(EmpresaHome.class.getResource("/img/empresaHome/conta_bt1.png"));
		JLabel lblConta = new JLabel("");
		lblConta.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent arg0) {
				lblConta2.setVisible(true);
				getContentPane().setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
		});
		lblConta.setBounds(571, 0, 165, 44);
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
				EmpresaConta frame4 = new EmpresaConta(); frame4.setVisible(true);
				//frame4.receber(Fachada.getInstance().buscarEmpresa(lblNickname.getText()));
				dispose();
			}
		});
		lblEditarPerfil.setBounds(581, 55, 146, 33);
		contentPane.add(lblEditarPerfil);
		lblEditarPerfil.setVisible(false);
		//FIM EDITAR PERFIL
		
		//SAIR
		lblSair.setBounds(581, 89, 145, 33);
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
		
		//OPCAO 3
		ImageIcon opcao3 = new ImageIcon(EmpresaHome.class.getResource("/img/empresaHome/conta_sair.png"));
		lblOpcao3.setBounds(580, 47, 147, 75);
		Image imgOpcao3 = opcao3.getImage().getScaledInstance(lblOpcao3.getWidth(), lblOpcao3.getHeight(), Image.SCALE_SMOOTH);
		lblOpcao3.setIcon(new ImageIcon(imgOpcao3));
		contentPane.add(lblOpcao3);
		lblOpcao3.setVisible(false);
		//FIM OPCAO 3
		
		//OPCAO 2
		ImageIcon opcao2 = new ImageIcon(EmpresaHome.class.getResource("/img/empresaHome/conta_edit.png"));
		lblOpcao2.setBounds(580, 47, 147, 75);
		Image imgOpcao2 = opcao2.getImage().getScaledInstance(lblOpcao2.getWidth(), lblOpcao2.getHeight(), Image.SCALE_SMOOTH);
		lblOpcao2.setIcon(new ImageIcon(imgOpcao2));
		contentPane.add(lblOpcao2);
		lblOpcao2.setVisible(false);
		//FIM OPCAO 2
		
		//OPCAO
		ImageIcon opcao = new ImageIcon(EmpresaHome.class.getResource("/img/empresaHome/conta_op.png"));
		lblOpcao.setBounds(580, 47, 147, 75);
		Image imgOpcao = opcao.getImage().getScaledInstance(lblOpcao.getWidth(), lblOpcao.getHeight(), Image.SCALE_SMOOTH);
		lblOpcao.setIcon(new ImageIcon(imgOpcao));
		contentPane.add(lblOpcao);
		lblOpcao.setVisible(false);
		//FIM OPCAO
		
		//PESQUISAR PRODUTOS 2
		ImageIcon pesquisar2 = new ImageIcon(EmpresaHome.class.getResource("/img/empresaHome/pesquisar_bt2.png"));
		lblPesquisarprodutos2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				EmpresaProduto frame4 = new EmpresaProduto(); frame4.setVisible(true);
				//frame4.receber(Fachada.getInstance().buscarUsuario(lblNickname.getText()));
				dispose();
			}
		});
		lblPesquisarprodutos2.setBounds(118, 51, 203, 46);
		Image imgPesquisar2 = pesquisar2.getImage().getScaledInstance(lblPesquisarprodutos2.getWidth(), lblPesquisarprodutos2.getHeight(), Image.SCALE_SMOOTH);
		lblPesquisarprodutos2.setIcon(new ImageIcon(imgPesquisar2));
		contentPane.add(lblPesquisarprodutos2);
		lblPesquisarprodutos2.setVisible(false);
		//FIM PESQUISAR PRODUTOS 2
		
		//PESQUISAR PRODUTOS
		ImageIcon pesquisar = new ImageIcon(EmpresaHome.class.getResource("/img/empresaHome/pesquisar_bt1.png"));
		lblPesquisarprodutos.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				lblPesquisarprodutos2.setVisible(true);
				getContentPane().setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
		});
		lblPesquisarprodutos.setBounds(118, 51, 203, 46);
		Image imgPesquisar = pesquisar.getImage().getScaledInstance(lblPesquisarprodutos.getWidth(), lblPesquisarprodutos.getHeight(), Image.SCALE_SMOOTH);
		lblPesquisarprodutos.setIcon(new ImageIcon(imgPesquisar));
		contentPane.add(lblPesquisarprodutos);
		//FIM PESQUISAR PRODUTOS
		
		// DATOS PROMOCAO
		txtCodigoProduto = new JTextField();
		txtCodigoProduto.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				lblBuscarproduto2.setVisible(false);
				getContentPane().setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
			}
		});
		txtCodigoProduto.setBounds(450, 172, 95, 20);
		contentPane.add(txtCodigoProduto);
		txtCodigoProduto.setColumns(10);
		txtCodigoProduto.setOpaque(false);
		txtCodigoProduto.setBorder(null);
		
		txtValidade = new JTextField();
		txtValidade.setBounds(586, 172, 100, 20);
		contentPane.add(txtValidade);
		txtValidade.setColumns(10);
		txtValidade.setOpaque(false);
		txtValidade.setBorder(null);
		
		txtNomeProduto = new JTextField();
		txtNomeProduto.setEditable(false);
		txtNomeProduto.setBounds(450, 250, 230, 20);
		contentPane.add(txtNomeProduto);
		txtNomeProduto.setColumns(10);
		txtNomeProduto.setOpaque(false);
		txtNomeProduto.setBorder(null);
		
		txtPrecoProduto = new JTextField();
		txtPrecoProduto.setEditable(false);
		txtPrecoProduto.setBounds(450, 290, 95, 20);
		contentPane.add(txtPrecoProduto);
		txtPrecoProduto.setColumns(10);
		txtPrecoProduto.setOpaque(false);
		txtPrecoProduto.setBorder(null);
		
		txtNovoPreco = new JTextField();
		txtNovoPreco.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				
				if(arg0.getKeyCode() == KeyEvent.VK_ENTER){
					
						DecimalFormat df = new DecimalFormat("#.00");
						float precoNormal = Float.parseFloat(txtPrecoProduto.getText());
						float precoDesconto = Float.parseFloat(txtNovoPreco.getText());
						float desconto = 100 - ((precoDesconto*100)/precoNormal);
						txtDesconto.setText(df.format(desconto) + " %");
				}
			}
		});
		txtNovoPreco.setBounds(593, 290, 95, 20);
		contentPane.add(txtNovoPreco);
		txtNovoPreco.setColumns(10);
		txtNovoPreco.setOpaque(false);
		txtNovoPreco.setBorder(null);
		
		txtDesconto = new JTextField();
		txtDesconto.setEditable(false);
		txtDesconto.setBounds(529, 329, 80, 20);
		contentPane.add(txtDesconto);
		txtDesconto.setColumns(10);
		txtDesconto.setOpaque(false);
		txtDesconto.setBorder(null);
		
		ImageIcon buscarProduto2 = new ImageIcon(EmpresaHome.class.getResource("/img/empresaHome/buscarProduto_bt2.png"));
		lblBuscarproduto2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Produto produto = Fachada.getInstance().buscarProduto(Integer.parseInt(txtCodigoProduto.getText()));
				txtNomeProduto.setText(produto.getNome());
				txtPrecoProduto.setText(String.valueOf(produto.getPreco()));
			}
		});
		lblBuscarproduto2.setBounds(545, 172, 28, 21);
		Image imgBuscarProduto2 = buscarProduto2.getImage().getScaledInstance(lblBuscarproduto2.getWidth(), lblBuscarproduto2.getHeight(), Image.SCALE_SMOOTH);
		lblBuscarproduto2.setIcon(new ImageIcon(imgBuscarProduto2));
		contentPane.add(lblBuscarproduto2);
		lblBuscarproduto2.setVisible(false);
		
		ImageIcon buscarProduto = new ImageIcon(EmpresaHome.class.getResource("/img/empresaHome/buscarProduto_bt1.png"));
		lblBuscarproduto.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent arg0) {
				lblBuscarproduto2.setVisible(true);
				getContentPane().setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
		});
		lblBuscarproduto.setBounds(545, 172, 28, 21);
		Image imgBuscarProduto = buscarProduto.getImage().getScaledInstance(lblBuscarproduto.getWidth(), lblBuscarproduto.getHeight(), Image.SCALE_SMOOTH);
		lblBuscarproduto.setIcon(new ImageIcon(imgBuscarProduto));
		contentPane.add(lblBuscarproduto);
		
		ImageIcon salvar2 = new ImageIcon(EmpresaHome.class.getResource("/img/empresaHome/salvarPromo_bt2.png"));
		JLabel lblSalvar2 = new JLabel("");
		lblSalvar2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Fachada.getInstance().salvarPromocao(txtNovoPreco.getText(), txtValidade.getText(), txtCodigoProduto.getText());
				JOptionPane.showMessageDialog(null, "Promoção Salva");
			}
		});
		lblSalvar2.setBounds(575, 355, 137, 57);
		Image imgSalvar2 = salvar2.getImage().getScaledInstance(lblSalvar2.getWidth(), lblSalvar2.getHeight(), Image.SCALE_SMOOTH);
		lblSalvar2.setIcon(new ImageIcon(imgSalvar2));
		contentPane.add(lblSalvar2);
		lblSalvar2.setVisible(false);
		
		ImageIcon salvar = new ImageIcon(EmpresaHome.class.getResource("/img/empresaHome/salvarPromo_bt1.png"));
		lblSalvar.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				lblSalvar2.setVisible(true);
				lblApagar2.setVisible(false);
				getContentPane().setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
		});
		lblSalvar.setBounds(575, 355, 137, 57);
		Image imgSalvar = salvar.getImage().getScaledInstance(lblSalvar.getWidth(), lblSalvar.getHeight(), Image.SCALE_SMOOTH);
		lblSalvar.setIcon(new ImageIcon(imgSalvar));
		contentPane.add(lblSalvar);
		
		ImageIcon apagar2 = new ImageIcon(EmpresaHome.class.getResource("/img/empresaHome/apagarPromo_bt2.png"));
		lblApagar2.setBounds(428, 355, 148, 57);
		Image imgApagar2 = apagar2.getImage().getScaledInstance(lblApagar2.getWidth(), lblApagar2.getHeight(), Image.SCALE_SMOOTH);
		lblApagar2.setIcon(new ImageIcon(imgApagar2));
		contentPane.add(lblApagar2);
		lblApagar2.setVisible(false);
		
		ImageIcon apagar = new ImageIcon(EmpresaHome.class.getResource("/img/empresaHome/apagarPromo_bt1.png"));
		lblApagar.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				lblApagar2.setVisible(true);
				lblSalvar2.setVisible(false);
				getContentPane().setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
		});
		lblApagar.setBounds(428, 355, 148, 57);
		Image imgCancelar = apagar.getImage().getScaledInstance(lblApagar.getWidth(), lblApagar.getHeight(), Image.SCALE_SMOOTH);
		lblApagar.setIcon(new ImageIcon(imgCancelar));
		contentPane.add(lblApagar);
		
		lblFechar2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				novaPromocao(false);
				atualizarTabela();
				getContentPane().setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
			}
		});
		lblFechar2.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent arg0) {
				getContentPane().setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
		});
		lblFechar2.setBounds(685, 105, 22, 23);
		contentPane.add(lblFechar2);
		// FIM DADOS PROMOCAO
		
		//	NOVA PROMOCAO
		ImageIcon novaPromocao = new ImageIcon(EmpresaHome.class.getResource("/img/empresaHome/novaPromocao.png"));
		lblNovapromocao.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				lblBuscarproduto2.setVisible(false);
				lblApagar2.setVisible(false);
				lblSalvar2.setVisible(false);
				lblOpcao3.setVisible(false);
				getContentPane().setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
			}
		});
		lblNovapromocao.setBounds(428, 102, 284, 310);
		Image imgNovaPromocao = novaPromocao.getImage().getScaledInstance(lblNovapromocao.getWidth(), lblNovapromocao.getHeight(), Image.SCALE_SMOOTH);
		lblNovapromocao.setIcon(new ImageIcon(imgNovaPromocao));
		contentPane.add(lblNovapromocao);
		// FIM NOVA PROMOCAO
		
		// RECUSADAS
		lblRecusadas.setForeground(UIManager.getColor("Button.shadow"));
		lblRecusadas.setFont(new Font("SansSerif", Font.BOLD, 35));
		lblRecusadas.setBounds(631, 362, 73, 33);
		contentPane.add(lblRecusadas);
		lblRecusadas.setForeground(new Color(149, 152, 154));
		// FIM RECUSADAS
		
		// ACEITAS
		lblAceitas.setForeground(UIManager.getColor("Button.shadow"));
		lblAceitas.setFont(new Font("SansSerif", Font.BOLD, 35));
		lblAceitas.setBounds(544, 362, 73, 33);
		contentPane.add(lblAceitas);
		lblAceitas.setForeground(new Color(149, 152, 154));
		// FIM ACEITAS
		
		// PENDENTES
		lblPendentes.setForeground(UIManager.getColor("Button.shadow"));
		lblPendentes.setFont(new Font("SansSerif", Font.BOLD, 35));
		lblPendentes.setBounds(439, 362, 73, 33);
		contentPane.add(lblPendentes);
		lblPendentes.setForeground(new Color(149, 152, 154));
		// FIM PENDENTES
		
		// TABELA
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(434, 131, 273, 217);
		contentPane.add(scrollPane);
		table = new JTable();
		table.setForeground(Color.DARK_GRAY);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int row = table.getSelectedRow();
				int id = (int) table.getModel().getValueAt(row, 0);
				reserva = Fachada.getInstance().tabelaParaTelaEmpresa(id);
				lblData.setText(reserva.getData());
				lblNome.setText(reserva.getCliente().getNome());
				lblProduto.setText(reserva.getProduto().getNome());
				lblCategoria.setText(reserva.getProduto().getCategoria());
				lblPreco.setText(String.valueOf(reserva.getProduto().getPreco()));
				lblDadosreserva.setVisible(true);
				lblFechar.setVisible(true);
				lblNome.setVisible(true);
				lblData.setVisible(true);
				lblProduto.setVisible(true);
				lblCategoria.setVisible(true);
				lblPreco.setVisible(true);
				lblEstoque.setVisible(true);
				lblAceitar.setVisible(true);
				lblRecusar.setVisible(true);
			}
		});
		scrollPane.setViewportView(table);
		lblNome.setForeground(SystemColor.controlDkShadow);
		// FIM TABELA
		
		// DADOS DA RESERVA
		lblNome.setBounds(143, 174, 140, 17);
		contentPane.add(lblNome);
		lblData.setForeground(SystemColor.controlDkShadow);
		
		lblData.setBounds(307, 175, 73, 15);
		contentPane.add(lblData);
		lblProduto.setForeground(SystemColor.controlDkShadow);
		
		lblProduto.setBounds(143, 255, 223, 16);
		contentPane.add(lblProduto);
		lblCategoria.setForeground(SystemColor.controlDkShadow);
		
		lblCategoria.setBounds(143, 283, 101, 18);
		contentPane.add(lblCategoria);
		lblPreco.setForeground(SystemColor.controlDkShadow);
		
		lblPreco.setBounds(276, 283, 95, 18);
		contentPane.add(lblPreco);
		lblEstoque.setForeground(SystemColor.controlDkShadow);
		
		lblEstoque.setBounds(286, 321, 46, 14);
		contentPane.add(lblEstoque);
		// FIM DADOS DA RESERVA
		
		lblFechar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				lblDadosreserva.setVisible(false);
				lblFechar.setVisible(false);
				lblNome.setVisible(false);
				lblData.setVisible(false);
				lblProduto.setVisible(false);
				lblCategoria.setVisible(false);
				lblPreco.setVisible(false);
				lblEstoque.setVisible(false);
				lblRecusar.setVisible(false);
				lblAceitar.setVisible(false);
				getContentPane().setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
			}
		});
		lblFechar.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent arg0) {
				getContentPane().setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
		});
		lblFechar.setBounds(376, 105, 22, 23);
		contentPane.add(lblFechar);
		
		// REJEITAR 2
		ImageIcon recusar2 = new ImageIcon(EmpresaHome.class.getResource("/img/empresaHome/recusarSolicitacao_bt2.png"));
		lblRecusar2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Fachada.getInstance().recusarReserva(reserva.getId());
				atualizarTabela();
			}
		});
		lblRecusar2.setBounds(118, 346, 143, 66);
		Image imgRecusar2 = recusar2.getImage().getScaledInstance(lblRecusar2.getWidth(), lblRecusar2.getHeight(), Image.SCALE_SMOOTH);
		lblRecusar2.setIcon(new ImageIcon(imgRecusar2));
		contentPane.add(lblRecusar2);
		lblRecusar2.setVisible(false);
		// FIM REJEITAR 2
		
		// RECUSAR
		ImageIcon recusar = new ImageIcon(EmpresaHome.class.getResource("/img/empresaHome/recusarSolicitacao_bt1.png"));
		lblRecusar.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				getContentPane().setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				lblRecusar2.setVisible(true);
				lblAceitar2.setVisible(false);
			}
		});
		lblRecusar.setBounds(118, 346, 143, 66);
		Image imgRecusar = recusar.getImage().getScaledInstance(lblRecusar.getWidth(), lblRecusar.getHeight(), Image.SCALE_SMOOTH);
		lblRecusar.setIcon(new ImageIcon(imgRecusar));
		contentPane.add(lblRecusar);
		lblRecusar.setVisible(false);
		// FIM RECUSAAR
		
		// ACEITAR 2
		ImageIcon aceitar2 = new ImageIcon(EmpresaHome.class.getResource("/img/empresaHome/aceitarSolicitacao_bt2.png"));
		lblAceitar2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Fachada.getInstance().aceitarReserva(reserva.getId());
				atualizarTabela();
			}
		});
		lblAceitar2.setBounds(259, 346, 143, 66);
		Image imgAceitar2 = aceitar2.getImage().getScaledInstance(lblAceitar2.getWidth(), lblAceitar2.getHeight(), Image.SCALE_SMOOTH);
		lblAceitar2.setIcon(new ImageIcon(imgAceitar2));
		contentPane.add(lblAceitar2);
		lblAceitar2.setVisible(false);
		// FIM ACEITAR 2
		
		// ACEITAR
		ImageIcon aceitar = new ImageIcon(EmpresaHome.class.getResource("/img/empresaHome/aceitarSolicitacao_bt1.png"));
		lblAceitar.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent arg0) {
				getContentPane().setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				lblAceitar2.setVisible(true);
				lblRecusar2.setVisible(false);
			}
		});
		lblAceitar.setBounds(259, 346, 143, 66);
		Image imgAceitar = aceitar.getImage().getScaledInstance(lblAceitar.getWidth(), lblAceitar.getHeight(), Image.SCALE_SMOOTH);
		lblAceitar.setIcon(new ImageIcon(imgAceitar));
		contentPane.add(lblAceitar);
		lblAceitar.setVisible(false);
		// FIM ACEITAR
		
		// DADOS RESERVA
		ImageIcon dadosreserva = new ImageIcon(EmpresaHome.class.getResource("/img/empresaHome/dadosReserva.png"));
		lblDadosreserva.setBounds(118, 102, 284, 310);
		Image imgDadosreserva = dadosreserva.getImage().getScaledInstance(lblDadosreserva.getWidth(), lblDadosreserva.getHeight(), Image.SCALE_SMOOTH);
		lblDadosreserva.setIcon(new ImageIcon(imgDadosreserva));
		contentPane.add(lblDadosreserva);
		lblDadosreserva.setVisible(false);
		// FIM DADOS RESERVA
		
		// PROMOCOES ACABANDO
		lblPromoAcabando.setForeground(UIManager.getColor("Button.shadow"));
		lblPromoAcabando.setFont(new Font("SansSerif", Font.BOLD, 35));
		lblPromoAcabando.setBounds(282, 362, 73, 33);
		contentPane.add(lblPromoAcabando);
		lblPromoAcabando.setForeground(new Color(149, 152, 154));
		// FIM PROMOCOES ACABANDO
		
		// PROMOCOES ATIVAS
		lblPromoAtivas.setForeground(UIManager.getColor("Button.shadow"));
		lblPromoAtivas.setFont(new Font("SansSerif", Font.BOLD, 35));
		lblPromoAtivas.setBounds(126, 362, 73, 33);
		contentPane.add(lblPromoAtivas);
		lblPromoAtivas.setForeground(new Color(149, 152, 154));
		// FIM PROMOCOES ATIVAS
				
		
		// TABELA PROMOÇÃO
		scrollPane2.setBounds(123, 131, 273, 217);
		contentPane.add(scrollPane2);
		table2 = new JTable();
		table2.setForeground(Color.DARK_GRAY);
		table2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				txtValidade.setText(dataAtual);
			}
		});
		scrollPane2.setViewportView(table2);
		// FIM TABELA PROMOÇÃO
		
		//PESQ 2
		ImageIcon pesq2 = new ImageIcon(EmpresaHome.class.getResource("/img/empresaHome/pesq_bt2.png"));
		JLabel lblPesq2 = new JLabel("");
		lblPesq2.setBounds(675, 54, 35, 39);
		Image imgPesq2 = pesq2.getImage().getScaledInstance(lblPesq2.getWidth(), lblPesq2.getHeight(), Image.SCALE_SMOOTH);
		lblPesq2.setIcon(new ImageIcon(imgPesq2));
		contentPane.add(lblPesq2);
		lblPesq2.setVisible(false);
		//FIM PESQ 2
		
		//PESQ
		ImageIcon pesq = new ImageIcon(EmpresaHome.class.getResource("/img/empresaHome/pesq_bt1.png"));
		JLabel lblPesq = new JLabel("");
		lblPesq.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent arg0) {
				lblPesq2.setVisible(true);
				getContentPane().setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
		});
		lblPesq.setBounds(675, 54, 35, 39);
		Image imgPesq = pesq.getImage().getScaledInstance(lblPesq.getWidth(), lblPesq.getHeight(), Image.SCALE_SMOOTH);
		lblPesq.setIcon(new ImageIcon(imgPesq));
		contentPane.add(lblPesq);
		//FIM PESQ
		
		// PESQUISAR
		txtCampoPesquisa = new JTextField();
		txtCampoPesquisa.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent arg0) {
				lblPesq2.setVisible(false);
				lblOpcao2.setVisible(false);
			}
		});
		txtCampoPesquisa.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				txtCampoPesquisa.setOpaque(true);
				e.getComponent().setBackground(new Color(246, 246, 246));
				
				char keyChar = e.getKeyChar();
				if (Character.isLowerCase(keyChar)) {
				      e.setKeyChar(Character.toUpperCase(keyChar));
				    }
			}
		});
		txtCampoPesquisa.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtCampoPesquisa.setOpaque(true);
				e.getComponent().setBackground(new Color(246, 246, 246));
			}
		});
		
		txtCampoPesquisa.setOpaque(false);
		txtCampoPesquisa.setForeground(SystemColor.controlDkShadow);
		txtCampoPesquisa.setColumns(10);
		txtCampoPesquisa.setBorder(null);
		txtCampoPesquisa.setBounds(435, 58, 239, 33);
		contentPane.add(txtCampoPesquisa);
		// FIM PESQUISAR
		
		// MAIS 2
		ImageIcon filtrar2 = new ImageIcon(EmpresaHome.class.getResource("/img/empresaHome/filtrar_bt2.png"));
		lblFiltrar2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				EmpresaProduto frame5 = new EmpresaProduto(); frame5.setVisible(true);
				//frame5.receber(Fachada.getInstance().buscarEmpresa(lblNickname.getText()));
				dispose();
			}
		});
		lblFiltrar2.setBounds(1, 381, 98, 29);
		Image imgFiltrar2 = filtrar2.getImage().getScaledInstance(lblFiltrar2.getWidth(), lblFiltrar2.getHeight(), Image.SCALE_SMOOTH);
		lblFiltrar2.setIcon(new ImageIcon(imgFiltrar2));
		contentPane.add(lblFiltrar2);
		lblFiltrar2.setVisible(false);
		// FIM MAIS 2
		
		// MAIS
		ImageIcon filtrar = new ImageIcon(EmpresaHome.class.getResource("/img/empresaHome/filtrar_bt1.png"));
		lblFiltrar.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				lblFiltrar2.setVisible(true);
				getContentPane().setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
		});
		lblFiltrar.setBounds(1, 381, 98, 29);
		Image imgFiltrar = filtrar.getImage().getScaledInstance(lblFiltrar.getWidth(), lblFiltrar.getHeight(), Image.SCALE_SMOOTH);
		lblFiltrar.setIcon(new ImageIcon(imgFiltrar));
		contentPane.add(lblFiltrar);
		// FIM MAIS
		
		//BG
		ImageIcon background = new ImageIcon(EmpresaHome.class.getResource("/img/empresaHome/Empresa_Home.png"));
		lblBg.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				lblRecusar2.setVisible(false);
				lblAceitar2.setVisible(false);
				lblApagar2.setVisible(false);
				lblPesq2.setVisible(false);
				lblConta2.setVisible(false);
				lblBuscarproduto2.setVisible(false);
				lblOpcao2.setVisible(false);
				lblOpcao3.setVisible(false);
				lblFiltrar2.setVisible(false);
				lblPesquisarprodutos2.setVisible(false);
				getContentPane().setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
			}
		});
		lblBg.setBounds(0, 0, 736, 421);
		Image imagem = background.getImage().getScaledInstance(lblBg.getWidth(), lblBg.getHeight(), Image.SCALE_SMOOTH);
		lblBg.setIcon(new ImageIcon(imagem));
		contentPane.add(lblBg);
		//FIM BG
}
	
	public void receber (Empresa emp){
		table.setModel(Fachada.getInstance().listarReservasEmpresa(emp.getId()));
		table2.setModel(Fachada.getInstance().listarPromocoesEmpresa(emp.getId()));
		lblNickname.setText(emp.getNome());
		
		table2.getColumnModel().getColumn(0).setPreferredWidth(30);
		table2.getColumnModel().getColumn(1).setPreferredWidth(140); 
		table2.getColumnModel().getColumn(2).setPreferredWidth(180); 
		table2.getColumnModel().getColumn(3).setPreferredWidth(100);
		table2.getColumnModel().getColumn(4).setPreferredWidth(80);
		
		table.getColumnModel().getColumn(0).setPreferredWidth(30);
		table.getColumnModel().getColumn(1).setPreferredWidth(80); 
		table.getColumnModel().getColumn(2).setPreferredWidth(120); 
		table.getColumnModel().getColumn(3).setPreferredWidth(80);
		
		lblPendentes.setText(String.valueOf(Fachada.getInstance().reservasPendentesEmpresa(emp.getId())));
		lblAceitas.setText(String.valueOf(Fachada.getInstance().reservasAceitasEmpresa(emp.getId())));
		lblRecusadas.setText(String.valueOf(Fachada.getInstance().reservasRecusadasEmpresa(emp.getId())));
		lblPromoAtivas.setText(String.valueOf(Fachada.getInstance().promocoesAtivas(emp.getId(), dataAtual)));
		lblPromoAcabando.setText(String.valueOf(Fachada.getInstance().promocoesAcabando(emp.getId(), dataAtual)));
		novaPromocao(false);
	}
	
	public void atualizarTabela(){
		int id = Fachada.getInstance().buscarEmpresa(lblNickname.getText()).getId();
		table.setModel(Fachada.getInstance().listarReservasEmpresa(id));
		table2.setModel(Fachada.getInstance().listarPromocoesEmpresa(id));
		
		table2.getColumnModel().getColumn(0).setPreferredWidth(30);
		table2.getColumnModel().getColumn(1).setPreferredWidth(140); 
		table2.getColumnModel().getColumn(2).setPreferredWidth(180); 
		table2.getColumnModel().getColumn(3).setPreferredWidth(100);
		table2.getColumnModel().getColumn(4).setPreferredWidth(80);
		
		table.getColumnModel().getColumn(0).setPreferredWidth(30);
		table.getColumnModel().getColumn(1).setPreferredWidth(80);
		table.getColumnModel().getColumn(2).setPreferredWidth(120);
		table.getColumnModel().getColumn(3).setPreferredWidth(80);
		
		lblPendentes.setText(String.valueOf(Fachada.getInstance().reservasPendentesEmpresa(id)));
		lblAceitas.setText(String.valueOf(Fachada.getInstance().reservasAceitasEmpresa(id)));
		lblRecusadas.setText(String.valueOf(Fachada.getInstance().reservasRecusadasEmpresa(id)));
		lblPromoAtivas.setText(String.valueOf(Fachada.getInstance().promocoesAtivas(id, dataAtual)));
		lblPromoAcabando.setText(String.valueOf(Fachada.getInstance().promocoesAcabando(id, dataAtual)));
	}
	
	public void novaPromocao(Boolean op){
		lblNovapromocao.setVisible(op);
		lblFechar2.setVisible(op);
		txtCodigoProduto.setVisible(op);
		lblBuscarproduto.setVisible(op);
		lblBuscarproduto2.setVisible(op);
		txtValidade.setVisible(op);
		txtNomeProduto.setVisible(op);
		txtPrecoProduto.setVisible(op);
		txtNovoPreco.setVisible(op);
		txtDesconto.setVisible(op);
		lblApagar.setVisible(op);
		lblSalvar.setVisible(op);
		table.setVisible(!op);
	}
}
