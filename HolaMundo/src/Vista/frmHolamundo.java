package Vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class frmHolamundo extends JFrame {

	private JPanel contentPane;
	private static String mundo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		mundo = "Hola Mundo!";
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmHolamundo frame = new frmHolamundo();
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
	public frmHolamundo() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnHola = new JButton("Hola Mundo");
		btnHola.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				System.out.println(mundo);
				
				JOptionPane.showMessageDialog(null, mundo);
				
			}
		});
		btnHola.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnHola.setBounds(137, 97, 165, 53);
		contentPane.add(btnHola);
	}
}
