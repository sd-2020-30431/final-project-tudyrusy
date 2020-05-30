package com.rustudor.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table
public class Plane implements Serializable {
    @Id
    @GeneratedValue
    @Column(nullable = false,updatable = false)
    private int id;
    @OneToOne
    private Engine engine;
    @OneToOne
    private Wings wings;
    @OneToOne
    private LandingGear landingGear;
    private int ok; //0=unchecked   1=ok 2=not ok

}
