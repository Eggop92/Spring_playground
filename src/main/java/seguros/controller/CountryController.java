package seguros.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import seguros.beans.CountryBean;
import seguros.beans.UserBean;
import seguros.models.Country;
import seguros.repositories.CountryRepository;
import seguros.utils.ListUtils;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping(path="/country")
public class CountryController extends BaseController{

	@Autowired
	private CountryRepository countryRepository;

	@GetMapping()
	public @ResponseBody List<CountryBean> getAllCountries() {
		return CountryBean.getBeans(ListUtils.convertToList(countryRepository.findAll()));
	}

	@GetMapping(path="/{countryId}")
	public @ResponseBody CountryBean getCountry(@PathVariable("countryId") String countryId) {
		Country c = countryRepository.findById(Integer.parseInt(countryId)).orElse(null);
		if(c == null) return null;
		return new CountryBean(c);
	}

	@RequestMapping(method=RequestMethod.POST)
	public @ResponseBody CountryBean addNewCountry (@RequestBody @Valid Country c) {
		//Country c = new Country();
		//c.setName(name);
		//c.setPhonePrefix(phonePrefix);
		countryRepository.save(c);
		return new CountryBean(c);
	}

	@RequestMapping(path="/{countryId}", method=RequestMethod.PUT)
	public @ResponseBody CountryBean updateCountry (@PathVariable("countryId") String countryId, @RequestPart String name, @RequestPart String phonePrefix) {
		// @ResponseBody means the returned String is the response, not a view name
		// @RequestParam means it is a parameter from the GET or POST request
		Country c = countryRepository.findById(Integer.parseInt(countryId)).orElse(null);
		if(c == null) return null;
		c.setName(name);
		c.setPhonePrefix(phonePrefix);
		countryRepository.save(c);
		return new CountryBean(c);

	}

	@RequestMapping(path="/{countryId}", method=RequestMethod.DELETE)
	public @ResponseBody Boolean deleteCountry (@PathVariable("countryId") String countryId){
		Country c = countryRepository.findById(Integer.parseInt(countryId)).orElse(null);
		if(c==null) return false;
		countryRepository.delete(c);
		return true;

	}

	@RequestMapping(path="/{countryId}/users", method = RequestMethod.GET)
	public @ResponseBody List<UserBean> getUsersByCountry(@PathVariable("countryId") String countryId){
		Country c = countryRepository.findById(Integer.parseInt(countryId)).orElse(null);
		if(c==null) return null;
		return UserBean.getBeans(c.getUsers());
	}
}