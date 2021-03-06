package com.jpmc.day04;

import com.jpmc.day04.lab05.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Day04BootstrapAppApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(Day04BootstrapAppApplication.class, args);
//		for (String arg: args) {
//			System.out.println(arg);
//		}
//		personsDao.insert(987, "Dhoni", 40); //personsDao is not yet initialized
//		System.out.println("Done");
	}

	@Autowired
	private  PersonsDao personsDao;

	@Autowired
	private Person person;

	@Autowired
	private Company company;

	@Override
	public void run(String... args) throws Exception {
		System.out.println(company);
//		System.out.println(person.getName() + ", " + person.getAge());
//		System.out.println(person.getHobbies());
//		for (String arg: args) {
//			System.out.println(arg);
//		}
//		personsDao.insert(987, "Dhoni", 40);
//		System.out.println("Done");
	}
}
