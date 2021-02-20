import {HOST} from '../../commons/hosts';
import RestApiClient from "../../commons/api/rest-client";


const endpoint = {
    loginreq: '/login/loginUser',
    registerreq: '/login/registerUser'
};



function loginUser(login, callback){
    let request = new Request(HOST.backend_api + endpoint.loginreq , {
        method: 'POST',
        headers : {
            'Accept': 'application/json',
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(login)
    });

    console.log("api URL: " + request.url);
    RestApiClient.performRequest(request, callback)
}

function registerUser(login, callback){
    let request = new Request(HOST.backend_api + endpoint.registerreq, {
        method: 'POST',
        headers : {
            'Accept': 'application/json',
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(login)
    });

    console.log("api URL: " + request.url);
    RestApiClient.performRequest(request, function() {
    	console.log("Request done!")
    	return "SUCCESS";
    });
}

export {
    loginUser,
    registerUser
};
