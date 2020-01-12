package com.sda.spring.core.autowired;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TextEditor {

    private SpellChecker spellChecker;

    // field injection
    @Autowired
    private TextFormatter textFormatter;

    private ImageConverter imageConverter;

    // constructor injection
    @Autowired
    public TextEditor(SpellChecker spellChecker) {
        this.spellChecker = spellChecker;
    }

    // setter injection
    @Autowired
    public void setImageConverter(ImageConverter converter) {
        this.imageConverter = converter;
    }

    // delegation
    public void spellCheck() {
        spellChecker.checkSpelling();
    }

    public void format() {
        textFormatter.format();
    }

    public void convertImage() {
        imageConverter.convert();
    }
}
