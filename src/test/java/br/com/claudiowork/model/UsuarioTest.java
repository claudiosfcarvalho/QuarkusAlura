package br.com.claudiowork.model;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import io.quarkus.panache.mock.PanacheMock;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@QuarkusTest
class UsuarioTest {

    @Test
    public void testarSeFindByIdRetornaUsuarioCorreto() {
        PanacheMock.mock(Usuario.class);
        Usuario u = new Usuario();

        Optional<PanacheEntityBase> usuario = Optional.of(u);
        Mockito.when(Usuario.findByIdOptional(40)).thenReturn(usuario);
        Assertions.assertSame(u,Usuario.findByIdOptional(40).get());
    }
}