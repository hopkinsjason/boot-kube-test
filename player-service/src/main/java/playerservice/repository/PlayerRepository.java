package playerservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import playerservice.model.Player;

@Repository
@RepositoryRestResource(exported = false) 
public interface PlayerRepository extends CrudRepository<Player, String> {

	@Query("SELECT p FROM Player p WHERE LOWER(p.username) LIKE LOWER(CONCAT('%',:username,'%'))")
	List<Player> findByUsername(String username);
	
}
