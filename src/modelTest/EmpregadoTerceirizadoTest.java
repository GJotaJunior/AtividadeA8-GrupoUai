package modelTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.EmpregadoTerceirizado;

public class EmpregadoTerceirizadoTest {

	private EmpregadoTerceirizado empregado1;
	private EmpregadoTerceirizado empregado2;
	
	@BeforeEach
	private void instanciaObjeto() {
		empregado1 = new EmpregadoTerceirizado();
		empregado1.setNome("Fulano");
		
		empregado2 = new EmpregadoTerceirizado();
		empregado2.setNome("Ciclano");
	}

	@Test
	public void entradaAbaixoSalarioMinimo() {
		empregado1.setHoras(40);
		empregado1.setValorPorHora(10);
		empregado1.setAdicional(100);
		assertEquals(1100.0, empregado1.realizarPagamento(), 0.0001);
		
		empregado2.setHoras(50);
		empregado2.setValorPorHora(10);
		empregado2.setAdicional(100);
		assertEquals(1100.0, empregado2.realizarPagamento(), 0.0001);
	}
	
	@Test
	public void entradaIgualSalarioMinimo() {
		empregado1.setHoras(100);
		empregado1.setValorPorHora(10);
		empregado1.setAdicional(100);
		assertEquals(1100.0, empregado1.realizarPagamento(), 0.0001);
		
		empregado2.setHoras(100);
		empregado2.setValorPorHora(11);
		empregado2.setAdicional(100);
		assertEquals(1100.0, empregado2.realizarPagamento(), 0.0001);
	}
	
	@Test
	public void entradaAcimaSalarioMinimo() {
		empregado1.setHoras(100);
		empregado1.setValorPorHora(50);
		empregado1.setAdicional(500);
		assertEquals(5500.0, empregado1.realizarPagamento(), 0.0001);
	
		empregado2.setHoras(200);
		empregado2.setValorPorHora(30);
		empregado2.setAdicional(500);
		assertEquals(6500.0, empregado2.realizarPagamento(), 0.0001);
	}

}
