package org.example.d.member;

import java.util.List;

public interface MemberRepository {
    void addMember(Member member);
    List<Member> getMembers();
}
