package com.ig.coffeehouse.dto;

import com.ig.coffeehouse.exception.ErrorEnv;

public class ResponseEnvelopeError {
	boolean success = false;
	Object responsePayLoad;
	ErrorEnv error;

	public ErrorEnv getError() {
		return error;
	}

	public void setError(ErrorEnv error) {
		this.error = error;
	}

	public Object getPayload() {
		return responsePayLoad;
	}

	public void setPayload(Object payload) {
		this.responsePayLoad = payload;
	}

	public boolean getSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}
}
