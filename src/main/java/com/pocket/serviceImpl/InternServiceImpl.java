package com.pocket.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pocket.dto.InternDTO;
import com.pocket.entity.Intern;
import com.pocket.repository.InternRepository;
import com.pocket.service.InternService;

@Service

public class InternServiceImpl implements InternService {

	@Autowired
    private InternRepository internRepository;

    @Autowired
    private ModelMapper mapper;

    @Override
    public InternDTO addIntern(InternDTO dto) {
        Intern internEntity = mapper.map(dto, Intern.class);
        Intern savedIntern = internRepository.save(internEntity);
        return mapper.map(savedIntern, InternDTO.class);
    }

    @Override
    public InternDTO getInternById(Long id) {
        Intern intern = internRepository.findById(id).orElseThrow(() -> new RuntimeException("Intern not found"));
        return mapper.map(intern, InternDTO.class);
    }

    @Override
    public List<InternDTO> getAllInterns() {
        List<Intern> interns = internRepository.findAll();
        return interns.stream()
                      .map(intern -> mapper.map(intern, InternDTO.class))
                      .collect(Collectors.toList());
    }

    @Override
    public InternDTO updateIntern(Long id, InternDTO dto) {
        Intern existingIntern = internRepository.findById(id)
                                                .orElseThrow(() -> new RuntimeException("Intern not found"));
        mapper.map(dto, existingIntern);
        Intern updatedIntern = internRepository.save(existingIntern);
        return mapper.map(updatedIntern, InternDTO.class);
    }

    @Override
    public void deleteIntern(Long id) {
        internRepository.deleteById(id);
    }

}
