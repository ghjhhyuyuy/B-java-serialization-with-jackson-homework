package com.thoughtworks.capability.gtb;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.thoughtworks.capability.gtb.vo.PersonVo;

import java.io.IOException;

/**
 * Created by wzw on 2020/9/12.
 */
public class PersonSerializer extends StdSerializer<PersonVo> {
    protected PersonSerializer() {
        super(PersonVo.class);
    }

    @Override
    public void serialize(PersonVo value, JsonGenerator gen, SerializerProvider provider) throws IOException {
        gen.writeNumber(0);
    }
}
