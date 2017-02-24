import {environment} from "../environments/environment";

const baseUrl = environment.baseUrl;
export const ServerAPI = {
  token: baseUrl + '/oauth/token',
  refresh: baseUrl + '/oauth/token',
  login: baseUrl + '/test'
}
