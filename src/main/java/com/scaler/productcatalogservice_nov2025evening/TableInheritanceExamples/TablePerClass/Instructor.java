package com.scaler.productcatalogservice_nov2025evening.TableInheritanceExamples.TablePerClass;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name="tpc_instructor")
public class Instructor extends User {
    private String company;
}
