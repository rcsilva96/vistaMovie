package com.techvista.vistamovie;


import com.techvista.vistamovie.exceptions.EstelionatoException;
import com.techvista.vistamovie.exceptions.ForbiddenIdException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(ForbiddenIdException.class)
    public ResponseEntity<Object> handleForbiddenIdException(ForbiddenIdException ex) {
        // Retorna uma mensagem customizada com o código de status FORBIDDEN (403)
        return new ResponseEntity<>(new ErrorResponse("Não mexa com as forças das trevas"), HttpStatus.FORBIDDEN);
    }

    @ExceptionHandler(EstelionatoException.class)
    public ResponseEntity<Object> handleForbiddenIdException(EstelionatoException ex) {
        // Retorna uma mensagem customizada com o código de status FORBIDDEN (403)
        return new ResponseEntity<>(new ErrorResponse("Estelionatários estão proibidos"), HttpStatus.FORBIDDEN);
    }

    // Classe de resposta de erro para personalizar o JSON
    static class ErrorResponse {
        private String message;

        public ErrorResponse(String message) {
            this.message = message;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }
    }
}
