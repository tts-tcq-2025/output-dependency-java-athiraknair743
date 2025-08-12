import static org.junit.Assert.*;
import org.junit.Test;
import weatherreport.*;

public class WeatherReportTest {

    // Custom stub for the missing scenario
    class HighRainLowWindStub implements IWeatherSensor {
        public double TemperatureInC() { return 28; }  // High temp
        public int Precipitation() { return 80; }       // High precipitation
        public int Humidity() { return 70; }
        public int WindSpeedKMPH() { return 30; }       // Low wind
    }

    @Test
    public void testHighPrecipitationLowWind() {
        IWeatherSensor sensor = new HighRainLowWindStub();
        String report = WeatherReport.Report(sensor);

        // Expecting rainy report, but current buggy code returns "Sunny Day"
        assertTrue("Report should indicate rain for high precipitation and low wind", 
                   report.toLowerCase().contains("rain"));
    }
}
