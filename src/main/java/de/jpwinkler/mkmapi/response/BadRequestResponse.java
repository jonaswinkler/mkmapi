package de.jpwinkler.mkmapi.response;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "response")
public class BadRequestResponse {
    private String mkmErrorDescription;
    private String internalErrorCode;
    private String postDataField;
    private int httpStatusCode;
    private String httpStatusCodeDescription;
    private String rfc2616DescriptionLink;

    @XmlElement(name = "mkm_error_description")
    public String getMkmErrorDescription() {
        return mkmErrorDescription;
    }

    public void setMkmErrorDescription(String mkmErrorDescription) {
        this.mkmErrorDescription = mkmErrorDescription;
    }

    @XmlElement(name = "internal_error_code")
    public String getInternalErrorCode() {
        return internalErrorCode;
    }

    public void setInternalErrorCode(String internalErrorCode) {
        this.internalErrorCode = internalErrorCode;
    }

    @XmlElement(name = "post_data_field")
    public String getPostDataField() {
        return postDataField;
    }

    public void setPostDataField(String postDataField) {
        this.postDataField = postDataField;
    }

    @XmlElement(name = "http_status_code")
    public int getHttpStatusCode() {
        return httpStatusCode;
    }

    public void setHttpStatusCode(int httpStatusCode) {
        this.httpStatusCode = httpStatusCode;
    }

    @XmlElement(name = "http_status_code_description")
    public String getHttpStatusCodeDescription() {
        return httpStatusCodeDescription;
    }

    public void setHttpStatusCodeDescription(String httpStatusCodeDescription) {
        this.httpStatusCodeDescription = httpStatusCodeDescription;
    }

    @XmlElement(name = "rfc2616_description_link")
    public String getRfc2616DescriptionLink() {
        return rfc2616DescriptionLink;
    }

    public void setRfc2616DescriptionLink(String rfc2616DescriptionLink) {
        this.rfc2616DescriptionLink = rfc2616DescriptionLink;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(httpStatusCode);
        sb.append(" ");
        sb.append(httpStatusCodeDescription);
        sb.append(": ");
        sb.append(mkmErrorDescription);
        if (internalErrorCode != null && !internalErrorCode.isEmpty()) {
            sb.append(" (Internal Error Code: ");
            sb.append(internalErrorCode);
            sb.append(")");
        }
        return sb.toString();
    }
}
