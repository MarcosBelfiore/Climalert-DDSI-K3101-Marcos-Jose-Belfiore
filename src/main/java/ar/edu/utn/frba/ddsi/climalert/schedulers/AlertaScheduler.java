package ar.edu.utn.frba.ddsi.climalert.schedulers;

import ar.edu.utn.frba.ddsi.climalert.services.AlertaService;
import ar.edu.utn.frba.ddsi.climalert.services.AlmacenajeClimaService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class AlertaScheduler {
  private final AlertaService alertaService;

  public AlertaScheduler(AlertaService alertaService) {
    this.alertaService = alertaService;
  }

  @Scheduled(fixedRate = 60000)
  public void almacenarClima() {
    alertaService.verificarAlerta();
  }
}
