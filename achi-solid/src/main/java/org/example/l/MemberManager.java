package org.example.l;

import java.util.ArrayList;
import java.util.List;

class MemberManager {
    private List<Member> members = new ArrayList<>();

    public void addMember(Member member) {
        members.add(member);
    }

    public List<Member> getMembers() {
        return members;
    }

    public void displayMembers() {
        members.forEach(member -> System.out.println("Member: " + member.getName()));
    }
}
