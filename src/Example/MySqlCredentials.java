package Example;

public class MySqlCredentials {
	private String url;
	private String password;
	private String user;
	private String dataBaseName = "student";
	
	public MySqlCredentials() 
	{
		setUrl();
		setPassword();
		setUser();
	}
	public String getUrl() {
		return url;
	}
	public void setUrl() {
		this.url ="jdbc:mysql://localhost:3306/"+dataBaseName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword() {
		this.password = "root";
	}
	public String getUser() {
		return user;
	}
	public void setUser() {
		this.user = "root";
	}
	
}
