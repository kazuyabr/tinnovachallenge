package com.tinnova.cadastro.veiculos.repository;

import java.util.Calendar;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tinnova.cadastro.veiculos.model.Veiculo;

@Repository
public interface VeiculoRepository extends JpaRepository<Veiculo, Long> {

	// Retorna quantidade de veículos em determinado ano
	Integer countByAnoBetween(Integer ano, Integer ano2);

	// Retornar quantidade de veículos não vendido
	long countByVendidoFalse();

	// Retorna por marca
	long countByMarca(String marca);

	// Retorna semana
	List<Veiculo> findByCreatedBetween(Calendar dataSemana, Calendar dataAtual);
}
