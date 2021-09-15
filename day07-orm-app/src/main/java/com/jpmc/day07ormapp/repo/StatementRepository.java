package com.jpmc.day07ormapp.repo;

import com.jpmc.day07ormapp.entity.Statement;
import org.springframework.data.repository.CrudRepository;

public interface StatementRepository extends CrudRepository<Statement, Integer> {
}
