// (./agro/AgroResponseDTO.java)

package com.example.spring.agro;

public record AgroResponseDTO(Long id, String title, String image, Integer price ) {
    // transformar a Agrolist em map
    // criando o constritor
    public AgroResponseDTO(Agro agro){
        this(agro.getId(), agro.getTitle(), agro.getImage(), agro.getPrice());
    }
}

