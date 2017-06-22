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

import DataBase.RepositorioEmpresa;
import DataBase.RepositorioProduto;
import DataBase.RepositorioUsuario;
import programa.Empresa;
import programa.Fachada;
import programa.Produto;
import programa.Reserva;
import programa.Usuario;

import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseAdapter;

public class EmpresaHome extends JFrame {

	private JPanel contentPane;
	JTable table;
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
		// FIM RECUSADAS
		
		// ACEITAS
		lblAceitas.setForeground(UIManager.getColor("Button.shadow"));
		lblAceitas.setFont(new Font("SansSerif", Font.BOLD, 35));
		lblAceitas.setBounds(544, 362, 73, 33);
		contentPane.add(lblAceitas);
		// FIM ACEITAS
		
		// PENDENTES
		lblPendentes.setForeground(UIManager.getColor("Button.shadow"));
		lblPendentes.setFont(new Font("SansSerif", Font.BOLD, 35));
		lblPendentes.setBounds(439, 362, 73, 33);
		contentPane.add(lblPendentes);
		// FIM PENDENTES
		
		// TABELA
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(434, 131, 273, 217);
		contentPane.add(scrollPane);
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int row = table.getSelectedRow();
				int id = (int) table.getModel().getValueAt(row, 0);
				Reserva reserva = Fachada.getInstance().tabelaParaTelaEmpresa(id);
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
				
			}
		});
		scrollPane.setViewportView(table);
		// FIM TABELA
		
		// DADOS DA RESERVA
		lblNome.setBounds(143, 174, 140, 17);
		contentPane.add(lblNome);
		
		lblData.setBounds(307, 175, 73, 15);
		contentPane.add(lblData);
		
		lblProduto.setBounds(143, 255, 223, 16);
		contentPane.add(lblProduto);
		
		lblCategoria.setBounds(143, 283, 101, 18);
		contentPane.add(lblCategoria);
		
		lblPreco.setBounds(276, 283, 95, 18);
		contentPane.add(lblPreco);
		
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
		
		// DADOS RESERVA
		ImageIcon dadosreserva = new ImageIcon(EmpresaHome.class.getResource("/img/empresaHome/dadosReserva.png"));
		lblDadosreserva.setBounds(118, 102, 284, 310);
		Image imgDadosreserva = dadosreserva.getImage().getScaledInstance(lblDadosreserva.getWidth(), lblDadosreserva.getHeight(), Image.SCALE_SMOOTH);
		lblDadosreserva.setIcon(new ImageIcon(imgDadosreserva));
		contentPane.add(lblDadosreserva);
		lblDadosreserva.setVisible(false);
		// FIM DADOS RESERVA
		
		//BG
		ImageIcon background = new ImageIcon(EmpresaHome.class.getResource("/img/empresaHome/Empresa_Home.png"));
		lblBg.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				
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
		
		table.getColumnModel().getColumn(0).setPreferredWidth(30);
		table.getColumnModel().getColumn(1).setPreferredWidth(80); 
		table.getColumnModel().getColumn(2).setPreferredWidth(120); 
		table.getColumnModel().getColumn(3).setPreferredWidth(80);
		
		lblPendentes.setText(String.valueOf(Fachada.getInstance().reservasPendentesEmpresa(emp.getId())));
		lblAceitas.setText(String.valueOf(Fachada.getInstance().reservasAceitasEmpresa(emp.getId())));
		lblRecusadas.setText(String.valueOf(Fachada.getInstance().reservasRecusadasEmpresa(emp.getId())));
		lblPendentes.setForeground(new Color(149, 152, 154));
		lblAceitas.setForeground(new Color(149, 152, 154));
		lblRecusadas.setForeground(new Color(149, 152, 154));
		
	}
}
