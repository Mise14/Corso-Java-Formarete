package it.fabio.MySpringRESTJPA;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import jakarta.transaction.Transactional;

//JpaRepository <Tipo entity, tipo PrimaryKey dell'entity>
public interface MyUserRepository extends JpaRepository<MyUser, Integer> {
	
	/* Per composizione */
	List<MyUser> findByNome(String nome);
		
	/* JPQL */	
	// Select
	@Query("SELECT u FROM MyUser u WHERE u.eta =:eta")
	List<Optional<MyUser>> myFindByUserEta(int eta);	
	
	// Modifiche al Database 
	//@Transactional: dichiara che il metodo o la classe eseguono transazioni SQL.
	//@Modifying: utilizzata per ampliare l'annotazione @Query in modo da poter eseguire non solo query SELECT ma anche INSERT, UPDATE, DELETE e DDL.
	@Transactional
	@Modifying
	@Query("UPDATE MyUser u SET u.nome = ?1, u.cognome = ?2, u.eta = ?3 where u.id_user = ?4")
	int myUpdateUserById(String nome, String cognome, int eta, int id_user);
	
	
	
}
