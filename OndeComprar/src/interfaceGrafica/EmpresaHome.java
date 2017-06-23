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
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import programa.Empresa;
import programa.Fachada;
import programa.Produto;
import programa.Reserva;
import programa.Usuario;

import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.Calendar;
import java.awt.event.MouseAdapter;
import java.awt.SystemColor;

public class EmpresaHome extends JFrame {

	private JPanel contentPane;
	JTable table;
	JScrollPane scrollPane2 = new JScrollPane();
	JTable table2;
	JLabel lblProvisorio2 = new JLabel("");
	JLabel lblPendentes = new JLabel("0");
	JLabel lblAceitas = new JLabel("0");
	JLabel lblRecusadas = new JLabel("0");
	JLabel lblNome = new JLabel("");
	JLabel lblData = new JLabel("");
	JLabel lblDadosreserva = new JLabel("");
	JLabel lblBg = new JLabel("");
	JLabel lblFechar = new JLabel("");
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
		setIconImage(Toolkit.getDefaultToolkit().getImage(EmpresaHome.class.getResource("/img/favicon.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 752, 460);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		this.setLocationRelativeTo(null); // COLOCA A JANELA NO CENTRO DA TELA
		
		JLabel lblProvisorio = new JLabel("provisorio:");
		lblProvisorio.setBounds(143, 23, 65, 14);
		contentPane.add(lblProvisorio);
		
		lblProvisorio2.setBounds(209, 23, 66, 14);
		contentPane.add(lblProvisorio2);
		
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
				lblNome.setText(Fachada.getInstance().buscarUsuario(reserva.getCliente_id()).getNome());
				Produto produto = Fachada.getInstance().buscarProduto(reserva.getProduto_id());
				lblProduto.setText(produto.getNome());
				lblCategoria.setText(produto.getCategoria());
				lblPreco.setText(String.valueOf(produto.getPreco()));
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
			}
		});
		scrollPane2.setViewportView(table2);
		// FIM TABELA PROMOÇÃO
		
		//BG
		ImageIcon background = new ImageIcon(EmpresaHome.class.getResource("/img/empresaHome/Empresa_Home.png"));
		lblBg.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				lblRecusar2.setVisible(false);
				lblAceitar2.setVisible(false);
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
		lblProvisorio2.setText(Integer.toString(emp.getId()));
		table.setModel(Fachada.getInstance().listarReservasEmpresa(emp.getId()));
		table2.setModel(Fachada.getInstance().listarPromocoesEmpresa(emp.getId()));
		
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
	}
	
	public void atualizarTabela(){
		int id = Integer.parseInt(lblProvisorio2.getText());
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
}
