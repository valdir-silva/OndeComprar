package interfaceGrafica;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

import programa.Fachada;
import programa.Usuario;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;

import javax.swing.JInternalFrame;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

public class Login extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtLogin;
	private JTextField txtSenha;
	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		try {
			Login frameLogin = new Login();
			frameLogin.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			frameLogin.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Login() {
		setResizable(false);
		setBounds(100, 100, 303, 296);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(255, 255, 255));
		contentPanel.setBorder(null);
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		this.setLocationRelativeTo(null); // COLOCA A JANELA NO CENTRO DA TELA
		
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBounds(43, 11, 1, 1);
		contentPanel.add(layeredPane);
	
		
		JLabel lblLogin = new JLabel("Login");
		lblLogin.setFont(new Font("SansSerif", Font.BOLD, 27));
		lblLogin.setForeground(new Color(102, 102, 102));
		lblLogin.setBounds(110, 0, 76, 37);
		contentPanel.add(lblLogin);
		
		txtLogin = new JTextField();
		txtLogin.setHorizontalAlignment(SwingConstants.CENTER);
		txtLogin.setFont(new Font("SansSerif", Font.BOLD, 13));
		txtLogin.setForeground(new Color(102, 102, 102));
		txtLogin.setBackground(new Color(102, 51, 0));
		txtLogin.setBounds(35, 65, 228, 32);
		txtLogin.setOpaque(false);
		txtLogin.setBorder(null);
		contentPanel.add(txtLogin);
		txtLogin.setColumns(10);
		
		txtSenha = new JPasswordField();
		txtSenha.setHorizontalAlignment(SwingConstants.CENTER);
		txtSenha.setForeground(new Color(102, 102, 102));
		txtSenha.setFont(new Font("SansSerif", Font.PLAIN, 13));
		txtSenha.setOpaque(false);
		txtSenha.setColumns(10);
		txtSenha.setBorder(null);
		txtSenha.setBackground(new Color(102, 51, 0));
		txtSenha.setBounds(35, 118, 228, 32);
		contentPanel.add(txtSenha);
		
		ImageIcon myImage = new ImageIcon(Login.class.getResource("/img/login/Login_bt.png"));
		ImageIcon myImage2 = new ImageIcon(Login.class.getResource("/img/login/Login_bt2.png"));
		JLabel btnEntrar = new JLabel("");

		btnEntrar.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent arg0) {
			}
			@Override
			public void mouseMoved(MouseEvent e) {
				getContentPane().setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				Image imagemBotao3 = myImage2.getImage().getScaledInstance(btnEntrar.getWidth(), btnEntrar.getHeight(), Image.SCALE_DEFAULT);
				btnEntrar.setIcon(new ImageIcon(imagemBotao3));

			}
		});
		btnEntrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				if(Fachada.getInstance().logarUsuario(txtLogin.getText(), txtSenha.getText())){
					UsuarioHome usuarioHome = new UsuarioHome(); usuarioHome.setVisible(true);
					usuarioHome.receber(Fachada.getInstance().buscarUsuario(txtLogin.getText()));
					dispose();
				} else if (Fachada.getInstance().logarEmpresa(txtLogin.getText(), txtSenha.getText())){
					EmpresaHome empresaHome = new EmpresaHome(); empresaHome.setVisible(true);
					empresaHome.receber(Fachada.getInstance().buscarEmpresa(txtLogin.getText()));
					dispose();
				} else {
					JOptionPane.showMessageDialog(null, "Login ou Senha inválidos");
				}
			}
		});
		btnEntrar.setFont(new Font("SansSerif", Font.PLAIN, 15));
		btnEntrar.setForeground(new Color(102, 102, 102));
		btnEntrar.setBounds(63, 181, 173, 40);
		Image imagemBotao = myImage.getImage().getScaledInstance(btnEntrar.getWidth(), btnEntrar.getHeight(), Image.SCALE_DEFAULT);
		btnEntrar.setIcon(new ImageIcon(imagemBotao));
		contentPanel.add(btnEntrar);
		
		//
		JLabel lblAlunando = new JLabel("alunando");
		lblAlunando.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtLogin.setText("alunando");
				txtSenha.setText("12345");
			}
		});
		lblAlunando.setBounds(10, 11, 61, 26);
		contentPanel.add(lblAlunando);
		//
		
		//BACKGROUND
		ImageIcon background = new ImageIcon(Login.class.getResource("/img/login/Login.jpg"));
		JLabel bg = new JLabel("");
		bg.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				getContentPane().setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
				Image imagemBotao = myImage.getImage().getScaledInstance(btnEntrar.getWidth(), btnEntrar.getHeight(), Image.SCALE_DEFAULT);
				btnEntrar.setIcon(new ImageIcon(imagemBotao));
			}
		});
		bg.setFont(new Font("SansSerif", Font.PLAIN, 15));
		bg.setForeground(new Color(102, 102, 102));
		bg.setBounds(0, 0, 297, 267);
		Image imagem = background.getImage().getScaledInstance(bg.getWidth(), bg.getHeight(), Image.SCALE_DEFAULT);
		bg.setIcon(new ImageIcon(imagem));
		contentPanel.add(bg);
		
		//VALORES PADRAO
		txtLogin.setText("valdirsilva");
		txtSenha.setText("1234");
		// FIM VALORES PADRAO
		
	}

}
