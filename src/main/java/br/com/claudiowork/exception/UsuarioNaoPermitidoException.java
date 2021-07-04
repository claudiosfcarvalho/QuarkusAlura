package br.com.claudiowork.exception;

public class UsuarioNaoPermitidoException extends RuntimeException{
    public UsuarioNaoPermitidoException(String msg) {
        super(msg);
    }
}
