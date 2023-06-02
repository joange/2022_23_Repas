package com.joange.service;

import java.util.List;

import com.joange.model.People;

public interface PeopleService {
	People savePeople(People people);
	People updatePeople(People people);
	People getPeopleById(Long id);
	List<People> listAllPeople();
	void deletePeople(Long id);
}
