package br.com.biopids.converter;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import br.com.biopids.interfaces.IConverterField;


public class GenericConverterField implements IConverterField{

	@Override
	public <T extends Object>T convertField(Class<T> classField, String value)
			throws Exception {
		Object object = null;
		if(classField == String.class){
			object = castString(value);
		}else if(classField == Date.class){
			object = castDate(value);
		}else{
			if(classField.isEnum()){
				object = castEnum(classField, value);
			}else if(classField.equals(Double.class)){
				object = castDouble(classField, value);
			}else {
				object = cast(classField, value);
			}
			
		}
		return (T)object;
	}
	
	private Object castString(String value) {
		return value.toUpperCase();
	}

	public static <T extends Object>T castDouble(Class<T> classField, String value) throws SecurityException, NoSuchMethodException, IllegalArgumentException, IllegalAccessException, InvocationTargetException, InstantiationException{
		value = value.replace(",", ".");
		return cast(classField, value);
	}
	public static <T extends Object>T castEnum(Class<T> classField, String value) throws SecurityException, NoSuchMethodException, IllegalArgumentException, IllegalAccessException, InvocationTargetException{
		T[] enums = classField.getEnumConstants();
		int i = 0;
		while(!enums[i].toString().equalsIgnoreCase(value)) i ++;
		return  enums[i];
	}
	
	public static <T extends Object>T cast( Class<T> classField,String value) throws IllegalArgumentException, InstantiationException, IllegalAccessException, InvocationTargetException, SecurityException, NoSuchMethodException{
		Constructor<T> constructor;
		constructor = classField.getConstructor(String.class);
		return constructor.newInstance(value);
	}
	
	public static Date castDate(String data) throws ParseException{
		Date date = null;
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		df.setLenient(false);
		date= df.parse(data);
		return date;
	}

	public String reconvertField(Object value) {
		String aux = "";
		if(value instanceof Date){
			aux = recastDate((Date)value);
		}else{
			aux = recast(value);
		}
		return aux;
	}
	
	public static String recastDate(Date date){
		DateFormat dt = new SimpleDateFormat("dd/MM/yyyy");
		return dt.format(date);
	}
	
	public static String recast(Object value){
		return value.toString();
	}

}
