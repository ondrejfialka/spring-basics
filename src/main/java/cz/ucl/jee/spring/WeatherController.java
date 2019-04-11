package cz.ucl.jee.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import cz.ucl.jee.spring.weather.WeatherReport;
import cz.ucl.jee.spring.weather.WeatherService;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
public class WeatherController {
	
	// field injection - not recommended, but used anyway on many projects
//	@Autowired(required=false)
//	@Qualifier("myWeatherService")
	WeatherService weatherService;
	
	//constructor injection - recommended
	@Autowired(required=false)
	public WeatherController (@Qualifier("myWeatherService") WeatherService weatherService) {
		this.weatherService = weatherService;
	}

	@PostMapping(
			value = "/weather/temperature",
			produces=APPLICATION_JSON_VALUE,
			consumes=APPLICATION_JSON_VALUE)
	public ResponseEntity<WeatherReport> getCurrentTemperature(@RequestBody WeatherReport report){
		
		if (report.getCity() == null) {
			throw new IllegalArgumentException("city must not be empty");
		}
		
		return new ResponseEntity<>(weatherService.getCurrentTemperature(report.getCity()),
				HttpStatus.OK);
	}
	
	
}
