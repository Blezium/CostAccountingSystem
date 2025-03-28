package com.cas.costaccountingsystem.mappers;

import com.cas.costaccountingsystem.domains.Account;
import com.cas.costaccountingsystem.dto.FullAccountDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AccountMapper extends BaseMapper<Account, FullAccountDto>{
}
