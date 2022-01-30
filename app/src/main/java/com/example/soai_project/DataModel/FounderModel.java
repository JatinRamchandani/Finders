package com.example.soai_project.DataModel;


import com.example.soai_project.Founderr1.CommonData;

public class FounderModel {


    CommonData commonData;
     private String ideaFounder,stageFounder,categoryFounder;
    private String purposeFounder, ideaDesFounder, websiteFounder;
    private String fundsReqFounder,retDisFounder;

    public FounderModel(CommonData commonData, String ideaFounder, String stageFounder, String categoryFounder, String purposeFounder, String ideaDesFounder, String websiteFounder, String fundsReqFounder, String retDisFounder) {
        this.commonData = commonData;
        this.ideaFounder = ideaFounder;
        this.stageFounder = stageFounder;
        this.categoryFounder = categoryFounder;
        this.purposeFounder = purposeFounder;
        this.ideaDesFounder = ideaDesFounder;
        this.websiteFounder = websiteFounder;
        this.fundsReqFounder = fundsReqFounder;
        this.retDisFounder = retDisFounder;
    }

    //    private String categoryFunder, stageFunder;
//    private String summaryFunder, websiteFunder;
//    private String payableAmtFunder, returnNetInvFunder;


//    public DataModel(String idea_Founder, String stage_Founder, String category_Founder){
//        ideaFounder=idea_Founder;
//        stageFounder=stage_Founder;
//        categoryFounder=category_Founder;
//    }
//
//    public void common2Data(String qualification_Common,String workEx_Common, String linkedin_Common){
//        qualificatioNCommon=qualification_Common;
//        workExCommon=workEx_Common;
//        linkedinCommon=linkedin_Common;
//    }
//
//        public void founder1Data(String idea_Founder, String stage_Founder, String category_Founder){
//            ideaFounder=idea_Founder;
//            stageFounder=stage_Founder;
//            categoryFounder=category_Founder;
//        }
//
//        public void founder2Data(String purpose_Founder, String ideaDes_Founder, String website_Founder){
//            purposeFounder=purpose_Founder;
//            ideaDesFounder=ideaDes_Founder;
//            websiteFounder=website_Founder;
//        }
//
//        public void founder3Data(String fundsReq_Founder, String retDis_Founder){
//            fundsReqFounder=fundsReq_Founder;
//            retDisFounder=retDis_Founder;
//        }
//
//        public void funder1Data(String category_Funder, String stage_Funder){
//            categoryFunder=category_Funder;
//            stageFunder=stage_Funder;
//        }
//
//        public void funder2Data(String summary_Funder, String website_Funder){
//            summaryFunder=summary_Funder;
//            websiteFunder=website_Funder;
//        }
//
//        public void funder3Data(String payabbleAmt_Funder, String returnNetInv_Funder){
//            payableAmtFunder=payabbleAmt_Funder;
//            returnNetInvFunder=returnNetInv_Funder;
//        }


//  public void getCommonData(){
//      fNameCommon=commonData.getFirst_Name();
//      lNameCommon=commonData.getLast_Name();
//      cityCommon=commonData.getCity();
//      dobCommon=commonData.getDate_Of_Birth();
//      passwordCommon=commonData.getPassword();
//      emailCommon=commonData.getEmail();
//      qualificatioNCommon=commonData.getQualificatioNCommon();
//      workExCommon=commonData.getWorkExCommon();
//      linkedinCommon=commonData.getLinkedinCommon();
//  }


    public String getIdeaFounder() {
        return ideaFounder;
    }

    public void setIdeaFounder(String ideaFounder) {
        this.ideaFounder = ideaFounder;
    }

    public String getStageFounder() {
        return stageFounder;
    }

    public void setStageFounder(String stageFounder) {
        this.stageFounder = stageFounder;
    }

    public String getCategoryFounder() {
        return categoryFounder;
    }

    public void setCategoryFounder(String categoryFounder) {
        this.categoryFounder = categoryFounder;
    }

    public String getPurposeFounder() {
        return purposeFounder;
    }

    public void setPurposeFounder(String purposeFounder) {
        this.purposeFounder = purposeFounder;
    }

    public String getIdeaDesFounder() {
        return ideaDesFounder;
    }

    public void setIdeaDesFounder(String ideaDesFounder) {
        this.ideaDesFounder = ideaDesFounder;
    }

    public String getWebsiteFounder() {
        return websiteFounder;
    }

    public void setWebsiteFounder(String websiteFounder) {
        this.websiteFounder = websiteFounder;
    }

    public String getFundsReqFounder() {
        return fundsReqFounder;
    }

    public void setFundsReqFounder(String fundsReqFounder) {
        this.fundsReqFounder = fundsReqFounder;
    }

    public String getRetDisFounder() {
        return retDisFounder;
    }

    public void setRetDisFounder(String retDisFounder) {
        this.retDisFounder = retDisFounder;
    }


    public CommonData getCommonData() {
        return commonData;
    }

    public void setCommonData(CommonData commonData) {
        this.commonData = commonData;
    }
}

