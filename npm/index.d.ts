declare module '@apiverve/airquality' {
  export interface airqualityOptions {
    api_key: string;
    secure?: boolean;
  }

  export interface airqualityResponse {
    status: string;
    error: string | null;
    data: AirQualityData;
    code?: number;
  }


  interface AirQualityData {
      pm25:            number;
      pm10:            number;
      usEpaIndex:      number;
      gbDefraIndex:    number;
      carbonMonoxide:  number;
      ozone:           number;
      nitrogenDioxide: number;
      sulfurdioxide:   number;
      recommendation:  string;
      city:            string;
  }

  export default class airqualityWrapper {
    constructor(options: airqualityOptions);

    execute(callback: (error: any, data: airqualityResponse | null) => void): Promise<airqualityResponse>;
    execute(query: Record<string, any>, callback: (error: any, data: airqualityResponse | null) => void): Promise<airqualityResponse>;
    execute(query?: Record<string, any>): Promise<airqualityResponse>;
  }
}
