package com.jidi.standard.entity;

import javax.persistence.*;
import java.util.Date;

@Table(name = "standard_result")
public class StandardResult {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "person_id")
    private Integer personId;

    @Column(name = "department_id")
    private Integer departmentId;

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

    private Integer level;

    @Column(name = "father_id")
    private Integer fatherId;

    @Column(name = "submit_time")
    private Date submitTime;

    private String location;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return person_id
     */
    public Integer getPersonId() {
        return personId;
    }

    /**
     * @param personId
     */
    public void setPersonId(Integer personId) {
        this.personId = personId;
    }

    /**
     * @return department_id
     */
    public Integer getDepartmentId() {
        return departmentId;
    }

    /**
     * @param departmentId
     */
    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    /**
     * @return standard_date
     */
    public Date getStandardDate() {
        return standardDate;
    }

    /**
     * @param standardDate
     */
    public void setStandardDate(Date standardDate) {
        this.standardDate = standardDate;
    }

    /**
     * @return index_name
     */
    public String getIndexName() {
        return indexName;
    }

    /**
     * @param indexName
     */
    public void setIndexName(String indexName) {
        this.indexName = indexName;
    }

    /**
     * @return increase_name
     */
    public String getIncreaseName() {
        return increaseName;
    }

    /**
     * @param increaseName
     */
    public void setIncreaseName(String increaseName) {
        this.increaseName = increaseName;
    }

    /**
     * @return increase_num
     */
    public Integer getIncreaseNum() {
        return increaseNum;
    }

    /**
     * @param increaseNum
     */
    public void setIncreaseNum(Integer increaseNum) {
        this.increaseNum = increaseNum;
    }

    /**
     * @return increase_point
     */
    public Integer getIncreasePoint() {
        return increasePoint;
    }

    /**
     * @param increasePoint
     */
    public void setIncreasePoint(Integer increasePoint) {
        this.increasePoint = increasePoint;
    }

    /**
     * @return increase_unit
     */
    public String getIncreaseUnit() {
        return increaseUnit;
    }

    /**
     * @param increaseUnit
     */
    public void setIncreaseUnit(String increaseUnit) {
        this.increaseUnit = increaseUnit;
    }

    /**
     * @return increase_detail
     */
    public String getIncreaseDetail() {
        return increaseDetail;
    }

    /**
     * @param increaseDetail
     */
    public void setIncreaseDetail(String increaseDetail) {
        this.increaseDetail = increaseDetail;
    }

    /**
     * @return decrease_name
     */
    public String getDecreaseName() {
        return decreaseName;
    }

    /**
     * @param decreaseName
     */
    public void setDecreaseName(String decreaseName) {
        this.decreaseName = decreaseName;
    }

    /**
     * @return decrease_num
     */
    public Integer getDecreaseNum() {
        return decreaseNum;
    }

    /**
     * @param decreaseNum
     */
    public void setDecreaseNum(Integer decreaseNum) {
        this.decreaseNum = decreaseNum;
    }

    /**
     * @return decrease_point
     */
    public Integer getDecreasePoint() {
        return decreasePoint;
    }

    /**
     * @param decreasePoint
     */
    public void setDecreasePoint(Integer decreasePoint) {
        this.decreasePoint = decreasePoint;
    }

    /**
     * @return decrease_unit
     */
    public String getDecreaseUnit() {
        return decreaseUnit;
    }

    /**
     * @param decreaseUnit
     */
    public void setDecreaseUnit(String decreaseUnit) {
        this.decreaseUnit = decreaseUnit;
    }

    /**
     * @return decrease_detail
     */
    public String getDecreaseDetail() {
        return decreaseDetail;
    }

    /**
     * @param decreaseDetail
     */
    public void setDecreaseDetail(String decreaseDetail) {
        this.decreaseDetail = decreaseDetail;
    }

    /**
     * @return total_point
     */
    public Integer getTotalPoint() {
        return totalPoint;
    }

    /**
     * @param totalPoint
     */
    public void setTotalPoint(Integer totalPoint) {
        this.totalPoint = totalPoint;
    }

    /**
     * @return level
     */
    public Integer getLevel() {
        return level;
    }

    /**
     * @param level
     */
    public void setLevel(Integer level) {
        this.level = level;
    }

    /**
     * @return father_id
     */
    public Integer getFatherId() {
        return fatherId;
    }

    /**
     * @param fatherId
     */
    public void setFatherId(Integer fatherId) {
        this.fatherId = fatherId;
    }

    /**
     * @return submit_time
     */
    public Date getSubmitTime() {
        return submitTime;
    }

    /**
     * @param submitTime
     */
    public void setSubmitTime(Date submitTime) {
        this.submitTime = submitTime;
    }

    /**
     * @return location
     */
    public String getLocation() {
        return location;
    }

    /**
     * @param location
     */
    public void setLocation(String location) {
        this.location = location;
    }
}