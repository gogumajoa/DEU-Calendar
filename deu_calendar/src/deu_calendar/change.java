package deu_calendar;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.AbstractDocument;
import javax.swing.text.DocumentFilter;
import javax.swing.text.DocumentFilter.FilterBypass;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JTextArea;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class change extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					change frame = new change();
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
	public change() {
		setResizable(false);
		setTitle("\uC77C\uC815 \uC218\uC815");
		setSize(724,624);
		setLocationRelativeTo(null); // 화면 중앙 정렬
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextArea textArea = new JTextArea();
		textArea.setFont(new Font("맑은 고딕", Font.PLAIN, 16));
		textArea.setLineWrap(true);
		textArea.setBounds(138, 213, 411, 111);
		contentPane.add(textArea);
		
		// 여기부터 추가
				int maxLength = 50; // 최대 글자 수
		        AbstractDocument doc = (AbstractDocument) textArea.getDocument();
		        doc.setDocumentFilter(new DocumentFilter() {
		            @Override
		            public void replace(FilterBypass fb, int offset, int length, String text, javax.swing.text.AttributeSet attrs) throws javax.swing.text.BadLocationException {
		                int currentLength = fb.getDocument().getLength();
		                int overLimit = (currentLength + text.length()) - maxLength - length;
		                if (overLimit > 0) {
		                    text = text.substring(0, text.length() - overLimit);
		                }
		                if (text.length() > 0) {
		                    super.replace(fb, offset, length, text, attrs);
		                }
		            }
		        }); // 여기까지
		
		JLabel lblNewLabel = new JLabel("\uC77C\uC815 \uC218\uC815");
		lblNewLabel.setFont(new Font("굴림", Font.PLAIN, 20));
		lblNewLabel.setBounds(303, 20, 95, 34);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\uC77C\uC815 \uC774\uB984");
		lblNewLabel_1.setBounds(138, 98, 69, 34);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("\uBA54\uBAA8");
		lblNewLabel_2.setBounds(138, 169, 69, 34);
		contentPane.add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setFont(new Font("맑은 고딕", Font.PLAIN, 16));
		textField.setBounds(219, 97, 330, 37);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 0, 0));
		panel.setBounds(137, 212, 413, 113);
		contentPane.add(panel);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("\uBC18\uBCF5 \uC5C6\uC74C");
		rdbtnNewRadioButton.setBackground(Color.WHITE);
		rdbtnNewRadioButton.setBounds(138, 363, 121, 23);
		contentPane.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("\uB9E4\uC77C");
		rdbtnNewRadioButton_2.setBackground(Color.WHITE);
		rdbtnNewRadioButton_2.setBounds(138, 412, 121, 23);
		contentPane.add(rdbtnNewRadioButton_2);
		
		JRadioButton rdbtnNewRadioButton_4 = new JRadioButton("\uB9E4\uC8FC \uAC19\uC740 \uC694\uC77C");
		rdbtnNewRadioButton_4.setBackground(Color.WHITE);
		rdbtnNewRadioButton_4.setBounds(138, 467, 121, 23);
		contentPane.add(rdbtnNewRadioButton_4);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("\uB9E4\uC6D4 \uAC19\uC740 \uC77C");
		rdbtnNewRadioButton_1.setBackground(Color.WHITE);
		rdbtnNewRadioButton_1.setBounds(361, 363, 121, 23);
		contentPane.add(rdbtnNewRadioButton_1);
		
		JRadioButton rdbtnNewRadioButton_3 = new JRadioButton("\uB9E4\uB144 \uAC19\uC740 \uC6D4\uC77C");
		rdbtnNewRadioButton_3.setBackground(Color.WHITE);
		rdbtnNewRadioButton_3.setBounds(361, 412, 121, 23);
		contentPane.add(rdbtnNewRadioButton_3);
		
		JButton btnNewButton = new JButton("\uC218\uC815");
		btnNewButton.setBounds(192, 518, 97, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\uCDE8\uC18C");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			} // 취소 버튼 클릭
		});
		btnNewButton_1.setBounds(410, 518, 97, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("\uC0AD\uC81C");
		btnNewButton_1_1.setBounds(301, 518, 97, 23);
		contentPane.add(btnNewButton_1_1);
	}
}
