package com.salah.gestiondestock.DtoMappers;

import com.salah.gestiondestock.Dtos.ArticlesDto;
import com.salah.gestiondestock.model.Articles;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;


@Mapper(componentModel = "spring", uses = {CategoryMapper.class})
public interface ArticlesMapper {
    ArticlesMapper INSTANCE = Mappers.getMapper(ArticlesMapper.class);

    ArticlesDto toDto(Articles entity);
    Articles toEntity(ArticlesDto dto);


}
