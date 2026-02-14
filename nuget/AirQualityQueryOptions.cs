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
        /// The city name for which you want to get the air quality data (e.g., New York)
        /// </summary>
        [JsonProperty("city")]
        public string City { get; set; }
    }
}
