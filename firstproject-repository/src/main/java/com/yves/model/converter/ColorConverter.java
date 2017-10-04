package com.yves.model.converter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import org.apache.commons.lang3.StringUtils;

import com.yves.model.field.CarColor;

@Converter
public class ColorConverter implements AttributeConverter<CarColor, String> {

	private static final String SEPARATOR = "|";
	private static final String SEPARATOR_PROTECTED = "\\" + SEPARATOR;

	/**
	 * Convert Color object to a String 
	 * with format red|green|blue|alpha
	 */
	@Override
	public String convertToDatabaseColumn(CarColor color) {
		StringBuilder sb = new StringBuilder();
		sb.append(color.getColor1()).append(SEPARATOR).append(color.getColor2());
		return sb.toString();
	}

	/**
	 * Convert a String with format red|green|blue|alpha
	 * to a Color object
	 */
	@Override
	public CarColor convertToEntityAttribute(String colorString) {
		if(StringUtils.isNotBlank(colorString)){
			String[] rgb = colorString.split(SEPARATOR_PROTECTED);
			if(rgb!=null && rgb.length>1){
				return new CarColor(rgb[0],rgb[1]);
			}
		}
		return new CarColor();
	}

}
