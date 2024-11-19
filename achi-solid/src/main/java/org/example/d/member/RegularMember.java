package org.example.d.member;

public class RegularMember implements Member {
    private String name;

    public RegularMember(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }
}
