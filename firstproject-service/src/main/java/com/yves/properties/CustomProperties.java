package com.yves.properties;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:config/custom.properties")
@ConfigurationProperties
public class CustomProperties {

	// Va recup les infos dans global.properties....
	
//	@Value("${email}")
	@NotEmpty
	private String email;
	
	@Max(5)
    @Min(0)
	@Value("${thread-pool}")
	private int toto;
	
	private String urlOverride;

	public int getToto() {
		return toto;
	}

	public void setToto(int toto) {
		this.toto = toto;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUrlOverride() {
		return urlOverride;
	}

	public void setUrlOverride(String urlOverride) {
		this.urlOverride = urlOverride;
	}

	@Override
	public String toString() {
		return "CustomProperties [email=" + email + ", toto=" + toto + ", urlOverride=" + urlOverride + "]";
	}
}
