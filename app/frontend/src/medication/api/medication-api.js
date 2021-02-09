import {HOST} from '../../commons/hosts';
import RestApiClient from "../../commons/api/rest-client";


const endpoint = {
	postreq: '/medicationSD/insertMedicationSD',
    medication: '/medicationSD/getMedicationSDs',
    updatereq: '/medicationSD/updateMedicationSD/',
    deleq: '/medicationSD/deleteMedicationSD/'
};

function getMedications(callback) {
    let request = new Request(HOST.backend_api + endpoint.medication, {
        method: 'GET',
    });
    console.log(request.url);
    RestApiClient.performRequest(request, callback);
}

function getMedicationById(params, callback){//
    let request = new Request(HOST.backend_api + endpoint.medication + params.id, {
       method: 'GET'
    });

    console.log(request.url);
    RestApiClient.performRequest(request, callback);
}

function deleteMedicationById(params, callback){//
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

function postMedication(user, callback){
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

function updateMedication(medication, callback){
    let request = new Request(HOST.backend_api + endpoint.updatereq, {
        method: 'POST',
        headers : {
            'Accept': 'application/json',
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(medication)
    });

    console.log("URL: " + request.url);
    RestApiClient.performRequest(request, function() {
    	console.log("Request done!")
    	return "SUCCES";
    });
}

export {
    getMedications,
    getMedicationById,
    postMedication,
    updateMedication,
    deleteMedicationById
};
