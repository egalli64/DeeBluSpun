package dd;




import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecensioniRepo extends CrudRepository<Recensione, Integer> {
	
	Iterable<Recensione> findByRisto_id(int id);
	Iterable<Recensione> findByUse_id(int id);
}