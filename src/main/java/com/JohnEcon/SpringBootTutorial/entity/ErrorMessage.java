package com.JohnEcon.SpringBootTutorial.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import javax.persistence.Embeddable;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class    ErrorMessage {

    private HttpStatus status;
    private String errorMessage;
}
