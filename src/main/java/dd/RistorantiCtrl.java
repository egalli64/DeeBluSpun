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
public class RistorantiCtrl {
	private static final Logger logger = LoggerFactory.getLogger(RistorantiCtrl.class);
	@Autowired
	RistorantiRepo repo;
	@Autowired
	RecensioniRepo reporec;
	

	@GetMapping("/tabellaRistoranti")
	public String ristoranti(Model model) {
		logger.trace("enter");
		model.addAttribute("ristoranti", repo.findAll());
		return "/tabellaRistoranti";
	}

	@GetMapping("/aggiungi")
	public String aggiungi(@RequestParam(name = "name") String nome, @RequestParam(name = "posizione") String posizione,
			@RequestParam(name = "specialita") String specialita, Model model) {
		logger.trace("enter");
		Ristorante entity = new Ristorante(nome, posizione, specialita);
		repo.save(entity);
		model.addAttribute("ristoranti", repo.findAll());
		return "/tabellaRistoranti";
	}

	@GetMapping("/delete")
	public String elimina(@RequestParam int id, Model model) {
		logger.trace("elimina " + id);
		repo.deleteById(id);
		model.addAttribute("ristoranti", repo.findAll());
		return "/tabellaRistoranti";
	}

	@GetMapping("/edit")
	public String update(@RequestParam(name = "id") int id, @RequestParam(name = "name") String nome,
			@RequestParam(name = "posizione") String posizione, @RequestParam(name = "specialita") String specialita,
			Model model) {
		Ristorante entity = new Ristorante(id, nome, posizione, specialita);
		repo.save(entity);
		model.addAttribute("ristoranti", repo.findAll());
		return "/tabellaRistoranti";
	}

	@GetMapping("/update")
	public String edit(@RequestParam(name = "id") int id, Model model) {
		logger.trace("enter");
		Optional<Ristorante> r = repo.findById(id);
		if (r.isPresent()) {
			model.addAttribute("r", r.get());
		}

		return "/edit";
	}
	
	@GetMapping("/visualizzaRec")
	public String visua(@RequestParam(name = "id") int id, 
			Model model) {
		logger.trace("enter");
		model.addAttribute("r", reporec.findByRisto_id(id));

		return "/rec_ris";
	}

	
}
