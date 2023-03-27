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


public class NewEmployeeList extends JFrame implements ActionListener {
	
	public DatabaseClass db;

    private JTable table;	
    private DefaultTableModel tableModel;	
    
    public  NewEmployeeList() {    	
    }
    
    public  NewEmployeeList(DatabaseClass db) {
    	this.db = db;
    	
        // 테이블 세팅
        String[] columnNames = {"사원번호", "부서명","이름","성별","주소","나이"};
        List<NewEmployee> newEmployeeList = db.getNewEmployeeList(); 
        Object[][] data = new Object[ newEmployeeList.size()][6];
        
        for (int i = 0; i <  newEmployeeList.size(); i++) {
            NewEmployee newEmployee =  newEmployeeList.get(i);
            data[i][0] = newEmployee.getId();
            data[i][1] = newEmployee.getDepartment();
            data[i][2] = newEmployee.getName();
            data[i][3] = newEmployee.getGender();
            data[i][4] = newEmployee.getAddress();
            data[i][5] = newEmployee.getAge();
        }

        tableModel = new DefaultTableModel(data, columnNames);
        table = new JTable(tableModel);
        
        
        
        
       JButton closeButton = new JButton("닫기");
       closeButton.addActionListener(this);	// 액션 리스터 부착
       
        // 액션 리스너 부착
        JButton removeButton = new JButton("삭제");
        removeButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int rowIndex = table.getSelectedRow();
				if(rowIndex == -1)return;
				tableModel.removeRow(rowIndex);
				newEmployeeList.remove(rowIndex);
			}
		});
        // 메인 패널 생성
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.add(new JScrollPane(table), BorderLayout.CENTER);

        // 입력 필드들이 놓일 input 패널 생성
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(6, 2));
        
        // input 패널을 메인 패널에 다시 부착
        // 닫기 버튼도 메인 패널에 부착
        mainPanel.add(closeButton, BorderLayout.SOUTH);
        // 삭제 버튼도 메인 패널에 부착
        mainPanel.add(removeButton, BorderLayout.WEST);

        // 프레임(윈도우 창) 설정
        setTitle("신규 사원 정보 입력");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(mainPanel);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    // 액션 리스너 
	public void actionPerformed(ActionEvent e) {
		 // 현재 열려있는 사원정보 화면을 닫음                
        this.dispose();
       
        MainMenu mainMenu = new MainMenu(db);
        mainMenu.setVisible(true);
	}
	
	
    public static void main(String[] args) {
    	new NewEmployeeList(new DatabaseClass());
    }	
}
