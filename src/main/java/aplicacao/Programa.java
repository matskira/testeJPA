package aplicacao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dominio.Pessoa;

public class Programa {

	public static void main(String[] args) {
		new Programa().excluirPessoa();
	}
	
	public void salvarPessoa() {
		Pessoa novaPessoa = new Pessoa(null, "Matheus Poda", "matheus.poda@gmail.com");
		Pessoa novaPessoa2 = new Pessoa(null, "Ricardo Almeida", "ricardo.almeida@gmail.com");
		Pessoa novaPessoa3 = new Pessoa(null, "Digas Souza", "digas.souza@gmail.com");
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(novaPessoa);
		em.persist(novaPessoa2);
		em.persist(novaPessoa3);
		em.getTransaction().commit();
		System.out.println("Pronto!");
		em.close();
		emf.close();
	}
	public void consultarPessoas() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa");
		EntityManager em = emf.createEntityManager();
		
		Pessoa p = em.find(Pessoa.class, 2);
		
		System.out.println(p);
		System.out.println("Pronto!");
		em.close();
		emf.close();
	}
	public void excluirPessoa() {
		//Primeiro você pega o objeto que deseja excluir
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa");
		EntityManager em = emf.createEntityManager();
		Pessoa p = em.find(Pessoa.class, 2);
		em.getTransaction().begin();
		em.remove(p);
		em.getTransaction().commit();
		System.out.println("Pronto!");
		em.close();
		emf.close();
	}
}
