package com.example.spring.agro;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "Agro")
@Entity(name = "Agro")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode

public class Agro {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String image;
    private Integer price;  

    public Agro(AgroRequestDTO data) {
        this.id = null; // ID is auto-generated
        this.title = data.getTitle();
        this.image = data.getImage();
        this.price = data.getPrice();
    }
}
