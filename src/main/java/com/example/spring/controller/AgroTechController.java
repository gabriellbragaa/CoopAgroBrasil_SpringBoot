package com.example.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

	
	@PostMapping("Administrativo/estado/cadastro")
	
		public String SaveProduct(@ModelAttribute AgroRequestDTO data) {
			Agro agroData = new Agro(data);
			agroRepository.save(agroData);
			System.out.println("Produto Cadastrado: " + agroData.getTitle());
			return "redirect:/Administrativo/estado?sucesso";
	}

	@GetMapping("/Administrativo")
	public String acessarPrincipal(@RequestParam String param) {
		return "Administrativo/home/cadastro";
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