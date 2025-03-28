package com.cas.costaccountingsystem.mappers;

import com.cas.costaccountingsystem.domains.FullName;
import com.cas.costaccountingsystem.dto.FullNameDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface FullNameMapper extends BaseMapper<FullName, FullNameDto>{

}
