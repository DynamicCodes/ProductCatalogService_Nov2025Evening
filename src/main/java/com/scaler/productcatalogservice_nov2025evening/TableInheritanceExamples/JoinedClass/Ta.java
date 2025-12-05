package com.scaler.productcatalogservice_nov2025evening.TableInheritanceExamples.JoinedClass;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name="jc_ta")
@PrimaryKeyJoinColumn(name = "user_id_")
public class Ta extends User{
    private Integer helpRequests;
}
