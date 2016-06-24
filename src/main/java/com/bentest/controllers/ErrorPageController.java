/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bentest.controllers;

import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author ben.schellenberger
 */
@RestController
@RequestMapping( "/error" )
public class ErrorPageController implements ErrorController {

    public static final String PATH = "/error";

    @RequestMapping( value = PATH, method = RequestMethod.GET )
    public String errorPage() {
        return "YOU BROKE IT. NOW BUY IT!";

    }

    @RequestMapping( value = "/", method = RequestMethod.GET )

    @Override
    public String getErrorPath() {
        return PATH;
    }
}
