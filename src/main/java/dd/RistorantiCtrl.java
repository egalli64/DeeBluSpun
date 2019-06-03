package dd;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


public class RistorantiCtrl {
	private static final Logger logger = LoggerFactory.getLogger(RistorantiCtrl.class);
	@Autowired
	RistorantiRepo repo;

	@GetMapping("/tabellaRistoranti")
	public String regions(Model model) {
		model.addAttribute("ristoranti", repo.findAll());
		return "/ristoranti";
	}
}


