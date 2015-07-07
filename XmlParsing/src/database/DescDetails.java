package database;

import org.mongodb.morphia.annotations.Entity;

@Entity
public class DescDetails extends QueryPOJO {
	
	private String CVE;
	private String provider;
	private String service;
	
	
	public String getCVE() {
		return CVE;
	}
	public void setCVE(String cVE) {
		CVE = cVE;
	}
	public String getProvider() {
		return provider;
	}
	public void setProvider(String provider) {
		this.provider = provider;
	}
	public String getService() {
		return service;
	}
	public void setService(String service) {
		this.service = service;
	}
	
	
	

}
