package com.hit.seoyugi.repository;

import com.hit.seoyugi.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {

}
