package com.jidi.standard.entity;

import javax.persistence.*;

@Table(name = "index_detail")
public class IndexDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "department_id")
    private Integer departmentId;

    @Column(name = "index_name")
    private String indexName;

    @Column(name = "increase_name")
    private String increaseName;

    @Column(name = "increase_point")
    private Double increasePoint;

    @Column(name = "increase_unit")
    private String increaseUnit;

    @Column(name = "decrease_name")
    private String decreaseName;

    @Column(name = "decrease_point")
    private Double decreasePoint;

    @Column(name = "decrease_unit")
    private String decreaseUnit;

    private Integer level;

    @Column(name = "father_id")
    private Integer fatherId;

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

    public Double getIncreasePoint() {
        return increasePoint;
    }

    public void setIncreasePoint(Double increasePoint) {
        this.increasePoint = increasePoint;
    }

    public Double getDecreasePoint() {
        return decreasePoint;
    }

    public void setDecreasePoint(Double decreasePoint) {
        this.decreasePoint = decreasePoint;
    }
}