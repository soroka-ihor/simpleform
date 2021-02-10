package com.inmost.pro.testtask.validators;

import java.util.regex.Pattern;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import org.primefaces.validate.ClientValidator;
import javax.faces.component.UIInput;
import java.util.Map;


public class EmailValidator implements Validator, ClientValidator {

    private Pattern pattern;

    private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
            + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

    public EmailValidator() {
        pattern = Pattern.compile(EMAIL_PATTERN);
    }

    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        String email = value.toString();
        UIInput input = (UIInput) context.getViewRoot().findComponent("feedback-form:confirmemail");
        String confirmEmail = input.getSubmittedValue().toString();


        if(value == null) {
            return;
        }

        if (!email.equals(confirmEmail)) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Confirm error",
                    "Please confirm your email."));
        }
        if (!pattern.matcher(email).matches()) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error",
                    "Validation Error " + value + " is not a valid email"));
        }


    }

    public Map<String, Object> getMetadata() {
        return null;
    }

    public String getValidatorId() {
        return "emailValidator";
    }

}
