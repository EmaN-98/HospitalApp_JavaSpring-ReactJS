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
import * as API_USERS from "./api/rolecaregiver-api"
import RolecaregiverTable from "./components/rolecaregiver-table";
//import RolecaregiverForm from "./components/rolecaregiver-form";



class RolecaregiverContainer extends React.Component {

    constructor(props) {
        super(props);
      //  this.toggleForm = this.toggleForm.bind(this);
        this.reload = this.reload.bind(this);
        this.formType="rolecaregiver"
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
        this.fetchRolecaregivers();
    }

    fetchRolecaregivers() {
    	let name = localStorage.getItem("name")

    	let currentConstr = this;
    	return API_USERS.getPatientsForCaregiver(undefined, function(json, status, err) {
           console.log("DADA")
    		currentConstr.setState({
               tableData: json,
               isLoaded: true
           });
    	})
    }

//    toggleForm() {
//        this.setState({selected: !this.state.selected});
//    }


    reload() {
        this.setState({
            isLoaded: false
        });
       // this.toggleForm();
        this.fetchRolecaregivers();
    }

    
    
    render() {
        return (
            <div>
                <CardHeader>
                    <strong> Rolecaregiver Management </strong>
                </CardHeader>
                <Card>
        
                    <Row>
                        <Col sm={{size: '8', offset: 1}}>
                            {this.state.isLoaded && <RolecaregiverTable tableData = {this.state.tableData}/>}
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


export default RolecaregiverContainer;
