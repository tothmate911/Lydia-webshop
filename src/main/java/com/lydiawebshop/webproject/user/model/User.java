package com.lydiawebshop.webproject.user.model;

import com.lydiawebshop.webproject.product.model.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Map;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "webShopUser")
public class User {

    @Id
    @GeneratedValue
    private long id;

    private String firstName;
    private String lastName;
    private String email;

    @ElementCollection
    @MapKeyJoinColumn(name = "productId")
    @Column(name = "quantity")
    private Map<Product, Integer> cart;

}
