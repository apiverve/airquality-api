/// Response models for the Air Quality API.

/// API Response wrapper.
class AirqualityResponse {
  final String status;
  final dynamic error;
  final AirqualityData? data;

  AirqualityResponse({
    required this.status,
    this.error,
    this.data,
  });

  factory AirqualityResponse.fromJson(Map<String, dynamic> json) => AirqualityResponse(
    status: json['status'] as String? ?? '',
    error: json['error'],
    data: json['data'] != null ? AirqualityData.fromJson(json['data']) : null,
  );

  Map<String, dynamic> toJson() => {
    'status': status,
    if (error != null) 'error': error,
    if (data != null) 'data': data,
  };
}

/// Response data for the Air Quality API.

class AirqualityData {
  double? pm2_5;
  double? pm10;
  int? us-epa-index;
  int? gb-defra-index;
  double? carbonMonoxide;
  int? ozone;
  double? nitrogenDioxide;
  double? sulfurdioxide;
  String? recommendation;
  String? city;

  AirqualityData({
    this.pm2_5,
    this.pm10,
    this.us-epa-index,
    this.gb-defra-index,
    this.carbonMonoxide,
    this.ozone,
    this.nitrogenDioxide,
    this.sulfurdioxide,
    this.recommendation,
    this.city,
  });

  factory AirqualityData.fromJson(Map<String, dynamic> json) => AirqualityData(
      pm2_5: json['pm2_5'],
      pm10: json['pm10'],
      us-epa-index: json['us-epa-index'],
      gb-defra-index: json['gb-defra-index'],
      carbonMonoxide: json['carbonMonoxide'],
      ozone: json['ozone'],
      nitrogenDioxide: json['nitrogenDioxide'],
      sulfurdioxide: json['sulfurdioxide'],
      recommendation: json['recommendation'],
      city: json['city'],
    );
}

class AirqualityRequest {
  String city;

  AirqualityRequest({
    required this.city,
  });

  Map<String, dynamic> toJson() => {
      'city': city,
    };
}
