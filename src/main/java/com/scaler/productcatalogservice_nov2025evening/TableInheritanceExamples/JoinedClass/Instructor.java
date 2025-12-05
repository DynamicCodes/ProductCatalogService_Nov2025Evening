package com.scaler.productcatalogservice_nov2025evening.TableInheritanceExamples.JoinedClass;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name="jc_instructor")
public class Instructor extends User{
    private String company;
}
