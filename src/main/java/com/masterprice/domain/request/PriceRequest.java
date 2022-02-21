package com.masterprice.domain.request;

import lombok.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
public class PriceRequest {
    @NotEmpty
    @Size(max = 20)
    private String originCode;
    @NotEmpty
    @Size(max = 50)
    private String destinationCode;
    private double price;
    @NotEmpty
    @Size(max = 150)
    private String product;
}
