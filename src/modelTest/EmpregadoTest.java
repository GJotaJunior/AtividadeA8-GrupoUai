package modelTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

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
		empregado1.setHoras(6);
		empregado1.setValorPorHora(100);
		assertEquals(1100.0, empregado1.realizarPagamento(), 0.0001);

		empregado2.setHoras(5);
		empregado2.setValorPorHora(110);
		assertEquals(1100.0, empregado2.realizarPagamento(), 0.0001);
	}

	@Test
	public void entradaIgualSalarioMinimo() {
		empregado1.setHoras(20);
		empregado1.setValorPorHora(55);
		assertEquals(1100.0, empregado1.realizarPagamento(), 0.0001);
	}

	@Test
	public void entradaAcimaSalarioMinimo() {
		empregado1.setHoras(40);
		empregado1.setValorPorHora(200);
		assertEquals(8000.0, empregado1.realizarPagamento(), 0.0001);

		empregado2.setHoras(30);
		empregado2.setValorPorHora(150);
		assertEquals(4500.0, empregado2.realizarPagamento(), 0.0001);
	}

	@Test
	public void validaQuantidadeHorasTrabalhadaIncorreto() {
		assertThrows(IllegalArgumentException.class, () -> empregado1.setHoras(100));
		assertThrows(IllegalArgumentException.class, () -> empregado2.setHoras(50));
	}
	
	@Test
	public void validaValorPorHoraIncorreto() {
		assertThrows(IllegalArgumentException.class, () -> empregado1.setValorPorHora(10.0));
		assertThrows(IllegalArgumentException.class, () -> empregado2.setValorPorHora(205.0));
	}

}
