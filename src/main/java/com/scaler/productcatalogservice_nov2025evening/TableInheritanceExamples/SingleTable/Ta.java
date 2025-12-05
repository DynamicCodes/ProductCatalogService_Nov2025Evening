package com.scaler.productcatalogservice_nov2025evening.TableInheritanceExamples.SingleTable;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name="st_ta")
@DiscriminatorValue(value = "TA")
public class Ta extends User {
    private Integer helpRequests;
}
