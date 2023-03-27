package company0327;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class AttendanceForm extends JFrame implements ActionListener{

	public DatabaseClass db;
	
	private JTextField idField;
    private JTextField nameField;
    private JTextField departmentField;
    private JTextField timeField;
    
	
    public AttendanceForm() {}

    public AttendanceForm(DatabaseClass db) {
    	
    	this.db = db;
    	
    	idField = new JTextField(10);
        nameField = new JTextField(10);
        departmentField = new JTextField(10);
        timeField = new JTextField(10);
        
        JLabel idLabel = new JLabel("사원번호:");
        JLabel nameLabel = new JLabel("이름:");
        JLabel departmentLabel = new JLabel("부서:");
        JLabel timeJLabel = new JLabel("출근 시간:");
        
        JButton addButton = new JButton("출근");
        
        addButton.addActionListener(this);
        
        JPanel mainPanel = new JPanel();
        
        mainPanel.setLayout(new BorderLayout());
        
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(4, 2));        
        inputPanel.add(idLabel);
        inputPanel.add(idField);
        inputPanel.add(nameLabel);
        inputPanel.add(nameField);
        inputPanel.add(departmentLabel);
        inputPanel.add(departmentField);
        inputPanel.add(timeJLabel);
        inputPanel.add(timeField);
        
        mainPanel.add(inputPanel, BorderLayout.NORTH);
        mainPanel.add(addButton, BorderLayout.SOUTH);
        
        setTitle("출근 입력");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(mainPanel);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent e) {
        String id = idField.getText();
        String name = nameField.getText();
        String department = departmentField.getText();
        String time = timeField.getText();
        
        // 화면에서 입력받은 데이터로 사원 객체 생성
        Attendance attendance = new Attendance(id, name, department, time);
        
        // 생성한 출근 객체를 ArrayList<Attendance> attendanceList에 저장
        this.db.addAttendance(attendance);
        
		// 출근 객체 성공적으로 등록 완료 메시지
		JOptionPane.showMessageDialog(this, "출근완료");
		
		// 현재까지 등록된 출근한 사원수 확인
        System.out.println("출근 객체 등록 완료 사원수 : " + db.getAttendanceCount());
		
        // 출근 등록 끝나서 현재의 화면 닫기                
        this.dispose();
        
        // 이동해갈 메인 메뉴 생성
        MainMenu mainMenu = new MainMenu(db);
        
        // 메인 메뉴 보이기
        mainMenu.setVisible(true);
	}
	
    /**
     * 출근 등록폼을 직접 실행할 경우에 사용하는 메소드
     *  - 프로그램 전체를 실행할 때는 사용되지 않음
     *  - 출근 등록폼을 만들면서 테스트 할 때 이 프로그램을 실행시킬때 사용됨
     */
    public static void main(String[] args) {
    	new AttendanceForm(new DatabaseClass());
    
 }
}
