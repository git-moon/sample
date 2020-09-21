package com.example.sample.domain.main.member;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Table(name = "member")
@Entity
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idx;

    @Column(name = "mid")
    private String mid;
    @Column(name = "mpw")
    private String mpw;
    @Column(name = "mname")
    private String mname;

    @Column(name = "created_time")
    private LocalDateTime createdTime;
    @Column(name = "updated_time")
    private LocalDateTime updatedTime;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_idx")
    private List<MemberRole> memberRoles;
}
