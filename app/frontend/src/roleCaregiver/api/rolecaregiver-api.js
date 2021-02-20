import {HOST} from '../../commons/hosts';
import RestApiClient from "../../commons/api/rest-client";


const endpoint = {
	
    patient: '/caregiver/getPatientsForCaregiver'
};

function getPatientsForCaregiver(params, callback) {
	let name = localStorage.getItem("name");
    let request = new Request(HOST.backend_api + endpoint.patient + "/" + name , {
        method: 'GET',
    });
    console.log(request.url);
    RestApiClient.performRequest(request, callback);
}



export {
	getPatientsForCaregiver
};
