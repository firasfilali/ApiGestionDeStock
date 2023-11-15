package com.filali.gestiodestock.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "category")
public class Category extends AbstarctEntity {
    @Column(name = "code")
    private String code;
    @Column(name = "designation")
    private String designation;
    @OneToMany(mappedBy = "category")
    private List<Article> articles;
}
