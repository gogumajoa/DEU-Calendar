package deu_calendar;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Enumeration;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.text.AbstractDocument;
import javax.swing.text.DocumentFilter;

public class entry extends JFrame {

	private JPanel contentPane;
	public static JTextField textField;
	public static JTextArea textArea;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					entry frame = new entry();
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
	public entry() {
		setTitle("\uC77C\uC815 \uB4F1\uB85D");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 724, 624);
		setLocation(610,200);
		setVisible(true);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\uC77C\uC815 \uB4F1\uB85D");
		lblNewLabel.setFont(new Font("êµ´ë¦¼", Font.PLAIN, 20));
		lblNewLabel.setBounds(303, 20, 95, 34);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\uC77C\uC815 \uC774\uB984");
		lblNewLabel_1.setBounds(138, 98, 69, 34);
		contentPane.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 16));
		textField.setBounds(219, 97, 330, 37);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("\uBA54\uBAA8");
		lblNewLabel_1_1.setBounds(138, 169, 69, 34);
		contentPane.add(lblNewLabel_1_1);
		
		textArea = new JTextArea();
		textArea.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 16));
		textArea.setLineWrap(true);
		textArea.setBounds(138, 213, 411, 111);
		contentPane.add(textArea);
		 
		// ¿©±âºÎÅÍ Ãß°¡
		int maxLength = 50; // ÃÖ´ë ±ÛÀÚ ¼ö
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
        }); // ¿©±â±îÁö
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("\uBC18\uBCF5 \uC5C6\uC74C");
		rdbtnNewRadioButton.setBackground(new Color(255, 255, 255));
		rdbtnNewRadioButton.setBounds(138, 363, 121, 23);
		contentPane.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("\uB9E4\uC6D4 \uAC19\uC740 \uC77C");
		rdbtnNewRadioButton_1.setBackground(new Color(255, 255, 255));
		rdbtnNewRadioButton_1.setBounds(361, 363, 121, 23);
		contentPane.add(rdbtnNewRadioButton_1);
		
		JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("\uB9E4\uC77C");
		rdbtnNewRadioButton_2.setBackground(new Color(255, 255, 255));
		rdbtnNewRadioButton_2.setBounds(138, 412, 121, 23);
		contentPane.add(rdbtnNewRadioButton_2);
		
		JRadioButton rdbtnNewRadioButton_3 = new JRadioButton("\uB9E4\uB144 \uAC19\uC740 \uC6D4\uC77C");
		rdbtnNewRadioButton_3.setBackground(new Color(255, 255, 255));
		rdbtnNewRadioButton_3.setBounds(361, 412, 121, 23);
		contentPane.add(rdbtnNewRadioButton_3);
		
		JRadioButton rdbtnNewRadioButton_4 = new JRadioButton("\uB9E4\uC8FC \uAC19\uC740 \uC694\uC77C");
		rdbtnNewRadioButton_4.setBackground(new Color(255, 255, 255));
		rdbtnNewRadioButton_4.setBounds(138, 467, 121, 23);
		contentPane.add(rdbtnNewRadioButton_4);
		
		// ë¼ë””ì˜¤ ê·¸ë£¹ ê°ì²´ ìƒì„±
		ButtonGroup BtnGroup = new ButtonGroup();
		
		// ë¼ë””ì˜¤ ë²„íŠ¼ë“¤ì„ ê·¸ë£¹ìœ¼ë¡œ ì¶”ê°€
		BtnGroup.add(rdbtnNewRadioButton);
		BtnGroup.add(rdbtnNewRadioButton_1);
		BtnGroup.add(rdbtnNewRadioButton_2);
		BtnGroup.add(rdbtnNewRadioButton_3);
		BtnGroup.add(rdbtnNewRadioButton_4);
		
		// registration í´ë˜ìŠ¤ì˜ ì¸ìŠ¤í„´ìŠ¤ ìƒì„±
		registration reg = new registration();
		
		JButton btnNewButton = new JButton("entry");
		
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// ì¼ì • ì œëª© ê°’ ë°›ì•„ì˜¤ê¸°
				reg.birngTitle(textField.getText());
				System.out.println(reg.birngTitle(textField.getText()));
				
				// ì¼ì • ë©”ëª¨ ê°’ ë°›ì•„ì˜¤ê¸°
				reg.bringMemo(textArea.getText());
				System.out.println(reg.bringMemo(textArea.getText()));
				
				// ì„ íƒëœ ë¼ë””ì˜¤ë²„íŠ¼ ê°’ ê°€ì ¸ì˜¤ê¸°
				JRadioButton selectBtn = null;
		        for (Enumeration<AbstractButton> buttons = BtnGroup.getElements(); buttons.hasMoreElements();) {
		            JRadioButton button = (JRadioButton) buttons.nextElement();
		            if (button.isSelected()) {
		            	selectBtn = button;
		                break;
		            }
		        }
				System.out.println(selectBtn.getActionCommand());
				reg.regist();
				dispose();
			} // ë“±ë¡ ë²„íŠ¼ í´ë¦­
		});
		btnNewButton.setBounds(217, 528, 97, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("cancel");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				dispose();
				
			} // ì·¨ì†Œ ë²„íŠ¼ í´ë¦­
		});
		
		JPanel panel = new JPanel();
		panel.setForeground(new Color(0, 0, 0));
		panel.setBackground(new Color(0, 0, 0));
		panel.setBounds(137, 212, 413, 113);
		contentPane.add(panel);
		btnNewButton_1.setBounds(373, 528, 97, 23);
		contentPane.add(btnNewButton_1);
	}
}
