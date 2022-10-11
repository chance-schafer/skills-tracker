package org.launchcode.skillstracker.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@ResponseBody
@RequestMapping("hello")
public class SkillsController {

    @GetMapping
    public String Hello() {
        return "<html>" +
                "<body>" +
                "<h1>Skills Tracker!" +
                "</h1>" +
                "<h2>We have a few skills we would like to learn. Here is the list!" +
                "</h2>" +
                "<ol>" +
                "<li>Javascript" +
                "</li>" +
                "<li>Typescript" +
                "</li>" +
                "<li>Java" +
                "</li>" +
                "</ol>" +
                "</body>" +
                "</html>";
    }

    @RequestMapping(value= "hello", method = {RequestMethod.POST, RequestMethod.GET})
    public String helloPost(@RequestParam String name, @RequestParam String languageOne, @RequestParam String languageTwo, @RequestParam String languageThree) {
        if(name == "") {
            name = "Coder";
        }

        return createMessage(name, languageOne, languageTwo, languageThree);
    }

    @GetMapping("form")
    public String languageForm() {
        return "<html>" +
                "<body>" +
                "<h1>Choose Languages: " +
                "<br>" +
                "<form action='hello' method='post'>" + // submit a request to /hello
                "<label name='name' value = 'name'>Name:</label>" +
                "<input type='text' name='name'>" +
                "<br>" +
                "<label name='language' value='language'>Language Selection:</label>" +
                "<br>" +
                "<select name='languageOne'>" +
                "<br>" +
                "<option value='' selected>--Choose Language--" +
                "</option>" +
                "<option value='java' default>Java" +
                "</option>" +
                "<option value='javascript'>Javascript" +
                "</option>" +
                "<option value='typescript'>Typescript" +
                "</option>" +
                "</select>" +
                "<br>" +
                "<select name='languageTwo'>" +
                "<option value='' selected>--Choose Language--" +
                "</option>" +
                "<option value='java' default>Java" +
                "</option>" +
                "<option value='javascript'>Javascript" +
                "</option>" +
                "<option value='typescript'>Typescript" +
                "</option>" +
                "</select>" +
                "<br>" +
                "<select name='languageThree'>" +
                "<option value='' selected>--Choose Language--" +
                "</option>" +
                "<option value='java' default>Java" +
                "</option>" +
                "<option value='javascript'>Javascript" +
                "</option>" +
                "<option value='typescript'>Typescript" +
                "</option>" +
                "</select>" +
                "<br>" +
                "<input type='submit' value='Select!'>" +
                "</form>" +
                "</body>" +
                "</html>";
    }

    public static String createMessage(String name, String lOne, String lTwo, String lThree) {
        return "<html>" +
                "<body>" +
                "<h1>Skills " + name + " Selected" +
                "</h1>" +
                "<h2>Here are the skills selected:" +
                "</h2>" +
                "<ol>" +
                "<li>" + lOne.toUpperCase() +
                "</li>" +
                "<li>" + lTwo.toUpperCase() +
                "</li>" +
                "<li>" + lThree.toUpperCase() +
                "</li>" +
                "</ol>" +
                "</body>" +
                "</html>";
    }
}
