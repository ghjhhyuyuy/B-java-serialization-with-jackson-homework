package com.thoughtworks.capability.gtb;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.thoughtworks.capability.gtb.vo.PersonVo;

import java.io.IOException;

/**
 * Created by wzw on 2020/9/12.
 */
public class PersonDeserializer extends StdDeserializer<PersonVo> {
    protected PersonDeserializer() {
        super(PersonVo.class);
    }

    @Override
    public PersonVo deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        JsonNode node = p.getCodec().readTree(p);
        PersonVo personVo = new PersonVo();
        System.out.println("hahaha");
        if(ctxt.readValue(node.get("age").traverse(), Integer.class) == null){
            personVo.setAge(0);
        }else {
            personVo.setAge(ctxt.readValue(node.get("age").traverse(), Integer.class));
        }
        if(ctxt.readValue(node.get("hobby").traverse(), String.class) != null){
            personVo.setHobby(ctxt.readValue(node.get("hobby").traverse(), String.class));
        }
        personVo.setId(ctxt.readValue(node.get("id").traverse(), String.class));
        personVo.setName(ctxt.readValue(node.get("name").traverse(), String.class));
        return personVo;
    }


}
