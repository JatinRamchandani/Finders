
package com.example.soai_project.companydetails;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Companydetail {

    @SerializedName("company_name")
    @Expose
    private String companyName;
    @SerializedName("company_desc")
    @Expose
    private String companyDesc;
    @SerializedName("company_location")
    @Expose
    private String companyLocation;

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyDesc() {
        return companyDesc;
    }

    public void setCompanyDesc(String companyDesc) {
        this.companyDesc = companyDesc;
    }

    public String getCompanyLocation() {
        return companyLocation;
    }

    public void setCompanyLocation(String companyLocation) {
        this.companyLocation = companyLocation;
    }

}
