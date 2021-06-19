package com.example.servicesaroundme.ServiceCatalogue;

public class serviceCatalogueHelper {
    public String serviceParentId;
    public String serviceId, serviceTitle, serviceDesc;
    public String serviceModeId, serviceTypeId, serviceCommissionCategoryId;

    public serviceCatalogueHelper() {
    }

    public serviceCatalogueHelper(String serviceParentId, String serviceId, String serviceTitle, String serviceDesc, String serviceModeId, String serviceTypeId, String serviceCommissionCategoryId) {
        this.serviceParentId = serviceParentId;
        this.serviceId = serviceId;
        this.serviceTitle = serviceTitle;
        this.serviceDesc = serviceDesc;
        this.serviceModeId = serviceModeId;
        this.serviceTypeId = serviceTypeId;
        this.serviceCommissionCategoryId = serviceCommissionCategoryId;
    }

    public String getServiceParentId() {
        return serviceParentId;
    }

    public void setServiceParentId(String serviceParentId) {
        this.serviceParentId = serviceParentId;
    }

    public String getServiceId() {
        return serviceId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }

    public String getServiceTitle() {
        return serviceTitle;
    }

    public void setServiceTitle(String serviceTitle) {
        this.serviceTitle = serviceTitle;
    }

    public String getServiceDesc() {
        return serviceDesc;
    }

    public void setServiceDesc(String serviceDesc) {
        this.serviceDesc = serviceDesc;
    }

    public String getServiceModeId() {
        return serviceModeId;
    }

    public void setServiceModeId(String serviceModeId) {
        this.serviceModeId = serviceModeId;
    }

    public String getServiceTypeId() {
        return serviceTypeId;
    }

    public void setServiceTypeId(String serviceTypeId) {
        this.serviceTypeId = serviceTypeId;
    }

    public String getServiceCommissionCategoryId() {
        return serviceCommissionCategoryId;
    }

    public void setServiceCommissionCategoryId(String serviceCommissionCategoryId) {
        this.serviceCommissionCategoryId = serviceCommissionCategoryId;
    }
}
