package com.rest.ops.pojo;

public class AuthResponse {

	private String operationStatus;
	private String operationMessage;
	private User item;

	public String getOperationStatus() {
		return operationStatus;
	}

	public void setOperationStatus(String operationStatus) {
		this.operationStatus = operationStatus;
	}

	public String getOperationMessage() {
		return operationMessage;
	}

	public void setOperationMessage(String operationMessage) {
		this.operationMessage = operationMessage;
	}

	public User getItem() {
		return item;
	}

	public void setItem(User item) {
		this.item = item;
	}

}
