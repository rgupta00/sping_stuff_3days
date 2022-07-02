package com.productapp.dto;

import java.time.LocalDateTime;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class ErrorMessage {
	private String message;
	private String statusCode;
	private LocalDateTime dateTime;
	private String toContact;

}
