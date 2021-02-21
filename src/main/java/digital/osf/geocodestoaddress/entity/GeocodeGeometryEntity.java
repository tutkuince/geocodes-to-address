package digital.osf.geocodestoaddress.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class GeocodeGeometryEntity {

    private GeocodeLocationEntity geocodeLocation;
    private String locationType;
}
