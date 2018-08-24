package seguros.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;

import seguros.models.Country;
import seguros.repositories.CountryRepository;

@Controller
@RequestMapping(path="/country")
public class CountryController{

	@Autowired
	private CountryRepository countryRepository;

	@GetMapping()
	public @ResponseBody Iterable<Country> getAllCountries() {
		return countryRepository.findAll();
	}

	@GetMapping(path="/{countryId}")
	public @ResponseBody Country getCountry(@PathVariable("countryId") String countryId) {
		return countryRepository.findById(Integer.parseInt(countryId)).orElse(null);
	}

	@RequestMapping(method=RequestMethod.POST)
	public @ResponseBody String addNewCountry (@RequestParam String name, @RequestParam String phonePrefix) {
		Country c = new Country();
		c.setName(name);
		c.setPhonePrefix(phonePrefix);
		countryRepository.save(c);
		return "Created new Country "+name;
	}

	@RequestMapping(path="/{countryId}", method=RequestMethod.PUT)
	public @ResponseBody String updateCountry (@PathVariable("countryId") String countryId, @RequestPart String name, @RequestPart String phonePrefix) {
		// @ResponseBody means the returned String is the response, not a view name
		// @RequestParam means it is a parameter from the GET or POST request
		Country c = countryRepository.findById(Integer.parseInt(countryId)).orElse(null);
		if(c!=null){
			c.setName(name);
			c.setPhonePrefix(phonePrefix);
			countryRepository.save(c);
			return "Updated country "+name;
		}
		return "Country "+countryId+" not found";
	}

	@RequestMapping(path="/{countryId}", method=RequestMethod.DELETE)
	public @ResponseBody String deleteCountry (@PathVariable("countryId") String countryId){
		Country c = countryRepository.findById(Integer.parseInt(countryId)).orElse(null);
		if(c!= null){
			countryRepository.delete(c);
			return "Deleted Country "+c.getName();
		}
		return "Country "+countryId+" not found";
	}
}