package com.mygdx.game;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TestMapper {
    TestMapper INSTANCE = Mappers.getMapper( TestMapper.class );

    TestThing from(TestThingDTO to);
    TestThingDTO to(TestThing from);
}
