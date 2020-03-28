import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;

public class calculador extends JFrame {

	private JPanel contentPane;
	private JTextField n1;
	private JTextField n2;
	private JTextField r;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					calculador frame = new calculador();
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
	public calculador() {
		setTitle("Calculadora");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNumero = new JLabel("Numero 1");
		lblNumero.setFont(new Font("Arial Black", Font.PLAIN, 11));
		lblNumero.setBounds(34, 28, 61, 14);
		contentPane.add(lblNumero);
		
		JLabel lblNumero_1 = new JLabel("Numero 2");
		lblNumero_1.setFont(new Font("Arial Black", Font.PLAIN, 11));
		lblNumero_1.setBounds(165, 28, 84, 14);
		contentPane.add(lblNumero_1);
		
		JLabel lblResultado = new JLabel("Resultado");
		lblResultado.setFont(new Font("Arial Black", Font.PLAIN, 11));
		lblResultado.setBounds(319, 28, 68, 14);
		contentPane.add(lblResultado);
		
		n1 = new JTextField();
		n1.setBounds(10, 53, 101, 20);
		contentPane.add(n1);
		n1.setColumns(10);
		
		n2 = new JTextField();
		n2.setBounds(148, 53, 101, 20);
		contentPane.add(n2);
		n2.setColumns(10);
		
		r = new JTextField();
		r.setEditable(false);
		r.setForeground(Color.BLACK);
		r.setBounds(290, 53, 118, 20);
		contentPane.add(r);
		r.setColumns(10);
		
		JButton btnSuma = new JButton("+");
		btnSuma.setFont(new Font("Arial Black", Font.PLAIN, 16));
		btnSuma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int a,b,c;
				a= Integer.parseInt(n1.getText());
				b= Integer.parseInt(n2.getText());
				c = a + b;
			    String res = Integer.toString(c);
			    r.setText(res);
				
			}
		});
		btnSuma.setBounds(10, 115, 61, 23);
		contentPane.add(btnSuma);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.setForeground(Color.BLACK);
		btnSalir.setFont(new Font("Arial Black", Font.PLAIN, 11));
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnSalir.setBounds(335, 238, 89, 23);
		contentPane.add(btnSalir);
		
		JButton btnResta = new JButton("-");
		btnResta.setFont(new Font("Arial Black", Font.PLAIN, 16));
		btnResta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int a,b,c;
				a= Integer.parseInt(n1.getText());
				b= Integer.parseInt(n2.getText());
				c = a - b;
			    String res = Integer.toString(c);
			    r.setText(res);
			}
		});
		btnResta.setBounds(117, 115, 61, 23);
		contentPane.add(btnResta);
		
		JButton btnX = new JButton("x");
		btnX.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int a,b,c;
				a= Integer.parseInt(n1.getText());
				b= Integer.parseInt(n2.getText());
				c = a * b;
			    String res = Integer.toString(c);
			    r.setText(res);
			}
		});
		btnX.setFont(new Font("Arial Black", Font.PLAIN, 16));
		btnX.setBounds(224, 115, 61, 23);
		contentPane.add(btnX);
		
		JButton button_1 = new JButton("/");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int a,b;
				float c;
				a= Integer.parseInt(n1.getText());
				b= Integer.parseInt(n2.getText());
				if(a==0 || b == 0) {
					JOptionPane.showMessageDialog(null, "No se puede realizar la division con el numero 0");
					n1.setText("");
					n2.setText("");
					r.setText("");
				}
				c = a / b;
			    String res = Float.toString(c);
			    r.setText(res);
			}
		});
		button_1.setFont(new Font("Arial Black", Font.PLAIN, 16));
		button_1.setBounds(347, 115, 61, 23);
		contentPane.add(button_1);
		
		JButton btnLimpiar = new JButton("Limpiar");
		btnLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Limpieza Realizada");
				n1.setText("");
				n2.setText("");
				r.setText("");
			}
		});
		btnLimpiar.setForeground(Color.RED);
		btnLimpiar.setFont(new Font("Arial Black", Font.PLAIN, 11));
		btnLimpiar.setBounds(165, 162, 89, 23);
		contentPane.add(btnLimpiar);
	}
}
