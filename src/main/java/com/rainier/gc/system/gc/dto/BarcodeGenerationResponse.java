package com.rainier.gc.system.gc.dto;

public class BarcodeGenerationResponse extends GenericResponse 
{
	private String barcodeImgUrl;
	private String barCode;

	public String getBarcodeImgUrl() {
		return barcodeImgUrl;
	}
	public void setUrl(String barcodeImgUrl) {
		this.barcodeImgUrl = barcodeImgUrl;
	}
	public String getBarCode() {
		return barCode;
	}
	public void setBarCode(String barCode) {
		this.barCode = barCode;
	}
}
