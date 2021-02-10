import {HOST} from '../../commons/hosts';
import RestApiClient from "../../commons/api/rest-client";


const endpoint = {
	postreq: '/patient/insertPatient',
    patient: '/patient/getPatients',
    updatereq: '/patient/updatePatient/',
    deleq: '/patient/deletePatient/'
};

function getPatients(callback) {
    let request = new Request(HOST.backend_api + endpoint.patient, {
        method: 'GET',
    });
    console.log(request.url);
    RestApiClient.performRequest(request, callback);
}

function getPatientById(params, callback){//
    let request = new Request(HOST.backend_api + endpoint.patient + params.id, {
       method: 'GET'
    });

    console.log(request.url);
    RestApiClient.performRequest(request, callback);
}

function deletePatientById(params, callback){//
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
    	console.log("Delete Successfulll")
    	return 0;
    });
}

function postPatient(user, callback){
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

function updatePatient(patient, callback){
    let request = new Request(HOST.backend_api + endpoint.updatereq, {
        method: 'POST',
        headers : {
            'Accept': 'application/json',
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(patient)
    });

    console.log("URL: " + request.url);
    RestApiClient.performRequest(request, function() {
    	console.log("Request done!")
    	return "SUCCES";
    });
}

export {
    getPatients,
    getPatientById,
    postPatient,
    updatePatient,
    deletePatientById
};
