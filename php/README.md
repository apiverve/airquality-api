# Air Quality API - PHP Package

Air Quality is a simple tool for getting air quality data. It returns the air quality index, o3, pm2, and more.

## Installation

Install via Composer:

```bash
composer require apiverve/airquality
```

## Getting Started

Get your API key at [APIVerve](https://apiverve.com)

### Basic Usage

```php
<?php

require_once 'vendor/autoload.php';

use APIVerve\Airquality\Client;

// Initialize the client
$client = new Client('YOUR_API_KEY');

// Make a request
$response = $client->execute(['city' => 'San Francisco']);

// Print the response
print_r($response);
```


### Error Handling

```php
use APIVerve\Airquality\Client;
use APIVerve\Airquality\Exceptions\APIException;
use APIVerve\Airquality\Exceptions\ValidationException;

try {
    $response = $client->execute(['city' => 'San Francisco']);
    print_r($response['data']);
} catch (ValidationException $e) {
    echo "Validation error: " . implode(', ', $e->getErrors());
} catch (APIException $e) {
    echo "API error: " . $e->getMessage();
    echo "Status code: " . $e->getStatusCode();
}
```

### Debug Mode

```php
// Enable debug logging
$client = new Client(
    apiKey: 'YOUR_API_KEY',
    debug: true
);
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

## Requirements

- PHP 7.4 or higher
- Guzzle HTTP client

## Documentation

For more information, visit the [API Documentation](https://docs.apiverve.com/ref/airquality?utm_source=packagist&utm_medium=readme).

## Support

- Website: [https://airquality.apiverve.com?utm_source=php&utm_medium=readme](https://airquality.apiverve.com?utm_source=php&utm_medium=readme)
- Email: hello@apiverve.com

## License

This package is available under the [MIT License](LICENSE).
