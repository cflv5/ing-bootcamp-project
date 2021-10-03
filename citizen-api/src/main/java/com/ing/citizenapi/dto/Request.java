package com.ing.citizenapi.dto;

import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

@Validated
public abstract class Request<T> {
    @NotNull
    private T data;

    protected Request(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    @Override
    public String toString() {
        return "Request [data=" + data + "]";
    }

}
