import React from 'react';
import APIResponseErrorMessage from "../commons/errorhandling/api-response-error-message";
import {
    Button,
    Card,
    CardHeader,
    Col,
    Modal,
    ModalBody,
    ModalHeader,
    Row
} from 'reactstrap';
import * as API_USERS from "./api/rolepatient-api"
import RolepatientTable from "./components/rolepatient-table";

import RestApiClient from "../commons/api/rest-client";

class RolepatientContainer extends React.Component {

    constructor(props) {
        super(props);
        //this.toggleForm = this.toggleForm.bind(this);
        this.reload = this.reload.bind(this);
        this.formType="rolepatient"
        this.state = {
            selected: false,
            collapseForm: false,
            tableData: [],
            isLoaded: false,
            errorStatus: 0,
            error: null
        };
    }

    componentDidMount() {
        this.fetchRolepatients();
    }

    fetchRolepatients() {
    	let name = localStorage.getItem("name")
//    	this.setState({
//            tableData: [{"id":"2a119c13-cb18-4c3c-a5be-e78e48dda8ae","name":"p","birthdate":"p","gender":"p","address":"p","medical_record":"p","caregiverName":"p","doctorName":"p","role":"patient"}],
//            isLoaded: true
//        });
    	let currentConstr = this;
    	return API_USERS.getDetailsForPatient(undefined, function(json, status, err) {
           console.log("DADA")
    		currentConstr.setState({
               tableData: [json],
               isLoaded: true
           });
    	})
    	
    }
//        return API_USERS.getDetailsForPatient((result, status, err) => {
//        	console.log(result)
//            if (result !== null && status === 200) {
//                this.setState({
//                    tableData: result,
//                    isLoaded: true
//                });
//            } else {
//                this.setState(({
//                    errorStatus: status,
//                    error: err
//                }));
//            }
//        });

//    toggleForm() {
//        this.setState({selected: !this.state.selected});
//    }
//

    reload() {
        this.setState({
            isLoaded: false
        });
      //  this.toggleForm();
        this.fetchRolepatients();
    }

    
    
    render() {
        return (
            <div>
                <CardHeader>
                    <strong> Rolepatient Management </strong>
                </CardHeader>
                <Card>
                    
                    <Row>
                        <Col sm={{size: '8', offset: 1}}>
                            {this.state.isLoaded && <RolepatientTable tableData = {this.state.tableData}/>}
                            {this.state.errorStatus > 0 && <APIResponseErrorMessage
                                                            errorStatus={this.state.errorStatus}
                                                            error={this.state.error}
                                                        />   }
                        </Col>
                    </Row>
                </Card>



            </div>
        )

    }
}


export default RolepatientContainer;
