package com.inmost.pro.testtask.controllers;

import com.inmost.pro.testtask.beans.Feedback;
import javax.faces.application.FacesMessage;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

@Named
@SessionScoped
public class FeedBackController {
    public void process(Feedback feedback) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info",
                feedback.getFirstName() + " " + feedback.getLastName() + " we will contact you within a hour."
        ));
    }
}
