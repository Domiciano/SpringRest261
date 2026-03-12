package edu.co.icesi.introspringboot.services.impl;

import edu.co.icesi.introspringboot.entity.Professor;
import edu.co.icesi.introspringboot.repository.ProfessorRepository;
import edu.co.icesi.introspringboot.services.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfessorServiceImpl implements ProfessorService {

    @Autowired
    private ProfessorRepository professorRepository;

    @Override
    public Professor saveProfessor(Professor professor) {
        Professor result =  professorRepository.save(professor);
        return result;
    }

}
