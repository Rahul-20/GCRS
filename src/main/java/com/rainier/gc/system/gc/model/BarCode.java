package com.rainier.gc.system.gc.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class BarCode {

	@Column (name ="BAR_CODE", length=64)
	private String barCode;

	/*	@Column (name ="BAR_IMAGE", length=100)
	private String barCodeImage;

	@Column (name ="BAR_CODE_TEXT", length=64)
	private String barCodeText;*/

	public BarCode() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BarCode(String barCode/*, String barCodeImage, String barCodeText*/) {
		super();
		this.barCode = barCode;
		/*this.barCodeImage = barCodeImage;
		this.barCodeText = barCodeText;*/
	}

	public String getBarCode() {
		return barCode;
	}

	public void setBarCode(String barCode) {
		this.barCode = barCode;
	}

	/*public String getBarCodeImage() {
		return barCodeImage;
	}

	public void setBarCodeImage(String barCodeImage) {
		this.barCodeImage = barCodeImage;
	}

	public String getBarCodeText() {
		return barCodeText;
	}

	public void setBarCodeText(String barCodeText) {
		this.barCodeText = barCodeText;
	}*/
}
