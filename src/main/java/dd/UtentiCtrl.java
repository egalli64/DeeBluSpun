package dd;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class UtentiCtrl {
	private static final Logger logger = LoggerFactory.getLogger(UtentiCtrl.class);
	@Autowired
	UtentiRepo repo;
	@Autowired
	RecensioniRepo reporec;

	@GetMapping("/tabellaUtenti")
	public String utenti(Model model) {
		logger.trace("enter");
		model.addAttribute("utente", repo.findAll());
		return "/tabellaUtenti";
	}
	
	@GetMapping("/aggiungiUtente")
	public String aggiungiUtente(
			@RequestParam(name = "name") String nome,
			@RequestParam(name = "cognome") String cognome,
			Model model) {
		Utente entity= new Utente(nome, cognome);
		repo.save(entity);
		model.addAttribute("utente", repo.findAll());
		return "/tabellaUtenti";
	}
	
	@GetMapping("/deleteUtente")
	public String elimina(
			@RequestParam int id,
			Model model) {
		logger.trace("elimina " + id);
		repo.deleteById(id);
		model.addAttribute("utente", repo.findAll());
		return "/tabellaUtenti";
	}
	
	@GetMapping("/editUtente")
	public String update(
			@RequestParam(name = "id") int id,
			@RequestParam(name = "name") String nome,
			@RequestParam(name = "cognome") String cognome,
			
			Model model) {
		Utente entity= new Utente(id, nome, cognome);
		repo.save(entity);
		model.addAttribute("utente", repo.findAll());
		return "/tabellaUtenti";
	}
	
	@GetMapping("/updateUtente")
	public String edit(
			@RequestParam(name = "id") int id,
			Model model) {
		logger.trace("enter");
		Optional<Utente> u= repo.findById(id);
		if (u.isPresent()) {
			model.addAttribute("u", u.get());		
		}
		return "/editUtente";
	}
	
	@GetMapping("/visualizzaUten")
	public String visua(@RequestParam(name = "id") int id, 
			Model model) {
		logger.trace("enter");
		model.addAttribute("u", reporec.findByUse_id(id));
		model.addAttribute("utenteId", id);

		return "/rec_ute";
	}
	
	
}
