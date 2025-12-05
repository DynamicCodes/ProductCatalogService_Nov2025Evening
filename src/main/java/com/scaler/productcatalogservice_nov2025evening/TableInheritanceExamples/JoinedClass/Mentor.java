package com.scaler.productcatalogservice_nov2025evening.TableInheritanceExamples.JoinedClass;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name="js_mentor")
@PrimaryKeyJoinColumn(name = "user_id_")
public class Mentor extends User{
    private Double ratings;

}
