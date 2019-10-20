package com.spring.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

@Service
public class MailContentBuilder {

    private TemplateEngine templateEngine;

    @Autowired
    public MailContentBuilder(TemplateEngine templateEngine){

        this.templateEngine = templateEngine;
    }

    public String build(String user, String message, String mailTemplate){

        Context context = new Context();
        context.setVariable("name", user);
        context.setVariable("message", message);
        return this.templateEngine.process(mailTemplate, context);
    }
}
