package com.hospedagem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hospedagem.entites.Pedido;

public interface PedidoRepository  extends JpaRepository<Pedido,Long >{

}
