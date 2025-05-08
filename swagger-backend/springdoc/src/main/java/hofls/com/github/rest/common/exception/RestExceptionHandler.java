package hofls.com.github.rest.common.exception;

import hofls.com.github.rest.common.exception.exceptions.BadRequestException;
import hofls.com.github.rest.common.exception.exceptions.InternalServerException;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;


@ControllerAdvice
@Slf4j
public class RestExceptionHandler {

    /** All errors should be logged */
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<String> handleException(Exception ex, HttpServletRequest request) {
        log.error(ex.getMessage(), ex);
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<String> handleIlegalArgumentException(
            BadRequestException ex, HttpServletRequest request) {
        log.error(ex.getMessage(), ex);
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(InternalServerException.class)
    public ResponseEntity<String> handleException(InternalServerException ex, HttpServletRequest request) {
        log.error(ex.getMessage(), ex);
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<String> handleMethodArgumentNotValidException(
            MethodArgumentNotValidException ex, HttpServletRequest request) {
        log.error(ex.getMessage(), ex);
        String errorMessage = bindingResultToString(ex.getBindingResult());
        return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(BindException.class)
    public ResponseEntity<String> handleBindException(
            BindException ex, HttpServletRequest request) {
        log.error(ex.getMessage(), ex);
        String errorMessage = bindingResultToString(ex.getBindingResult());
        return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
    }

    private String bindingResultToString(BindingResult bindingResult) {
        if (CollectionUtils.isEmpty(bindingResult.getFieldErrors())) {
            return "Error text not found";
        } else {
            FieldError fieldError = bindingResult.getFieldErrors().get(0);
            String errorMessage = String.format("%s.%s %s",
                    fieldError.getObjectName(), fieldError.getField(), fieldError.getDefaultMessage());
            return errorMessage;
        }
    }

}
