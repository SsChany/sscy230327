package company0327;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**
 * 초기화면 - 메인 메뉴
 *  - 프로그램 구동후 가장 먼저 보여지는 화면
 *  - 여기에서 다른 화면으로 이동함.
 * 
 */
public class MainMenu extends JFrame implements ActionListener {
	/*
	 * 데이터베이스 역할을 하는 DatabaseClass 변수 선언
	 * 생성자에서 전달 받음. 가장 중요함.
	 */
	public DatabaseClass db;
	
    // 화면에서 사용할 입력필드, 버튼, 레이블 변수 선언(GUI components)
    private JLabel  titleLabel;
    private JButton attendanceButton;
    private JButton leaveWorkButton;
    private JButton newEmployeeButton;
    private JButton attendanceListButton;
    private JButton leaveWorkListButton;
    private JButton newEmployeeListButton;
    private JButton exitButton;
    
    Font font = new Font("휴먼편지체",Font.BOLD,65);
    Font font1 = new Font("휴먼편지체",Font.BOLD,25);
    // 본 클래스에는 기본 생성자 생성 금지 //
    
    /**
     * 생성자
     *  - 메인 메뉴에서 불려질 때 데이터베이스 클래스의 주소를 전달 받는다.
     * @param db
     */
    public MainMenu(DatabaseClass db) {
    	// 데이터베이스 전담 클래스의 객체를 전달받아서 내가 선언한 변수에 저장함
    	this.db = db;
    			
        // 프레임 설정
        setTitle("사원 관리 시스템");
        setSize(415, 439);
        setLocationRelativeTo(null);
        setLayout(null);
        
        // 프레임 타이틀 설정
        titleLabel = new JLabel("목록");
        titleLabel.setFont(font1);
        titleLabel.setForeground(Color.white);
        getContentPane().setBackground(Color.DARK_GRAY);
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        add(titleLabel);
        
        // 각 화면을 버튼으로 만들어서 프레임에 부착 - 출근등록
        attendanceButton = new JButton("출근");
        attendanceButton.setFont(font);
        attendanceButton.setForeground(Color.white);
        attendanceButton.setBackground(Color.gray);
        attendanceButton.addActionListener(this);	// 버튼에 액션 리스너 부착
        add(attendanceButton); // 버튼을 프레임에 부착(별도의 패널 안쓰고 바로 부착)
        
        // 각 화면을 버튼으로 만들어서 프레임에 부착 - 퇴근등록
        leaveWorkButton = new JButton("퇴근");
        leaveWorkButton.setFont(font);
        leaveWorkButton.setBackground(Color.gray);
        leaveWorkButton.addActionListener(this);	// 버튼에 액션 리스너 부착
        add(leaveWorkButton); // 버튼을 프레임에 부착(별도의 패널 안쓰고 바로 부착)
        
        // newEmployeeButton
        newEmployeeButton = new JButton("신규 사원 등록");
        newEmployeeButton.setFont(font1);
        newEmployeeButton.setBackground(Color.LIGHT_GRAY);
        newEmployeeButton.addActionListener(this);
        add(newEmployeeButton);
        
        
        // attendanceList Button
        attendanceListButton = new JButton("출근 목록");
        attendanceListButton.setFont(font1);
        attendanceListButton.setBackground(Color.LIGHT_GRAY);
        attendanceListButton.addActionListener(this);
        add(attendanceListButton);
        
        // leaveWorkListButton 
        leaveWorkListButton = new JButton("퇴근 목록");
        leaveWorkListButton.setFont(font1);
        leaveWorkListButton.setBackground(Color.LIGHT_GRAY);
        leaveWorkListButton.addActionListener(this);
        add(leaveWorkListButton);
        
        
        // newEmployeeListButton
        newEmployeeListButton = new JButton("사원 목록");
        newEmployeeListButton.setFont(font1);
        newEmployeeListButton.setBackground(Color.LIGHT_GRAY);
        newEmployeeListButton.addActionListener(this);
        add(newEmployeeListButton);
        
        
        // Exit button
        exitButton = new JButton("끄기");
        exitButton.setFont(font1);
        exitButton.setForeground(Color.white);
        exitButton.setBackground(Color.red);
        exitButton.addActionListener(this);
        add(exitButton);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
          titleLabel.setBounds(-100, -20, 600,100);
          attendanceButton.setBounds(0, 60, 200,120);
          leaveWorkButton.setBounds(200, 60, 200, 120);
          attendanceListButton.setBounds(0, 180, 200, 80);
          leaveWorkListButton.setBounds(200, 180, 200, 80);
          newEmployeeButton.setBounds(0, 260, 400, 50);
          newEmployeeListButton.setBounds(0, 310, 400, 50);
          exitButton.setBounds(0, 360, 400, 40);
        
    }
    
    // 각 메뉴 버튼 클릭시 할일 정의
    public void actionPerformed(ActionEvent e) {
    	// 출근 등록
        if (e.getSource() == attendanceButton) {
            System.out.println("출근");
            
            // 현재의 메인 메뉴 화면 닫기                
            this.dispose();
            
            // 이동해갈 화면 객체 생성(출근등록폼)
            AttendanceForm attendanceForm = new AttendanceForm(db);
            // 이동해갈 화면 보이기
            attendanceForm.setVisible(true);
            
            //퇴근 등록
        } else if (e.getSource() == leaveWorkButton) {
        	System.out.println("퇴근");
        	this.dispose();
        	LeaveWorkForm leaveWorkForm = new LeaveWorkForm(db);
        	leaveWorkForm.setVisible(true);              
        	
        	//신규 사원 등록
        } else if (e.getSource() == newEmployeeButton) {
            System.out.println("신규사원 등록");
            this.dispose();
            NewEmployeeForm newEmployeeForm = new NewEmployeeForm(db);
            newEmployeeForm.setVisible(true);              
            
            //출근한사원출력
        } else if (e.getSource() == attendanceListButton) {
            System.out.println("출근한 사원 목록");            
            // 현재 화면 닫기                
            this.dispose();            
            // 이동해갈 화면 객체 생성
            AttendanceList attendanceList = new AttendanceList(db);            
            // 이동해갈 화면 보이기
            attendanceList.setVisible(true);            
            
            //퇴근한 사원 목록
        } else if (e.getSource() == leaveWorkListButton) {
        	System.out.println("퇴근한 사원 목록");
        	this.dispose();
        	LeaveWorkList leaveWorkList = new LeaveWorkList(db);            
        	leaveWorkList.setVisible(true);
        	
        } else if (e.getSource() == newEmployeeListButton) {
            System.out.println("사원 정보");
            this.dispose();
            NewEmployeeList newEmployeeList = new NewEmployeeList(db);            
            newEmployeeList.setVisible(true);
            //나가기
        } else if (e.getSource() == exitButton) {
            System.exit(0);
        }
        
    }
    
    
    public static void main(String[] args) {
        new MainMenu(new DatabaseClass());
    }
}
