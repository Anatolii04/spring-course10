package com.luxoft.data;

import com.luxoft.springioc.lab1.model.Country;

import java.util.List;

public interface CountryDao {

	public abstract void save(Country country);

	public abstract List<Country> getAllCountries();

	public abstract Country getCountryByName(String name);

}