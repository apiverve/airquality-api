using System;
using System.Collections.Generic;
using System.Text;
using Newtonsoft.Json;

namespace APIVerve.API.AirQuality
{
    /// <summary>
    /// Query options for the Air Quality API
    /// </summary>
    public class AirQualityQueryOptions
    {
        /// <summary>
        /// The city name for which you want to get the air quality data (e.g., New York). A name shared by several places resolves to the best-known one (Delhi is Delhi, India); add a state, province or country after a comma to pick another (e.g., Portland, Maine or London, Ontario)
        /// </summary>
        [JsonProperty("city")]
        public string City { get; set; }

        /// <summary>
        /// Include the estimated 0-500 US AQI, its category, the dominant pollutant and the index for each pollutant
        /// </summary>
        [JsonProperty("aqi")]
        public bool? Aqi { get; set; }
    }
}
