package by.sak.dormitory.mapper;

import by.sak.dormitory.dto.ContractReadDto;
import by.sak.dormitory.entity.Contract;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring", uses = UserReadMapper.class, injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface ContractReadMapper {

    ContractReadMapper INSTANCE = Mappers.getMapper(ContractReadMapper.class);

    @Mapping(source = "user", target = "userReadDto")
    ContractReadDto convertToContractReadDto(Contract contract);

    @Mapping(source = "userReadDto", target = "user")
    Contract convertToContract(ContractReadDto contractReadDto);
}
