package com.niewiadomski.guessagender.mapper;

import com.niewiadomski.guessagender.dto.ComplexTokenDTO;
import com.niewiadomski.guessagender.dto.MaleTokenDTO;
import com.niewiadomski.guessagender.entity.ComplexToken;
import com.niewiadomski.guessagender.entity.MaleToken;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface MaleTokenMapper {

    MaleTokenMapper INSTANCE = Mappers.getMapper(MaleTokenMapper.class);

    MaleTokenDTO maleTokenToDTO(MaleToken maleToken);
    MaleToken dtoToMaleToken(MaleTokenDTO maleTokenDTO);


}
