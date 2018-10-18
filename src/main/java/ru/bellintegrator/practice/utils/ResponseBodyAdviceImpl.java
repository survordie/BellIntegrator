package ru.bellintegrator.practice.utils;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import javax.servlet.http.HttpServletResponse;
import java.util.LinkedHashMap;

@ControllerAdvice
public class ResponseBodyAdviceImpl implements ResponseBodyAdvice<Object> {

    @Override
    public boolean supports(MethodParameter methodParameter, Class aClass) {
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter methodParameter, MediaType mediaType, Class aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {

        HttpServletResponse servletResponse = ((ServletServerHttpResponse) serverHttpResponse).getServletResponse();

        if (servletResponse.getStatus() != 200) {

            return new String("error: {" + ((LinkedHashMap<Integer, String>) body).get("message") + "}");
        }

        return new Wrapper<Object>(body);
    }

    @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
    @JsonSerialize
    private class Wrapper<T> {
        private final Object data;

        public Wrapper(Object data) {
            this.data = data;
        }
    }

    public ResponseEntity<Object> createYourResponseBodyE_G_200(Object body) {

        return new ResponseEntity<Object>("data: { result:success }", HttpStatus.OK);

    }

    public ResponseEntity<Object> createYourResponseBodyE_G_500() {

        return new ResponseEntity<Object>("data: { \"error\":\"500\" }", HttpStatus.INTERNAL_SERVER_ERROR);

    }
}
