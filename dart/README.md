# Air Quality API - Dart/Flutter Client

Air Quality is an air pollution API that reports particulate pollution levels and health recommendations for any city or zip code. Look up PM2.5 and PM10 concentrations to check current air conditions; paid plans add ozone, toxic gases, and EPA index scores.

[![pub package](https://img.shields.io/pub/v/apiverve_airquality.svg)](https://pub.dev/packages/apiverve_airquality)
[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)

This is the Dart/Flutter client for the [Air Quality API](https://apiverve.com/marketplace/airquality?utm_source=dart&utm_medium=referral&utm_content=readme).

## Installation

Add this to your `pubspec.yaml`:

```yaml
dependencies:
  apiverve_airquality: ^1.2.3
```

Then run:

```bash
dart pub get
# or for Flutter
flutter pub get
```

## Usage

```dart
import 'package:apiverve_airquality/apiverve_airquality.dart';

void main() async {
  final client = AirqualityClient('YOUR_API_KEY');

  try {
    final response = await client.execute({
      'city': 'San Francisco'
    });

    print('Status: ${response.status}');
    print('Data: ${response.data}');
  } catch (e) {
    print('Error: $e');
  }
}
```

## Response

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

## API Reference

- **API Home:** [Air Quality API](https://apiverve.com/marketplace/airquality?utm_source=dart&utm_medium=referral&utm_content=readme)
- **Documentation:** [docs.apiverve.com/ref/airquality](https://docs.apiverve.com/ref/airquality?utm_source=dart&utm_medium=referral&utm_content=readme)

## Authentication

All requests require an API key. Get yours at [apiverve.com](https://apiverve.com?utm_source=dart&utm_medium=referral&utm_content=readme).

## License

MIT License - see [LICENSE](LICENSE) for details.

---

Built with Dart for [APIVerve](https://apiverve.com?utm_source=dart&utm_medium=referral&utm_content=readme)
