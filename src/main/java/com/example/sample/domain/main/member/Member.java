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

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
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

    @Builder.Default
    @Column(name = "created_time")
    private LocalDateTime createdTime = LocalDateTime.now();
    @Builder.Default
    @Column(name = "updated_time")
    private LocalDateTime updatedTime = LocalDateTime.now();

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_idx")
    private List<MemberRole> memberRoles;
}
