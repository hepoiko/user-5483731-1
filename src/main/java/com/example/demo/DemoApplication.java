package com.example.demo;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class DemoApplication implements CommandLineRunner{

	@Autowired
	private AttributeRepository repo;
	@Autowired
	private ItemRepository itemRepo;

	private static final Logger logger = LoggerFactory.getLogger(DemoApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@PostMapping("/test")
	public Map<String, Object> request(@RequestBody Item item) {
		logger.info("{}", item);
		itemRepo.save(item);

		Iterable<Attribute> a = repo.findAll();
		logger.info("{}", a);
		Iterable<Item> b = itemRepo.findAll();
		logger.info("{}", b);
		return null;
	}

	@Override
	public void run(String... args) throws Exception
	{
		logger.info("Prepare DB");
		Attribute attribute = new Attribute();
		attribute.setId(6l);
		attribute.setName("init");
		repo.save(attribute);
	}

}
