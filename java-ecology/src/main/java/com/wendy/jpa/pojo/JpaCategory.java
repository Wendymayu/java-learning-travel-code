package com.wendy.jpa.pojo;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @Description TODO
 * @Author wendyma
 * @Date 2022/7/10 15:00
 * @Version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
@Entity
@Table(name = "ms_category")
public class JpaCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;

    private String avatar;

    @NotNull
    @Size(min = 5, message = "Name must be at least 2 characters long")
    private String categoryName;

    private String description;
}
