package digital.osf.geocodestoaddress.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class  GeocodeObjectEntity {

    private String placeId;
    private List<AddressComponentEntity> addressComponents;
    private String formattedAddress;
    private GeocodeGeometryEntity geocodeGeometry;
    private List<String> types;
}
