package model;

public class EmpregadoTerceirizado extends Empregado {

    private double adicional;

    public double getAdicional() {
	return adicional;
    }

    public void setAdicional(double adicional) {
	if (adicional < 100.0 || adicional > 1100.0)
	    throw new IllegalArgumentException("O adicional precisa ser um valor entre 100,00 e 1.100,00.");

	this.adicional = adicional;
    }

    @Override
    public double realizarPagamento() {
	return (getHoras() * getValorPorHora() + adicional) > 1100.0 ? getHoras() * getValorPorHora() + adicional
		: 1100.0;
    }
}
