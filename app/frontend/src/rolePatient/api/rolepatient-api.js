import {HOST} from '../../commons/hosts';
import RestApiClient from "../../commons/api/rest-client";


const endpoint = {
	
    patient: '/patient/getDetailsForPatient'
};


function getDetailsForPatient(params, callback) {
    let request = new Request(HOST.backend_api + endpoint.patient + params.id, {
        method: 'GET',
    });
    console.log(request.url);
    RestApiClient.performRequest(request, callback);
}



export {
	getPatientsForCaregiver
};
