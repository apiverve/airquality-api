# Air Quality API - Dart/Flutter Client

Air Quality is a simple tool for getting air quality data. It returns the air quality index, o3, pm2, and more.

[![pub package](https://img.shields.io/pub/v/apiverve_airquality.svg)](https://pub.dev/packages/apiverve_airquality)
[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)

This is the Dart/Flutter client for the [Air Quality API](https://airquality.apiverve.com?utm_source=dart&utm_medium=readme).

## Installation

Add this to your `pubspec.yaml`:

```yaml
dependencies:
  apiverve_airquality: ^1.1.13
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
    "pm2_5": 25.345,
    "pm10": 32.005,
    "us-epa-index": 2,
    "gb-defra-index": 3,
    "carbonMonoxide": 745.55,
    "ozone": 47,
    "nitrogenDioxide": 54.02,
    "sulfurdioxide": 4.625,
    "recommendation": "The air quality in San Francisco is good. It is safe to go outside.",
    "city": "San Francisco"
  }
}
```

## API Reference

- **API Home:** [Air Quality API](https://airquality.apiverve.com?utm_source=dart&utm_medium=readme)
- **Documentation:** [docs.apiverve.com/ref/airquality](https://docs.apiverve.com/ref/airquality?utm_source=dart&utm_medium=readme)

## Authentication

All requests require an API key. Get yours at [apiverve.com](https://apiverve.com?utm_source=dart&utm_medium=readme).

## License

MIT License - see [LICENSE](LICENSE) for details.

---

Built with Dart for [APIVerve](https://apiverve.com?utm_source=dart&utm_medium=readme)
