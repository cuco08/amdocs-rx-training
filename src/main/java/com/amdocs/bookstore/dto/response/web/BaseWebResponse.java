package com.amdocs.bookstore.dto.response.web;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class BaseWebResponse<T> {
    private T data;

    public static BaseWebResponse successNoData() {
        return BaseWebResponse.builder().build();
    }

    public static <T> BaseWebResponse<T> successWithData(T data) {
        return BaseWebResponse.<T>builder().data(data).build();
    }
}
