package com.ssingh.h2db;

import com.ssingh.h2db.com.ssingh.h2db.springboot.daos.IndivisulaTyreRepository;
import com.ssingh.h2db.com.ssingh.h2db.springboot.daos.TyrePartRepository;
import com.ssingh.h2db.springboot.models.IndivisualTyre;
import com.ssingh.h2db.springboot.models.TyrePart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Fetch;
import javax.persistence.criteria.Root;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
@RestController
public class SpringBootPersistenceH2Application implements CommandLineRunner {

    @RequestMapping("v1/tyreDetail")
	public List<TyrePart>  tyreDetail(){
		CriteriaBuilder cb =em.getCriteriaBuilder();
		CriteriaQuery<TyrePart>  cq=cb.createQuery(TyrePart.class);
		Root<TyrePart>r=cq.from(TyrePart.class);
		Fetch<TyrePart,IndivisualTyre> f=r.fetch("indivisualTyre");
		cq=cq.select(r).distinct(true);
		TypedQuery<TyrePart> typeQuery =em.createQuery(cq);
		List<TyrePart> resultList = typeQuery.getResultList();
		resultList.forEach(System.err::println);
		return resultList;
	}

	@RequestMapping("v2/tyreDetail")
	public List<TyrePart>  tyreDetailV2(){

		return tyrePartRepository.findAll();
	}


	@Autowired
	private IndivisulaTyreRepository indivisulaTyreRepository;
	@Autowired
	private TyrePartRepository tyrePartRepository;

	@Autowired
	private EntityManager em;


	public static void main(String[] args) {
		SpringApplication.run(SpringBootPersistenceH2Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		saveData();
	}

	private void saveData() {
		TyrePart tyrePart1 = new TyrePart();
		tyrePart1.setDirectionalType(true);
		TyrePart tyrePart2 = new TyrePart();
		tyrePart2.setDirectionalType(false);
		IndivisualTyre indivisualTyre1 = new IndivisualTyre();
		indivisualTyre1.setProvidedForm("Ferrari");
		indivisualTyre1.setRfId("321454664");
		IndivisualTyre indivisualTyre2 = new IndivisualTyre();
		indivisualTyre2.setProvidedForm("Lamborgani");
		indivisualTyre2.setRfId("321454664");
		tyrePart1.getIndivisualTyre().add(indivisualTyre1);
		tyrePart1.getIndivisualTyre().add(indivisualTyre2);
		IndivisualTyre indivisualTyre3 = new IndivisualTyre();
		indivisualTyre3.setProvidedForm("Endevour");
		indivisualTyre3.setRfId("12345");
		IndivisualTyre indivisualTyre4 = new IndivisualTyre();
		indivisualTyre4.setProvidedForm("Fortuner");
		indivisualTyre4.setRfId("422222");
		tyrePart1.getIndivisualTyre().add(indivisualTyre1);
		tyrePart1.getIndivisualTyre().add(indivisualTyre2);
		tyrePart2.getIndivisualTyre().add(indivisualTyre3);
		tyrePart2.getIndivisualTyre().add(indivisualTyre4);
		tyrePartRepository.saveAll(Arrays.asList(tyrePart1,tyrePart2));
		System.err.println("Saved all the tyre part ");
	}
}
