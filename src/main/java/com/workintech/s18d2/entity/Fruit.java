package com.workintech.s18d2.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name="fruit", schema="fsweb")
public class Fruit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Min(value = 0, message = "Id cannot be less than 0")
    private Long id;

    @NotNull(message = "boş değer olamaz")
    @NotBlank(message = "Name cannot be blank")
    @Column(name="name")
    private String name;

    @NotNull(message = "boş değer olamaz")
    @Column(name="price")
    private double price;

    @NotNull(message = "boş değer olamaz")
    @Enumerated(EnumType.STRING)
    private FruitType fruitType;

}
