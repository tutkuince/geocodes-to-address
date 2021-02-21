package digital.osf.geocodestoaddress.rest;

import com.google.maps.errors.ApiException;
import digital.osf.geocodestoaddress.dto.GeocodeResultDto;
import digital.osf.geocodestoaddress.entity.GeocodeResultEntity;
import digital.osf.geocodestoaddress.service.GeocodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;

@RestController
@RequestMapping("/api/v0/geocodes")
public class GeocodeController {

    private final GeocodeService geocodeService;

    @Autowired
    public GeocodeController(GeocodeService geocodeService) {
        this.geocodeService = geocodeService;
    }

    @GetMapping(value = "/getGeocode")
    public ResponseEntity<GeocodeResultEntity> getGeocode(@RequestParam("lat") String lat, @RequestParam("lng") String lng) throws InterruptedException, ApiException, IOException {
        String latAndLng = lat + "," + lng;
        final GeocodeResultEntity reverseGeocode = geocodeService.getReverseGeocode(latAndLng);
        return ResponseEntity.ok(reverseGeocode);
    }
}
