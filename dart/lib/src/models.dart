/// Response models for the Air Quality API.

/// API Response wrapper.
class AirqualityResponse {
  final String status;
  final dynamic error;
  final AirqualityData? data;

  /// Set only when the current plan locks one or more fields; null otherwise.
  final PremiumInfo? premium;

  AirqualityResponse({
    required this.status,
    this.error,
    this.data,
    this.premium,
  });

  factory AirqualityResponse.fromJson(Map<String, dynamic> json) => AirqualityResponse(
    status: json['status'] as String? ?? '',
    error: json['error'],
    data: json['data'] != null ? AirqualityData.fromJson(json['data']) : null,
    premium: json['premium'] != null ? PremiumInfo.fromJson(json['premium']) : null,
  );

  Map<String, dynamic> toJson() => {
    'status': status,
    if (error != null) 'error': error,
    if (data != null) 'data': data,
    if (premium != null) 'premium': premium!.toJson(),
  };
}

/// Describes fields the current plan does not unlock. Locked fields arrive as null
/// in [data], and [lockedFields] names them (nested ones use dot paths).
class PremiumInfo {
  final String? message;
  final String? upgradeUrl;
  final List<String>? lockedFields;

  PremiumInfo({this.message, this.upgradeUrl, this.lockedFields});

  factory PremiumInfo.fromJson(Map<String, dynamic> json) => PremiumInfo(
    message: json['message'] as String?,
    upgradeUrl: json['upgrade_url'] as String?,
    lockedFields: (json['locked_fields'] as List?)?.map((e) => e.toString()).toList(),
  );

  Map<String, dynamic> toJson() => {
    if (message != null) 'message': message,
    if (upgradeUrl != null) 'upgrade_url': upgradeUrl,
    if (lockedFields != null) 'locked_fields': lockedFields,
  };
}

/// Response data for the Air Quality API.

class AirqualityData {
  num? pm2_5;
  num? pm10;
  num? carbonMonoxide;
  num? ozone;
  num? nitrogenDioxide;
  num? sulfurdioxide;
  num? usEpaIndex;
  num? gbDefraIndex;
  String? recommendation;
  String? city;

  AirqualityData({
    this.pm2_5,
    this.pm10,
    this.carbonMonoxide,
    this.ozone,
    this.nitrogenDioxide,
    this.sulfurdioxide,
    this.usEpaIndex,
    this.gbDefraIndex,
    this.recommendation,
    this.city,
  });

  factory AirqualityData.fromJson(Map<String, dynamic> json) => AirqualityData(
      pm2_5: json['pm2_5'],
      pm10: json['pm10'],
      carbonMonoxide: json['carbonMonoxide'],
      ozone: json['ozone'],
      nitrogenDioxide: json['nitrogenDioxide'],
      sulfurdioxide: json['sulfurdioxide'],
      usEpaIndex: json['usEpaIndex'],
      gbDefraIndex: json['gbDefraIndex'],
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
