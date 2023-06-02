package com.joange.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.joange.model.People;
import com.joange.repository.PeopleRepository;

@Service
public class PeopleServiceImpl implements PeopleService{

	@Autowired
	PeopleRepository peopleRepository;
	
	@Override
	public People savePeople(People people) {
		People savedPeople=peopleRepository.save(people);
		return savedPeople;
	}

	@Override
	public People updatePeople(People people) {
		Optional<People> oldPeople=peopleRepository.findById(people.getIdPeople());
		if (oldPeople.isPresent()) {
			People p=oldPeople.get();
			p.setAge(people.getAge());
			p.setName(people.getName());
			People newPeople=peopleRepository.save(p);
			return newPeople;
		}
		else {
			return people;
		}

	}

	@Override
	public People getPeopleById(Long id) {
		Optional<People> people=peopleRepository.findById(id);
		if (people.isPresent())
			return people.get();
		else
			return null;
	}

	@Override
	public List<People> listAllPeople() {
		return peopleRepository.findAll();
	}

	@Override
	public void deletePeople(Long id) {
		peopleRepository.deleteById(id);
		
	}

	
}
