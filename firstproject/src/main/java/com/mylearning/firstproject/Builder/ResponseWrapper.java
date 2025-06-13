package com.mylearning.firstproject.Builder;

import jdk.nashorn.internal.runtime.Debug;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ResponseWrapper<T>{
    private String id;
    private String type;
    private T attributes;
    private String code;

    public ResponseWrapper(String id, String type, T attributes, String code) {
        this.id = id;
        this.type = type;
        this.attributes = attributes;
        this.code = code;
    }
}
