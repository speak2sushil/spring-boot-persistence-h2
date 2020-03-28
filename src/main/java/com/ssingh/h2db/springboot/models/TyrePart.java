package com.ssingh.h2db.springboot.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Table(name = "tyrePart")
@Entity
public class TyrePart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer tyrePartNo;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "tyrePartNo")
    private List<IndivisualTyre> indivisualTyre = new ArrayList<IndivisualTyre>(
            0);

    public List<IndivisualTyre> getIndivisualTyre() {
        return this.indivisualTyre;
    }

    public void setIndivisualTyre(List<IndivisualTyre> indivisualTyre) {
        this.indivisualTyre = indivisualTyre;
    }
//    @OneToMany(fetch = FetchType.LAZY, mappedBy = "tyrePart")
//    public List<IndivisualTyre> getIndivisualTyreList() {
//        return this.indivisualTyreList;
//    }
//
//    public void setIndivisualTyreList(List<IndivisualTyre> indivisualTyreList) {
//        this.indivisualTyreList = indivisualTyreList;
//    }

    private Boolean isDirectionalType;

    public TyrePart() {
    }

    public Boolean getDirectionalType() {
        return isDirectionalType;
    }

    public void setDirectionalType(Boolean directionalType) {
        isDirectionalType = directionalType;
    }
    @Column(name = "tyrePartNo", unique = true, nullable = false)
    public Integer getTyrePartNo() {
        return tyrePartNo;
    }

    public void setTyrePartNo(Integer tyrePartNo) {
        this.tyrePartNo = tyrePartNo;
    }




    @Override
    public String toString() {
        return "TyrePart{" +
                "tyrePartNo=" + tyrePartNo +
                ", indivisualTyre=" + indivisualTyre +
                ", isDirectionalType=" + isDirectionalType +
                '}';
    }
}