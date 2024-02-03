package com.example.uzrailways.model;

import jdk.jfr.Name;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class KadrResponse
{
    private boolean status;
    private String message;
    private Object object;
}
