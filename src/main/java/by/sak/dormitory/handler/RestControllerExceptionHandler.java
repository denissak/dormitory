package by.sak.dormitory.handler;

import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice(basePackages = "by.sak.dormitory.rest")
public class RestControllerExceptionHandler extends ResponseEntityExceptionHandler {
}
