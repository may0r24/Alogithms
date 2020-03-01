package spring.webflux.demo.service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import spring.webflux.demo.model.Employee;

public interface IEmployeeService {

	void create(Employee e);
	
	Mono<Employee> findById(Integer id);
	
	Flux<Employee> findByName(String name);
	
	Flux<Employee> findAll();
	
	Mono<Employee> update(Employee e);
	
	Mono<Void> delete(Integer id);
}
