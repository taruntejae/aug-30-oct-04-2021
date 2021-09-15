package com.jpmc.day07ormapp.repo;

import com.jpmc.day07ormapp.entity.Account;
import org.springframework.data.repository.CrudRepository;

public interface AccountRepository extends CrudRepository<Account, String> {
}
