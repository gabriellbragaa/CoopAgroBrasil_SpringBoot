package com.example.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.spring.agro.Agro;
import com.example.spring.agro.AgroRepository;
import com.example.spring.agro.AgroRequestDTO;
import com.example.spring.agro.AgroResponseDTO;


@RestController
@RequestMapping("/agrotech")

public class AgroTechController {

	@Autowired
	private AgroRepository agroRepository;

	
	@PostMapping("path")
	public void SaveAgro(@RequestBody AgroRequestDTO data) {
		Agro agroData = new Agro(data);
		agroRepository.save(agroData);
		return;
	}


	@GetMapping("/")
	public List<AgroResponseDTO> getAll() {

		
		List<Agro> agroList = agroRepository.findAll();
		List<AgroResponseDTO> agroResponseList = agroList.stream()
				.map(agro -> new AgroResponseDTO(agro.getId(), agro.getTitle(), agro.getImage(), agro.getPrice()))
				.toList();	

		return agroResponseList;
	}

}