package com.niewiadomski.guessagender.mapper;

import com.niewiadomski.guessagender.dto.ComplexTokenDTO;
import com.niewiadomski.guessagender.entity.ComplexToken;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ComplexTokenMapper {

    ComplexTokenMapper INSTANCE = Mappers.getMapper(ComplexTokenMapper.class);

    ComplexTokenDTO complexTokenToDTO(ComplexToken complexToken);
    ComplexToken dtoToComplexToken(ComplexTokenDTO complexTokenDTO);


}
