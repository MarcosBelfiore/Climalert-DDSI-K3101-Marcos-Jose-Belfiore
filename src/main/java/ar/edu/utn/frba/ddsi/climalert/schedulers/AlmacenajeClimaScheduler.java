package ar.edu.utn.frba.ddsi.climalert.schedulers;

import ar.edu.utn.frba.ddsi.climalert.services.AlmacenajeClimaService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class AlmacenajeClimaScheduler {
  private final AlmacenajeClimaService almacenajeClimaService;

  public AlmacenajeClimaScheduler(AlmacenajeClimaService almacenajeClimaService){
    this.almacenajeClimaService = almacenajeClimaService;
  }

  @Scheduled(fixedRate = 300000)
  public void almacenarClima(){
    almacenajeClimaService.almacenarClimaActual();
  }
}
