package deu_calendar;

import deu_calendar.mainScreen_Control;

import java.awt.BorderLayout;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import java.awt.SystemColor;
import javax.swing.border.LineBorder;

public class mainScreen extends JFrame implements ItemListener, ActionListener{
	Font fnt = new Font("±¼¸²Ã¼", Font.BOLD, 15);
	Font fnt2 = new Font("±¼¸²Ã¼", Font.BOLD, 12);
	
	
	//»ó´Ü
	JPanel selectPane = new JPanel(); //ÆĞ³Î»ı¼º
		JButton prevBtn = new JButton("¢¸"); //ÀÌÀü¹öÆ°
		JButton nextBtn = new JButton("¢º"); //´ÙÀ½¹öÆ°
		JComboBox<Integer> yearCombo = new JComboBox<Integer>(); //³âµµ ÄŞº¸¹Ú½ºÃß°¡
		JComboBox<Integer> monthCombo = new JComboBox<Integer>(); //¿ù ÄŞº¸¹Ú½º Ãß°¡
		JLabel yearLBl = new JLabel("³â");  //"³â"À» Ç¥½ÃÇÒ ¶óº§ Ãß°¡
		JLabel monthLBl = new JLabel("¿ù"); //"¿ù"À» Ç¥½ÃÇÒ ¶óº§Ãß°¡
		
	//°¡¿îµ¥
	JPanel centerPane = new JPanel(new BorderLayout()); //°¡¿îµ¥ ÆĞ³ÎÀ» »ı¼ºÇÏ°í borderLayoutÀ¸·Î Àâ¾ÆÁØ´Ù. 
														//borderLayout : »óÇÏÁÂ¿ì °¡¿îµ¥·Î ³ª´µ¾î¼­ layoutÀ» Àâ´Â°Í
		JPanel titlePane = new JPanel(new GridLayout(1, 7));// Å¸ÀÌÆ²À» »ı¼º½ÃÅ³ ÆĞ³ÎÀ» »ı¼ºÇÏ°í GridLayoutÀ¸·Î Àâ¾ÆÁØ´Ù.
															// GridLayout: ÁöÁ¤µÈ ¼öÀÇ Çà°ú ¿­À» »ı¼ºÇÏ´Â ·¹ÀÌ¾Æ¿ôÀÌ´Ù 1Çà 7¿­ÀÌ¹Ç·Î ÀÏ,¿ù,È­,¼ö,¸ñ,±İ,Åä °¡ µé¾î°¡°ÔµÈ´Ù.
		String[] title = {"ÀÏ", "¿ù", "È­", "¼ö", "¸ñ", "±İ", "Åä"};
		JPanel dayPane = new JPanel(new GridLayout(0, 7)); // À§¿Í µ¿ÀÏÇÏ¸ç ³¯Â¥°¡ ³ª¿À°Ô µÈ´Ù. 
	
	//´Ş·Â°ü·Ã µ¥ÀÌÅÍ
	Calendar date; //´Ş·ÂÁÖÀÔ
	int year; //³â°ú, ¿ù ÁÖÀÔ
	int month;
	private final JLabel lblNewLabel = new JLabel("\uB3D9\uC758 \uCE98\uB9B0\uB354");
	private final JLabel lblNewLabel_1 = new JLabel("\uC77C\uC815 \uB9AC\uC2A4\uD2B8");
	private final JTextArea txtrTestTest = new JTextArea();
	
	
	
