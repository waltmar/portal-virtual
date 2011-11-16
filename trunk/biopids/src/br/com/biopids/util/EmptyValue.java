package br.com.biopids.util;

import java.util.Date;

public class EmptyValue {
	
	public static boolean isEmpty(Object value){
		boolean aux = true;
		if(value instanceof String){
			aux = isEmptyString(value.toString());
		}else if(value instanceof Double){
				aux = isEmptyDouble((Double)value);
			}else if(value instanceof Integer){
				aux = isEmptyInteger((Integer)value);
			}else if(value instanceof Date){
				aux = isEmptyDate((Date) value);
			}else aux = value == null;
		return aux;
	}
	private static boolean isEmptyString(String value){
		return value.equalsIgnoreCase("");
	}
	private static boolean isEmptyDouble(Double value){
		return value == 0.0;
	}
	private static boolean isEmptyInteger(Integer value){
		return value == 0;
	}
	private static boolean isEmptyDate(Date date){
		return date == null;
	}
	
}
