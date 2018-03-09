package com.onuz.service;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

@Service
public class TcRecognitionService {
	
	
	public boolean tcRecognate(String tcNo) { // Tc Dogr
		
		List<String> tcNoStringList = Arrays.asList(tcNo.split(""));
		
		List<Integer> tcList = convertList(tcNoStringList, s -> Integer.parseInt(s));
		
		if (method10(tcList) == tcList.get(9) && method11(tcList) == tcList.get(10)) {
			return true;
		} else {
			return false;
		}
		
	}
	
	private int method10(List<Integer> integerList) { //10. basamagı dogrular
		
		int sonuc = (integerList.get(0) + integerList.get(2) 
		+ integerList.get(4) + integerList.get(6) + integerList.get(8) ) * 7;
		
		sonuc = sonuc - (integerList.get(1) + integerList.get(3) 
		+ integerList.get(5) + integerList.get(7));
		
		return sonuc % 10;
	}
	
	
	private int method11(List<Integer> integerList) { //11. basamagı dogrular
		
		return (integerList.subList(0, 10).stream().mapToInt(i -> i).sum()) % 10;
	}
	
	private static <T, U> List<U> convertList(List<T> from, Function<T, U> func) {
	    return from.stream().map(func).collect(Collectors.toList());
	}
	
	public boolean tcValidate(String tcNo) { // tc integer deger kontrolü
		
		List<String> tcNoStringList = Arrays.asList(tcNo.split(""));
		
		for (String string : tcNoStringList) {
			
			try {
				Integer.parseInt(string);
			} catch (Exception e) {
				return false;
			}
		}
		
		return true;
		
	}

}
