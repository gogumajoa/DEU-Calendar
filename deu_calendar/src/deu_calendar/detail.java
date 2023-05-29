package deu_calendar;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;
import java.awt.SystemColor;

public class detail extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					detail frame = new detail();
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
	public detail() {
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 668, 503);
		setVisible(true);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.window);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("entry");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
//				entry ee = new entry();
//				ee.setVisible(true);
//				dispose();     
				new entry();
			}
		});
		btnNewButton.setBounds(420, 60, 94, 28);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("date");
		lblNewLabel.setBounds(260, 20, 65, 37);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("subject");
		lblNewLabel_1.setBounds(67, 123, 112, 77);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("subject title");
		lblNewLabel_2.setBounds(207, 123, 307, 82);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_1_1 = new JLabel("title");
		lblNewLabel_1_1.setBounds(67, 241, 112, 77);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_2_1 = new JLabel("memo");
		lblNewLabel_2_1.setBounds(207, 241, 307, 82);
		contentPane.add(lblNewLabel_2_1);
		
		JButton btnNewButton_1 = new JButton("change");
		btnNewButton_1.setBounds(538, 150, 65, 50);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("change");
		btnNewButton_1_1.setBounds(538, 255, 65, 50);
		contentPane.add(btnNewButton_1_1);
	}

}
