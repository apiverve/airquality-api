declare module '@apiverve/airquality' {
  export interface airqualityOptions {
    api_key: string;
    secure?: boolean;
  }

  /**
   * Describes fields the current plan does not unlock. Locked fields arrive as null
   * in `data`; `locked_fields` names them, using dot paths for nested fields.
   * Absent when the plan unlocks everything.
   */
  export interface PremiumInfo {
    message: string;
    upgrade_url: string;
    locked_fields: string[];
  }

  export interface airqualityResponse {
    status: string;
    error: string | null;
    data: AirQualityData;
    code?: number;
    premium?: PremiumInfo;
  }


  interface AirQualityData {
      pm25:            number | null;
      pm10:            number | null;
      carbonMonoxide:  number | null;
      ozone:           number | null;
      nitrogenDioxide: number | null;
      sulfurdioxide:   number | null;
      usEpaIndex:      number | null;
      gbDefraIndex:    number | null;
      recommendation:  null | string;
      city:            null | string;
  }

  export default class airqualityWrapper {
    constructor(options: airqualityOptions);

    execute(callback: (error: any, data: airqualityResponse | null) => void): Promise<airqualityResponse>;
    execute(query: Record<string, any>, callback: (error: any, data: airqualityResponse | null) => void): Promise<airqualityResponse>;
    execute(query?: Record<string, any>): Promise<airqualityResponse>;
  }
}
