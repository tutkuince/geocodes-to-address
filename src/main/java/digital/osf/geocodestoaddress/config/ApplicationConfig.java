package digital.osf.geocodestoaddress.config;

import com.google.maps.GeoApiContext;
import digital.osf.geocodestoaddress.utility.Constants;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {

    @Bean
    public GeoApiContext geoApiContext() {
        GeoApiContext.Builder builder = new GeoApiContext.Builder();
        builder.apiKey(Constants.API_KEY);
        return builder.build();
    }

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
