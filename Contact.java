class Contact {
	private String ID;
	private String Name;
	private String Phonenum;
	private String Company;
	private double Salary;
	private String BD;

	Contact(String id, String name, String pn, String cn, double salary, String bd) {
		this.ID = id;
		this.Name = name;
		this.Phonenum = pn;
		this.Company= cn;
		this.Salary = salary;
		this.BD = bd;
	}

	public void setID(String ID) {
		this.ID = ID;
	}

	public void setName(String Name) {
		this.Name = Name;
	}

	public void setPhonenum(String Phonenum) {
		this.Phonenum = Phonenum;
	}

	public void setCompany(String Company) {
		this.Company= Company;
	}

	public void setSalary(double Salary) {
		this.Salary = Salary;
	}

	public void setBD(String BD) {
		this.BD = BD;
	}

	public String getID() {
		return ID;
	}

	public String getName() {
		return Name;
	}

	public String getPhonenum() {
		return Phonenum;
	}

	public String getCompany() {
		return Company;
	}

	public double getSalary() {
		return Salary;
	}

	public String getBD() {
		return BD;
	}
}