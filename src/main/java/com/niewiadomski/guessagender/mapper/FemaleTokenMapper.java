package com.niewiadomski.guessagender.mapper;

import com.niewiadomski.guessagender.dto.FemaleTokenDTO;
import com.niewiadomski.guessagender.dto.MaleTokenDTO;
import com.niewiadomski.guessagender.entity.FemaleToken;
import com.niewiadomski.guessagender.entity.MaleToken;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface FemaleTokenMapper {

    FemaleTokenMapper INSTANCE = Mappers.getMapper(FemaleTokenMapper.class);

    FemaleTokenDTO femaleTokenToDTO(FemaleToken femaleToken);
    FemaleToken dtoToFemaleToken(FemaleTokenDTO femaleTokenDTO);


}
