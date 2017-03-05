// The file contents for the current environment will overwrite these during build.
// The build system defaults to the dev environment which uses `environment.ts`, but if you do
// `ng build --env=prod` then `environment.prod.ts` will be used instead.
// The list of which env maps to which file can be found in `angular-cli.json`.
let prefix: string = 'http://'

const server = {
  http: '',
  gateway: {
    url: 'http://localhost:9000',
  },
  eureka: {
    url: 'http://localhost:8761',
  },
}
export const environment = {
  production: false,
  api: {
    token: server.gateway.url + '/oauth/token',
    refresh: server.gateway.url + '/oauth/token',
    login: server.gateway.url + '/test',
    join: server.gateway.url + '/uaa/user/signup',

    //  server-discovery
    queryApps: server.eureka.url + '/eureka/apps',
    queryInstance: server.eureka.url + '/eureka/instances',
  },

  authCofig: {
    clientId: 'items',
    clientSecret: 'items',
  }
}
