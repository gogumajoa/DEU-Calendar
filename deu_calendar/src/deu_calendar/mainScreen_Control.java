package deu_calendar;

import java.util.ArrayList;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement; 

public class mainScreen_Control {
    public ArrayList<String> ConnectDB(int year, int month, int day) { //db 연동
    	Connection con = null;
        String url = "jdbc:oracle:thin:@dict.asuscomm.com:3100:system";
        String id = "c##java";
        String password = "java123";
        
        ArrayList<String> text = new ArrayList();
        
        try { //드라이버 적재
            Class.forName("oracle.jdbc.driver.OracleDriver"); 
            System.out.println("드라이버 적재 성공");
        } catch (ClassNotFoundException e) {
            System.out.println("No Driver.");
        }
        
        try {
            con = DriverManager.getConnection(url, id, password);
            System.out.println("DB 연결 성공");
         	String query = "select PLAN_TITLE, MEMO from PLAN Where REGIST_DATE="+year+month+day; //나중에 where문으로 접속한 학번에 해당하는 것만 출력하도록 바꿔야함.
         	System.out.println(query);
         	try { 
         		Statement stmt = con.createStatement(); 
         		ResultSet rs = stmt.executeQuery(query);
         		while (rs.next()) {
         			text.add("- " + rs.getString("PLAN_TITLE")); // 데이터의 값을 한줄 씩 가져온다. 일정명과 메모
         		}
         		stmt.close(); 
         		rs.close();
         		} catch (SQLException e) { e.printStackTrace(); 
         		} finally { 
         			con.close(); 
         			}
         	
   
         	con = DriverManager.getConnection(url, id, password);
            System.out.println("DB 연결 성공");
          	String query1 = "select SUB_TITLE from SUBJECT Where SUB_DATE="+year+month+day; //나중에 where문으로 접속한 학번에 해당하는 것만 출력하도록 바꿔야함.
          	System.out.println(query1);
          	try { 
         		Statement stmt = con.createStatement(); 
         		ResultSet rs = stmt.executeQuery(query1);
         		while (rs.next()) {
         			text.add("★ "+rs.getString("SUB_TITLE")); // 데이터의 값을 한줄 씩 가져온다. 일정명과 메모
         		}
         		stmt.close(); 
         		rs.close();
         		} catch (SQLException e) { e.printStackTrace(); 
         		} finally { 
         			con.close(); 
         			}
          	
             	
         } catch (SQLException e) {
             System.out.println("Connection Fail: " + e.getMessage());
             e.printStackTrace();
         } finally {
             try {
                 if (con != null)
                     con.close();
                 System.out.println("DB 연결 종료");
             } catch (SQLException e) {
                 e.printStackTrace();
             }
         }
       
        return text;
     }
    
    	
}

