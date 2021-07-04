package br.com.claudiowork.repository;

import br.com.claudiowork.model.Ordem;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped //a classe tem uma instância apenas compartilhada
public class OrdemRepository implements PanacheRepository<Ordem> {

}
