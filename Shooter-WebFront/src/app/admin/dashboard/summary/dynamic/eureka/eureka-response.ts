export enum EUREKA_STATUS {
  UP = 0,
  DOWN = 1,
  UNKNWON = 2
}

export interface EurekaResponse {
  applications: {
    versions__delta: number
    apps__hashcode: string
    application: [{
      name: string
      instance: [{
        instanceId: string
        hostName: string
        app: string
        ipAddr: string
        status: string
        overriddenstatus: string
        port: {
          $: number
          // @enabled: boolean
        },
        securePort: {
          $: number
          // @enabled: boolean
        },
        countryId: number
        dataCenterInfo: {
          class: string
          name: string
        }
        leaseInfo: {
          renewalIntervalInSecs: number
          durationInSecs: number
          registrationTimestamp: Date
          lastRenewalTimestamp: Date
          evictionTimestamp: Date
          serviceUpTimestamp: Date
        }
        metadata: {
          instanceId: string
        }
        homePageUrl: string
        statusPageUrl: string
        healthCheckUrl: string
        vipAddress: string
        secureVipAddress: string
        isCoordinatingDiscoveryServer: boolean
        lastUpdatedTimestamp: Date
        lastDirtyTimestamp: Date
        actionType: string
      }]
    }]
  }
}
