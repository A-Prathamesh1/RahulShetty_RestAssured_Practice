package RahulShettyRestAssured.OauthAndDeserialization;

import java.util.List;

public class Courses {
    private List<WebAutomationItem> webAutomation;
    private List<ApiItem> api;
    private List<MobileItem> mobile;

    public List<WebAutomationItem> getWebAutomation() {
        return webAutomation;
    }

    public void setWebAutomation(List<WebAutomationItem> webAutomation) {
        this.webAutomation = webAutomation;
    }

    public List<ApiItem> getApi() {
        return api;
    }

    public void setApi(List<ApiItem> api) {
        this.api = api;
    }

    public List<MobileItem> getMobile() {
        return mobile;
    }

    public void setMobile(List<MobileItem> mobile) {
        this.mobile = mobile;
    }
}
