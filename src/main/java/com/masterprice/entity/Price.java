package com.masterprice.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.redis.core.RedisHash;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "MASTER_PRICE")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Price implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    @Column(name = "ORIGIN_CODE")
    private String originCode;

    @Column(name = "DESTINATION_CODE")
    private String destinationCode;

    @Column(name = "PRICE")
    private double price;

    @Column(name = "PRODUCT")
    private String product;
}
