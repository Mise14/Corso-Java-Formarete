package it.fabio.MySpringRESTJPA;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyService {

	@Autowired
	MyUserRepository myUserRepository;

	public List<MyUser> myFindAllUsers() {
		return myUserRepository.findAll();
	}

	//Optional ritorna o un user o null, opzionalmente
	public Optional<MyUser> myFindUserById(int id) {
		return myUserRepository.findById(id);
	}

	public List<MyUser> myFindUsersByNome(String nome) {
		return myUserRepository.findByNome(nome);
	}

	public void myInsertUserParams(String nome, String cognome, int eta) {
		myUserRepository.save(new MyUser(nome, cognome, eta));
	}

	/*
	public MyUser myInsertUserObj(MyUser myUser) {
		return myUserRepository.save(myUser);
	}
*/
	/*
	
	/* Esempio di elaborazione da parte del service */	
	public String myInsertUserObj(MyUser myUser) {
		String result = "";
		// Verifica il dato in ingresso
		if(myUser.getEta() >=18 ) {
			// JpaRepository.save() ritorna l'istanza dell'oggetto salvato
			MyUser myUserRet = myUserRepository.save(myUser);
			// Manipola il dato in uscita
			result = "Complimenti " + myUserRet.getNome() + ", ora sei nel Club" ;
		} else {
			result = "Spiacente, non è un Club per minori";
		}
		return result;
	}
	 

	public void deleteUserObjById(int id_user) {
		myUserRepository.deleteById(id_user);
	}

	// Custom Query JPQL
	public List<Optional<MyUser>> myFindByUserEta(int eta) {
		return myUserRepository.myFindByUserEta(eta);
	}

	public int myUpdateUserById(MyUser myUser) {
		System.out.printf(myUser.getNome(), myUser.getCognome(), myUser.getEta(), myUser.getId_user());
		return myUserRepository.myUpdateUserById(myUser.getNome(), myUser.getCognome(), myUser.getEta(),
				myUser.getId_user());
	}
	public int myUpdateUserByIdParam(String nome, String cognome, int eta, int id_user) {
		return myUserRepository.myUpdateUserById(nome,cognome,eta,id_user);
	}
}
