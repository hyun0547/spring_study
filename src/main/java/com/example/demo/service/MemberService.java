package com.example.demo.service;

import com.example.demo.model.TO.MemberTO;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface MemberService extends UserDetailsService {
    Integer save(MemberTO memberTO);
}