package com.currency.demo.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.currency.demo.entity.Currency;

@Repository
public class CurrencyJdbcRepository {

	@Autowired
	JdbcTemplate jdbcTemplate;

	public int addConversionFactor(Currency currency) {
		return jdbcTemplate.update("insert into currency (id, countryCode, conversionFactor) " + "values(?,  ?, ?)",
				new Object[] { currency.getId(), currency.getCountryCode(), currency.getConversionFactor() });
	}

	public int updateConversionFactor(Currency currency) {
		return jdbcTemplate.update("update currency " + " set countryCode = ?, conversionFactor = ? " + " where id = ?",
				new Object[] { currency.getCountryCode(), currency.getConversionFactor(), currency.getId() });
	}

	public Double getConversionFactor(String countryCode) {
		try {
			return jdbcTemplate.queryForObject("select conversionFactor from currency where countryCode = ?",
					Double.class, countryCode);
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

}
