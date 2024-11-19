package org.example.s;

import java.util.ArrayList;
import java.util.List;

class MemberManager {
    private List<String> members = new ArrayList<>();

    public void addMember(String member) {
        members.add(member);
    }

    public List<String> getMembers() {
        return members;
    }

    public void displayMembers() {
        System.out.println("Members: " + members);
    }
}
