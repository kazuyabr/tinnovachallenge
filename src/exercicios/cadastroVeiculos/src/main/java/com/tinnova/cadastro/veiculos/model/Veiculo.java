package com.tinnova.cadastro.veiculos.model;

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Veiculo {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@NotNull(message = "Campo não pode ser nulo")
	private String veiculo;

	@NotNull(message = "Campo não pode ser nulo")
	private String marca;

	@Min(value = 1900)
	@Max(value = 2022)
	@NotNull(message = "Campo não pode ser nulo")
	private Integer ano;

	@NotNull(message = "Campo não pode ser nulo")
	private String descricao;

	private boolean vendido;

	private Calendar created = Calendar.getInstance();

	private Calendar updated;

}
