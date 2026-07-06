package ar.edu.utn.frba.ddsi.climalert.services.impl;

import ar.edu.utn.frba.ddsi.climalert.models.entities.Alerta;
import ar.edu.utn.frba.ddsi.climalert.models.entities.Clima;
import ar.edu.utn.frba.ddsi.climalert.models.repositories.ClimaRepository;
import ar.edu.utn.frba.ddsi.climalert.services.AlertaService;
import ar.edu.utn.frba.ddsi.climalert.services.MailService;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class AlertaServiceImpl implements AlertaService {
  private final ClimaRepository climaRepository;
  private final MailService mailService;

  public AlertaServiceImpl(ClimaRepository climaRepository, MailService mailService) {
    this.climaRepository = climaRepository;
    this.mailService = mailService;
  }

  @Override
  public void verificarAlerta(){
    Optional<Clima> ultimoRegistro = climaRepository.ultimoRegistro();
    if (ultimoRegistro.isEmpty()) {
      return;
    }
    Clima clima = ultimoRegistro.get();

    System.out.println("Verificando si hay alerta...");
    if(clima.getTemperatura() > 35 && clima.getHumedad() > 60){
      Alerta alerta = new Alerta(clima, LocalDateTime.now());
      mailService.enviarAlerta(alerta);
    }
  }
}
