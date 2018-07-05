package javaNIO.companies;

public class Company {
    private String id;
    private String name;
    private String foundationDate;
    private int capital;
    private String country;
    private String headquarterId;

    public Company() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFoundationDate() {
        return foundationDate;
    }

    public void setFoundationDate(String foundationDate) {
        this.foundationDate = foundationDate;
    }

    public int getCapital() {
        return capital;
    }

    public void setCapital(int capital) {
        this.capital = capital;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getHeadquarterId() {
        return headquarterId;
    }

    public void setHeadquarterId(String headquarterId) {
        this.headquarterId = headquarterId;
    }

    @Override
    public String toString() {
        return "Company{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", foundationDate='" + foundationDate + '\'' +
                ", capital='" + capital + '\'' +
                ", country='" + country + '\'' +
                ", headquarterId='" + headquarterId + '\'' +
                '}';
    }


}
