package modelTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

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
		empregado1.setHoras(6);
		empregado1.setValorPorHora(100);
		empregado1.setAdicional(100);
		assertEquals(1100.0, empregado1.realizarPagamento(), 0.0001);

		empregado2.setHoras(5);
		empregado2.setValorPorHora(110);
		empregado2.setAdicional(110);
		assertEquals(1100.0, empregado2.realizarPagamento(), 0.0001);
	}

	@Test
	public void entradaIgualSalarioMinimo() {
		empregado1.setHoras(20);
		empregado1.setValorPorHora(50);
		empregado1.setAdicional(100);
		assertEquals(1100.0, empregado1.realizarPagamento(), 0.0001);
	}

	@Test
	public void entradaAcimaSalarioMinimo() {
		empregado1.setHoras(40);
		empregado1.setValorPorHora(200);
		empregado1.setAdicional(300);
		assertEquals(8300.0, empregado1.realizarPagamento(), 0.0001);

		empregado2.setHoras(30);
		empregado2.setValorPorHora(150);
		empregado2.setAdicional(500);
		assertEquals(5000.0, empregado2.realizarPagamento(), 0.0001);
	}

	@Test
	public void retornaExceptionComValorAdicionalIncorreto() {
		assertThrows(IllegalArgumentException.class, () -> empregado1.setAdicional(50.0));
		assertThrows(IllegalArgumentException.class, () -> empregado2.setAdicional(2000.0));
	}

}
