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
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JList;
import javax.swing.AbstractListModel;

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
		setResizable(false);
		setTitle("\uC0C1\uC138 \uC77C\uC815");
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 668, 503);
		setLocationRelativeTo(null); // 화면 중앙 정렬
		setVisible(true);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.window);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("\uC77C\uC815 \uB4F1\uB85D");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {    
				new entry();
			}
		});
		btnNewButton.setBounds(420, 60, 94, 28);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("date");
		lblNewLabel.setBounds(260, 20, 65, 37);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton_1 = new JButton("\uC218\uC815");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new change();
			} // 수정 버튼 클릭
		});
		btnNewButton_1.setBounds(538, 150, 65, 50);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("\uC218\uC815");
		btnNewButton_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new change();
			} // 수정 버튼 클릭
		});
		btnNewButton_1_1.setBounds(538, 255, 65, 50);
		contentPane.add(btnNewButton_1_1);
	}
}
