package deu_calendar;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class registration {
	
	private String planName; // ì¼ì • ì œëª©
	private String memoTextArea; // ì¼ì • ë©”ëª¨
	private int Repetiton; // ë°˜ë³µ ê°’
	private String dayValue; // ë‚ ì§œ ê°’
	
	// ì¼ì • ì œëª© ê°€ì ¸ì˜¤ëŠ” ë©”ì†Œë“œ
	public String birngTitle(String planName) { 
		planName = entry.textField.getText();
		
		return planName;
	}
	
	// ì¼ì • ë©”ëª¨ ê°€ì ¸ì˜¤ëŠ” ë©”ì†Œë“œ
	public String bringMemo(String memoText) {
		memoTextArea = entry.textArea.getText();
		
		return memoTextArea;	
	}
	
	// ë°˜ë³µ ê°’ ê°€ì ¸ì˜¤ëŠ” ë©”ì†Œë“œ
	public int bringRepeat() {
		
		return Repetiton;
	}
	
	// ë‚ ì§œ ê°’ ë°›ì•„ì˜¤ëŠ” ë©”ì†Œë“œ
	public String bringDayValue() {
		
		return dayValue;
	}
	
	// ì¼ì • ë“±ë¡ ê¸°ëŠ¥ ë©”ì†Œë“œ
	public void regist() {
		Connection con = null;
		String url = "jdbc:oracle:thin:@dict.asuscomm.com:3100:system";
	    String id = "c##java";
	    String password = "java123";
	    
	    try {
	    	
            con = DriverManager.getConnection(url, id, password);
<<<<<<< HEAD
            System.out.println("DB ì—°ê²° ì„±ê³µ");

            // íŠ¸ëœì­ì…˜ ì‹œì‘
            con.setAutoCommit(false);         

            try {
                // "SUBJECT" í…Œì´ë¸”ì— ë°ì´í„° ì‚½ì…
                String insertPlantSql = "INSERT INTO PLAN (STUDENT_ID, REGIST_DATE, PLAN_TITLE, MEMO, REPEATVALUE) VALUES (?, ?, ?, ?, ?)";
                PreparedStatement insertPlanStatement = con.prepareStatement(insertPlantSql);
                insertPlanStatement.setInt(1, 20215030); //ì„ì˜ë¡œ db ì§‘ì–´ë„£ì€ ê°’ í•™ë²ˆ
                insertPlanStatement.setInt(2, 20230201); //ë‚ ì§œ ì„ì˜ ê°’
                insertPlanStatement.setString(3, birngTitle("")); //ì¼ì • ëª…
                insertPlanStatement.setString(4, bringMemo("")); //ë©”ëª¨
                insertPlanStatement.setInt(5, 22); //ë°˜ë³µê°’
                insertPlanStatement.executeUpdate();

                // íŠ¸ëœì­ì…˜ ì»¤ë°‹
                con.commit();

                System.out.println("ì¼ì • ë°ì´í„° ì‚½ì…ì´ ì„±ê³µì ìœ¼ë¡œ ì™„ë£Œë˜ì—ˆìŠµë‹ˆë‹¤.");
            } catch (SQLException e) {
                // íŠ¸ëœì­ì…˜ ë¡¤ë°±
                con.rollback();

                System.out.println("ì¼ì • ë°ì´í„° ì‚½ì… ì¤‘ ì˜¤ë¥˜ê°€ ë°œìƒí–ˆìŠµë‹ˆë‹¤.");
=======
            System.out.println("DB ¿¬°á ¼º°ø");

            // Æ®·£Àè¼Ç ½ÃÀÛ
            con.setAutoCommit(false);         

            try {
                // "SUBJECT" Å×ÀÌºí¿¡ µ¥ÀÌÅÍ »ğÀÔ
                String insertPlantSql = "INSERT INTO PLAN (STUDENT_ID, REGIST_DATE, PLAN_TITLE, MEMO, REPEATVALUE) VALUES (?, ?, ?, ?, ?)";
                PreparedStatement insertPlanStatement = con.prepareStatement(insertPlantSql);
                insertPlanStatement.setInt(1, 20215030); //ÀÓÀÇ·Î db Áı¾î³ÖÀº °ª ÇĞ¹ø
                insertPlanStatement.setInt(2, 20230201); //³¯Â¥ ÀÓÀÇ °ª
                insertPlanStatement.setString(3, birngTitle("")); //ÀÏÁ¤ ¸í
                insertPlanStatement.setString(4, bringMemo("")); //¸Ş¸ğ
                insertPlanStatement.setInt(5, 22); //¹İº¹°ª
                insertPlanStatement.executeUpdate();

                // Æ®·£Àè¼Ç Ä¿¹Ô
                con.commit();

                System.out.println("ÀÏÁ¤ µ¥ÀÌÅÍ »ğÀÔÀÌ ¼º°øÀûÀ¸·Î ¿Ï·áµÇ¾ú½À´Ï´Ù.");
            } catch (SQLException e) {
                // Æ®·£Àè¼Ç ·Ñ¹é
                con.rollback();

                System.out.println("ÀÏÁ¤ µ¥ÀÌÅÍ »ğÀÔ Áß ¿À·ù°¡ ¹ß»ıÇß½À´Ï´Ù.");
>>>>>>> upstream/main
                e.printStackTrace();
            }
        } catch (SQLException e) {
            System.out.println("Connection Fail: " + e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                if (con != null)
                    con.close();
<<<<<<< HEAD
                System.out.println("DB ì—°ê²° ì¢…ë£Œ");
=======
                System.out.println("DB ¿¬°á Á¾·á");
>>>>>>> upstream/main
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
<<<<<<< HEAD
		
=======
>>>>>>> upstream/main
	}
	
	// ê²½ê³  ë©”ì‹œì§€ ë©”ì†Œë“œ
	public void showErrorMsg() {
		
	}

}
