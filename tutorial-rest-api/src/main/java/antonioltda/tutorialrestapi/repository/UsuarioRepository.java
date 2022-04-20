package antonioltda.tutorialrestapi.repository;

import antonioltda.tutorialrestapi.model.UsuarioModel;
import org.springframework.data.repository.CrudRepository;

public interface UsuarioRepository extends CrudRepository<UsuarioModel, Integer> {

}
