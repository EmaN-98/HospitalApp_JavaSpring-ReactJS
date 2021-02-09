import {HOST} from '../../commons/hosts';
import RestApiClient from "../../commons/api/rest-client";


const endpoint = {
	postreq: '/caregiver/insertCaregiver',
    caregiver: '/caregiver/getCaregivers',
    updatereq: '/caregiver/updateCaregiver/',
    deleq: '/caregiver/deleteCaregiver/'
};

function getCaregivers(callback) {
    let request = new Request(HOST.backend_api + endpoint.caregiver, {
        method: 'GET',
    });
    console.log(request.url);
    RestApiClient.performRequest(request, callback);
}

function getCaregiverById(params, callback){//
    let request = new Request(HOST.backend_api + endpoint.caregiver + params.id, {
       method: 'GET'
    });

    console.log(request.url);
    RestApiClient.performRequest(request, callback);
}

function deleteCaregiverById(params, callback){//
	let delParam = {"id": params.id}
    let request = new Request(HOST.backend_api + endpoint.deleq, {
       method: 'DELETE',
	   headers : {
           'Accept': 'application/json',
           'Content-Type': 'application/json',
       },
       body: JSON.stringify(delParam)
    });

    console.log(request.url);
    RestApiClient.performRequest(request, function() {
    	console.log("Delete Succesfull")
    	return 0;
    });
}

function postCaregiver(user, callback){
    let request = new Request(HOST.backend_api + endpoint.postreq , {
        method: 'POST',
        headers : {
            'Accept': 'application/json',
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(user)
    });

    console.log("URL: " + request.url);

    RestApiClient.performRequest(request, callback);
}

function updateCaregiver(caregiver, callback){
    let request = new Request(HOST.backend_api + endpoint.updatereq, {
        method: 'POST',
        headers : {
            'Accept': 'application/json',
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(caregiver)
    });

    console.log("URL: " + request.url);
    RestApiClient.performRequest(request, function() {
    	console.log("Request done!")
    	return "SUCCES";
    });
}

export {
    getCaregivers,
    getCaregiverById,
    postCaregiver,
    updateCaregiver,
    deleteCaregiverById
};
