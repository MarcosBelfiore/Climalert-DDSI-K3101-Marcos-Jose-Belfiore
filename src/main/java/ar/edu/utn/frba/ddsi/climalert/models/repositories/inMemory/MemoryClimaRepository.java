package ar.edu.utn.frba.ddsi.climalert.models.repositories.inMemory;

import ar.edu.utn.frba.ddsi.climalert.models.entities.Clima;
import ar.edu.utn.frba.ddsi.climalert.models.repositories.ClimaRepository;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class MemoryClimaRepository implements ClimaRepository {
  private final List<Clima> registrosClimaticos = new ArrayList<>();

  @Override
  public void save(Clima clima){
    registrosClimaticos.add(clima);
  }

  @Override
  public Optional<Clima> ultimoRegistro(){
    if(registrosClimaticos.isEmpty()) {
      return Optional.empty();
    }
    return Optional.of(registrosClimaticos.get(registrosClimaticos.size()-1));
  }

  @Override
  public List<Clima> findAll(){
      return new ArrayList<>(registrosClimaticos);
  }
}
