package company0327;

import java.util.ArrayList;
import java.util.List;

/**
 * 오직 데이터를 보관하는 데이터베이스 역할
 */
public class DatabaseClass {
	// 필드
	public List<Attendance> attendanceList; // 출근 ArrayList
	public List<LeaveWork> leaveWorkList;	// 퇴근 ArrayList
	public List<NewEmployee> newEmployeeList;	// 신규사원 ArrayList
	
	/*
	 * 생성자
	 *  - 이 클래스가 객체로 생성되면서  출퇴근, 신규사원을 담을 ArrayList객체가 생성됨
	 */
	public DatabaseClass() {
		attendanceList = new ArrayList<Attendance>(); // 출근 ArrayList
		leaveWorkList = new ArrayList<LeaveWork>(); // 퇴근 ArrayList
		newEmployeeList = new ArrayList<NewEmployee>();	// 신규사원 ArrayList
	}
	
	// 출근 사원 목록 출력화면에서 사용할 메소드 - 출근 사원 ArrayList를 보내줌
	public  List<Attendance> getAttendanceList() {
		return attendanceList;
	}
	public   void setAttendanceList(List<Attendance> attendanceList) {
		this.attendanceList = attendanceList;
	}
	
	// 퇴근 사원 목록 출력화면에서 사용할 메소드 - 퇴근 사원 ArrayList를 보내줌
	public  List<LeaveWork> getLeaveWorkList() {
		return leaveWorkList;
	}
	public   void setLeaveWorkList(List<LeaveWork> leaveWorkList) {
		this.leaveWorkList = leaveWorkList;
	}
	

	// 사원 목록 출력화면에서 사용할 메소드 - 사원 ArrayList를 보내줌
	public List<NewEmployee> getNewEmployeeList() {
		return newEmployeeList;
	}
	public void setnewEmployeeList(List<NewEmployee> newEmployeeList) {
		this.newEmployeeList = newEmployeeList;
	}

	// 출근추가 메소드 - 출근 등록 화면에서 한명의 사원을 추가했을 때 사용되는 메소드
	public void addAttendance(Attendance attendance) {
		this.attendanceList.add(attendance);
	}
	
	// 퇴근추가 메소드 - 퇴근 등록 화면에서 한명의 사원을 추가했을 때 사용되는 메소드
	public void addLeaveWork(LeaveWork leaveWork) {
		this.leaveWorkList.add(leaveWork);
	}
	
	
	// 신규사원 추가 메소드 - 사원 등록 화면에서 하나의 사원를 추가했을 때 사용되는 메소드
	public void addNewEmployee(NewEmployee newEmployee) {
		this.newEmployeeList.add(newEmployee);
	}
	// 신규사원 추가 메소드 - 사원 등록 화면에서 하나의 사원를 추가했을 때 사용되는 메소드
	public void deleteNewEmployee(NewEmployee newEmployee) {
		this.newEmployeeList.add(newEmployee);
	}
	
	
	// 현재 출근한 사원수 확인
	public int getAttendanceCount() {
		return attendanceList.size();
	}
	
	// 현재 퇴근한 사원수 확인
	public int getLeaveWorkCount() {
		return leaveWorkList.size();
	}
	
	
	// 현재  사원 수
	public int getNewEmployeeCount() {
		return newEmployeeList.size();
	}
}
