package com.filali.gestiodestock.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.*;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@Builder
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
