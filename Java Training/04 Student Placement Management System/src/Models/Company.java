package Models;

public class Company {
    private int companyId;
    private String name;
    private String website;
    private String contactEmail;

    public Company() {
    }

    public Company(int companyId, String name, String website, String contactEmail) {
        this.companyId = companyId;
        this.name = name;
        this.website = website;
        this.contactEmail = contactEmail;
    }

    public Company(String name, String website, String contactEmail) {
        this.name = name;
        this.website = website;
        this.contactEmail = contactEmail;
    }

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }
}

