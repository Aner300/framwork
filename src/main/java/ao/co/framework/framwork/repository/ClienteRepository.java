package ao.co.framework.framwork.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ao.co.framework.framwork.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
	@Query("select cli from Cliente cli where cli.email=:email")
	public Cliente buscarPorEmail(@Param("email")String email);
	
	@Query("select cli from Cliente cli")
	public List<Cliente> buscarTodos();
}