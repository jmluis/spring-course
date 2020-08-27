package com.conygre.test.pets;

public class Address {
    String address1, address2;
    String city, state, zip;
    
    public Address(String address) {
        String[] args = address.split(",");
        for(int i = 0; i < args.length; i++) {
            switch(i) {
                case 0:
                    this.address1 = args[i];
                    break;
                case 1:
                    this.address2 = args[i];
                    break;
                case 2:
                    this.city = args[i];
                    break;
                case 3:
                    this.state = args[i];
                    break;
                case 4:
                    this.zip = args[i];
                    break;
            }
        }
    }

    public String getAddress1() {
        return address1;
    }

    public String getAddress2() {
        return address2;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getZip() {
        return zip;
    }

    public String toString() {
        return getAddress1() + ", " + getAddress2() + ", " + getCity() + ", " + getState() + ", " + getZip();
    }
}