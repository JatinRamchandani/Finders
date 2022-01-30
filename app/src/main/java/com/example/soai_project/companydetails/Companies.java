
package com.example.soai_project.companydetails;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Companies {

    @SerializedName("companydetails")
    @Expose
    private List<Companydetail> companydetails = null;

    public List<Companydetail> getCompanydetails() {
        return companydetails;
    }

    public void setCompanydetails(List<Companydetail> companydetails) {
        this.companydetails = companydetails;
    }

}
