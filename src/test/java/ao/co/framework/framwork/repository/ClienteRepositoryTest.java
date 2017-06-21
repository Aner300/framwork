package ao.co.framework.framwork.repository;


import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import javax.persistence.EntityManager;

import org.assertj.core.api.Assert;
import org.h2.command.dml.Replace;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import ao.co.framework.framwork.model.Cliente;

@RunWith(SpringRunner.class)
@DataJpaTest

//@AutoConfigureTestDatabase(connection=EmbeddedDatabaseConnection.H2,replace=Replace.class)
public class ClienteRepositoryTest {
	
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	EntityManager entityManager;
	
	@Test
	public void testSalvar(){
		
		Cliente cli = new Cliente();
		cli.setNome("Anércio");
	
		
		Cliente cliSalvo = clienteRepository.save(cli);
		//Assert.assertNotNull(cliSalvo.getId());
		
		
	}
	@Test
	public void testBuscaPorEmail(){
		Cliente cli = new Cliente();
		cli.setNome("Anércio");

		entityManager.persist(cli);
		Cliente cliEncontrado = clienteRepository.buscarPorEmail("anermorais@gmail.com");
		assertThat(cliEncontrado.getNome()).isEqualTo(cli.getNome());
		
	}
	
	@Test
	public void BuscaTodos(){	
	Cliente cli2 = new Cliente();	
	cli2.setNome("Anércio");
	entityManager.persist(cli2);
	
	List<Cliente> lista = clienteRepository.buscarTodos();
	assertThat(lista.get(0).getNome()).isEqualTo(cli2.getNome());
	}
	
}
