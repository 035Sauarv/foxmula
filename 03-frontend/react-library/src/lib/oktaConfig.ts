
export const oktaConfig = {
    clientId:'0oag79h8bg3lN5OnD5d7',
    issuer : 'https://dev-88602718.okta.com/oauth2/default',
    redirectUri : 'https://localhost:3000/login/callback',
    scope: ['openid' ,'profile' ,'email'],
    pkce : true,
    disableHttpCheck : true
}

export default oktaConfig
