package com.liveasy.service.serviceImpl;

import com.liveasy.Repository.LoadRepo;
import com.liveasy.entity.Load;
import com.liveasy.payload.LoadDto;
import com.liveasy.service.LoadService;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoadServiceImpl implements LoadService {

    @Autowired
    private LoadService loadService;

    @Autowired
    private LoadRepo loadRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public LoadDto create(LoadDto loadDto) {
        Load load = this.modelMapper.map(loadDto, Load.class);
        Load savedLoad = this.loadRepo.save(load);
        return this.modelMapper.map(savedLoad,LoadDto.class);
    }

    @Override
    public Load getLoadByShipperId(Integer shipperId) {
        Optional<Load> load = loadRepo.findById(shipperId);
        if (load.isPresent()) {
            return load.get();
        }
        else {
            return null;
        }

    }

    @Override
    public LoadDto getLoadByLoadId(Integer loadId) {
        Load load = this.loadRepo.findById(loadId).orElseThrow();
        return modelMapper.map(load,LoadDto.class);
    }

    @Override
    public LoadDto deleteLoad(Integer loadId) {
        Load load = this.loadRepo.findById(loadId).orElseThrow();
        this.loadRepo.delete(load);
        return this.modelMapper.map(load,LoadDto.class);
    }
}
