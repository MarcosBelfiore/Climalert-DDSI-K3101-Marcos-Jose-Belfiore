package ar.edu.utn.frba.ddsi.climalert.services.impl;

import ar.edu.utn.frba.ddsi.climalert.models.adapters.ClimaAdapter;
import ar.edu.utn.frba.ddsi.climalert.models.entities.Clima;
import ar.edu.utn.frba.ddsi.climalert.models.repositories.ClimaRepository;
import ar.edu.utn.frba.ddsi.climalert.services.AlmacenajeClimaService;
import org.springframework.stereotype.Service;


@Service
public class AlmacenajeClimaServiceImpl implements AlmacenajeClimaService {
  private final ClimaAdapter climaAdapter;
  private final ClimaRepository climaRepository;

  public AlmacenajeClimaServiceImpl(ClimaAdapter climaAdapter,ClimaRepository climaRepository){
    this.climaAdapter = climaAdapter;
    this.climaRepository = climaRepository;
  }

  @Override
  public void almacenarClimaActual(){
    Clima clima = climaAdapter.obtenerClimaActual();
    climaRepository.save(clima);
    System.out.println("Clima almacenado");
  }
}
