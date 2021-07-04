package br.com.claudiowork.service;

import br.com.claudiowork.exception.UsuarioNaoPermitidoException;
import br.com.claudiowork.model.Ordem;
import br.com.claudiowork.model.Usuario;
import br.com.claudiowork.repository.OrdemRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.core.SecurityContext;
import java.time.LocalDate;
import java.util.Optional;

@ApplicationScoped
public class OrdemService {

    @Inject
    OrdemRepository ordemRepository;

    public void inserir(SecurityContext securityContext, Ordem ordem) {
        Optional<Usuario> usuarioOptional =
                Usuario.findByIdOptional(ordem.getUserId());
        Usuario usuario = usuarioOptional.orElseThrow();
        if (!usuario.getUsername().equals(securityContext.getUserPrincipal().getName())) {
            System.out.println("O usuário logado "
                    + securityContext.getUserPrincipal().getName()
                    + "é diferente do userId");
            throw new UsuarioNaoPermitidoException("O usuário logado é diferente do userId");
        }
        ordem.setData(LocalDate.now());
        ordem.setStatus("ENVIADA");
        ordemRepository.persist(ordem);
    }
}