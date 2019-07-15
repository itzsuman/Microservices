package com.currency.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.currency.demo.entity.Currency;
import com.currency.demo.error.CustomError;
import com.currency.demo.repository.CurrencyJdbcRepository;

@RestController
public class ManageCurrencyController {

	public static final Logger logger = LoggerFactory.getLogger(ManageCurrencyController.class);

	@Autowired
	CurrencyJdbcRepository currencyJdbcRepository;

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@PostMapping(value = "/addCurrency")
	public ResponseEntity<String> addConversionFactor(@RequestBody Currency currency) {

		Double conversionFactor = currencyJdbcRepository.getConversionFactor(currency.getCountryCode());
		if (conversionFactor != null) {
			logger.error("Unable to create. A Currency with name {} already exist", currency.getCountryCode());
			return new ResponseEntity(new CustomError(
					"Unable to create. A Currency with country code " + currency.getCountryCode() + " already exist."),
					HttpStatus.CONFLICT);
		}

		currencyJdbcRepository.addConversionFactor(currency);
		return ResponseEntity.status(HttpStatus.CREATED).build();

	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@PutMapping(value = "/updateCurrency")
	public ResponseEntity<String> updateConversionFactor(@RequestBody Currency currency) {

		Double conversionFactor = currencyJdbcRepository.getConversionFactor(currency.getCountryCode());
		if (conversionFactor == null) {
			logger.error("Unable to update. Currency with country code {} not found.", currency.getCountryCode());
			return new ResponseEntity(
					new CustomError("Unable to upate. country code " + currency.getCountryCode() + " not found."),
					HttpStatus.NOT_FOUND);
		}

		currencyJdbcRepository.updateConversionFactor(currency);
		return ResponseEntity.status(HttpStatus.OK).build();

	}

	@GetMapping("/getCurrency/{countryCode}")
	public Double updateConversionFactor(@PathVariable String countryCode) {
		Double conversionFactor = currencyJdbcRepository.getConversionFactor(countryCode);
		if (conversionFactor == null) {
			logger.error("User with id {} not found.", countryCode);
		}
		return conversionFactor;
	}

}
