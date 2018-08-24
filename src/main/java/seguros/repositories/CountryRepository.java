package seguros.repositories;

import org.springframework.data.repository.CrudRepository;

import seguros.models.Country;

public interface CountryRepository extends CrudRepository<Country, Integer> {

}