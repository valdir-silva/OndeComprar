package interfaceGrafica;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JInternalFrame;
import javax.swing.JLayeredPane;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Login extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtLogin;
	private JTextField txtSenha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Login dialog = new Login();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
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
		
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBounds(43, 11, 1, 1);
		contentPanel.add(layeredPane);
		
		JLabel bg = new JLabel("");
		bg.setFont(new Font("SansSerif", Font.PLAIN, 15));
		bg.setForeground(new Color(102, 102, 102));
		bg.setBounds(0, 0, 297, 267);
		
		ImageIcon background = new ImageIcon(Login.class.getResource("/img/Login.jpg"));
		Image imagem = background.getImage().getScaledInstance(bg.getWidth(), bg.getHeight(), Image.SCALE_DEFAULT);
		
		JLabel lblLogin = new JLabel("Login");
		lblLogin.setFont(new Font("SansSerif", Font.BOLD, 27));
		lblLogin.setForeground(new Color(102, 102, 102));
		lblLogin.setBounds(110, 0, 76, 37);
		contentPanel.add(lblLogin);
		
		JLabel lblNewLabel = new JLabel("login");
		lblNewLabel.setBackground(new Color(240, 240, 240));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("SansSerif", Font.PLAIN, 17));
		lblNewLabel.setBounds(133, 187, 36, 26);
		contentPanel.add(lblNewLabel);
		
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
		bg.setIcon(new ImageIcon(imagem));
		
		contentPanel.add(bg);
		
		//VALORES PADRAO
		txtLogin.setText("Valdir");
		txtSenha.setText("1234");
		// FIM VALORES PADRAO
	}
}
