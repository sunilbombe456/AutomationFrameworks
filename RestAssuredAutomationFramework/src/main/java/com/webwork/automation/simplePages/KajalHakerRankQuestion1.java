package com.webwork.automation.simplePages;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class KajalHakerRankQuestion1 {

	static String blackListedIps[] = {"111.*","123.*","34.*"};
	static String requests[] = {"123.1.23.34","121.1.23.34","34.1.23.34","121.1.23.34","121.1.23.34","12.1.23.34","121.1.23.34"};
	public static void main(String args[]) {
		
		List<String> requestIpSet = Arrays.asList(requests).stream().collect(Collectors.toList());
		List<Integer> blackListedIpStatus = new ArrayList<Integer>();
		for(String rip:requestIpSet) {
			int status = 0;
			for(String bip:blackListedIps) {
				String bipFirst = bip.replace(".*", "");
				int length = bipFirst.length();
				if(rip.substring(0, length).equals(bipFirst)) {
					status = 1;
				}	
			}
			blackListedIpStatus.add(status);
		}
		
		System.out.println(blackListedIpStatus);
	}
	
}
