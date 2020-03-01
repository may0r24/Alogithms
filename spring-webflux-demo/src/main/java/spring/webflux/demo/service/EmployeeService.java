package spring.webflux.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import spring.webflux.demo.dao.EmployeeRepository;
import spring.webflux.demo.model.Employee;

@Service
public class EmployeeService implements IEmployeeService{

	@Autowired
    EmployeeRepository employeeRepo;
	
	@Override
	public void create(Employee e) {
		employeeRepo.save(e).subscribe();
	}

	@Override
	public Mono<Employee> findById(Integer id) {
		return employeeRepo.findById(id);
	}

	@Override
	public Flux<Employee> findByName(String name) {
		return employeeRepo.findByName(name);
	}

	@Override
	public Flux<Employee> findAll() {
		return employeeRepo.findAll();
	}

	@Override
	public Mono<Employee> update(Employee e) {
		return employeeRepo.save(e);
	}

	@Override
	public Mono<Void> delete(Integer id) {
		return employeeRepo.deleteById(id);
	}
}
