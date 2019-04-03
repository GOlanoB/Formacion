package gonzalo.formacion.Tabla.repositories;


import gonzalo.formacion.Tabla.model.Usuario;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UsuarioRepository extends CrudRepository<Usuario, Integer> {


}