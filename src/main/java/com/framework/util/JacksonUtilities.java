package com.framework.util;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class JacksonUtilities {

    /**
     * Get node from json node
     * @param jsonNode - Json node containing key
     * @param keyToFetch - name of the key to be fetched
     * @return - Object
     */
    public Object getNodeFromJsonNode(JsonNode jsonNode, String keyToFetch) throws Exception {
        if(jsonNode==null || jsonNode.isNull())
            return null;
        JsonNode node = jsonNode.get(keyToFetch);
        if(node.isTextual())
            return node.asText();
        if(node.isInt())
            return node.asInt();
        if(node.isDouble())
            return node.asDouble();
        if(node.isBoolean())
            return node.asBoolean();
        return null;
    }

    public JsonGenerator addDataToJsonGenerator(JsonGenerator jsonGenerator, String fieldName,  Object obj) throws IOException, JsonProcessingException {
        if(jsonGenerator==null)
            return null;
        if(obj instanceof String)
            jsonGenerator.writeStringField(fieldName, (String) obj);
        if(obj instanceof Integer)
            jsonGenerator.writeNumberField(fieldName, (int) obj);
        if(obj instanceof  Long)
            jsonGenerator.writeNumberField(fieldName, (long) obj);
        if(obj instanceof Double)
            jsonGenerator.writeNumberField(fieldName, (double) obj);
        if(obj instanceof Date)
        {
            jsonGenerator.writeStringField(fieldName, Utilities.DATE_TIME_FORMATTER.format((Date)obj));
        }

        return jsonGenerator;
    }



}
