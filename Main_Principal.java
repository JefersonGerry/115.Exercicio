package application;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;
import entities.Departamento;
import entities.Funcionario;
import entities.Hora_Contrato;
import entities.enums.Nivel_Funcionario;
public class Main_Principal {

	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		System.out.println("Entre com o nome do departamento: ");
		String Nome_Departamento = sc.nextLine();
		System.out.println("Digite os dados do Funcionario: ");
		System.out.println("Nome: ");
		String Nome_Funcionario = sc.nextLine();
		System.out.println("Nivel: ");
		String nivel_Funcionario = sc.nextLine();
		System.out.println("Base salarial: ");
		double Base_Salario = sc.nextDouble();
		//Instanciado a classe funcionario na Main
		Funcionario funcionario = new Funcionario(Nome_Funcionario,Nivel_Funcionario.valueOf(nivel_Funcionario),Base_Salario, new Departamento(Nome_Departamento));
		System.out.println("Quantos contratos para esse funcionario: ");
		int n = sc.nextInt();
		// função para percorrer os contratos  e econtrar os pertencentes ao respectivo funcionario
		for(int i = 1; i < n + 1; i++) {
			System.out.println("Entre com o numero do contrato #" + i + " data: ");
			System.out.println("Date (DD/MM/YYYY)");
			Date Data_Contrato = sdf.parse(sc.next());
			System.out.println("Valor por hora: ");
			double Valor_PorHora = sc.nextDouble();
			System.out.println("Duração das horas de trabalho: ");
			int Horas = sc.nextInt();
			Hora_Contrato Novo_Contrato = new Hora_Contrato(Data_Contrato,Valor_PorHora,Horas);
			funcionario.Add_Contrato(Novo_Contrato);
		}
		 System.out.println();
		 System.out.println("Entre com o mês e ano para calcular o salario (MM/YYYY) : ");
		 String Mes_E_Ano = sc.next();
		 int mes = Integer.parseInt(Mes_E_Ano.substring(0, 2));
		 int ano = Integer.parseInt(Mes_E_Ano.substring(3));
		 System.out.println("Nome: " + funcionario.getNome());
		 System.out.println("Departamento: " + funcionario.getDepartamento().getName());
		 System.out.println("Renda para " + Mes_E_Ano + ": " + String.format("%.2f",funcionario.renda(ano, mes)));
		 	
		
        sc.close();
	}

}
