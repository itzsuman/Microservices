package com.currency.demo.entity;

public class Currency {
	
	private Long id;
	private String countryCode;
	private String conversionFactor;
	public Currency() {
		super();
	}
	
	public Currency(Long id, String countryCode, String conversionFactor) {
		super();
		this.id = id;
		this.countryCode = countryCode;
		this.conversionFactor = conversionFactor;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getConversionFactor() {
		return conversionFactor;
	}

	public void setConversionFactor(String conversionFactor) {
		this.conversionFactor = conversionFactor;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	
	

}
