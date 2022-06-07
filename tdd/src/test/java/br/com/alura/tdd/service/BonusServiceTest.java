package br.com.alura.tdd.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import br.com.alura.tdd.modelo.Funcionario;

class BonusServiceTest {

	@Test
	void bonusDeveriaSerZeroParaFuncionarioComSalarioMuitoAlto() {
		BonusService service= new BonusService();
		//assertThrows (IllegalArgumentException.class,
			//	() -> service.calcularBonus(new Funcionario("Viviane", LocalDate.now(), new BigDecimal("25000"))));
		try {
			
			service.calcularBonus(new Funcionario("Viviane", LocalDate.now(), new BigDecimal("25000")));
			fail("N�o deu a exception!");
		}catch (Exception e) {
			assertEquals("Funcion�rio com sal�rio maior que R$1000 n�o pode receber b�nus", e.getMessage());
		}
		
		
		
	}
	@Test
	void bonusDeveriaSer10PorCentodoSalario() {
		BonusService service= new BonusService();
		BigDecimal bonus = service.calcularBonus(new Funcionario("Viviane", LocalDate.now(), new BigDecimal("2500")));

	
		
		assertEquals(new BigDecimal("250.00"),bonus);
		
	}
	
	@Test
	void bonusDeveriaSerDezPorCentoParaSalarioDeExatamente10000() {
		BonusService service= new BonusService();
		BigDecimal bonus = service.calcularBonus(new Funcionario("Viviane", LocalDate.now(), new BigDecimal("10000")));

	
		
		assertEquals(new BigDecimal("1000.00"),bonus);
		
	}
}
