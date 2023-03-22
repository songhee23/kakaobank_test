package com.songhee.demo.dto;

import java.sql.Timestamp;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class BaseTimeDto {
	private Timestamp regDateTime;
	private Timestamp modDateTime;
}
