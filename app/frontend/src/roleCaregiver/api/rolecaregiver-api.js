import {HOST} from '../../commons/hosts';
import RestApiClient from "../../commons/api/rest-client";


const endpoint = {
	
    patient: '/caregiver/getPatientsForCaregiver'
};

function getPatientsForCaregiver(callback) {
    let request = new Request(HOST.backend_api + endpoint.patient, {
        method: 'GET',
    });
    console.log(request.url);
    RestApiClient.performRequest(request, callback);
}



export {
	getPatientsForCaregiver
};
