package seguros.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Countries")
public class Country{

	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
    private String name;
	private String phonePrefix;
	
	public Integer getId(){return id;}
	public void setId(Integer id){this.id=id;}

	public String getName(){return name;}
	public void setName(String name){this.name = name;}

	public String getPhonePrefix(){return phonePrefix;}
	public void setPhonePrefix(String phonePrefix){this.phonePrefix = phonePrefix;
	}
}