package com.cyber_chill.configuration;

import org.apache.logging.log4j.core.Layout;
import org.apache.logging.log4j.core.LogEvent;
import org.apache.logging.log4j.core.layout.ByteBufferDestination;

import java.util.Map;

public class CustomLayout implements Layout<String> {
    @Override
    public byte[] getFooter() {
        return new byte[0];
    }

    @Override
    public byte[] getHeader() {
        return new byte[0];
    }

    @Override
    public byte[] toByteArray(LogEvent event) {
        return new byte[0];
    }

    @Override
    public String toSerializable(LogEvent event) {
        return event.getMessage().getFormattedMessage();
    }

    @Override
    public String getContentType() {
        return null;
    }

    @Override
    public Map<String, String> getContentFormat() {
        return null;
    }

    @Override
    public void encode(LogEvent source, ByteBufferDestination destination) {

    }
}
