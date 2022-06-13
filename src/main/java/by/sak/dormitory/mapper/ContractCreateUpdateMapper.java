package by.sak.dormitory.mapper;

import by.sak.dormitory.dto.ContractCreateUpdateDto;
import by.sak.dormitory.entity.Contract;
import by.sak.dormitory.entity.User;
import by.sak.dormitory.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ContractCreateUpdateMapper implements Mapper<ContractCreateUpdateDto, Contract>{

    private final UserRepository userRepository;

    @Autowired
    public ContractCreateUpdateMapper(UserRepository userRepository) {
        this.userRepository = userRepository;
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
        contract.setUser(getUser(object.getUserId()));
    }

    public User getUser(Integer userId) {
        return Optional.ofNullable(userId)
                .flatMap(userRepository::findById)
                .orElse(null);
    }

}
