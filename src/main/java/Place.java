public class Place {
    public String name;
    public String firstname;
    public String lastname;
    public String old;


    public Place(String name, String firstname, String lastname, String old) {
        this.name = name;
        this.firstname = firstname;
        this.lastname = lastname;
        this.old = old;
    }

    public Place() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getOld() {
        return old;
    }

    public void setOld(String old) {
        this.old = old;
    }

    @Override
    public String toString() {
        return name +"|" + firstname + "|" + lastname + "|" + old;
    }
}
