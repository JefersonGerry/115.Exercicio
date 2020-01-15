package entities;

import java.util.Date;

public class Hora_Contrato {
	
	private Date date;
	private Double ValorPorHora;
	private Integer Horas;
	
	public Hora_Contrato() {
		
	}

	public Hora_Contrato(Date date, Double valorPorHora, Integer horas) {
		this.date = date;
		ValorPorHora = valorPorHora;
		Horas = horas;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Double getValorPorHora() {
		return ValorPorHora;
	}

	public void setValorPorHora(Double valorPorHora) {
		ValorPorHora = valorPorHora;
	}

	public Integer getHoras() {
		return Horas;
	}

	public void setHoras(Integer horas) {
		Horas = horas;
	}
	
	public double Valor_Total() {
		return ValorPorHora * Horas;
	}
	
	

}
