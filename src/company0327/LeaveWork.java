package company0327;


public class LeaveWork{

	private String id;			//사원번호
	private String name; 		//이름
	private String department;	//부서
	private String time;		//퇴근시간
	public LeaveWork() {}
	
	
	public LeaveWork(String id, String name, String department, String time) {
		super();
		this.id = id;
		this.name = name;
		this.department = department;
		this.time = time;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getDepartment() {
		return department;
	}


	public void setDepartment(String department) {
		this.department = department;
	}


	public String getTime() {
		return time;
	}


	public void setTime(String time) {
		this.time = time;
	}


	@Override
	public String toString() {
		return "LeaveWork [id=" + id + ", name=" + name + ", department=" + department + ", time=" + time + "]";
	}
    

	
	
}
