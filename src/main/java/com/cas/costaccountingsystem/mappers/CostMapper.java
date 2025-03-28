package com.cas.costaccountingsystem.mappers;

import com.cas.costaccountingsystem.domains.Cost;
import com.cas.costaccountingsystem.dto.CostDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CostMapper extends BaseMapper<Cost, CostDto> {
}
