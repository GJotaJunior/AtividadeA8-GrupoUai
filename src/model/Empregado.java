package model;

public class Empregado {

    private String nome;
    private int horas;
    private double valorPorHora;

    public String getNome() {
	return nome;
    }

    public void setNome(String nome) {
	this.nome = nome;
    }

    public int getHoras() {
	return horas;
    }

    public void setHoras(int horas) {
	if (horas > 40)
	    throw new IllegalArgumentException("Os funcionários podem trabalhar por no máximo 40 horas.");

	this.horas = horas;
    }

    public double getValorPorHora() {
	return valorPorHora;
    }

    public void setValorPorHora(double valorPorHora) {
	if (valorPorHora < 30.0 || valorPorHora > 200.0)
	    throw new IllegalArgumentException("O valor por hora precisa ser um valor entre 30,00 e 200,00.");

	this.valorPorHora = valorPorHora;
    }

    public double realizarPagamento() {
	return (horas * valorPorHora) > 1100.0 ? horas * valorPorHora : 1100.0;
    }

}
