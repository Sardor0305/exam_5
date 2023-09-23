package org.example.bot.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Money {
	private int id;
	private int Code;
	private String Ccy;
	private String CcyNm_RU;
	private String CcyNm_UZ;
	private String CcyNm_UZC;
	private String CcyNm_EN;
	private int Nominal;
	private double Rate;
	private double Diff;
	private String Date;
}