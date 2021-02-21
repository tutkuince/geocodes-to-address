package digital.osf.geocodestoaddress.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class AddressComponentEntity {

    private String longName;
    private String shortName;
    private List<String> types;
}
