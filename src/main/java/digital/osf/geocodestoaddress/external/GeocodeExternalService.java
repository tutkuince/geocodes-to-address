package digital.osf.geocodestoaddress.external;

import com.google.maps.errors.ApiException;
import digital.osf.geocodestoaddress.dto.GeocodeResultDto;

import java.io.IOException;

public interface GeocodeExternalService {

    GeocodeResultDto getReverseGeocode(String latitudeAndLongitude) throws InterruptedException, ApiException, IOException;
}
