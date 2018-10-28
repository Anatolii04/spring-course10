package com.luxoft.data.jpa;

import com.luxoft.data.CountryDao;
import com.luxoft.springioc.lab1.model.Country;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class CountryJpaDaoImpl extends AbstractJpaDao implements CountryDao {

	@Override
	public void save(Country country) {
//		TODO: Implement it
		EntityManager em = emf.createEntityManager();
		if (em != null) {
			em.getTransaction().begin();
			em.persist(country);
			em.getTransaction().commit();
			em.close();
		}
	}

	@Override
	public List<Country> getAllCountries() {
		List<Country> list = null;
		EntityManager em = emf.createEntityManager();
		if (em != null) {
			list = em.createQuery("from Country", Country.class).getResultList();
			em.close();
		}
		return list;
	}// getAllcountries()

	@Override
	public Country getCountryByName(String name) {
      EntityManager em = emf.createEntityManager();
      Country country = em
              .createQuery("SELECT c FROM Country c WHERE c.name LIKE :name",
                      Country.class).setParameter("name", name)
              .getSingleResult();

      if (em != null) {
          em.close();
      }
		return country;
	}

}
