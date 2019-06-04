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
public class RecensioniCtrl {
	private static final Logger logger = LoggerFactory.getLogger(RistorantiCtrl.class);
	@Autowired
	RecensioniRepo reporec;
	@Autowired
	RistorantiRepo reporic;

	@GetMapping("/tabellaRecensioni")
	public String recensione(Model model) {
		logger.trace("enter");
		model.addAttribute("recensioni", reporec.findAll());
		return "/tabellaRecensioni";
	}
	
	@GetMapping("/formRecensione")
	public String formrec(Model model) {
		logger.trace("enter");
		model.addAttribute("ristoranti", reporic.findAll());
		return "/formRecensione";
	}
	
	@GetMapping("/aggiungiRecensione")
	public String aggiungirec(
			@RequestParam(name = "id") int id,
			@RequestParam(name = "stelle") int stelle,
			@RequestParam(name = "id_utente") int id_utente,
			Model model) {
		logger.trace("enter");
		Optional<Ristorante> r= reporic.findById(id);
		if (r.isPresent()) {
			Ristorante cur=r.get();
			Recensione entity= new Recensione(cur, stelle, id_utente);
			logger.trace("entity");
			reporec.save(entity);
			model.addAttribute("recensioni", reporec.findAll());	
		}
		return "/tabellaRecensioni";
	}
	
	
}