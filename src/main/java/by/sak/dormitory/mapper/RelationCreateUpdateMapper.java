package by.sak.dormitory.mapper;

import by.sak.dormitory.dto.RelationCreateUpdateDto;
import by.sak.dormitory.entity.Relation;
import by.sak.dormitory.entity.Tenant;
import by.sak.dormitory.repository.TenantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class RelationCreateUpdateMapper implements Mapper<RelationCreateUpdateDto, Relation>{

    private final TenantRepository tenantRepository;

    @Autowired
    public RelationCreateUpdateMapper(TenantRepository tenantRepository) {
        this.tenantRepository = tenantRepository;
    }

    @Override
    public Relation map(RelationCreateUpdateDto object) {
        Relation relation = new Relation();
        copy(object, relation);

        return relation;
    }

    @Override
    public Relation map(RelationCreateUpdateDto fromObject, Relation toObject) {
        copy(fromObject, toObject);

        return toObject;
    }

    private void copy (RelationCreateUpdateDto object, Relation relation) {
        relation.setCurrentTenant(getTenant(object.getCurrentTenantId()));
        relation.setCurrentTenant(getTenant(object.getFamilyTenantId()));
        relation.setStatusFamily(object.getStatusFamily());
    }

    public Tenant getTenant(Integer tenantId) {
        return Optional.ofNullable(tenantId)
                .flatMap(tenantRepository::findById)
                .orElse(null);
    }
}
