package edu.co.icesi.introspringboot.api.v1.mappers;

import edu.co.icesi.introspringboot.api.v1.dto.CourseRequest;
import edu.co.icesi.introspringboot.api.v1.dto.CourseResponse;
import edu.co.icesi.introspringboot.entity.Course;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface CourseMapper {

    // Entity → DTO
    @Mapping(source = "professor.name", target = "professorName")
    CourseResponse toDTO(Course course);

    // DTO → Entity
    @Mapping(source = "professorId", target = "professor.id")
    Course toEntity(CourseRequest dto);

    // Actualiza los campos de un entity existente sin crear uno nuevo
    //@Mapping(source = "profesorId", target = "profesor.id")
    //void updateEntityFromDTO(CursoDTO dto, @MappingTarget Curso entity);
}
