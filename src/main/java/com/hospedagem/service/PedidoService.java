package com.hospedagem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hospedagem.entites.Pedido;
import com.hospedagem.repository.PedidoRepository;

@Service
public class PedidoService {

	private final PedidoRepository pedidoRepository;
	
	@Autowired
	public PedidoService(PedidoRepository pedidoRepository) {
		this.pedidoRepository = pedidoRepository;
	}
	public List<Pedido> buscaTodosPedido(){
		return pedidoRepository.findAll();
	}
	
	public Pedido buscaPedidoId(Long id) {
		Optional <Pedido> Pedido = pedidoRepository.findById(id);
		return Pedido.orElse(null);
	}
	
	public Pedido salvaPedido(Pedido Pedido) {
		return pedidoRepository.save(Pedido);
	}
	public Pedido alterarPedido(Long id, Pedido alterarU) {
		Optional <Pedido> existePedido = pedidoRepository.findById(id);
		if(existePedido.isPresent()) {
			alterarU.setId(id);
			return pedidoRepository.save(alterarU);
		}
		return null;
	}
	public boolean apagarPedido(Long id) {
		Optional <Pedido> existePedido = pedidoRepository.findById(id);
		if (existePedido.isPresent()) {
			pedidoRepository.deleteById(id);
			return true;
		}
		return false;
	}
}
