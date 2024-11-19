package org.example.i.member;

import org.example.i.Displayable;

import java.util.ArrayList;
import java.util.List;

public class MemberManager implements Displayable {
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

    @Override
    public void display() {
        displayMembers();
    }
}
