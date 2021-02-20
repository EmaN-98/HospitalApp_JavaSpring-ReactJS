import {HOST} from '../../commons/hosts';
import RestApiClient from "../../commons/api/rest-client";


const endpoint = {
	
    patient: '/patient/getDetailsForPatient'
};


function getDetailsForPatient(params, callback) {
	let name = localStorage.getItem('name');
    let request = new Request(HOST.backend_api + endpoint.patient + "/" + name, {
        method: 'GET',
    });
    RestApiClient.performRequest(request, callback)
}



export {
	getDetailsForPatient
};
