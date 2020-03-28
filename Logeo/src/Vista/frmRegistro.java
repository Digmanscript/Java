package Vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controlador.Busuarios;
import Controlador.SqlUsuarios;
import Utilidades.hash;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class frmRegistro extends JFrame {

	private JPanel contentPane;
	private JTextField txtUsuario;
	private JTextField txtNombre;
	private JTextField txtCorreo;
	private JPasswordField txtConfirmaPassword;
	private JPasswordField txtPassword;

	/**
	 * Launch the application.
	 */

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmRegistro frame = new frmRegistro();
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
	public frmRegistro() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				frmMain.frmReg = null;
			}
		});
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 401);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Usuario:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(10, 34, 63, 14);
		contentPane.add(lblNewLabel);

		txtUsuario = new JTextField();
		txtUsuario.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtUsuario.setBounds(125, 31, 203, 20);
		contentPane.add(txtUsuario);
		txtUsuario.setColumns(10);

		JLabel lblContrasea = new JLabel("Password:");
		lblContrasea.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblContrasea.setBounds(10, 78, 63, 14);
		contentPane.add(lblContrasea);

		JLabel lblNewLabel_1_1 = new JLabel("<html>Confirmar Password:</html>");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1.setBounds(10, 118, 78, 34);
		contentPane.add(lblNewLabel_1_1);

		JLabel lblNewLabel_1_2 = new JLabel("Nombre:");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_2.setBounds(10, 185, 63, 14);
		contentPane.add(lblNewLabel_1_2);

		JLabel lblNewLabel_1_3 = new JLabel("Correo:");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_3.setBounds(10, 247, 63, 14);
		contentPane.add(lblNewLabel_1_3);

		txtNombre = new JTextField();
		txtNombre.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtNombre.setColumns(10);
		txtNombre.setBounds(125, 182, 203, 20);
		contentPane.add(txtNombre);

		txtCorreo = new JTextField();
		txtCorreo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtCorreo.setColumns(10);
		txtCorreo.setBounds(125, 244, 203, 20);
		contentPane.add(txtCorreo);

		txtConfirmaPassword = new JPasswordField();
		txtConfirmaPassword.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtConfirmaPassword.setBounds(125, 132, 203, 20);
		contentPane.add(txtConfirmaPassword);

		txtPassword = new JPasswordField();
		txtPassword.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtPassword.setBounds(125, 75, 203, 20);
		contentPane.add(txtPassword);

		JButton btnRegistrar = new JButton("Registrar");
		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SqlUsuarios modSql = new SqlUsuarios();
				Busuarios mod = new Busuarios();
				String pass = new String(txtPassword.getPassword());
				String passCon = new String(txtConfirmaPassword.getPassword());

				
				
				if (txtUsuario.getText().equals("") || pass.equals("") || passCon.equals("")
						|| txtNombre.getText().equals("") || txtCorreo.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Hay campos Vacios - Debe llenar todos los campos");

				} else {

					if (pass.equals(passCon)) {
						if (modSql.existeUsuario(txtUsuario.getText()) == 0) {
							if (modSql.esEmail(txtCorreo.getText())) {

								String nuevoPass = hash.sha1(pass);

								mod.setUsuario(txtUsuario.getText());
								mod.setPassword(nuevoPass);
								mod.setNombre(txtNombre.getText());
								mod.setCorreo(txtCorreo.getText());
								mod.setId_tipo(1);


								if (modSql.registrar(mod)) {
									JOptionPane.showMessageDialog(null, "Registro Guardado");
									limpiar();

								} else {
									JOptionPane.showMessageDialog(null, "Error al Guardar");
								}
							} else {
								JOptionPane.showMessageDialog(null, "El correo electronico no es valido");
							}

						} else {
							JOptionPane.showMessageDialog(null, "El Usuario ya existe");
						}

					} else {
						JOptionPane.showMessageDialog(null, "Las contraseñas no coinciden");

					}
				}
			}

			private void limpiar() {
				txtUsuario.setText("");
				txtPassword.setText("");
				txtConfirmaPassword.setText("");
				txtNombre.setText("");
				txtCorreo.setText("");

			}
		});
		btnRegistrar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnRegistrar.setBounds(164, 288, 89, 23);
		contentPane.add(btnRegistrar);
	}
}
