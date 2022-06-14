package by.sak.dormitory.mapper;

import by.sak.dormitory.dto.ContractReadDto;
import by.sak.dormitory.entity.Contract;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring", uses = TenantReadMapper.class, injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface ContractReadMapper {

    ContractReadMapper INSTANCE = Mappers.getMapper(ContractReadMapper.class);

    @Mapping(source = "tenant", target = "tenantReadDto")
    ContractReadDto convertToContractReadDto(Contract contract);

    @Mapping(source = "tenantReadDto", target = "tenant")
    Contract convertToContract(ContractReadDto contractReadDto);
}
