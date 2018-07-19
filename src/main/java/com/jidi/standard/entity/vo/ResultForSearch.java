package com.jidi.standard.entity.vo;

import com.jidi.standard.entity.LeaderComment;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Table(name = "standard_result")
public class ResultForSearch {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "person_id")
    private Integer personId;

    @Column(name = "username")
    private String username;

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


    @Column(name = "increase_num")
    private Integer increaseNum;

    @Column(name = "increase_point")
    private Integer increasePoint;

    @Column(name = "increase_unit")
    private String increaseUnit;

    @Column(name = "increase_detail")
    private String increaseDetail;

    @Column(name = "decrease_name")
    private String decreaseName;

    @Column(name = "decrease_num")
    private Integer decreaseNum;

    @Column(name = "decrease_point")
    private Integer decreasePoint;

    @Column(name = "decrease_unit")
    private String decreaseUnit;

    @Column(name = "decrease_detail")
    private String decreaseDetail;

    @Column(name = "total_point")
    private Integer totalPoint;

    @Column(name = "leadercomment")
    private List<LeaderComment> leadercomment;

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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public Integer getIncreaseNum() {
        return increaseNum;
    }

    public void setIncreaseNum(Integer increaseNum) {
        this.increaseNum = increaseNum;
    }

    public Integer getIncreasePoint() {
        return increasePoint;
    }

    public void setIncreasePoint(Integer increasePoint) {
        this.increasePoint = increasePoint;
    }

    public String getIncreaseUnit() {
        return increaseUnit;
    }

    public void setIncreaseUnit(String increaseUnit) {
        this.increaseUnit = increaseUnit;
    }

    public String getIncreaseDetail() {
        return increaseDetail;
    }

    public void setIncreaseDetail(String increaseDetail) {
        this.increaseDetail = increaseDetail;
    }

    public String getDecreaseName() {
        return decreaseName;
    }

    public void setDecreaseName(String decreaseName) {
        this.decreaseName = decreaseName;
    }

    public Integer getDecreaseNum() {
        return decreaseNum;
    }

    public void setDecreaseNum(Integer decreaseNum) {
        this.decreaseNum = decreaseNum;
    }

    public Integer getDecreasePoint() {
        return decreasePoint;
    }

    public void setDecreasePoint(Integer decreasePoint) {
        this.decreasePoint = decreasePoint;
    }

    public String getDecreaseUnit() {
        return decreaseUnit;
    }

    public void setDecreaseUnit(String decreaseUnit) {
        this.decreaseUnit = decreaseUnit;
    }

    public String getDecreaseDetail() {
        return decreaseDetail;
    }

    public void setDecreaseDetail(String decreaseDetail) {
        this.decreaseDetail = decreaseDetail;
    }

    public List<LeaderComment> getLeadercomment() {
        return leadercomment;
    }

    public void setLeadercomment(List<LeaderComment> leadercomment) {
        this.leadercomment = leadercomment;
    }

    public Integer getTotalPoint() {
        return totalPoint;
    }

    public void setTotalPoint(Integer totalPoint) {
        this.totalPoint = totalPoint;
    }
}