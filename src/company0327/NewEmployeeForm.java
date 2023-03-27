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


public class NewEmployeeForm extends JFrame implements ActionListener {

	private DatabaseClass db;
	// Text fields for input
	private JTextField idField, departmentField, nameField, genderField,addressField,ageField;

	public NewEmployeeForm() {}
	
	public NewEmployeeForm(DatabaseClass db) {
		
		
		this.db =db;
		
		idField = new JTextField(10);
		departmentField = new JTextField(10);
		nameField = new JTextField(10);
		genderField = new JTextField(10);
		addressField = new JTextField(10);
		ageField = new JTextField(10);
		
		JLabel idLabel = new JLabel("사원코드:");
		JLabel departmentLabel = new JLabel("부서명:");
		JLabel nameLabel = new JLabel("사원명:");
		JLabel genderLabel = new JLabel("성별:");
		JLabel addressLabel = new JLabel("주소:");
		JLabel ageLabel = new JLabel("나이:");
		
		
		JButton addButton = new JButton("추가");
		addButton.addActionListener(this);
		
		
		JPanel mainPanel = new JPanel();
		 
		mainPanel.setLayout(new BorderLayout());
		 
		// Create a JPanel to hold the input fields and button
		JPanel inputPanel = new JPanel();
		inputPanel.setLayout(new GridLayout(6, 2));
		inputPanel.add(idLabel);
		inputPanel.add(idField);
		inputPanel.add(departmentLabel);
		inputPanel.add(departmentField);
		inputPanel.add(nameLabel);
		inputPanel.add(nameField);
		inputPanel.add(genderLabel);
		inputPanel.add(genderField);
		inputPanel.add(addressLabel);
		inputPanel.add(addressField);
		inputPanel.add(ageLabel);
		inputPanel.add(ageField);

		// 메인 패널에 input패널 부착
        mainPanel.add(inputPanel, BorderLayout.NORTH);
        // 메인 패널에 "추가"버튼 부착
        mainPanel.add(addButton, BorderLayout.SOUTH);
        
        setTitle("사원 정보 입력");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // 메인 패널을 프레임의 루트 컨텐트에 저장
        setContentPane(mainPanel);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
        
	}

	// 버튼 클릭시 행할 내용을 적은 메소드(이벤트 핸들러, 이벤트 처리기)
	public void actionPerformed(ActionEvent e) {
		
			String id = idField.getText();
			String department = departmentField.getText(); 
			String name = nameField.getText(); 
			String gender = genderField.getText(); 
			String address = addressField.getText(); 
			String age = ageField.getText(); 

			NewEmployee newEmployee = new NewEmployee(id,department, name,gender,address,age);
			
			this.db.addNewEmployee(newEmployee);
			
			// 신규사원 객체 성공적으로 등록 완료 메시지
			JOptionPane.showMessageDialog(this, "신규 사원 등록 완료.");

			System.out.println("신규사원 객체 등록 완료 신규 사원 수 : " + db.getNewEmployeeCount());
			
			this.dispose();
			
			MainMenu mainMenu = new MainMenu(db);
			
			mainMenu.setVisible(true);
		}
	public static void main(String[] args) {
		new NewEmployeeForm(new DatabaseClass());
	}
}