package com.example.soai_project.DataModel;

import com.example.soai_project.Founderr1.CommonData;

public class FunderModel {

    private String categoryFunder, stageFunder;
    private String summaryFunder, websiteFunder;
    private String payableAmtFunder, returnNetInvFunder;

    CommonData commonData;

    public FunderModel(String categoryFunder, String stageFunder, String summaryFunder, String websiteFunder, String payableAmtFunder, String returnNetInvFunder, CommonData commonData) {
        this.categoryFunder = categoryFunder;
        this.stageFunder = stageFunder;
        this.summaryFunder = summaryFunder;
        this.websiteFunder = websiteFunder;
        this.payableAmtFunder = payableAmtFunder;
        this.returnNetInvFunder = returnNetInvFunder;
        this.commonData = commonData;
    }

    public String getCategoryFunder() {
        return categoryFunder;
    }

    public void setCategoryFunder(String categoryFunder) {
        this.categoryFunder = categoryFunder;
    }

    public String getStageFunder() {
        return stageFunder;
    }

    public void setStageFunder(String stageFunder) {
        this.stageFunder = stageFunder;
    }

    public String getSummaryFunder() {
        return summaryFunder;
    }

    public void setSummaryFunder(String summaryFunder) {
        this.summaryFunder = summaryFunder;
    }

    public String getWebsiteFunder() {
        return websiteFunder;
    }

    public void setWebsiteFunder(String websiteFunder) {
        this.websiteFunder = websiteFunder;
    }

    public String getPayableAmtFunder() {
        return payableAmtFunder;
    }

    public void setPayableAmtFunder(String payableAmtFunder) {
        this.payableAmtFunder = payableAmtFunder;
    }

    public String getReturnNetInvFunder() {
        return returnNetInvFunder;
    }

    public void setReturnNetInvFunder(String returnNetInvFunder) {
        this.returnNetInvFunder = returnNetInvFunder;
    }

    public CommonData getCommonData() {
        return commonData;
    }

    public void setCommonData(CommonData commonData) {
        this.commonData = commonData;
    }
}
