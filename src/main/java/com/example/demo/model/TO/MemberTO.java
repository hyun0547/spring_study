package com.example.demo.model.TO;

import com.example.demo.model.entity.Member;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class MemberTO {

    private Integer id;

    private String name;

    private String account;

    private String password;

    private LocalDateTime lastAccessDt;

    private LocalDateTime regDt;

    private String role;

    public Member toEntity() {
        return new Member(id, name, account, password, role);
    }
}
 