	public mainScreen() {
		super("µ¿ÀÇ Ä¶¸°´õ");
		setResizable(false);
		getContentPane().setBackground(Color.WHITE);
		date = Calendar.getInstance();//ÇöÀçÀÇ ³¯Â¥ ½Ã°£ °´Ã¼ »ı¼º + °´Ã¼¸¦ ¹Ş¾Æ¿Â´Ù.
		year = date.get(Calendar.YEAR); // Ä¶¸°´õ¿¡¼­ ³âÀ» ¹Ş¾Æ¿Í¼­ ¹Ì¸®»ı¼ºÇØ³õÀº year¿¡ ÁÖÀÔÇÑ´Ù.
		month = date.get(Calendar.MONTH)+1; //¿ùÀ» ¹Ş¾Æ¿Í¼­ month¿¡ ´ëÀÔÇÑ´Ù. +1À» ÇÏ´Â ÀÌÀ¯´Â 0~11ÀÌ¶ó
		getContentPane().setLayout(null);
		selectPane.setBounds(202, 46, 729, 37);
		
		//»ó´Ü
		selectPane.setBackground(Color.WHITE); //¹é±×¶ó¿îµåÀÇ ¹è°æÀ» ÁÖÀÔÇÑ´Ù.
		selectPane.add(prevBtn); prevBtn.setFont(fnt);  
		selectPane.add(yearCombo); yearCombo.setFont(fnt);
		selectPane.add(yearLBl); yearLBl.setFont(fnt);
		selectPane.add(monthCombo); monthCombo.setFont(fnt);
		selectPane.add(monthLBl); monthLBl.setFont(fnt);
		selectPane.add(nextBtn); nextBtn.setFont(fnt);  //ÆĞ³Î¿¡ ´ëÀÔÇÑÈÄ ÀÛ¼ºÇÑ font¸¦ ÁÖÀÔÇÑ´Ù.
		
		getContentPane().add(selectPane); // borderLayout : »óÇÏÁÂ¿ì °¡¿îµ¥·Î ³ª´µ¾î¼­ layoutÀ» Àâ´Â°Í
											// À§¿¡ ´ëÀÔ½ÃÅ°°í selectPaneÀ» ³Ö´Â´Ù.
		
		//ÇöÀç ³â, ¿ù ¼¼ÆÃ
		setYear();	
		setMonth();
		
		//titleÈ£Ãâ
		setCalendarTitle();		//ÀÏ¿ùÈ­¼ö¸ñ±İÅä¸¦ ¸¸µé¾î³õÀº ¸Ş¼Òµå setCalendarTitleÀ» È£ÃâÇÑ´Ù.
		centerPane.setBounds(202, 89, 729, 380);
		titlePane.setBorder(new LineBorder(new Color(0, 0, 0)));
		titlePane.setBackground(new Color(220, 220, 220));
		centerPane.add(BorderLayout.NORTH, titlePane);	//¼¾ÅÍÆĞ³ÎÀÇ À§ÂÊ¿¡ titleÀ» ³Ö´Â´Ù(ÀÏ¿ùÈ­¼ö¸ñ±İÅä)
		getContentPane().add(centerPane);
		dayPane.setBorder(new LineBorder(new Color(0, 0, 0)));
		dayPane.setBackground(Color.WHITE);
		
		//³¯Â¥¸¸µé±â
		centerPane.add(dayPane);
		lblNewLabel.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 33));
		lblNewLabel.setBounds(407, 5, 226, 37);
		
		getContentPane().add(lblNewLabel);
		lblNewLabel_1.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 17));
		lblNewLabel_1.setBounds(61, 46, 91, 37);
		
		getContentPane().add(lblNewLabel_1); //ì¼ì • ë¦¬ìŠ¤íŠ¸ì¸ê°€?
		txtrTestTest.setBorder(new LineBorder(new Color(0, 0, 0)));
		txtrTestTest.setBackground(new Color(255, 255, 255));
		txtrTestTest.setEditable(false);
		txtrTestTest.setRows(10);
		txtrTestTest.setText("TEST1\r\nTEST2");
		txtrTestTest.setBounds(12, 89, 178, 380);
		
		getContentPane().add(txtrTestTest);
		setDay();	//setDay()¸Ş¼Òµå¸¦ È£ÃâÇÑ´Ù.
		
		
		//---------------------------±â´ÉÀÌº¥Æ®¸¦ Ãß°¡-------------------------------
		prevBtn.addActionListener(this);
		nextBtn.addActionListener(this);
		//³â¿ù ÀÌº¥Æ® ´Ù½Ãµî·Ï
		yearCombo.addItemListener(this);
		monthCombo.addItemListener(this);
		
		//JFrameÀÇ ¼³Á¤µé
		setLocation(450,200);
		setSize(959, 518);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
	//³¯Â¥¼ÂÆÃ
	public void setDay() {
		//¿äÀÏ
		date.set(year, month-1, 1); //date¸¦ ¼¼ÆÃÇÏ´Âµ¥, ÀÏ(day)¸¦ 1·Î ¼¼ÆÃÇÑ´Ù.
		int week = date.get(Calendar.DAY_OF_WEEK); //DAY_OF_WEEK´Â ÀÏ¿ùÈ­¼ö¸ñ±İÅäÀÌ¸ç ÀÌµ¥ÀÌÅÍ¸¦ ¹Ş¾Æ¿Í¼­ week¿¡ ³Ö´Â´Ù.
		//¸¶Áö¸·³¯
		int lastDay = date.getActualMaximum(Calendar.DATE); //getActualMaximum ´Â ³¯Â¥°¡ ¼ÂÆÃ µÈ Calender °¡ °¡Áú¼ö ÀÖ´Â °ª
															//getMaximum ´Â Calender ÀÚÃ¼°¡ ÃÖ´ë·Î °¡Áú¼ö ÀÖ´Â °ª
															//¸¶Áö¸·³¯À» ºÒ·¯¿Â´Ù.
		//°ø¹é
		for(int s=1; s<week; s++) {  //¹İº¹¹®À» µ¹¸°´Ù.
			JLabel lbl = new JLabel(" "); //µé¿©¾²±â
			dayPane.add(lbl);
		}
		//³¯Â¥Ãß°¡
		for(int day=1; day<=lastDay; day++) {
<<<<<<< HEAD
			/*
			 * JButton lbl = new JButton(String.valueOf(day)); //ë¼ë²¨ì„ ì–¸í•´ì£¼ëŠ”ë° String.value ëŠ”
			 * í˜•ë³€í™˜ì´ë‹¤. JLabelì„ ê°€ìš´ë°ì— ì…ë ¥í•˜ê²Œë‘”ë‹¤. //
			 * lbl.setHorizontalAlignment(SwingConstants.TOP); //// ê°€ìš´ë° ì •ë ¬ //
			 * lbl.setEditable(false);
			 * 
			 * mainScreen_Control main_con = new mainScreen_Control(); ArrayList<String>
			 * dbData = main_con.ConnectDB(year, month, day); //connectDB í˜¸ì¶œ StringBuilder
			 * sb = new StringBuilder(); for (String item : dbData) { //sb.insert(0, "-");
			 * sb.append(item).append("<br>"); //ê°ìì˜ ìš”ì†Œ ë’¤ì— <br> ì¶”ê°€ (í•œì¤„ ë„ìš°ê¸° } int
			 * maxCharacters = 10; // ìµœëŒ€ í‘œì‹œí•  ë¬¸ì ìˆ˜ String labelText = (String.valueOf(day) +
			 * "<br>" +sb.toString()); //ë²„íŠ¼ì— ì¼, ì¼ì • ì¶œë ¥ if (labelText.length() >
			 * maxCharacters) { //ê¸€ììˆ˜ ì–´ëŠì •ë„ ë„˜ì–´ê°€ë©´ ...ìœ¼ë¡œ í‘œì‹œ labelText = labelText.substring(0,
			 * maxCharacters) + "..."; } lbl.setText("<html>" + labelText + "</html>");
			 * //html íƒœê·¸ ì“°ê² ë‹¤ëŠ” ì˜ë¯¸
			 * 
			 * lbl.setBackground(Color.WHITE); lbl.setFont(fnt); //ë¼ë²¨ì— í°íŠ¸ë¥¼ ì£¼ì…í•œë‹¤.
			 */			
			JButton lbl = new JButton();
		    lbl.setLayout(new BorderLayout()); // ë²„íŠ¼ì˜ ë ˆì´ì•„ì›ƒì„ BorderLayoutìœ¼ë¡œ ì„¤ì •í•©ë‹ˆë‹¤.

		    JLabel dayLabel = new JLabel(String.valueOf(day));
		    dayLabel.setHorizontalAlignment(SwingConstants.RIGHT); // ë‚ ì§œë¥¼ ì˜¤ë¥¸ìª½ ì •ë ¬í•©ë‹ˆë‹¤.
		    lbl.add(dayLabel, BorderLayout.NORTH); // ë‚ ì§œë¥¼ ë²„íŠ¼ì˜ ìƒë‹¨ì— ì¶”ê°€í•©ë‹ˆë‹¤.

		    mainScreen_Control main_con = new mainScreen_Control();
		    ArrayList<String> dbData = main_con.ConnectDB(year, month, day);
		    StringBuilder sb = new StringBuilder();
		    for (String item : dbData) {
		        sb.append(item).append("\n");
		    }

		    String[] lines = sb.toString().split("\n");
		    StringBuilder labelTextBuilder = new StringBuilder();
		    for (String line : lines) {
		    	if (line.length() > 8) {
		            line = line.substring(0, 8) + "..";
		        }
		        labelTextBuilder.append(line).append("\n");
		    }
		    String labelText = labelTextBuilder.toString().trim();

		    JLabel scheduleLabel = new JLabel("<html>" + labelText.replace("\n", "<br>") + "</html>");
		    System.out.println(labelText);
		    Font font = scheduleLabel.getFont();
		    Font smallerFont = font.deriveFont(font.getSize() - 2f); // í°íŠ¸ í¬ê¸°ë¥¼ 2í¬ì¸íŠ¸ ì‘ê²Œ ì„¤ì •
		    scheduleLabel.setFont(smallerFont);
		    lbl.add(scheduleLabel, BorderLayout.CENTER); // ì¼ì •ì„ ë²„íŠ¼ì˜ ì¤‘ì•™ì— ì¶”ê°€í•©ë‹ˆë‹¤.
		    
		    
		    lbl.setBackground(Color.WHITE); 
		    lbl.setFont(fnt); //ë¼ë²¨ì— í°íŠ¸ë¥¼ ì£¼ì…í•œë‹¤.
		    
		    lbl.addActionListener(new ActionListener() {
=======
			JButton lbl = new JButton(String.valueOf(day)); //¶óº§¼±¾ğÇØÁÖ´Âµ¥ String.value ´Â Çüº¯È¯ÀÌ´Ù. JLabelÀ» °¡¿îµ¥¿¡ ÀÔ·ÂÇÏ°ÔµĞ´Ù.
//			lbl.setHorizontalAlignment(SwingConstants.TOP);		//// °¡¿îµ¥ Á¤·Ä
//			lbl.setEditable(false);
			lbl.setBackground(Color.WHITE);
			lbl.setFont(fnt); //¶óº§¿¡ ÆùÆ®¸¦ ÁÖÀÔÇÑ´Ù.
			
			lbl.addActionListener(new ActionListener() {
>>>>>>> upstream/main
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					new detail();
				}
			});
			
<<<<<<< HEAD
			
			//ì¶œë ¥í•˜ëŠ” ë‚ ì§œì— ëŒ€í•œ ìš”ì¼
=======
			//Ãâ·ÂÇÏ´Â ³¯Â¥¿¡ ´ëÇÑ ¿äÀÏ
>>>>>>> upstream/main
			date.set(Calendar.DATE, day); // 19 ->1
			int w = date.get(Calendar.DAY_OF_WEEK); //¿äÀÏ
			if(w ==1) lbl.setForeground(Color.red); //ÀÏ¿ùÈ­¼ö¸ñ±İÅä (1~7) 1Àº ÀÏ¿äÀÏÀÌ¹Ç·Î ÀÏ¿äÀÏ¿¡ red»ö±ò
			if(w ==7) lbl.setForeground(Color.blue); //7ÀÌ¹Ç·Î blue»ö±ò
			dayPane.add(lbl);
			
		}
	}
	//¿ùÈ­¼ö¸ñ±İÅäÀÏ ¼³Á¤
	public void setCalendarTitle() { //¸Ş¼Òµå
		for(int i =0; i <title.length; i++) { //¸¸µé¾îÁØ ¹è¿­ÀÇ ¼ö¸¸Å­ µ¹¸°´Ù.
			JLabel lbl = new JLabel(title[i], JLabel.CENTER); //¸¸µé¾îÁØ ¹è¿­ÀÇ ¼ö¸¸Å­ label¿¡ ÁÖÀÔ½ÃÅ°°í °¡¿îµ¥·Î ¿À°ÔÇÑ´Ù.
			lbl.setFont(fnt); //ÆùÆ®Àû¿ë
			if(i ==0) lbl.setForeground(Color.red); //setForegroundÆùÆ®¼Ó¼ºÀ» º¯°æÇØÁÖ´Âµ¥ ¾²´Â°Í,
			if(i ==6) lbl.setForeground(Color.blue);
			titlePane.add(lbl); //Å¸ÀÌÆ²ÆĞ³Î¿¡ ¶óº§À» Ãß°¡½ÃÅ²´Ù.
		}
	}
	//³âµµ¼¼ÆÃ
	public void setYear() {
		for(int i= year-50; i<year+20; i++) { //ÇØ´ç±¸¹®À» ¹İº¹¹®À»µ¹·Á¼­
			yearCombo.addItem(i); //yearCombo¹Ú½º¿¡ ´ã´Â´Ù.
		}
		yearCombo.setSelectedItem(year); //ÄŞº¸¹Ú½º¿¡ ´ãÁö¸¸ ÀÌº¥Æ®¿Í ¿¬µ¿½ÃÄÑÁÖ±âÀ§ÇØ ¼±¾ğ
	}
	//¿ù¼¼ÆÃ
	public void setMonth() {
		for(int i=1; i<=12; i++) {
			monthCombo.addItem(i);
		}
		monthCombo.setSelectedItem(month); //À§¿Íµ¿
	}
	
	//ÄŞº¸¹Ú½ºÅ¬¸¯ÀÌº¥Æ®
	public void itemStateChanged(ItemEvent e) { //ÄŞº¸¹Ú½º¸¦ º¯°æÇÏ¿´À»¶§¿¡ ¼±ÅÃµÇ´Â ÀÌº¥Æ®ÀÌ´Ù.
		year = (int)yearCombo.getSelectedItem(); //Çüº¯È¯ÇÑ°ÍÀ»º¼¼ö ÀÖÀ¸¸ç yearCombo¹Ù²î¾úÀ»¶§ yearComboÀÇ °ªÀ» getSelected °¡Á®¿Í¼­ Ã£´Â°ÍÀ» º¼¼ö ÀÖ´Ù.
		month = (int)monthCombo.getSelectedItem();
		
		dayPane.setVisible(false); //ÆĞ³ÎÀ» ´İ´Â´Ù.
		dayPane.removeAll(); //¿ø·¡ÀÖ´Â ³¯Â¥ Áö¿ì±â
		setDay(); //³¯Â¥ Ã³¸® ÇÔ¼ö È£Ãâ
		dayPane.setVisible(true); //ÆĞ³ÎÀ» º¼¼öÀÖ°Ô Ã³¸®ÇÑ´Ù.
		
									//¿©±â¼­ ´İ°í Áö¿ü´Ù°¡ È£ÃâÇÏ°í, ´Ù½Ã º¸¿©ÁÖ´Â ÀÌÀ¯´Â  ¾È±×·¯¸é È­¸éÀÌ Áö¿öÁöÁö¾Ê±â ¶§¹®ÀÌ´Ù.
		
	}
	//¹öÆ°ÀÌº¥Æ® 
	public void actionPerformed(ActionEvent ae) {  //¾×¼ÇÀÌº¥Æ®(¹öÆ°ÀÌº¥Æ®)
		Object obj = ae.getSource(); //Obejct¿¡ ¾×¼ÇÀÌº¥Æ®ÀÇ ¼Ò½º¸¦ °¡Á®¿Â´Ù.
		if(obj == prevBtn) {//ÀÌÀü¹öÆ°À» ´­·¶À»¶§
			//ÀÌÀü¿ùÀ» ´­·¶À»¶§
			prevMonth(); //ÀÌÀü¹öÆ°¸Ş¼ÒµåÈ£Ãâ
			setDayReset(); //Day¸¦ ResetÇØÁÖ´Â ¸Ş¼Òµå È£Ãâ
		}else if(obj == nextBtn) { //ÀÌÈÄ ¹öÆ°À» ´­·¶À»¶§
			//´ÙÀ½¿ùÀ» ´­·¶À»‹š
			nextMonth(); //À§¿Íµ¿
			setDayReset(); //À§¿Íµ¿
		}
		
	}
	private void setDayReset() {
		//³â¿ù ÀÌº¥Æ® µî·ÏÇØÁ¦
		yearCombo.removeItemListener(this); //µî·ÏÀÌº¥Æ®¸¦ ÇØÁ¦½ÃÄÑÁÖ°í
		monthCombo.removeItemListener(this);
		
		yearCombo.setSelectedItem(year); //yearComboÀÇ year¿¡ ÇØ´çµÇ´Â °ªÀ» °¡Á®¿Â´Ù.
		monthCombo.setSelectedItem(month);
		
		dayPane.setVisible(false); //ÆĞ³ÎÀ» º¸¿©ÁÖ±â¸¦ ¼ûÅ²´Ù.
		dayPane.removeAll(); //ÀüºÎÁö¿î´Ù.
		setDay(); //ÇØ´ç¸Ş¼Òµå¸¦ È£ÃâÇÑ´Ù.
		dayPane.setVisible(true); //´Ù½Ãº¸¿©ÁØ´Ù.
		
		yearCombo.addItemListener(this); //´Ù½Ã ÀÌº¥Æ®¸¦ µî·Ï½ÃÅ²´Ù.
		monthCombo.addItemListener(this); //´Ù½Ã ÀÌº¥Æ® µî·Ï
		
	}
	public void prevMonth() { //¿ù
		if(month==1) { //21.01¿ù ÀÏ¶§¿¡ 12¿ù·Î ¶³¾îÁö¸é¼­ year¸¦ Àü³âµµ·Î ¹Ù²Û´Ù.
			year--;
			month=12;
		}else { //±×¿ÜÀÇ °æ¿ì
			month--; 
		}
	}
	public void nextMonth() {
		if(month==12){ //12¿ùÀÏ¶§¿¡´Â ³âµµ¸¦ Ãß°¡½ÃÅ°°í ¿ùÀ» 1·Î¹Ù²Û´Ù.
			year++; 
			month=1;
		}else{ //±×¿ÜÀÇ °æ¿ì
			month++;
		}
	}
	
	//½ÃÀÛ¸Ş¼Òµå
	public static void main(String[] args) {
		new mainScreen();
	}
}