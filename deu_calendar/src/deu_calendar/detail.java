package deu_calendar;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.AbstractCellEditor;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.SystemColor;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;

public class detail extends JFrame {
    private ArrayList<ArrayList<String>> data;
    private JPanel contentPane;
    private String select_day;
    private JTable table;
    private DefaultTableModel model; //jtable

    public static void main(String[] args) {
        final ArrayList<ArrayList<String>> data = new ArrayList<>();
        String select_day="0";

        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    detail frame = new detail(data, select_day);
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public detail(ArrayList<ArrayList<String>> data, String select_day) {
        this.data = data;
        this.select_day = select_day;
        System.out.println(data);
        setResizable(false);
        setTitle("일정 상세");
        setBounds(100, 100, 668, 503);
        setLocation(610,200);
        setVisible(true);
        contentPane = new JPanel();
        contentPane.setBackground(SystemColor.window);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);


        JButton btnNewButton = new JButton("일정 등록");
        btnNewButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {    
                new entry();
            }
        });
        btnNewButton.setBounds(420, 60, 94, 28);
        contentPane.add(btnNewButton);

        JLabel lblNewLabel = new JLabel();
        String dayString = select_day;
        lblNewLabel.setText(dayString);
        lblNewLabel.setBounds(260, 20, 65, 37);
        contentPane.add(lblNewLabel);


        model = new DefaultTableModel();
        table = new JTable(model);
        table.setBounds(50, 100, 400, 200);
        contentPane.add(table);

        // Add columns to the table
        model.addColumn("Plan");
        model.addColumn("Memo");
        model.addColumn("수정");

        
		table.getColumnModel().getColumn(2).setCellRenderer(new TableCell());
		table.getColumnModel().getColumn(2).setCellEditor(new TableCell());
        
        // Add rows to the table using the data ArrayList
        for (ArrayList<String> row : data) {
            model.addRow(new Object[] { row.get(0), row.get(1), "수정" });
        }
        
    }
    class TableCell extends AbstractCellEditor implements TableCellEditor, TableCellRenderer {

		JButton jb;

		public TableCell() {
		    jb = new JButton("수정");

		    jb.addMouseListener(new MouseAdapter() {
		        @Override
		        public void mouseClicked(MouseEvent e) {
		            // 클릭 이벤트 처리 로직을 작성하세요
		            // 수정 버튼이 클릭되었을 때 수행할 동작을 여기에 추가합니다
		            // 예시: 새로운 change 인스턴스를 생성하여 변경 작업을 수행
		            new change();
		        }
		    });
		}

		/*
		 * JButton btnNewButton_1_1 = new JButton("수정");
		 * btnNewButton_1_1.addMouseListener(new MouseAdapter() {
		 * 
		 * @Override public void mouseClicked(MouseEvent e) { new change(); } // 수정 버튼
		 * 클릭 }); btnNewButton_1_1.setBounds(538, 255, 65, 50);
		 * contentPane.add(btnNewButton_1_1);
		 */
		
		@Override
		public Object getCellEditorValue() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
				int row, int column) {
			// TODO Auto-generated method stub
			return jb;
		}

		@Override
		public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row,
				int column) {
			// TODO Auto-generated method stub
			return jb;
		}

	}
}