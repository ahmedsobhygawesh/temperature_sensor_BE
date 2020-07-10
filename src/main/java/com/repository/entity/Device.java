package com.repository.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "device")
public class Device {

    @Id
    @Column(name = "DEVICE_ID")
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "MODEL")
    private String model;

    @OneToMany(
            mappedBy = "device",
            cascade = CascadeType.REMOVE,
            orphanRemoval = true
    )
    private List<Temperature> temperatures = new ArrayList<>();

}
