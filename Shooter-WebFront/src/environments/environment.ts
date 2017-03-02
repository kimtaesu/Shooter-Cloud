// The file contents for the current environment will overwrite these during build.
// The build system defaults to the dev environment which uses `environment.ts`, but if you do
// `ng build --env=prod` then `environment.prod.ts` will be used instead.
// The list of which env maps to which file can be found in `angular-cli.json`.

let baseUrl: string = 'http://localhost:9999'
export const environment = {
  production: false,


  api: {
    token: baseUrl + '/oauth/token',
    refresh: baseUrl + '/oauth/token',
    login: baseUrl + '/test',
    join: baseUrl + '/uaa/user/signup',
  },

  authCofig: {
    clientId: 'items',
    clientSecret: 'items',
  }
}
