package com.acc;

import java.util.Date;

import org.springframework.stereotype.Service;

@Service    
public class HumanResourceServiceImpl implements HumanResourceService{

	public void bookholiday(Date startdate, Date enddate, String firstName) {
		System.out.println("Booking holiday for [" + startdate + "-" + enddate + "] for [" + firstName + "] ");
		
	}

}
