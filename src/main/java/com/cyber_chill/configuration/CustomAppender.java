package com.cyber_chill.configuration;

import org.apache.logging.log4j.core.Layout;
import org.apache.logging.log4j.core.LogEvent;
import org.apache.logging.log4j.core.appender.AbstractAppender;

public class CustomAppender extends AbstractAppender {
    private final Layout<String> customLayout;

    protected CustomAppender(Layout<String> customLayout) {
        super("CustomAppender", null, customLayout, false, null);
        this.customLayout = customLayout;
    }

    @Override
    public void append(LogEvent event) {
        String formattedMessage = customLayout.toSerializable(event);
        System.out.println(formattedMessage);
    }
}
