package digital.osf.geocodestoaddress.service;

import com.google.maps.errors.ApiException;
import digital.osf.geocodestoaddress.dto.GeocodeResultDto;
import digital.osf.geocodestoaddress.entity.GeocodeResultEntity;
import org.springframework.stereotype.Service;

import java.io.IOException;

public interface GeocodeService {

    GeocodeResultEntity getReverseGeocode(String latitudeAndLongitude) throws InterruptedException, ApiException, IOException;
}
