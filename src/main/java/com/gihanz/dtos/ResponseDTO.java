package com.gihanz.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ResponseDTO {
    private LocalDate date = LocalDate.now();
    private Integer output;

    public ResponseDTO(Integer output) {
        this.output = output;
    }
}
