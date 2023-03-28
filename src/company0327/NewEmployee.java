package company0327;

public class NewEmployee {
	public String id;			//사원번호
	public String department;	//부서
	public String name;			//이름
	public String gender;		//성별
	public String address;		//주소
	public String age;			//생년월일
	
	
	public NewEmployee() {}
	
	public NewEmployee(String id, String department, String name, String gender, String address, String age) {
		super();
		this.id = id;
		this.department = department;
		this.name = name;
		this.gender = gender;
		this.address = address;
		this.age = age;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "NewEmployee [id=" + id + ", department=" + department + ", name=" + name + ", gender=" + gender
				+ ", address=" + address + ", age=" + age + "]";
	}
	
	
	
	
}
