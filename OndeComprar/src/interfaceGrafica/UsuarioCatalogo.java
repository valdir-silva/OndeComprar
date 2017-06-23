package interfaceGrafica;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.SystemColor;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import programa.Fachada;
import programa.Produto;
import programa.Reserva;
import programa.Usuario;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;

import java.awt.Color;
import java.awt.Cursor;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import java.awt.Toolkit;

public class UsuarioCatalogo extends JFrame {
	
	JLabel lblProvisorio2 = new JLabel("");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UsuarioCatalogo frame = new UsuarioCatalogo();
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
	
	
	public UsuarioCatalogo() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(UsuarioCatalogo.class.getResource("/img/favicon.png")));
		
		JPanel contentPane;
		JTable table;
		JTextField txtId = new JTextField();
		JTextField txtNome = new JTextField();
		JTextField txtMarca = new JTextField();
		JTextField txtPreco = new JTextField();
		JComboBox<Object> comboBox = new JComboBox<Object>();
		JTextField txtBuscar = new JTextField();
		JLabel lblSolicitar = new JLabel("");
		JLabel lblSolicitar2 = new JLabel("");
		String order="id";
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 752, 460);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		this.setLocationRelativeTo(null); // JANELA FICA NO CENTRO
		
		// TABELA
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(261, 111, 455, 260);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int row = table.getSelectedRow();
				int id = (int) table.getModel().getValueAt(row, 0);
				Produto produto = Fachada.getInstance().produtoParaTela(id);
				
				txtId.setText(Integer.toString(produto.getId()));
				txtNome.setText(produto.getNome());
				txtMarca.setText(produto.getMarca());
		        for (int i = 0; i < comboBox.getItemCount(); i++)
		        {
		            if (produto.getCategoria().equalsIgnoreCase((String) comboBox.getItemAt(i)))
		            {
		                comboBox.setSelectedIndex(i);
		                break;
		            }
		        }
				txtPreco.setText(Float.toString(produto.getPreco()));
			}
		});
		scrollPane.setViewportView(table);
		
		//FIM TABELA
		
		// BUSCAR
		txtBuscar.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				if(arg0.getKeyCode() == KeyEvent.VK_ENTER){
					table.setModel(Fachada.getInstance().listarProdutosTabela(txtBuscar.getText(), order));
					
					table.getColumnModel().getColumn(0).setPreferredWidth(50);
					table.getColumnModel().getColumn(1).setPreferredWidth(180); 
					table.getColumnModel().getColumn(2).setPreferredWidth(120); 
					table.getColumnModel().getColumn(3).setPreferredWidth(100);
					table.getColumnModel().getColumn(4).setPreferredWidth(60);
				}
			}
		});
		txtBuscar.setOpaque(false);
		txtBuscar.setForeground(SystemColor.controlDkShadow);
		txtBuscar.setColumns(10);
		txtBuscar.setBorder(null);
		txtBuscar.setBounds(263, 80, 157, 20);
		contentPane.add(txtBuscar);
		// FIM BUSCAR
		
		// PRECO
		txtPreco.setBounds(105, 307, 83, 20);
		contentPane.add(txtPreco);
		txtPreco.setColumns(10);
		txtPreco.setOpaque(false);
		txtPreco.setBorder(null);
		txtPreco.setEditable(false);
		// FIM PRECO
		
		// MARCA
		txtMarca.setBounds(31, 272, 157, 20);
		contentPane.add(txtMarca);
		txtMarca.setColumns(10);
		txtMarca.setOpaque(false);
		txtMarca.setBorder(null);
		txtMarca.setEditable(false);
		// FIM MARCA
		
		// NOME
		txtNome.setBounds(31, 226, 157, 20);
		contentPane.add(txtNome);
		txtNome.setColumns(10);
		txtNome.setOpaque(false);
		txtNome.setBorder(null);
		txtNome.setEditable(false);
		// FIM NOME
		
		// ID
		txtId.setBounds(31, 182, 157, 20);
		contentPane.add(txtId);
		txtId.setColumns(10);
		txtId.setOpaque(false);
		txtId.setBorder(null);
		txtId.setEditable(false);
		// FIM ID
		
		// COMBOBOX
		comboBox.setModel(new DefaultComboBoxModel<Object>(new String[] {"Smartphone", "Notebook", "Placa de Video", "Outro"}));
		comboBox.setBounds(21, 77, 167, 22);
		contentPane.add(comboBox);
		comboBox.getColorModel();
		// FIM COMBOBOX
		
		// SOLICITAR 2
		lblSolicitar2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Reserva reserva = new Reserva();
				Calendar date = Calendar.getInstance();;
				reserva.setData(date.get(Calendar.DAY_OF_MONTH) + "/" + (date.get(Calendar.MONTH)+1) + "/" + date.get(Calendar.YEAR));
				reserva.setProduto_id(Integer.parseInt(txtId.getText()));
				reserva.setCliente_id(Integer.parseInt(lblProvisorio2.getText()));
				Fachada.getInstance().solicitarReserva(reserva);
				JOptionPane.showMessageDialog(null, "Solicitação enviada!");
			}
		});
		ImageIcon solicitar2 = new ImageIcon(UsuarioCatalogo.class.getResource("/img/usuarioCatalogo/solicitar_bt2.png"));
		lblSolicitar2.setBounds(26, 338, 168, 38);
		Image imgSolicitar2 = solicitar2.getImage().getScaledInstance(lblSolicitar2.getWidth(), lblSolicitar2.getHeight(), Image.SCALE_SMOOTH);
		lblSolicitar2.setIcon(new ImageIcon(imgSolicitar2));
		contentPane.add(lblSolicitar2);
		lblSolicitar2.setVisible(false);
		// FIM SOLICITAR 2
		
		// SOLICITAR
		lblSolicitar.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				lblSolicitar2.setVisible(true);
				getContentPane().setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
		});
		ImageIcon solicitar = new ImageIcon(UsuarioCatalogo.class.getResource("/img/usuarioCatalogo/solicitar_bt1.png"));
		lblSolicitar.setBounds(26, 338, 168, 38);
		Image imgSolicitar = solicitar.getImage().getScaledInstance(lblSolicitar.getWidth(), lblSolicitar.getHeight(), Image.SCALE_SMOOTH);
		lblSolicitar.setIcon(new ImageIcon(imgSolicitar));
		contentPane.add(lblSolicitar);
		// FIM SOLICITAR
		
		JLabel lblProvisorio = new JLabel("provisorio:");
		lblProvisorio.setBounds(570, 388, 63, 14);
		contentPane.add(lblProvisorio);
		
		lblProvisorio2.setBounds(633, 388, 63, 14);
		contentPane.add(lblProvisorio2);
		
		//BG
		ImageIcon background = new ImageIcon(UsuarioCatalogo.class.getResource("/img/usuarioCatalogo/Usuario_Catalogo.png"));
		JLabel lblBg = new JLabel("");
		lblBg.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				lblSolicitar2.setVisible(false);
				getContentPane().setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
			}
		});
		lblBg.setBounds(0, 0, 747, 431);
		Image imagem = background.getImage().getScaledInstance(lblBg.getWidth(), lblBg.getHeight(), Image.SCALE_SMOOTH);
		lblBg.setIcon(new ImageIcon(imagem));
		contentPane.add(lblBg);
		//FIM BG
	}
	
	public void receber (Usuario user){
		lblProvisorio2.setText(Integer.toString(user.getId()));
	}
}
