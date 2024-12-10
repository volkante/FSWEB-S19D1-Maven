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
@Table(name="vegetable",schema = "fsweb")
public class Vegetable {

    @Id
    @Min(value = 0, message = "Id cannot be less than 0")
    @NotNull
    private Long id;

    @NotNull(message = "Name cannot be null")
    @NotBlank(message = "Name cannot be blank")
    @Column(name = "name")
    private String name;

    @NotNull(message = "Price cannot be null")
    @Column(name= "price")
    private double price;

    @Column(name="isGrownOnTree")
    private boolean isGrownOnTree;

}
