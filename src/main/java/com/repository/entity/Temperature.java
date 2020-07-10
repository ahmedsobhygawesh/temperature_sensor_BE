package com.repository.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.time.LocalDateTime;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "temperature")
public class Temperature {

    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "ID", updatable = false, nullable = false)
    @Id
    private Long id;

    @Column(name = "DEGREE")
    private short degree;

    @Column(name = "RECEIVED_DATE")
    private LocalDateTime receivedDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "DEVICE_ID")
    private Device device;

}
