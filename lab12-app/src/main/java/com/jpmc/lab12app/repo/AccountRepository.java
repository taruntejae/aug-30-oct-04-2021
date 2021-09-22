package com.jpmc.lab12app.repo;

import com.jpmc.lab12app.entity.Account;
import org.springframework.data.repository.CrudRepository;

public interface AccountRepository extends CrudRepository<Account, String> {
}
