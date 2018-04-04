package com.jidi.standard.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "index_statics")
public class IndexStatics {
    @Id
    private Integer ids;

    @Column(name = "person_id")
    private Integer personId;

    @Column(name = "department_id")
    private Integer departmentId;

    private Integer score;

    /**
     * @return ids
     */
    public Integer getIds() {
        return ids;
    }

    /**
     * @param ids
     */
    public void setIds(Integer ids) {
        this.ids = ids;
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
     * @return score
     */
    public Integer getScore() {
        return score;
    }

    /**
     * @param score
     */
    public void setScore(Integer score) {
        this.score = score;
    }
}