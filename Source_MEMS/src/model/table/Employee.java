package model.table;

public class Employee {
	private Integer id;
	private String firstName;
	private String lastName;
	private String position;
	private Integer userId;
	private Integer deptId;

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Employee(String firstName, String lastName, String position, Integer deptId) {

		this.firstName = firstName;
		this.lastName = lastName;
		this.position = position;
		this.deptId = deptId;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirst_name() {
		return firstName;
	}

	public void setFirst_name(String firstName) {
		this.firstName = firstName;
	}

	public String getLast_name() {
		return lastName;
	}

	public void setLast_name(String lastName) {
		this.lastName = lastName;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public Integer getUser_id() {
		return userId;
	}

	public void setUser_id(Integer userId) {
		this.userId = userId;
	}

	public Integer getDept_id() {
		return deptId;
	}

	public void setDept_id(Integer deptId) {
		this.deptId = deptId;
	}

}
