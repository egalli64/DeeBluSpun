package dd;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UtentiRepo extends CrudRepository<Utente, Integer>{

}
