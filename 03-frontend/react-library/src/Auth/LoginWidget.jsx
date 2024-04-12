import React from 'react'
import {Redirect} from 'react-router-dom'
import {useOktaAuth} from '@okta/okta-react'
import SpinnerLoading from '../../src/layouts/Utils/SpinnerLoading'
import OktaSignWidget from './OktaSignWidget'

export const LoginWidget = ({config}) => {

  const {oktaAuth , authState} = useOktaAuth()
  const onSuccess = (tokens) =>{
    oktaAuth.handleLoginRedirect(tokens)
  }
  
    const onError = (err) =>{
        console.log('Sing in error : ' ,err)
    }

    if(!authState){
        return(
            <SpinnerLoading/>
        );
    }

    return authState.isAuthenticated ?
    <Redirect to={{pathname : '/'}}/>
    :
    <OktaSignWidget config={config} onSuccess={onSuccess} onError={onError}/>
}
export default LoginWidget
