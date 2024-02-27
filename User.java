package maven_Demo.dto;

public class User {
		private int id;
	    private String name;
	    private String email;
	    private long phone;
	    private String pwd;
	    private String gender;
	    private String address;
	    private double wallet;
		public String getGender() {
			return gender;
		}
		public void setGender(String gender) {
			this.gender = gender;
		}
		
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
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public long getPhone() {
			return phone;
		}
		public void setPhone(long phone) {
			this.phone = phone;
		}
		public String getPwd() {
			return pwd;
		}
		public void setPwd(String pwd) {
			this.pwd = pwd;
		}
		public String getAddress() {
			return address;
		}
		public void setAddress(String address) {
			this.address = address;
		}
		public double getWallet() {
			return wallet;
		}
		public void setWallet(double wallet) {
			this.wallet = wallet;
		}
		public User(int id, String name, String email, long phone, String pwd, String gender, String address,
				double wallet) {
			super();
			this.id = id;
			this.name = name;
			this.email = email;
			this.phone = phone;
			this.pwd = pwd;
			this.gender = gender;
			this.address = address;
			this.wallet = wallet;
		}
		@Override
		public String toString() {
			return "User_data [id=" + id + ", name=" + name + ", email=" + email + ", phone=" + phone + ", pwd=" + pwd
					+ ", gender=" + gender + ", address=" + address + ", wallet=" + wallet + "]";
		}
		
		public User(String email, String pwd) {
			super();
			this.email = email;
			this.pwd = pwd;
		}	      
	}

