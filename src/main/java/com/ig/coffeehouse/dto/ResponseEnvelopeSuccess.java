package com.ig.coffeehouse.dto;

public class ResponseEnvelopeSuccess {
	private boolean success=true;
	private Object responsePayload;
	
	public ResponseEnvelopeSuccess(Object payload) {
		this.responsePayload = payload;
	}
	public Object getPayload() {
		return responsePayload;
	}
	public void setPayload(Object payload) {
		this.responsePayload = payload;
	}
	public boolean getSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
}
