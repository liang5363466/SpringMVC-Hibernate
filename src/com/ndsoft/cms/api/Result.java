package com.ndsoft.cms.api;

import java.io.Serializable;
public class Result<T> implements Serializable{
	
	private static final long serialVersionUID = 7251734178724584350L;
	
	private T data;
	private String message = "";
	private boolean isSuccess = true;
	private Integer resultType = ResultType.Success;
	
	public Result(){
		
	}
	
	public Result(T data){
		this.data = data;
	}
	
	public Result(T data,String message){
		this.data = data;
		this.message = message;
	}
	
	public Result(T data,String message,boolean isSuccess,Integer resultType){
		this(data,message);
		this.isSuccess = isSuccess;
		this.resultType = resultType;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public boolean isSuccess() {
		return isSuccess;
	}

	public void setSuccess(boolean isSuccess) {
		this.isSuccess = isSuccess;
	}

	public Integer getResultType() {
		return resultType;
	}

	public void setResultType(Integer resultType) {
		this.resultType = resultType;
	}
}

