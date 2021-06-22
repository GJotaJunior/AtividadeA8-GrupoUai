package modelTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.Empregado;

public class EmpregadoTest {

	private Empregado empregado1;
	private Empregado empregado2;

	@BeforeEach
	private void instanciaObjeto() {
		empregado1 = new Empregado();
		empregado1.setNome("Fulano");
		
		empregado2 = new Empregado();
		empregado2.setNome("Ciclano");
	}

	@Test
	public void entradaAbaixoSalarioMinimo() {
		empregado1.setHoras(40);
		empregado1.setValorPorHora(10);
		assertEquals(1100.0, empregado1.realizarPagamento(), 0.0001);
		
		empregado2.setHoras(50);
		empregado2.setValorPorHora(10);
		assertEquals(1100.0, empregado2.realizarPagamento(), 0.0001);
	}
	
	@Test
	public void entradaIgualSalarioMinimo() {
		empregado1.setHoras(110);
		empregado1.setValorPorHora(10);
		assertEquals(1100.0, empregado1.realizarPagamento(), 0.0001);
		
		empregado2.setHoras(100);
		empregado2.setValorPorHora(11);
		assertEquals(1100.0, empregado2.realizarPagamento(), 0.0001);
	}
	
	@Test
	public void entradaAcimaSalarioMinimo() {
		empregado1.setHoras(100);
		empregado1.setValorPorHora(50);
		assertEquals(5000.0, empregado1.realizarPagamento(), 0.0001);
	
		empregado2.setHoras(200);
		empregado2.setValorPorHora(30);
		assertEquals(6000.0, empregado2.realizarPagamento(), 0.0001);
	}

}
