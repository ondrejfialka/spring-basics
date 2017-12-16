package cz.ucl.jee.spring.weather;

public interface WeatherService {
	
	WeatherReport getCurrentTemperature(String location);

}
