package com.yves.repository.specifications;

import org.apache.commons.lang3.StringUtils;
import org.springframework.data.jpa.domain.Specification;

public class SpecificationFactory<T> {
	
	public Specification<T> containsLike(String attribute, String value) {
		return (root, query, cb) -> cb.like(root.get(attribute), "%" + value + "%");
	}

	public Specification<T> isBetween(String attribute, int min, int max) {
		return (root, query, cb) -> cb.between(root.get(attribute), min, max);
	}

	public Specification<T> isBetween(String attribute, double min, double max) {
		return (root, query, cb) -> cb.between(root.get(attribute), min, max);
	}

//	public <T extends Enum<T>> Specification<T> enumMatcher(String attribute, T queriedValue) {
//		return (root, query, cb) -> {
//			Path<T> actualValue = root.get(attribute);
//
//			if (queriedValue == null) {
//				return null;
//			}
//
//			return cb.equal(actualValue, queriedValue);
//		};
//	}
	
	public String getContainsLikePattern(String searchTerm) {
    	return (StringUtils.isBlank(searchTerm)) ? "%" : "%" + searchTerm.toLowerCase() + "%"; 
    }
	
//	public static Specification extendedCarSearch(CarSearchQuery q) {
//	    return Specifications
//	            .where(containsLike("plate", q.getPlate()))
//	            .and(containsLike("type", q.getType())).and(enumMatcher("brand", q.getBrand()))
//	            .and(isBetween("usage", q.getUsage().getMin(), q.getUsage().getMax()))
//	            .and(isBetween("maxSpeed", q.getMaxSpeed().getMin(), q.getMaxSpeed().getMax()))
//	            .and(isBetween("horsePower", q.getHorsePower().getMin(), q.getHorsePower().getMax()))
//	            .and(enumMatcher("fuelKind", q.getFuelKind()));
//	}
//
//	public List extendedSearch(CarSearchQuery query) {
//	    return repository.findAll(CarSpecificationFactory.extendedCarSearch(query));
//	}
}
