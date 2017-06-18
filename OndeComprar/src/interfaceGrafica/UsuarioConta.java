package interfaceGrafica;

import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.MouseAdapter;

public class UsuarioConta extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UsuarioConta frame = new UsuarioConta();
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
	public UsuarioConta() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 752, 460);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		this.setLocationRelativeTo(null); // JANELA FICA NO CENTRO
		
		//VOLTAR 2
		ImageIcon voltar2 = new ImageIcon(UsuarioConta.class.getResource("/img/usuarioConta/voltar_bt2.png"));
		JLabel lblVoltar2 = new JLabel("");
		lblVoltar2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				UsuarioHome frame4 = new UsuarioHome(); frame4.setVisible(true);
				dispose();
			}
		});
		lblVoltar2.setBounds(23, 5, 93, 33);
		Image imgVoltar2 = voltar2.getImage().getScaledInstance(lblVoltar2.getWidth(), lblVoltar2.getHeight(), Image.SCALE_SMOOTH);
		lblVoltar2.setIcon(new ImageIcon(imgVoltar2));
		contentPane.add(lblVoltar2);
		lblVoltar2.setVisible(false);
		//FIM VOLTAR 2
		
		//VOLTAR
		ImageIcon voltar = new ImageIcon(UsuarioConta.class.getResource("/img/usuarioConta/voltar_bt1.png"));
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
		//FIM VOLTAR
		
		//BG
		ImageIcon background = new ImageIcon(UsuarioConta.class.getResource("/img/usuarioConta/Usuario_Conta.png"));
		JLabel lblBg = new JLabel("");
		lblBg.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				lblVoltar2.setVisible(false);
				getContentPane().setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
			}
		});
		lblBg.setBounds(0, 0, 736, 421);
		Image imagem = background.getImage().getScaledInstance(lblBg.getWidth(), lblBg.getHeight(), Image.SCALE_SMOOTH);
		lblBg.setIcon(new ImageIcon(imagem));
		contentPane.add(lblBg);
		//FIM BG
	}
}
