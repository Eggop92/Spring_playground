package seguros.beans;

import seguros.models.Country;

import java.util.List;
import java.util.stream.Collectors;

public class CountryBean{

	private Integer id;
    private String name;
	private String phonePrefix;

	public CountryBean(){}

	public CountryBean(Country country){
		this.id = country.getId();
		this.name = country.getName();
		this.phonePrefix = country.getPhonePrefix();
	}

	public Integer getId(){return id;}
	public void setId(Integer id){this.id=id;}

	public String getName(){return name;}
	public void setName(String name){this.name = name;}

	public String getPhonePrefix(){return phonePrefix;}
	public void setPhonePrefix(String phonePrefix){this.phonePrefix = phonePrefix;}

	public static List<CountryBean> getBeans(List<Country> countries){
		if (countries==null) return null;
		return countries.stream().map(CountryBean::new).collect(Collectors.toList());
	}

}