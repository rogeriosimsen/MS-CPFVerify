package br.com.CPFVerify.model;

import br.com.CPFVerify.enums.CPFStatus;

public class CPF {
	
	private String cpfNumber;
	private CPFStatus cpfStatus;
	
	public String getCpfNumber() {
		return cpfNumber;
	}
	
	public void setCpfNumber(String cpfNumber) {
		this.cpfNumber = cpfNumber;
	}
	
	public CPFStatus getCpfStatus() {
		return cpfStatus;
	}
	
	public void setCpfStatus(CPFStatus cpfStatus) {
		this.cpfStatus = cpfStatus;
	}

}
