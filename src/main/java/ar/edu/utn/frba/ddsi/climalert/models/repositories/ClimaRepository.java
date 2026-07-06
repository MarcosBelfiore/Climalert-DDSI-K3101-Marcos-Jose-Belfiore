package ar.edu.utn.frba.ddsi.climalert.models.repositories;

import ar.edu.utn.frba.ddsi.climalert.models.entities.Clima;
import java.util.List;
import java.util.Optional;

public interface ClimaRepository {
  void save(Clima clima);
  Optional<Clima> ultimoRegistro();
  List<Clima> findAll();
}
