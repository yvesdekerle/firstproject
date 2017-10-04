package com.yves.repository.specifications;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.domain.Specifications;
import org.springframework.stereotype.Service;

import com.yves.model.Car_;
import com.yves.model.Car; 


@Service
public class CarSpecificationsFactory extends SpecificationFactory<Car>{
	
	public Specification<Car> titleOrDescriptionContainsIgnoreCase(String searchTerm) {
        return (root, query, cb) -> {
            String containsLikePattern = getContainsLikePattern(searchTerm);
            return cb.or(
                    cb.like(cb.lower(root.get(Car_.plate.getName())), containsLikePattern),
                    cb.like(cb.lower(root.get(Car_.type.getName())), containsLikePattern)
            );
        };
    }
	
	public Specification<Car> titleOrDescriptionContainsIgnoreCaseBis(String searchTerm){
		String containsLikePattern = getContainsLikePattern(searchTerm);
        return Specifications.where(containsLike(Car_.plate.getName(), containsLikePattern)).and(containsLike(Car_.type.getName(), containsLikePattern));
	}
	
	private CarSpecificationsFactory() {}

}
