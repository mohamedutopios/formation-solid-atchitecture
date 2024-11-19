package org.example.l;

class PremiumMember implements Member {
    private String name;

    public PremiumMember(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }
}
