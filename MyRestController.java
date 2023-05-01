package it.fabio.MySpringRESTJPA;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
//RequestMapping necessario se ho più controller nel progetto
//@RequestMapping("myrestcontroller")
public class MyRestController {

	@Autowired
	private MyService myService;
		
	/* GET */
	@GetMapping("/mygetallusers")
	public List<MyUser> myGetAllUsers() {
		return myService.myFindAllUsers();
	}
	
	@GetMapping("/mygetuserbyid/{id}")
	public Optional<MyUser> myGetUserById(@PathVariable int id) {
		return myService.myFindUserById(id);
	}
	
	@GetMapping("/mygetusersbynome/{nome}")
	public List<MyUser> myGetUsersByNome(@PathVariable String nome) {
		return myService.myFindUsersByNome(nome);
	}
	
	/* Custom JPQL */	
	@GetMapping("/myfindbyusereta/{eta}")
	public List<Optional<MyUser>> myFindByUserEta(@PathVariable int eta) {
		return myService.myFindByUserEta(eta);
	}
	
	// Post via app (es. Postman, Angular, ecc.): usa @RequestBody e consuma APPLICATION_JSON_VALUE
		@PostMapping("/mypostinsertuserobj")
		public String myPostObj(@RequestBody MyUser myUser) {
			return myService.myInsertUserObj(myUser); 
		}
		/*
		@PostMapping("/mypostinsertuserobj")
		public Cliente myPostObj(@RequestBody MyUser myUser) {
			return myService.myInsertUserObj(myUser); 
		}
		*/	
		@PostMapping("/mypostupdateuserobj")
		public int myPostUpdateObj(@RequestBody MyUser myUser) {		
			return myService.myUpdateUserById(myUser); 
		}
		
		@PostMapping("/myupdateuserbyid/{id_user}")
		public int myPostUpdateParams(@RequestParam String nome, String cognome, int eta,@PathVariable int id_user) {		
			return myService.myUpdateUserByIdParam(nome,cognome,eta,id_user);
		}
		
		@DeleteMapping("/deleteuserbyid/{id_user}")
		public void deleteUserObjById(@PathVariable int id_user) {
			myService.deleteUserObjById(id_user); 
		}
	
}
