package digital.osf.geocodestoaddress.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class GeocodeObjectDto {

    @JsonProperty("place_id")
    private String placeId;

    @JsonProperty("address_components")
    private List<AddressComponentDto> addressComponents;

    @JsonProperty("formatted_address")
    private String formattedAddress;

    @JsonProperty("geometry")
    private GeocodeGeometryDto geocodeGeometry;

    private List<String> types;
}
