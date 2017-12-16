package cz.ucl.jee.spring.weather;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("myWeatherService")
@Scope("singleton")
public class MockWeatherService implements WeatherService {

	public WeatherReport getCurrentTemperature(String location) {
		WeatherReport report = new WeatherReport();
		report.setCity(location);
		report.setTemperature(17.5f);
		return report;
	}

	
}
