package com.acc;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;

import com.acc.domain.HolidayRequest;

@Endpoint
public class HolidayEndpoint {
	
	
	private HumanResourceService humanResourceService;

	@Autowired
	public HolidayEndpoint(HumanResourceService humanResourceService) {
		this.humanResourceService = humanResourceService;
	}


	@PayloadRoot(namespace="http://mycompany.com/hr/schemas",localPart="HolidayRequest")
	public void handleHolidayRequest(@RequestPayload HolidayRequest holidayRequest) throws Exception{
		
		Date startdate = holidayRequest.getHoliday().getStartDate().toGregorianCalendar().getTime();
		Date enddate = holidayRequest.getHoliday().getEndDate().toGregorianCalendar().getTime();
		humanResourceService.bookholiday(startdate,enddate,holidayRequest.getEmployee().getFirstName());
	}
}
