package com.framework.serializers;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.framework.model.UserModel;
import com.framework.util.JacksonUtilities;

import java.io.IOException;

public class UserModelSerializer extends StdSerializer<UserModel> {

    private JacksonUtilities jacksonUtilities = new JacksonUtilities();

    public UserModelSerializer(){
        this(null);
    }

    public UserModelSerializer(Class<UserModel> object){
        super(object);
    }

    @Override
    public void serialize(UserModel model, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException, JsonProcessingException {

        jsonGenerator.writeStartObject();
        jsonGenerator = jacksonUtilities.addDataToJsonGenerator(jsonGenerator, "username", model.getUsername());
        jsonGenerator = jacksonUtilities.addDataToJsonGenerator(jsonGenerator, "email", model.getEmail());
        jsonGenerator = jacksonUtilities.addDataToJsonGenerator(jsonGenerator, "nameOfUser", model.getNameOfUser());
        jsonGenerator = jacksonUtilities.addDataToJsonGenerator(jsonGenerator, "mobileNumber", model.getMobileNumber());
        jsonGenerator = jacksonUtilities.addDataToJsonGenerator(jsonGenerator, "dateOfBirth", model.getDateOfBirth());
        jsonGenerator.writeObjectField("address", model.getAddress());
        jsonGenerator.writeEndObject();

    }
}

