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

public class LeaveWorkForm  extends JFrame implements ActionListener{

	
public DatabaseClass db;
	
	private JTextField idField;
    private JTextField nameField;
    private JTextField departmentField;
    private JTextField timeField;
    
    public LeaveWorkForm() {}
    
    public LeaveWorkForm(DatabaseClass db) {
    
    	this.db = db;
    	
    	idField = new JTextField(10);
        nameField = new JTextField(10);
        departmentField = new JTextField(10);
        timeField = new JTextField(10);
        
        JLabel idLabel = new JLabel("사원번호:");
        JLabel nameLabel = new JLabel("이름:");
        JLabel departmentLabel = new JLabel("부서:");
        JLabel timeJLabel = new JLabel("퇴근 시간:");
        
        JButton addButton = new JButton("퇴근");
        
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
        
        setTitle("퇴근 입력");
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
        
        LeaveWork leaveWork = new LeaveWork(id, name, department, time);
        
        this.db.addLeaveWork(leaveWork);
        
		JOptionPane.showMessageDialog(this, "퇴근등록완료");
		
        System.out.println("퇴근 객체 등록 완료 사원수 : " + db.getLeaveWorkCount());
		
        this.dispose();
        
        // 이동해갈 메인 메뉴 생성
        MainMenu mainMenu = new MainMenu(db);
        
        // 메인 메뉴 보이기
        mainMenu.setVisible(true);
	}
	
   
    public static void main(String[] args) {
    	new LeaveWorkForm(new DatabaseClass());
    
 }
}