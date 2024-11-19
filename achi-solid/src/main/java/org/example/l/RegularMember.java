package org.example.l;

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
