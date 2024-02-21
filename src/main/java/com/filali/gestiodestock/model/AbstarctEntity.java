package com.filali.gestiodestock.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.io.Serializable;
import java.time.Instant;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class AbstarctEntity implements Serializable {

    @Id
    @GeneratedValue
    private Integer id;
    //@CreatedDate
    @Column(name = "creationDate")
    private Instant creationDate;

    //@LastModifiedDate
    @Column(name = "lastModifiedDate")
    private Instant lastUpdateDate;
    @PrePersist
    void prePersist(){
        creationDate = Instant.now();
    }
    @PreUpdate
    void preUpdate(){
        lastUpdateDate = Instant.now();
    }
}
