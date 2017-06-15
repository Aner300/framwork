package ao.co.framework.framwork.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;

import ao.co.framework.framwork.model.Cliente;
import ao.co.framework.framwork.repository.ClienteRepository;
import lombok.Getter;
import lombok.Setter;




@Named
@ViewScoped
@Getter
@Setter
public class ClienteController {
String nome;
String email;

@Autowired
private ClienteRepository clienteRepository;

private List<Cliente> clientes;

private Cliente cliente = new Cliente();

@PostConstruct
public void init(){
	clientes = clienteRepository.buscarTodos();
}

public void salvar(){

	clienteRepository.save(cliente);
	clientes.add(cliente);
	cliente = new Cliente();
	

}

public Cliente getCliente(){
	return cliente;
}

public void setCliente(Cliente cliente){
	this.cliente = cliente;
}

}
