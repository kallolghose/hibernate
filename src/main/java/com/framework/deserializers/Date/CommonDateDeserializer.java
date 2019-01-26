package com.framework.deserializers.Date;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.framework.util.Utilities;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CommonDateDeserializer extends StdDeserializer<Date> {

    public CommonDateDeserializer(){
        this(null);
    }

    public CommonDateDeserializer(Class<?> object){
        super(object);
    }

    @Override
    public Date deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        try {
            String date = jsonParser.getText();
            return Utilities.DATE_FORMATTER.parse(date);
        }
        catch(ParseException ex){
            throw new IOException(ex.getMessage());
        }

    }
}
