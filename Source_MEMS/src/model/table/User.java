package model.table;

public class User {
	private Integer userId;
	private String userAcc;
	private String userPass;
	private Boolean isLocked;

	public User() {
		super();
	}

	public User(String userAcc, String userPass, Boolean isLocked) {
		this.userAcc = userAcc;
		this.userPass = userPass;
		this.isLocked = isLocked;
	}

	public Integer getUser_id() {
		return userId;
	}

	public void setUser_id(Integer user_id) {
		this.userId = user_id;
	}

	public String getUser_acc() {
		return userAcc;
	}

	public void setUser_acc(String userAcc) {
		this.userAcc = userAcc;
	}

	public String getUser_pass() {
		return userPass;
	}

	public void setUser_pass(String userPass) {
		this.userPass = userPass;
	}

	public Boolean getIsLocked() {
		return isLocked;
	}

	public void setIsLocked(Boolean isLocked) {
		this.isLocked = isLocked;
	}

}
