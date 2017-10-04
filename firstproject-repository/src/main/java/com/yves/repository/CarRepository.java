package com.yves.repository;

import static org.hibernate.jpa.QueryHints.HINT_FETCH_SIZE;

import java.util.List;
import java.util.stream.Stream;

import javax.persistence.QueryHint;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;

import com.yves.model.Car;

@Component
public interface CarRepository extends AbstractRepository<Car, Long> {

	/*
	 * https://github.com/spring-projects/spring-data-examples/blob/34fe9d2720e9402db7708b9101011266d9e00d5a/jpa/example/src/main/java/example/springdata/jpa/simple/SimpleUserRepository.java
	 * 
	 */
	
    List<Car> findAllByOrderByPlate(Pageable pageable);
    
    @Query("select distinct c.type from Car as c")
    List<String> findAllUsedTypes();
    
    long count(Specification<Car> spec);
    List<Car> findAll(Specification<Car> spec);
    Car findOne(Specification<Car> spec);
    
    
    /*
     *  http://knes1.github.io/blog/2015/2015-10-19-streaming-mysql-results-using-java8-streams-and-spring-data.html
     *  
     *  /!\ Pb quand  l'entite a une relation vers une autre entite....
     *  Caused by: java.sql.SQLException: Streaming result set com.mysql.jdbc.RowDataDynamic@35edafe1 is still active. No statements may be issued when any streaming result sets are open and in use on a given connection. Ensure that you have called .close() on any active streaming result sets before attempting more queries.
     *  
     */
    @QueryHints(value = @QueryHint(name = HINT_FETCH_SIZE, value = "" + Integer.MIN_VALUE))
	@Query(value = "select t from Car t")
	Stream<Car> streamAll();
    
    /*
     * Page vs Slice
     */
    Slice<Car> findAllOrderByPlate(Specification<Car> spec, Pageable pageable);
//    Page<Car> findAllOrderByPlate(String plate, Pageable pageable);
    
    
    @Query("Select c from Car c Join c.drivers d Where d.id = :id")
	List<Car> findById(@Param("id") Long id);
}
