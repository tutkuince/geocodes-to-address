package digital.osf.geocodestoaddress.service.impl;

import com.google.maps.errors.ApiException;
import digital.osf.geocodestoaddress.dto.*;
import digital.osf.geocodestoaddress.entity.GeocodeResultEntity;
import digital.osf.geocodestoaddress.external.GeocodeExternalService;
import digital.osf.geocodestoaddress.service.GeocodeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class GeocodeServiceImplTest {

    @Mock
    GeocodeExternalService geocodeExternalService;
    @InjectMocks
    GeocodeServiceImpl geocodeService;


    @BeforeEach
    void setUp() {
        geocodeService = new GeocodeServiceImpl(geocodeExternalService);
    }

    @Test
    void getReverseGeocode() throws InterruptedException, ApiException, IOException {
        String latitudeAndLongitude = "0,0";
        GeocodeResultDto geocodeResultDto = new GeocodeResultDto();
        List<GeocodeObjectDto> resultsDto = new ArrayList<>();
        GeocodeObjectDto geocodeObjectDto = new GeocodeObjectDto();
        geocodeObjectDto.setFormattedAddress("Formatted-Address");

        resultsDto.add(geocodeObjectDto);

        geocodeResultDto.setResults(resultsDto);
        geocodeResultDto.setStatus("OK");

        when(geocodeExternalService.getReverseGeocode(latitudeAndLongitude)).thenReturn(geocodeResultDto);

        ModelMapper modelMapper = new ModelMapper();

        GeocodeResultEntity geocodeResultEntity = new GeocodeResultEntity();
        geocodeResultEntity.setResults(modelMapper.map(geocodeResultDto.getResults(), List.class));

        geocodeService.getReverseGeocode(latitudeAndLongitude);

        assertNotNull(geocodeResultEntity);
    }

    @Test
    void getGeocode() throws InterruptedException, ApiException, IOException {
        String address = "Address";
        GeocodeResultDto geocodeResultDto = new GeocodeResultDto();
        List<GeocodeObjectDto> resultsDto = new ArrayList<>();
        GeocodeObjectDto geocodeObjectDto = new GeocodeObjectDto();
        geocodeObjectDto.setFormattedAddress("Formatted-Address");

        resultsDto.add(geocodeObjectDto);

        geocodeResultDto.setResults(resultsDto);
        geocodeResultDto.setStatus("OK");

        when(geocodeExternalService.getGeocode(address)).thenReturn(geocodeResultDto);

        ModelMapper modelMapper = new ModelMapper();

        GeocodeResultEntity geocodeResultEntity = new GeocodeResultEntity();
        geocodeResultEntity.setResults(modelMapper.map(geocodeResultDto.getResults(), List.class));

        geocodeService.getGeocode(address);

        assertNotNull(geocodeResultEntity);
    }
}