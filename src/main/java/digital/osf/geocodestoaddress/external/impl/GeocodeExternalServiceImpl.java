package digital.osf.geocodestoaddress.external.impl;

import com.google.maps.GeoApiContext;
import com.google.maps.GeocodingApi;
import com.google.maps.errors.ApiException;
import com.google.maps.model.GeocodingResult;
import com.google.maps.model.LatLng;
import digital.osf.geocodestoaddress.dto.GeocodeResultDto;
import digital.osf.geocodestoaddress.external.GeocodeExternalService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class GeocodeExternalServiceImpl implements GeocodeExternalService {

    private final GeoApiContext geoApiContext;

    @Autowired
    public GeocodeExternalServiceImpl(GeoApiContext geoApiContext) {
        this.geoApiContext = geoApiContext;
    }

    @Override
    public GeocodeResultDto getReverseGeocode(String latitudeAndLongitude) throws InterruptedException, ApiException, IOException {
        String[] latAndLng = latitudeAndLongitude.split(",");
        double lat = Double.parseDouble(latAndLng[0].trim());
        double lng = Double.valueOf(latAndLng[1].trim());
        LatLng latLng = new LatLng(lat, lng);

        GeocodingResult[] await = GeocodingApi.newRequest(geoApiContext).latlng(latLng).await();

        List<GeocodingResult> geocodingResults = List.of(await);

        ModelMapper modelMapper = new ModelMapper();

        GeocodeResultDto geocodeResultDto = new GeocodeResultDto();
        geocodeResultDto.setResults(modelMapper.map(geocodingResults, List.class));

        return geocodeResultDto;
    }

    @Override
    public GeocodeResultDto getGeocode(String address) throws InterruptedException, ApiException, IOException {
        final GeocodingResult[] await = GeocodingApi.newRequest(geoApiContext).address(address).await();

        List<GeocodingResult> geocodingResults = List.of(await);

        ModelMapper modelMapper = new ModelMapper();

        GeocodeResultDto geocodeResultDto = new GeocodeResultDto();
        geocodeResultDto.setResults(modelMapper.map(geocodingResults, List.class));

        return geocodeResultDto;
    }
}
