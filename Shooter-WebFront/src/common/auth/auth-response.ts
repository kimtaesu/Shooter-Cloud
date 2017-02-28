export class AuthResponse {
  constructor(public access_token: string, public token_type: string, public expires_in, public refresh_token: string) {
  }
}
