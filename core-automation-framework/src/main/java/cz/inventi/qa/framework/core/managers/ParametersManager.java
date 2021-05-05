package cz.inventi.qa.framework.core.managers;

import cz.inventi.qa.framework.core.data.enums.ApplicationType;
import cz.inventi.qa.framework.core.objects.framework.AppInstance;
import cz.inventi.qa.framework.core.objects.parameters.ApiAppParameters;
import cz.inventi.qa.framework.core.objects.parameters.CommonParameters;
import cz.inventi.qa.framework.core.objects.parameters.TestSuiteParameters;
import cz.inventi.qa.framework.core.objects.parameters.WebAppParameters;
import cz.inventi.qa.framework.core.objects.api.Api;
import cz.inventi.qa.framework.core.objects.web.WebPage;

public class ParametersManager {
    private final TestSuiteParameters testSuiteParameters;
    private final AppInstance appInstance;
    private CommonParameters commonParameters;
    private ApiAppParameters<?> apiAppParameters;
    private WebAppParameters<?> webAppParameters;
    private ApplicationType applicationType;

    public ParametersManager(AppInstance appInstance) {
        this.appInstance = appInstance;
        testSuiteParameters = TestSuiteParameters.getInstance();
    }

    public <T extends Api> void setApiParameters(String environment, Class<T> api) {
        setCommonParameters(environment);
        apiAppParameters = new ApiAppParameters<>(environment, api);
        applicationType = ApplicationType.API;
    }

    public <T extends WebPage> void setWebParameters(String browser, String environment, String language, Class<T> startingWebpage) {
        setCommonParameters(environment, language);
        webAppParameters = new WebAppParameters<>(environment, browser, language, startingWebpage);
        applicationType = ApplicationType.WEB;
    }

    public void setCommonParameters(String environment, String language) {
        commonParameters = new CommonParameters(environment, language);
    }

    public void setCommonParameters(String environment) {
        commonParameters = new CommonParameters(environment,"EN");
    }

    @SuppressWarnings("unchecked")
    public <T extends Api> ApiAppParameters<T> getApiAppParameters() {
        return (ApiAppParameters<T>) apiAppParameters;
    }

    @SuppressWarnings("unchecked")
    public <T extends WebPage> WebAppParameters<T> getWebAppParameters() {
        return (WebAppParameters<T>) webAppParameters;
    }

    public TestSuiteParameters getTestSuiteParameters() {
        return testSuiteParameters;
    }

    public CommonParameters getCommonParameters() {
        return commonParameters;
    }

    public ApplicationType getApplicationType() {
        return applicationType;
    }

    public AppInstance getAppInstance() {
        return appInstance;
    }
}
