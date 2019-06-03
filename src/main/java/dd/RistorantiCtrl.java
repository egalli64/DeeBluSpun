package dd;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RistorantiCtrl {
	private static final Logger logger = LoggerFactory.getLogger(RistorantiCtrl.class);
	@Autowired
	RistorantiRepo repo;

	@GetMapping("/tabellaRistoranti")
	public String ristoranti(Model model) {
		logger.trace("enter");
		model.addAttribute("ristoranti", repo.findAll());
		return "/tabellaRistoranti";
	}
	
	@GetMapping("/aggiungi")
	public String aggiungi(
			@RequestParam(name = "id_risto") int id,
			@RequestParam(name = "name") String nome,
			@RequestParam(name = "posizione") String posizione,
			@RequestParam(name = "specialita") String specialita,
			Model model) {
		logger.trace("enter");
		Ristorante entity= new Ristorante(id, nome, posizione, specialita);
		repo.save(entity);
		model.addAttribute("ristoranti", repo.findAll());
		return "/tabellaRistoranti";
	}
	@GetMapping("/delate")
	public String aggiungi(
			@RequestParam(name = "id") int id,
			Model model) {
		logger.trace("enter");
		repo.deleteById(id);
		model.addAttribute("ristoranti", repo.findAll());
		return "/tabellaRistoranti";
	}
	
}


