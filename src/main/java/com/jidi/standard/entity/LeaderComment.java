package com.jidi.standard.entity;

import javax.persistence.*;
import java.util.Date;

@Table(name = "leader_comment")
public class LeaderComment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "stand_id")
    private Integer standId;

    @Column(name = "leader_id")
    private Integer leaderId;

    @Column(name = "comment_content")
    private String commentContent;

    @Column(name = "comment_time")
    private Date commentTime;

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
     * @return stand_id
     */
    public Integer getStandId() {
        return standId;
    }

    /**
     * @param standId
     */
    public void setStandId(Integer standId) {
        this.standId = standId;
    }

    /**
     * @return leader_id
     */
    public Integer getLeaderId() {
        return leaderId;
    }

    /**
     * @param leaderId
     */
    public void setLeaderId(Integer leaderId) {
        this.leaderId = leaderId;
    }

    /**
     * @return comment_content
     */
    public String getCommentContent() {
        return commentContent;
    }

    /**
     * @param commentContent
     */
    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent;
    }

    /**
     * @return comment_time
     */
    public Date getCommentTime() {
        return commentTime;
    }

    /**
     * @param commentTime
     */
    public void setCommentTime(Date commentTime) {
        this.commentTime = commentTime;
    }
}