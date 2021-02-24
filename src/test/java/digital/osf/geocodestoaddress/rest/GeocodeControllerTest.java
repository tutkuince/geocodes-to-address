package digital.osf.geocodestoaddress.rest;

import digital.osf.geocodestoaddress.entity.GeocodeResultEntity;
import digital.osf.geocodestoaddress.service.GeocodeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
class GeocodeControllerTest {

    @Mock
    GeocodeService geocodeService;

    @InjectMocks
    GeocodeController geocodeController;

    @BeforeEach
    void setUp() {
        geocodeController = new GeocodeController(geocodeService);
    }

    @Test
    void getReverseGeocode() throws Exception {
        String latitudeAndLongitude = "0,0";
        String lat = latitudeAndLongitude.split(",")[0];
        String lng = latitudeAndLongitude.split(",")[1];

        GeocodeResultEntity geocodeResultEntity = new GeocodeResultEntity();
        geocodeResultEntity.setStatus("OK");
        when(geocodeService.getReverseGeocode(latitudeAndLongitude)).thenReturn(geocodeResultEntity);
        final ResponseEntity<GeocodeResultEntity> reverseGeocode = geocodeController.getReverseGeocode(lat, lng);
        assertEquals(geocodeResultEntity.getStatus(), reverseGeocode.getBody().getStatus());
    }

    @Test
    void getGeocode() throws Exception {
        GeocodeResultEntity geocodeResultEntity = new GeocodeResultEntity();
        geocodeResultEntity.setStatus("OK");
        String address = "Address";
        when(geocodeService.getGeocode(address)).thenReturn(geocodeResultEntity);
        final ResponseEntity<GeocodeResultEntity> geocode = geocodeController.getGeocode(address);
        assertEquals(geocodeResultEntity.getStatus(), geocode.getBody().getStatus());
    }
}