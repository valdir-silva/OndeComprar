package interfaceGrafica;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DataBase.RepositorioUsuario;
import programa.Empresa;
import programa.Usuario;

import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

public class EmpresaHome extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
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
		
		//BG
		ImageIcon background = new ImageIcon(EmpresaHome.class.getResource("/img/empresaHome/Empresa_Home.png"));
		JLabel lblBg = new JLabel("");
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
		System.out.println(emp.getCnpj());
		/*
		lblProvisorio2.setText(Integer.toString(user.getId()));
		RepositorioUsuario repositorio = new RepositorioUsuario();
		table.setModel(repositorio.listarReservas(user.getId()));
		
		table.getColumnModel().getColumn(0).setPreferredWidth(30);
		table.getColumnModel().getColumn(1).setPreferredWidth(80); 
		table.getColumnModel().getColumn(2).setPreferredWidth(120); 
		table.getColumnModel().getColumn(3).setPreferredWidth(80);
		
		lblPendentes.setText(String.valueOf(repositorio.reservasPendentes(user.getId())));
		lblAceitas.setText(String.valueOf(repositorio.reservasAceitas(user.getId())));
		lblRecusadas.setText(String.valueOf(repositorio.reservasRecusadas(user.getId())));
		lblPendentes.setForeground(new Color(149, 152, 154));
		lblAceitas.setForeground(new Color(149, 152, 154));
		lblRecusadas.setForeground(new Color(149, 152, 154));
		*/
	}
}
