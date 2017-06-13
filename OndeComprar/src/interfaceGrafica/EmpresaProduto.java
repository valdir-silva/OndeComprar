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
import java.awt.event.MouseAdapter;

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
	private JLabel lblSalvar2;
	private JLabel lblId;
	private JLabel lblId2;
	private JLabel lblId3;
	private JLabel lblNome;
	private JLabel lblNome2;
	private JLabel lblNome3;
	private JLabel lblMarca;
	private JLabel lblMarca2;
	private JLabel lblMarca3;
	private JLabel lblPreco;
	private JLabel lblPreco2;
	private JLabel lblPreco3;

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
	/**
	 * 
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
				lblSalvar2.setVisible(false);
				lblId2.setVisible(false);
				lblNome2.setVisible(false);
				lblMarca2.setVisible(false);
				lblPreco2.setVisible(false);
				getContentPane().setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
			}
		});
		lblBg.setBounds(0, 0, 747, 431);
		Image imagem = background.getImage().getScaledInstance(lblBg.getWidth(), lblBg.getHeight(), Image.SCALE_SMOOTH);
		
		txtBuscar = new JTextField();
		txtBuscar.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				lblBuscar.setVisible(false);
			}
		});
		txtBuscar.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				// QUANDO APERDER O ENTER IR� BUSCAR NO BANCO
			}
		});
		txtBuscar.setOpaque(false);
		txtBuscar.setForeground(SystemColor.controlDkShadow);
		txtBuscar.setColumns(10);
		txtBuscar.setBorder(null);
		txtBuscar.setBounds(263, 80, 172, 20);
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
		lblApagar2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//ADICIONAR OUTRA IMAGEM PARA GERAR SENSA플O DE ANIMA플O AO DELETAR
			}
		});
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
		
		//SALVAR 2
		ImageIcon salvar2 = new ImageIcon(EmpresaProduto.class.getResource("/img/Salvar_bt2.png"));
		lblSalvar2 = new JLabel("");
		lblSalvar2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//ADICIONAR OUTRA IMAGEM PARA GERAR SENSA플O DE ANIMA플O AO SALVAR
			}
		});
		lblSalvar2.setBounds(117, 247, 76, 66);
		Image imgSalvar2 = salvar2.getImage().getScaledInstance(lblSalvar2.getWidth(), lblSalvar2.getHeight(), Image.SCALE_SMOOTH);
		lblSalvar2.setIcon(new ImageIcon(imgSalvar2));
		contentPane.add(lblSalvar2);
		lblSalvar2.setVisible(false);
		//FIM SALVAR 2
		
		//SALVAR
		ImageIcon salvar = new ImageIcon(EmpresaProduto.class.getResource("/img/Salvar_bt.png"));
		JLabel lblSalvar = new JLabel("");
		lblSalvar.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent arg0) {
				lblSalvar2.setVisible(true);
				getContentPane().setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
		});
		lblSalvar.setBounds(117, 247, 76, 66);
		Image imgSalvar = salvar.getImage().getScaledInstance(lblSalvar.getWidth(), lblSalvar.getHeight(), Image.SCALE_SMOOTH);
		lblSalvar.setIcon(new ImageIcon(imgSalvar));
		contentPane.add(lblSalvar);
		//FIM SALVAR
		
		//ID 3
		ImageIcon id3 = new ImageIcon(EmpresaProduto.class.getResource("/img/id3.png"));
		lblId3 = new JLabel("");
		lblId3.setBounds(524, 79, 30, 21);
		Image imgId3 = id3.getImage().getScaledInstance(lblId3.getWidth(), lblId3.getHeight(), Image.SCALE_SMOOTH);
		lblId3.setIcon(new ImageIcon(imgId3));
		contentPane.add(lblId3);
		lblId3.setVisible(false);
		// FIM ID 3
		
		//ID 2
		ImageIcon id2 = new ImageIcon(EmpresaProduto.class.getResource("/img/id2.png"));
		lblId2 = new JLabel("");
		lblId2.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				lblNome2.setVisible(false);
				lblMarca2.setVisible(false);
				lblPreco2.setVisible(false);
			}
		});
		lblId2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				lblId3.setVisible(true);
				lblNome3.setVisible(false);
				lblMarca3.setVisible(false);
				lblPreco3.setVisible(false);
			}
		});
		lblId2.setBounds(524, 79, 30, 21);
		Image imgId2 = id2.getImage().getScaledInstance(lblId2.getWidth(), lblId2.getHeight(), Image.SCALE_SMOOTH);
		lblId2.setIcon(new ImageIcon(imgId2));
		contentPane.add(lblId2);
		lblId2.setVisible(false);
		// FIM ID 2
		
		//ID
		ImageIcon id = new ImageIcon(EmpresaProduto.class.getResource("/img/id.png"));
		lblId = new JLabel("");
		lblId.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				lblId2.setVisible(true);
				getContentPane().setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
		});
		lblId.setBounds(524, 79, 30, 21);
		Image imgId = id.getImage().getScaledInstance(lblId.getWidth(), lblId.getHeight(), Image.SCALE_SMOOTH);
		lblId.setIcon(new ImageIcon(imgId));
		contentPane.add(lblId);
		// FIM ID
		
		//NOME 3
		ImageIcon nome3 = new ImageIcon(EmpresaProduto.class.getResource("/img/nome3.png"));
		lblNome3 = new JLabel("");
		lblNome3.setBounds(554, 79, 51, 21);
		Image imgNome3 = nome3.getImage().getScaledInstance(lblNome3.getWidth(), lblNome3.getHeight(), Image.SCALE_SMOOTH);
		lblNome3.setIcon(new ImageIcon(imgNome3));
		contentPane.add(lblNome3);
		lblNome3.setVisible(false);
		//FIM NOME 3
		
		//NOME 2
		ImageIcon nome2 = new ImageIcon(EmpresaProduto.class.getResource("/img/nome2.png"));
		lblNome2 = new JLabel("");
		lblNome2.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				lblId2.setVisible(false);
				lblMarca2.setVisible(false);
				lblPreco2.setVisible(false);
			}
		});
		lblNome2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblId3.setVisible(false);
				lblNome3.setVisible(true);
				lblMarca3.setVisible(false);
				lblPreco3.setVisible(false);
			}
		});
		lblNome2.setBounds(554, 79, 51, 21);
		Image imgNome2 = nome2.getImage().getScaledInstance(lblNome2.getWidth(), lblNome2.getHeight(), Image.SCALE_SMOOTH);
		lblNome2.setIcon(new ImageIcon(imgNome2));
		contentPane.add(lblNome2);
		lblNome2.setVisible(false);
		//FIM NOME 2
		
		//NOME
		ImageIcon nome = new ImageIcon(EmpresaProduto.class.getResource("/img/nome.png"));
		lblNome = new JLabel("");
		lblNome.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				lblNome2.setVisible(true);
				getContentPane().setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
		});
		lblNome.setBounds(554, 79, 51, 21);
		Image imgNome = nome.getImage().getScaledInstance(lblNome.getWidth(), lblNome.getHeight(), Image.SCALE_SMOOTH);
		lblNome.setIcon(new ImageIcon(imgNome));
		contentPane.add(lblNome);
		//FIM NOME
		
		//MARCA 3
		ImageIcon marca3 = new ImageIcon(EmpresaProduto.class.getResource("/img/marca3.png"));
		lblMarca3 = new JLabel("");
		lblMarca3.setBounds(605, 79, 62, 21);
		Image imgMarca3 = marca3.getImage().getScaledInstance(lblMarca3.getWidth(), lblMarca3.getHeight(), Image.SCALE_SMOOTH);
		lblMarca3.setIcon(new ImageIcon(imgMarca3));
		contentPane.add(lblMarca3);
		lblMarca3.setVisible(false);
		//FIM MARCA 3
		
		//MARCA 2
		ImageIcon marca2 = new ImageIcon(EmpresaProduto.class.getResource("/img/marca2.png"));
		lblMarca2 = new JLabel("");
		lblMarca2.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				lblId2.setVisible(false);
				lblNome2.setVisible(false);
				lblPreco2.setVisible(false);
			}
		});
		lblMarca2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblId3.setVisible(false);
				lblNome3.setVisible(false);
				lblMarca3.setVisible(true);
				lblPreco3.setVisible(false);
			}
		});
		lblMarca2.setBounds(605, 79, 62, 21);
		Image imgMarca2 = marca2.getImage().getScaledInstance(lblMarca2.getWidth(), lblMarca2.getHeight(), Image.SCALE_SMOOTH);
		lblMarca2.setIcon(new ImageIcon(imgMarca2));
		contentPane.add(lblMarca2);
		lblMarca2.setVisible(false);
		//FIM MARCA 2

		//MARCA
		ImageIcon marca = new ImageIcon(EmpresaProduto.class.getResource("/img/marca.png"));
		lblMarca = new JLabel("");
		lblMarca.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				lblMarca2.setVisible(true);
				getContentPane().setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
		});
		lblMarca.setBounds(605, 79, 62, 21);
		Image imgMarca = marca.getImage().getScaledInstance(lblMarca.getWidth(), lblMarca.getHeight(), Image.SCALE_SMOOTH);
		lblMarca.setIcon(new ImageIcon(imgMarca));
		contentPane.add(lblMarca);
		//FIM MARCA
		
		//PRECO
		ImageIcon preco3 = new ImageIcon(EmpresaProduto.class.getResource("/img/preco3.png"));
		lblPreco3 = new JLabel("");
		lblPreco3.setBounds(668, 79, 53, 21);
		Image imgPreco3 = preco3.getImage().getScaledInstance(lblPreco3.getWidth(), lblPreco3.getHeight(), Image.SCALE_SMOOTH);
		lblPreco3.setIcon(new ImageIcon(imgPreco3));
		contentPane.add(lblPreco3);
		lblPreco3.setVisible(false);
		//FIM PRECO
		
		//PRECO
		ImageIcon preco2 = new ImageIcon(EmpresaProduto.class.getResource("/img/preco2.png"));
		lblPreco2 = new JLabel("");
		lblPreco2.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				lblId2.setVisible(false);
				lblNome2.setVisible(false);
				lblMarca2.setVisible(false);
			}
		});
		lblPreco2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblId3.setVisible(false);
				lblNome3.setVisible(false);
				lblMarca3.setVisible(false);
				lblPreco3.setVisible(true);
			}
		});
		lblPreco2.setBounds(668, 79, 53, 21);
		Image imgPreco2 = preco2.getImage().getScaledInstance(lblPreco2.getWidth(), lblPreco2.getHeight(), Image.SCALE_SMOOTH);
		lblPreco2.setIcon(new ImageIcon(imgPreco2));
		contentPane.add(lblPreco2);
		lblPreco2.setVisible(false);
		//FIM PRECO
		
		//PRECO
		ImageIcon preco = new ImageIcon(EmpresaProduto.class.getResource("/img/preco.png"));
		lblPreco = new JLabel("");
		lblPreco.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				lblPreco2.setVisible(true);
				getContentPane().setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
		});
		lblPreco.setBounds(668, 79, 53, 21);
		Image imgPreco = preco.getImage().getScaledInstance(lblPreco.getWidth(), lblPreco.getHeight(), Image.SCALE_SMOOTH);
		lblPreco.setIcon(new ImageIcon(imgPreco));
		contentPane.add(lblPreco);
		//FIM PRECO
		
		//BACKGROUND
		lblBg.setIcon(new ImageIcon(imagem));
		contentPane.add(lblBg);
		//...
		
	}
}
