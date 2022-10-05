package com.geral.empresa;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.geral.empresa.domain.Departamento;
import com.geral.empresa.domain.Funcionario;
import com.geral.empresa.repositories.DepartamentoRepository;
import com.geral.empresa.repositories.FuncionarioRepository;

@SpringBootApplication
public class EmpresaApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmpresaApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(DepartamentoRepository deptoRep,
	  FuncionarioRepository funcRep) {
		return (args) -> {
			Departamento depto1 = new Departamento(null,"Produção");
			Departamento depto2 = new Departamento(null,"Finanças");
			deptoRep.save(depto1);
			deptoRep.save(depto2);
			funcRep.save(new Funcionario(null,"Marcos",depto1));
			funcRep.save(new Funcionario(null,"Pedro",depto1));
			funcRep.save(new Funcionario(null,"Tiago",depto1));
			funcRep.save(new Funcionario(null,"Yurii",depto2));
			funcRep.save(new Funcionario(null,"Wellington",depto2));


			//deptoRep.save(new Departamento(null,null));
			//deptoRep.save(new Departamento(null,"A"));
		};
	}
}
