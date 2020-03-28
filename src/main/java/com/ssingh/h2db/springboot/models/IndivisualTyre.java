package com.ssingh.h2db.springboot.models;

import javax.persistence.*;

@Table(name = "indivisualTyre")
@Entity
public class IndivisualTyre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

//    @ManyToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "typrePartNo")
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "tyrePartNo", nullable = false)
//    private TyrePart tyrePart;

    private String rfId;

    private String providedForm;


    public IndivisualTyre() { }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

//    public TyrePart getTyrePart() {
//        return tyrePart;
//    }
//
//    public void setTyrePart(TyrePart tyrePart) {
//        this.tyrePart = tyrePart;
//    }

    public String getRfId() {
        return rfId;
    }

    public void setRfId(String rfId) {
        this.rfId = rfId;
    }

    public String getProvidedForm() {
        return providedForm;
    }

    public void setProvidedForm(String providedForm) {
        this.providedForm = providedForm;
    }

    @Override
    public String toString() {
        return "IndivisualTyre{" +
                "id=" + id +
               // ", tyrePart=" + tyrePart +
                ", rfId='" + rfId + '\'' +
                ", providedForm='" + providedForm + '\'' +
                '}';
    }
}