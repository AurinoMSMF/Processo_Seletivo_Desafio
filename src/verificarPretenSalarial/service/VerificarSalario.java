package verificarPretenSalarial.service;
import java.util.concurrent.ThreadLocalRandom;
import java.util.Random;
class VerificarSalario {
	
	public static void main(String[] args) {
		
		System.out.println("PROCESSO SELETIVO DESAFIO");
		selecaoCandidatos();
		
	}
	
	static void  selecaoCandidatos() {
		
		//a ordem de chegada das pretensões coincide com o indice no array dos candidatos
		System.out.println("Analisando candidatos e suas pretensões...");
		System.out.println();
		
		String [] candidatos= {"JOSE","MARIA","JOAO","PAULO","PEDRO","MARCOS","TIAGO","MATEUS","MOISES","ELIAS"};
		
		System.out.println("Os candidatos são:");
		for (int x =0;x<candidatos.length;x++) {
			System.out.println(candidatos[x]);
		}
		
		System.out.println();
		
		//somente 5 são selecionados
		int candidatosSelecionados=0;
		int candidatoAtual=0;
		while (candidatosSelecionados<5 && candidatoAtual<candidatos.length) {
			
			String candidato = candidatos[candidatoAtual];
			
			double baseSalarial=2000.0;
			
			double salarioPretendido= valorPretendido();
			
			String salarioFormatado = String.format("%.2f",salarioPretendido);
			
			analisaPretensao(salarioPretendido);
			
			System.out.println("O candidato "+candidato+" propos o valor: "+ salarioFormatado);
		
			if (baseSalarial>salarioPretendido) {
				System.out.println("Candidato "+candidato+" selecionado.");
				entrandoEmContato(candidato);
				System.out.println();
				candidatosSelecionados++;
			} else {
				System.out.println("Por não chegar a um consenso o candidato "+candidato+" não selecionado.");
				System.out.println();
			}
			candidatoAtual++;
		}
		
	}
	
	static void entrandoEmContato(String candidato) {
		int tentativasDeContato=1;
		boolean continuarLigando=true;
		boolean atendeu=false;
		
		do {
			atendeu = statusLigacao();
			continuarLigando= !atendeu;
			if(continuarLigando) {
				tentativasDeContato++;
			} else {
				System.out.println("CONTATO REALIZADO COM SUCESSO!");
			}
		} while (continuarLigando && tentativasDeContato<3);
		
		if(atendeu) {
			System.out.println("Conseguimos contato com "+candidato+" após "+tentativasDeContato+" tentativas.");
		}
		else {
			System.out.println("Não conseguimos contato com " + candidato + ", excedido o limite de "+tentativasDeContato+" tentativas de ligação.");
		}		
	}
	
	static boolean statusLigacao() {
		return new Random().nextInt(3)==1;
	}
	
	static void analisaPretensao(double salarioPretendido) {

		double baseSalarial=2000.0;
		
		if (baseSalarial>salarioPretendido) {
			System.out.println("LIGAR PARA O CANDIDATO");
		} else if (baseSalarial==salarioPretendido) {
			System.out.println("LIGAR PARA O CANDIDATO, COM CONTRA PROPOSTA");
		} else {
			System.out.println("AGUARDANDO RESULTADO DOS DEMAIS CANDIDATOS.");
		}
		
	}
	
	static double valorPretendido() {
	     return ThreadLocalRandom.current().nextDouble(1800, 2200);
	}

}
