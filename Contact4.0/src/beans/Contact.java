package beans;


public class Contact {
	/** ID 1*/
	private int id;
	/** 姓名 1*/
	private String name;
	/** 性别*/
	private String gender;
	/** 年龄*/
	private int age;
	/** 联系电话 */
	private String phone;
	/** 电子邮件 */
	private String email;
	/** QQ号码 */
	private String qq;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getQq() {
		return qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	public Contact() {
		super();
		// TODO Auto-generated constructor stub
	}

	public  Contact(String name, String gender, int age, String phone, String email, String qq) {
		super();
		this.name = name;
		this.gender = gender;
		this.age = age;
		this.phone = phone;
		this.email = email;
		this.qq = qq;
	}
}
