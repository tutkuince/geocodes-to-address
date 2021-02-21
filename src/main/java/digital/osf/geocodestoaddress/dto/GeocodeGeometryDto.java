package digital.osf.geocodestoaddress.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class GeocodeGeometryDto {

    @JsonProperty("location")
    private GeocodeLocationDto geocodeLocation;

    @JsonProperty("location_type")
    private String locationType;
}
