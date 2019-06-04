package dd;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RecensioniCtrl {
	private static final Logger logger = LoggerFactory.getLogger(RistorantiCtrl.class);
	@Autowired
	RecensioniRepo repo;

	@GetMapping("/tabellaRecensioni")
	public String ristoranti(Model model) {
		logger.trace("enter");
		model.addAttribute("recensioni", repo.findAll());
		return "/tabellaRecensioni";
	}
	
	@GetMapping("/aggiungiRecensione")
	public String aggiungi(
			@RequestParam(name = "id_rest") int id_rest,
			@RequestParam(name = "stelle") int stelle,
			@RequestParam(name = "id_utente") int id_utente,
			Model model) {
		logger.trace("enter");
		Recensione entity= new Recensione(id_rest , stelle, id_utente);
		repo.save(entity);
		model.addAttribute("recensioni", repo.findAll());
		return "/tabellaRecensioni";
	}
}