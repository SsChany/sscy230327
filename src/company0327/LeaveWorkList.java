package company0327;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class LeaveWorkList extends JFrame implements ActionListener {
	
	public DatabaseClass db;

    private JTable table;	
    private DefaultTableModel tableModel;	
    
    public LeaveWorkList() {}
    
    public LeaveWorkList(DatabaseClass db) {
    	// 데이터베이스 전담 클래스의 객체를 전달받아서 내가 선언한 변수에 저장함
    	this.db = db;
    	
        // 테이블 세팅
        String[] columnNames = {"사원번호",  "이름", "부서", "퇴근시간"};
        List<LeaveWork> leaveWorkList = db.getLeaveWorkList(); 
        Object[][] data = new Object[leaveWorkList.size()][4];
        
        for (int i = 0; i < leaveWorkList.size(); i++) {
        	LeaveWork leaveWork = leaveWorkList.get(i);
            data[i][0] = leaveWork.getId();
            data[i][1] = leaveWork.getName();
            data[i][2] = leaveWork.getDepartment();
            data[i][3] = leaveWork.getTime();
        }

        tableModel = new DefaultTableModel(data, columnNames);
        table = new JTable(tableModel);
        
        
       JButton closeButton = new JButton("닫기");
       
        // 액션 리스너 부착
        closeButton.addActionListener(this);	// 액션 리스터 부착

        // 메인 패널 생성
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.add(new JScrollPane(table), BorderLayout.CENTER);

        // 입력 필드들이 놓일 input 패널 생성
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(6, 2));
        
        // input 패널을 메인 패널에 다시 부착
        mainPanel.add(inputPanel, BorderLayout.SOUTH);
        // 닫기 버튼도 메인 패널에 부착
        mainPanel.add(closeButton, BorderLayout.SOUTH);

        // 프레임(윈도우 창) 설정
        setTitle("퇴근 기록");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(mainPanel);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    // 액션 리스너 
	public void actionPerformed(ActionEvent e) {
        this.dispose();
        
        MainMenu mainMenu = new MainMenu(db);
        mainMenu.setVisible(true);
	}
	
  
    public static void main(String[] args) {
    	new LeaveWorkList(new DatabaseClass());
    }	
}