package com.morse.code;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.net.URLDecoder;
import java.nio.charset.Charset;

@RestController
public class MorseCodeController {
    
    @GetMapping(path = "/morseToText/{text}")
    public String getTextFromMorse(@PathVariable String text){
        //Se usa como separador de palabras el pipe ("|") porque cuando se renderiza en html, los multiples espacios son ignorados y quedan todas las palabras juntas
        String decoded = URLDecoder.decode(text, Charset.forName("UTF-8"));
        return MorseCodeTranslator.translateFromMorseCode(decoded);
    }

    @GetMapping(path = "/textToMorse/{text}")
    public String getMorseFromText(@PathVariable String text){
        //Se usa como separador de palabras el pipe ("|") porque cuando se renderiza en html, los multiples espacios son ignorados y quedan todas las palabras juntas
        String decoded = URLDecoder.decode(text, Charset.forName("UTF-8"));
        String response = MorseCodeTranslator.translateFromText(decoded);
        return response.trim().replace("   ", "<br>");
    }

}
