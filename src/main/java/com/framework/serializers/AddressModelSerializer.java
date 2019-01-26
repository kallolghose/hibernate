package com.framework.serializers;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.framework.model.AddressModel;
import com.framework.util.JacksonUtilities;

import java.io.IOException;

public class AddressModelSerializer extends StdSerializer<AddressModel> {

    private JacksonUtilities jacksonUtilities = new JacksonUtilities();

    public AddressModelSerializer(){
        this(null);
    }

    public AddressModelSerializer(Class<AddressModel> object){
        super(object);
    }

    @Override
    public void serialize(AddressModel model, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException, JsonProcessingException {

        jsonGenerator.writeStartObject();
        jsonGenerator = jacksonUtilities.addDataToJsonGenerator(jsonGenerator, "line1", model.getLine1());
        jsonGenerator = jacksonUtilities.addDataToJsonGenerator(jsonGenerator, "line2", model.getLine2());
        jsonGenerator = jacksonUtilities.addDataToJsonGenerator(jsonGenerator, "city", model.getCity());
        jsonGenerator = jacksonUtilities.addDataToJsonGenerator(jsonGenerator, "state", model.getStete());
        jsonGenerator = jacksonUtilities.addDataToJsonGenerator(jsonGenerator, "country", model.getCountry());
        jsonGenerator = jacksonUtilities.addDataToJsonGenerator(jsonGenerator, "pincode", model.getPinCode());
        jsonGenerator.writeEndObject();

    }
}
