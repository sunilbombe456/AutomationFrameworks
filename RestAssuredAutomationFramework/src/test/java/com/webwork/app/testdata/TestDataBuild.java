package com.webwork.app.testdata;
import java.util.ArrayList;
import java.util.List;

import com.webwork.automation.pojo.AddPlace;
import com.webwork.automation.pojo.Location;

public class TestDataBuild {

	public AddPlace getPlacePayload() {
		AddPlace p = new AddPlace();
		p.setAccuracy(50);
		p.setAddress("29, side layout, cohen 09");
		p.setLanguage("English");
		p.setPhone_number("(+91) 8783483879");
		p.setWebsite("https://rahulshettyacademy.com");
		p.setName("Fronline house");
		List<String> myList = new ArrayList<String>();
		myList.add("Shoe Park");
		myList.add("Shop");
		p.setTypes(myList);
		Location l = new Location();
		l.setLng(-38.383494);
		l.setLat(33.427362);
		p.setLocation(l);
		return p;
	}
	
	public String deletePlacePayload(String placeId) {
		return "{ place_id:"+placeId+"}";
	}

}
