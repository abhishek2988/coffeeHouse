package com.ig.coffeehouse.controller;

import static com.ig.coffeehouse.common.ExceptionMessageConstants.APPLICATION_ERROR;
import static com.ig.coffeehouse.common.ExceptionMessageConstants.BAD_REQUEST;
import static java.net.HttpURLConnection.HTTP_BAD_REQUEST;
import static java.net.HttpURLConnection.HTTP_INTERNAL_ERROR;
import static java.net.HttpURLConnection.HTTP_NOT_FOUND;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.ig.coffeehouse.dto.ResponseEnvelopeError;
import com.ig.coffeehouse.dto.ResponseEnvelopeSuccess;
import com.ig.coffeehouse.exception.EntityNotFoundException;
import com.ig.coffeehouse.exception.ErrorEnv;
import com.ig.coffeehouse.exception.ValidationError;
/**
 * @author abhisagrawal
 *
 */
public abstract class AbsractRequestController {
	
	
	
	private static final Logger LOGGER = (Logger) LoggerFactory.getLogger(AbsractRequestController.class);

	/**
	 * Builds success api response object with response payload. 
	 * 
	 * @param responsePayload
	 * @return
	 */
	public ResponseEnvelopeSuccess buildSuccessResponse(Object responsePayload){
		return new ResponseEnvelopeSuccess(responsePayload);
	}
	
	@ExceptionHandler
	public ResponseEnvelopeError buildFailureResponse(Exception e, HttpServletResponse response){
		ResponseEnvelopeError responseEnvelopeError = new ResponseEnvelopeError();
		LOGGER.error("An exception occured.", e);
		if(e instanceof EntityNotFoundException){
			response.setStatus(HTTP_NOT_FOUND);
			buildResponseEnvelopeError(responseEnvelopeError, e.getMessage());
		} else if(e instanceof MethodArgumentNotValidException){
			response.setStatus(HTTP_BAD_REQUEST);
			handleBadRequestException(responseEnvelopeError, (MethodArgumentNotValidException) e);
		} else {
			response.setStatus(HTTP_INTERNAL_ERROR);
			buildResponseEnvelopeError(responseEnvelopeError, APPLICATION_ERROR);
		}
		return responseEnvelopeError;
	}
	
	/**
	 * Creates response envelope error object.
	 * 
	 * @param responseEnvelopeError
	 * @param errorCode
	 * @return
	 */
	private ResponseEnvelopeError buildResponseEnvelopeError(ResponseEnvelopeError responseEnvelopeError, String errorCode){
		ErrorEnv errorEnv = new ErrorEnv(errorCode);
		responseEnvelopeError.setError(errorEnv);
		return responseEnvelopeError;
	}
	
	/**
	 * Request validation exception handler.
	 * 
	 * @param responseEnvelopeError
	 * @param exception
	 * @return
	 */
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ResponseEnvelopeError handleBadRequestException(ResponseEnvelopeError responseEnvelopeError, MethodArgumentNotValidException exception) {
		final BindingResult errors = exception.getBindingResult();
		ValidationError validationError = new ValidationError();
        for (ObjectError objectError : errors.getAllErrors()) {
        	validationError.addValidationError(objectError.getDefaultMessage());
        }
        responseEnvelopeError.setPayload(validationError);
        return buildResponseEnvelopeError(responseEnvelopeError, BAD_REQUEST);
    }

}
