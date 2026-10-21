# Air Quality API - Ruby Gem

Air Quality is an air pollution API that reports particulate pollution levels and health recommendations for any city or zip code. Look up PM2.5 and PM10 concentrations to check current air conditions; paid plans add ozone, toxic gases, and EPA index scores.

## Installation

Add this line to your application's Gemfile:

```ruby
gem 'apiverve_airquality'
```

And then execute:

```bash
$ bundle install
```

Or install it yourself as:

```bash
$ gem install apiverve_airquality
```

## Getting Started

Get your API key at [APIVerve](https://apiverve.com)

### Basic Usage

```ruby
require 'apiverve_airquality'

# Initialize the client
client = APIVerve::Airquality::Client.new(api_key: "YOUR_API_KEY")

# Make a request
response = client.execute({ city: "San Francisco" })

# Print the response
puts response
```


### Error Handling

```ruby
begin
  response = client.execute({ city: "San Francisco" })
  puts response["data"]
rescue APIVerve::Airquality::ValidationError => e
  puts "Validation error: #{e.errors.join(', ')}"
rescue APIVerve::Airquality::APIError => e
  puts "API error: #{e.message}"
  puts "Status code: #{e.status_code}"
end
```

### Debug Mode

```ruby
# Enable debug logging
client = APIVerve::Airquality::Client.new(
  api_key: "YOUR_API_KEY",
  debug: true
)
```

## Example Response

```json
{
  "status": "ok",
  "error": null,
  "data": {
    "pm2_5": 16.75,
    "pm10": 18.85,
    "carbonMonoxide": 387.85,
    "ozone": 9,
    "nitrogenDioxide": 38.55,
    "sulfurdioxide": 5.95,
    "usEpaIndex": 2,
    "gbDefraIndex": 2,
    "recommendation": "The air quality in San Francisco is good. It is safe to go outside.",
    "city": "San Francisco"
  }
}
```

## Documentation

For more information, visit the [API Documentation](https://docs.apiverve.com/ref/airquality?utm_source=rubygems&utm_medium=referral&utm_content=readme).

## Support

- Website: [https://apiverve.com/marketplace/airquality?utm_source=ruby&utm_medium=referral&utm_content=readme](https://apiverve.com/marketplace/airquality?utm_source=ruby&utm_medium=referral&utm_content=readme)
- Email: hello@apiverve.com

## License

This gem is available under the [MIT License](LICENSE).
