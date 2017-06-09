package interfaceGrafica;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Cursor;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import java.awt.SystemColor;
import javax.swing.JButton;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseEvent;

public class EmpresaProduto extends JFrame {

	private JPanel contentPane;
	private JTextField txtId;
	private JTextField txtNome;
	private JTextField txtPreco;
	private JTextField txtBuscar;
	private JLabel lblBuscar;
	private JLabel lblBuscar2;
	private JLabel lblApagar;
	private JLabel lblApagar2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EmpresaProduto frame = new EmpresaProduto();
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
	public EmpresaProduto() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setBounds(100, 100, 753, 460);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		this.setLocationRelativeTo(null); //coloca a janela no centro da tela
		
		//BACKGROUND
		ImageIcon background = new ImageIcon(EmpresaProduto.class.getResource("/img/Empresa_Produto.png"));
		JLabel lblBg = new JLabel("");
		lblBg.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				lblBuscar.setVisible(false);
				lblApagar2.setVisible(false);
				getContentPane().setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
			}
		});
		lblBg.setBounds(0, 0, 747, 431);
		Image imagem = background.getImage().getScaledInstance(lblBg.getWidth(), lblBg.getHeight(), Image.SCALE_SMOOTH);
		
		txtBuscar = new JTextField();
		txtBuscar.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				// QUANDO APERDER O ENTER IRÁ BUSCAR NO BANCO
			}
		});
		txtBuscar.setOpaque(false);
		txtBuscar.setForeground(SystemColor.controlDkShadow);
		txtBuscar.setColumns(10);
		txtBuscar.setBorder(null);
		txtBuscar.setBounds(263, 80, 178, 20);
		contentPane.add(txtBuscar);
		
		txtPreco = new JTextField();
		txtPreco.setOpaque(false);
		txtPreco.setForeground(SystemColor.controlDkShadow);
		txtPreco.setColumns(10);
		txtPreco.setBorder(null);
		txtPreco.setBounds(50, 197, 143, 20);
		contentPane.add(txtPreco);
		
		txtNome = new JTextField();
		txtNome.setOpaque(false);
		txtNome.setForeground(SystemColor.controlDkShadow);
		txtNome.setColumns(10);
		txtNome.setBorder(null);
		txtNome.setBounds(33, 145, 160, 20);
		contentPane.add(txtNome);
		
		txtId = new JTextField();
		txtId.setForeground(UIManager.getColor("CheckBox.darkShadow"));
		txtId.setBounds(33, 92, 59, 20);
		txtId.setOpaque(false);
		txtId.setBorder(null);
		contentPane.add(txtId);
		txtId.setColumns(10);
		
		ImageIcon buscar = new ImageIcon(EmpresaProduto.class.getResource("/img/Buscar_bt.png"));
		lblBuscar = new JLabel("");
		lblBuscar.setBounds(437, 76, 27, 26);
		Image imgBuscar = buscar.getImage().getScaledInstance(lblBuscar.getWidth(), lblBuscar.getHeight(), Image.SCALE_SMOOTH);
		lblBuscar.setIcon(new ImageIcon(imgBuscar));
		contentPane.add(lblBuscar);
		lblBuscar.setVisible(false);
		
		ImageIcon buscar2 = new ImageIcon(EmpresaProduto.class.getResource("/img/Buscar_bt2.png"));
		lblBuscar2 = new JLabel("");
		lblBuscar2.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				lblBuscar.setVisible(true);
				getContentPane().setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
		});
		lblBuscar2.setBounds(437, 76, 27, 26);
		Image imgBuscar2 = buscar2.getImage().getScaledInstance(lblBuscar2.getWidth(), lblBuscar2.getHeight(), Image.SCALE_SMOOTH);
		lblBuscar2.setIcon(new ImageIcon(imgBuscar2));
		contentPane.add(lblBuscar2);
		
		ImageIcon apagar2 = new ImageIcon(EmpresaProduto.class.getResource("/img/Apagar_bt2.png"));
		lblApagar2 = new JLabel("");
		lblApagar2.setBounds(28, 247, 79, 66);
		Image imgApagar2 = apagar2.getImage().getScaledInstance(lblApagar2.getWidth(), lblApagar2.getHeight(), Image.SCALE_SMOOTH);
		lblApagar2.setIcon(new ImageIcon(imgApagar2));
		contentPane.add(lblApagar2);
		lblApagar2.setVisible(false);
		
		ImageIcon apagar = new ImageIcon(EmpresaProduto.class.getResource("/img/Apagar_bt.png"));
		lblApagar = new JLabel("");
		lblApagar.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				lblApagar2.setVisible(true);
				getContentPane().setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
		});
		lblApagar.setBounds(28, 247, 79, 66);
		Image imgApagar = apagar.getImage().getScaledInstance(lblApagar.getWidth(), lblApagar.getHeight(), Image.SCALE_SMOOTH);
		lblApagar.setIcon(new ImageIcon(imgApagar));
		contentPane.add(lblApagar);
		
		//BACKGROUND
		lblBg.setIcon(new ImageIcon(imagem));
		contentPane.add(lblBg);
		//...
		
	}
}
