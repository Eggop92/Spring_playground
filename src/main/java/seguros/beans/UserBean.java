package seguros.beans;

import seguros.models.User;

import java.util.List;
import java.util.stream.Collectors;

public class UserBean{

	private Integer id;
    private String name;
	private String email;
	private CountryBean country;

	public UserBean(){}

	public UserBean(User user){
		this.id = user.getId();
		this.name = user.getName();
		this.email = user.getEmail();
		this.country = new CountryBean(user.getCountry());
	}

	public Integer getId() {return id;}
	public void setId(Integer id) {	this.id = id;}

	public String getName() {return name;}
	public void setName(String name) {this.name = name;}

	public String getEmail() {return email;}
	public void setEmail(String email) {this.email = email;	}
	
	public CountryBean getCountry(){return country;}
	public void setCountry(CountryBean country){this.country = country;}

	public static List<UserBean> getBeans(List<User> users){
		if(users == null) return null;
		return users.stream().map(UserBean::new).collect(Collectors.toList());
	}
}