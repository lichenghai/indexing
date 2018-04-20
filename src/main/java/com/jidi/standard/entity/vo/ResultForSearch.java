package com.jidi.standard.entity.vo;

import javax.persistence.*;
import java.util.Date;

@Table(name = "standard_result")
public class ResultForSearch {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "person_id")
    private Integer personId;

    @Column(name = "person_name")
    private String personName;

    @Column(name = "department_id")
    private Integer departmentId;

    @Column(name = "department_name")
    private String departmentName;

    @Column(name = "standard_date")
    private Date standardDate;

    @Column(name = "index_name")
    private String indexName;

    @Column(name = "increase_name")
    private String increaseName;

    @Column(name = "total_point")
    private Integer totalPoint;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPersonId() {
        return personId;
    }

    public void setPersonId(Integer personId) {
        this.personId = personId;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public Date getStandardDate() {
        return standardDate;
    }

    public void setStandardDate(Date standardDate) {
        this.standardDate = standardDate;
    }

    public String getIndexName() {
        return indexName;
    }

    public void setIndexName(String indexName) {
        this.indexName = indexName;
    }

    public String getIncreaseName() {
        return increaseName;
    }

    public void setIncreaseName(String increaseName) {
        this.increaseName = increaseName;
    }

    public Integer getTotalPoint() {
        return totalPoint;
    }

    public void setTotalPoint(Integer totalPoint) {
        this.totalPoint = totalPoint;
    }
}