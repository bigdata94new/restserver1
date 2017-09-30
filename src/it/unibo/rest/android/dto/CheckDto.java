package it.unibo.rest.android.dto;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class CheckDto {
	private boolean ok;

	public boolean isOk() {
		return ok;
	}

	public void setOk(boolean ok) {
		this.ok = ok;
	}
	
	
}
