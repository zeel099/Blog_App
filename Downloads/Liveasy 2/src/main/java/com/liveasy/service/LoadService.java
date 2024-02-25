package com.liveasy.service;

import com.liveasy.entity.Load;
import com.liveasy.payload.LoadDto;

public interface LoadService {
    LoadDto create(LoadDto loadDto);

    Load getLoadByShipperId(Integer shipperId);

    LoadDto getLoadByLoadId(Integer loadId);

    LoadDto deleteLoad(Integer loadId);

}
