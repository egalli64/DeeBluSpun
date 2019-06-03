package dd;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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
}


