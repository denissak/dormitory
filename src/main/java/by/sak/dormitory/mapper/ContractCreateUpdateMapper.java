package by.sak.dormitory.mapper;

import by.sak.dormitory.dto.ContractCreateUpdateDto;
import by.sak.dormitory.entity.Contract;
import by.sak.dormitory.entity.Tenant;
import by.sak.dormitory.repository.TenantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ContractCreateUpdateMapper implements Mapper<ContractCreateUpdateDto, Contract>{

    private final TenantRepository tenantRepository;

    @Autowired
    public ContractCreateUpdateMapper(TenantRepository tenantRepository) {
        this.tenantRepository = tenantRepository;
    }

    @Override
    public Contract map(ContractCreateUpdateDto object) {
        Contract contract = new Contract();
        copy(object, contract);

        return contract;
    }

    @Override
    public Contract map(ContractCreateUpdateDto fromObject, Contract toObject) {
        copy(fromObject, toObject);

        return toObject;
    }

    private void copy (ContractCreateUpdateDto object, Contract contract) {
        contract.setContractNumber(object.getContractNumber());
        contract.setContractStart(object.getContractStart());
        contract.setType(object.getType());
        contract.setContractEnd(object.getContractEnd());
        contract.setContractRegistration(object.getContractRegistration());
        contract.setNumberRegistration(object.getNumberRegistration());
        contract.setContractPetition(object.getContractPetition());
        contract.setTenant(getUser(object.getTenantId()));
    }

    public Tenant getUser(Integer userId) {
        return Optional.ofNullable(userId)
                .flatMap(tenantRepository::findById)
                .orElse(null);
    }

}
