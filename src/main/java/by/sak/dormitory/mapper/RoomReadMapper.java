package by.sak.dormitory.mapper;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring"/*, uses = TagMapper.class*/, injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface RoomReadMapper {
}
