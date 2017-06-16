package interfaceGrafica;

import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;

public class UsuarioHome extends JFrame {

	private JPanel contentPane;
	JLabel lblOpcao = new JLabel("");
	JLabel lblOpcao2 = new JLabel("");
	JLabel lblOpcao3 = new JLabel("");
	JLabel lblEditarPerfil = new JLabel("");
	JLabel lblSair = new JLabel("");
	
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
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 752
				, 460);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		this.setLocationRelativeTo(null); // JANELA FICA NO CENTRO
		
		//CONTA 2
		ImageIcon conta3 = new ImageIcon(EmpresaProduto.class.getResource("/img/usuarioHome/conta_bt3.png"));
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
		ImageIcon conta2 = new ImageIcon(EmpresaProduto.class.getResource("/img/usuarioHome/conta_bt2.png"));
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
		ImageIcon conta = new ImageIcon(EmpresaProduto.class.getResource("/img/usuarioHome/conta_bt1.png"));
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
		ImageIcon opcao3 = new ImageIcon(EmpresaProduto.class.getResource("/img/usuarioHome/conta_sair.png"));
		lblOpcao3.setBounds(591, 47, 147, 75);
		Image imgOpcao3 = opcao3.getImage().getScaledInstance(lblOpcao3.getWidth(), lblOpcao3.getHeight(), Image.SCALE_SMOOTH);
		lblOpcao3.setIcon(new ImageIcon(imgOpcao3));
		contentPane.add(lblOpcao3);
		lblOpcao3.setVisible(false);
		//FIM OPCAO 2
		
		//OPCAO 2
		ImageIcon opcao2 = new ImageIcon(EmpresaProduto.class.getResource("/img/usuarioHome/conta_edit.png"));
		lblOpcao2.setBounds(591, 47, 147, 75);
		Image imgOpcao2 = opcao2.getImage().getScaledInstance(lblOpcao2.getWidth(), lblOpcao2.getHeight(), Image.SCALE_SMOOTH);
		lblOpcao2.setIcon(new ImageIcon(imgOpcao2));
		contentPane.add(lblOpcao2);
		lblOpcao2.setVisible(false);
		//FIM OPCAO 2
		
		//OPCAO
		ImageIcon opcao = new ImageIcon(EmpresaProduto.class.getResource("/img/usuarioHome/conta_op.png"));
		lblOpcao.setBounds(591, 47, 147, 75);
		Image imgOpcao = opcao.getImage().getScaledInstance(lblOpcao.getWidth(), lblOpcao.getHeight(), Image.SCALE_SMOOTH);
		lblOpcao.setIcon(new ImageIcon(imgOpcao));
		contentPane.add(lblOpcao);
		lblOpcao.setVisible(false);
		
		//FIM OPCAO
		
		//BG
		ImageIcon background = new ImageIcon(EmpresaProduto.class.getResource("/img/usuarioHome/Usuario_Home.png"));
		JLabel lblBg = new JLabel("");
		lblBg.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				lblConta2.setVisible(false);
				lblOpcao2.setVisible(false);
				lblOpcao3.setVisible(false);
				getContentPane().setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
			}
		});
		lblBg.setBounds(0, 0, 747, 431);
		Image imagem = background.getImage().getScaledInstance(lblBg.getWidth(), lblBg.getHeight(), Image.SCALE_SMOOTH);
		lblBg.setIcon(new ImageIcon(imagem));
		contentPane.add(lblBg);
		//FIM BG
	}
}
