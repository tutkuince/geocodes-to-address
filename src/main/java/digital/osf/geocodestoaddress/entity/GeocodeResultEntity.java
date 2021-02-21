package digital.osf.geocodestoaddress.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class GeocodeResultEntity {

    private List<GeocodeObjectEntity> results;
    private String status;
}
