package br.com.claudiowork.controller;

import br.com.claudiowork.model.Ordem;
import br.com.claudiowork.repository.OrdemRepository;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import java.time.LocalDate;

@Path("/ordens")
public class OrdemController {
    @Inject
    OrdemRepository ordemRepository;

    @POST
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON)
    public void inserir(Ordem ordem) {
        ordem.setData(LocalDate.now());
        ordem.setStatus("ENVIADA");
        ordemRepository.persist(ordem);
    }
}
