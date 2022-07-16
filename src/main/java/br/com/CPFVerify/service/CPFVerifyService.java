package br.com.CPFVerify.service;

import org.springframework.stereotype.Service;

import br.com.CPFVerify.enums.CPFStatus;
import br.com.CPFVerify.model.CPF;

@Service
public class CPFVerifyService {
	
	public void verify(CPF cpf) {
		
		try {
		
			char[] arr = new char[11];
			
			int aux1, aux2, aux3, aux4, aux5, aux6, aux7, aux8, aux9, digit1, digit2, total, mod, sub;
			
			/* PERCORRENDO STRING E ATRIBUINDO VALORES AO ARRAY */
			for(int i = 0; i < cpf.getCpfNumber().length(); i++) {
				
				arr[i] = cpf.getCpfNumber().charAt(i);
				
			}
			
			/* CONVERTENDO ARRAY PARA INT E ATRIBUINDO OS VALORES DOS DIGITOS VERIFICADORES */
			digit1 = Integer.parseInt(String.valueOf(arr[9]));
			digit2 = Integer.parseInt(String.valueOf(arr[10]));
			
			/* CONVERTENDO ARRAY PARA INT E ATRIBUINDO OS VALORES AS VARIAVEIS AUXILIARES */
			aux1 = Integer.parseInt(String.valueOf(arr[0])) * 10;
			aux2 = Integer.parseInt(String.valueOf(arr[1])) * 9;
			aux3 = Integer.parseInt(String.valueOf(arr[2])) * 8;
			aux4 = Integer.parseInt(String.valueOf(arr[3])) * 7;
			aux5 = Integer.parseInt(String.valueOf(arr[4])) * 6;
			aux6 = Integer.parseInt(String.valueOf(arr[5])) * 5;
			aux7 = Integer.parseInt(String.valueOf(arr[6])) * 4;
			aux8 = Integer.parseInt(String.valueOf(arr[7])) * 3;
			aux9 = Integer.parseInt(String.valueOf(arr[8])) * 2;
			
			/* SOMANDO TODAS AS VARIAVEIS AUXILIARES E ATRIBUINDO O RESULTADO A VARIAVEL 'total' */
			total = aux1 + aux2 + aux3 + aux4 + aux5 + aux6 + aux7 + aux8 + aux9;
			
			mod = total % 11;
			
			sub = 11 - mod;
			
			
			if (sub >= 10) {
				
				digit1 = 0;
				sub = 0;
			}
			
			/* SÓ SERÁ EXECUTADO CASO A VARIAVEL 'sub' SEJA IGUAL A 'digit1', SE NÃO, RETORNA CPF INVÁLIDO  */
			if(sub == digit1) {
				
				aux1 = Integer.parseInt(String.valueOf(arr[0])) * 11;
				aux2 = Integer.parseInt(String.valueOf(arr[1])) * 10;
				aux3 = Integer.parseInt(String.valueOf(arr[2])) * 9;
				aux4 = Integer.parseInt(String.valueOf(arr[3])) * 8;
				aux5 = Integer.parseInt(String.valueOf(arr[4])) * 7;
				aux6 = Integer.parseInt(String.valueOf(arr[5])) * 6;
				aux7 = Integer.parseInt(String.valueOf(arr[6])) * 5;
				aux8 = Integer.parseInt(String.valueOf(arr[7])) * 4;
				aux9 = Integer.parseInt(String.valueOf(arr[8])) * 3;
				digit1 = Integer.parseInt(String.valueOf(arr[9])) * 2;
				
				total = aux1 + aux2 + aux3 + aux4 + aux5 + aux6 + aux7 + aux8 + aux9 + digit1;
				
				mod = total % 11;
				
				sub = 11 - mod;
				
				if (sub >= 10) {
					
					digit2 = 0;
					sub = 0;
					
				}
				
				if(sub != digit2) {
					
					cpf.setCpfStatus(CPFStatus.INVALID);
					
				}else {
					
					cpf.setCpfStatus(CPFStatus.VALID);
				}
				
			}else {
				
				cpf.setCpfStatus(CPFStatus.INVALID);
			}
			
		}catch(Exception e) {
			
			cpf.setCpfStatus(CPFStatus.ERROR);
		}
	}
}
