package entities;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import entities.enums.Nivel_Funcionario;

public class Funcionario {
	
	private String nome;
	// usa enum Nivel_Funcionario para se criar o level dentro dessa classe
	private Nivel_Funcionario level;
	private Double Salario_Base;
	// se chama a classe Departamento para se gerar departamento dentro dessa classe
	private Departamento departamento; 
	// criando a lista de contratos dentro da classe chamando a classe Hora_Contrato
	private List<Hora_Contrato> contratos = new ArrayList<>();
	
	public Funcionario() {
		
	}

	public Funcionario(String nome, Nivel_Funcionario level, Double salario_Base, Departamento departamento) {
		this.nome = nome;
		this.level = level;
		Salario_Base = salario_Base;
		this.departamento = departamento;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Nivel_Funcionario getLevel() {
		return level;
	}

	public void setLevel(Nivel_Funcionario level) {
		this.level = level;
	}

	public Double getSalario_Base() {
		return Salario_Base;
	}

	public void setSalario_Base(Double salario_Base) {
		Salario_Base = salario_Base;
	}

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	public List<Hora_Contrato> getContratos() {
		return contratos;
	}

	// esse metodo vai pegar a lista de contratos e adicionar o contrato criando a ela
	public void Add_Contrato(Hora_Contrato contrato) {
		contratos.add(contrato);
	}
	// metodo para remover contrato da lista
	public void remover_Contrato (Hora_Contrato contrato) {
		contratos.remove(contrato);
	}
	
	public double renda(int ano, int mes) {
		double soma = Salario_Base;
		Calendar cal = Calendar.getInstance();
		// função que vai percorer cada ano e mes do respectivo funcionario para encontrar seus contratos
		for(Hora_Contrato c : contratos) {
			cal.setTime(c.getDate());
			int c_ano = cal.get(Calendar.YEAR);
		    int c_mes = cal.get(Calendar.MONTH) + 1;
		    if(ano == c_ano && mes == c_mes) {
		    	soma += c.Valor_Total();
		    }
		}
		return soma;
	}
	
	
	

}
