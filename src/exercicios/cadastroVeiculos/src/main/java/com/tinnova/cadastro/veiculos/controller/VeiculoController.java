package com.tinnova.cadastro.veiculos.controller;

import java.util.Calendar;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tinnova.cadastro.veiculos.model.Veiculo;
import com.tinnova.cadastro.veiculos.repository.VeiculoRepository;
import com.tinnova.cadastro.veiculos.repository.service.VeiculoService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "Cadastro de Veículos API")
@RestController
@RequestMapping({ "/api/v1/veiculos" })
public class VeiculoController {

	private VeiculoRepository veiculoRepository;

	VeiculoController(VeiculoRepository veiculoRepository) {
		this.veiculoRepository = veiculoRepository;
	}

	@Autowired
	private VeiculoService service;

	@ApiOperation(value = "Retorna os veículos cadastrados na semana")
	@GetMapping(path = { "/ultimasemana" })
	public List<Veiculo> findBySemana() {
		Calendar dataAtual = Calendar.getInstance();
		Calendar dataSemana = service.dataSemana();
		return veiculoRepository.findByCreatedBetween(dataSemana, dataAtual);
	}

	@ApiOperation(value = "Retorna apenas veículos não vendidos, true = vendido")
	@GetMapping(path = { "/vendidos" })
	public long countVeiculoNaoVendido() {
		return veiculoRepository.countByVendidoFalse();
	}

	@SuppressWarnings("rawtypes")
	@ApiOperation(value = "Retorna todos veículos")
	@GetMapping
	public List findAll() {
		return veiculoRepository.findAll();
	}

	@ApiOperation(value = "Retorna os detalhes de cada veículo")
	@GetMapping(path = { "/{id}" })
	Optional<Veiculo> find(@PathVariable Long id) {
		return veiculoRepository.findById(id);
	}

	@ApiOperation(value = "Retorna o total de veículos por marca")
	@GetMapping(path = { "/fabricantes/{marca}" })
	public long countByMarca(@PathVariable String marca) {
		return veiculoRepository.countByMarca(marca);
	}

	@ApiOperation(value = "Retorna veículo de determinado ano")
	@GetMapping(path = { "/ano/{ano}" })
	public Integer countAno(@PathVariable Integer ano) {

		return veiculoRepository.countByAnoBetween(2000, 2020);
	}

	@ApiOperation(value = "Cadastra veículo")
	@PostMapping
	public Veiculo create(@RequestBody Veiculo veiculoModel) {
		return veiculoRepository.save(veiculoModel);
	}

	@ApiOperation(value = "Atualiza veículo")
	@PutMapping(path = { "/{id}" })
	public ResponseEntity<Veiculo> put(@PathVariable("id") long id, @RequestBody Veiculo veiculo) {
		return veiculoRepository.findById(id).map(record -> {
			record.setVeiculo(veiculo.getVeiculo());
			record.setAno(veiculo.getAno());
			record.setDescricao(veiculo.getDescricao());
			record.setMarca(veiculo.getMarca());
			record.setVendido(veiculo.isVendido());
			record.setUpdated(veiculo.getCreated());
			Veiculo put = veiculoRepository.save(record);
			return ResponseEntity.ok().body(put);
		}).orElse(ResponseEntity.notFound().build());
	}

	@ApiOperation(value = "Deleta veículo")
	@DeleteMapping(path = { "/{id}" })
	public void delete(@PathVariable Long id) {
		veiculoRepository.deleteById(id);
	}
}
