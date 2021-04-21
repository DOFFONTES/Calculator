package br.edu.ifsp.exception;

import java.io.Serializable;
import java.util.Date;

public class ExceptionResponse implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Date timestamp;
	private String message;
	private String detals;
	
	public ExceptionResponse(Date timestamp, String message, String detals) {
		super();
		this.timestamp = timestamp;
		this.message = message;
		this.detals = detals;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public String getMessage() {
		return message;
	}

	public String getDetals() {
		return detals;
	}
	
	

}
