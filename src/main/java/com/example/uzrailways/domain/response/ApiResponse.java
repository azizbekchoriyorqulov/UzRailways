package com.example.uzrailways.domain.response;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ApiResponse {
    private String message;
    private Long id;
    private boolean isSuccess;
    private Object object;

    public ApiResponse(boolean isSuccess,String message){
        this.isSuccess = isSuccess;
        this.message = message;
    }
}
