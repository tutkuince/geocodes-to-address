package digital.osf.geocodestoaddress.service.impl;

import com.google.maps.errors.ApiException;
import digital.osf.geocodestoaddress.dto.GeocodeResultDto;
import digital.osf.geocodestoaddress.entity.GeocodeResultEntity;
import digital.osf.geocodestoaddress.external.GeocodeExternalService;
import digital.osf.geocodestoaddress.service.GeocodeService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class GeocodeServiceImpl implements GeocodeService {

    private final GeocodeExternalService geocodeExternalService;

    @Autowired
    public GeocodeServiceImpl(GeocodeExternalService geocodeExternalService) {
        this.geocodeExternalService = geocodeExternalService;
    }

    @Override
    public GeocodeResultEntity getReverseGeocode(String latitudeAndLongitude) throws InterruptedException, ApiException, IOException {
        GeocodeResultEntity geocodeResultEntity = new GeocodeResultEntity();
        GeocodeResultDto reverseGeocode = geocodeExternalService.getReverseGeocode(latitudeAndLongitude);
        ModelMapper modelMapper = new ModelMapper();
        geocodeResultEntity.setResults(modelMapper.map(reverseGeocode.getResults(), List.class));
        return geocodeResultEntity;
    }

    @Override
    public GeocodeResultEntity getGeocode(String address) throws InterruptedException, ApiException, IOException {
        GeocodeResultEntity geocodeResultEntity = new GeocodeResultEntity();
        GeocodeResultDto geocodeResultDto = geocodeExternalService.getGeocode(address);
        ModelMapper modelMapper = new ModelMapper();
        geocodeResultEntity.setResults(modelMapper.map(geocodeResultDto.getResults(), List.class));
        return geocodeResultEntity;
    }
}
