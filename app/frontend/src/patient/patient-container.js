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
import PatientForm from "./components/patient-form";
import * as API_USERS from "./api/patient-api"
import PatientTable from "./components/patient-table";



class PatientContainer extends React.Component {

    constructor(props) {
        super(props);
        this.toggleForm = this.toggleForm.bind(this);
        this.reload = this.reload.bind(this);
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
        this.fetchPatients();
    }

    fetchPatients() {
        return API_USERS.getPatients((result, status, err) => {
            if (result !== null && status === 200) {
                this.setState({
                    tableData: result,
                    isLoaded: true
                });
            } else {
                this.setState(({
                    errorStatus: status,
                    error: err
                }));
            }
        });
    }

    toggleForm() {
        this.setState({selected: !this.state.selected});
    }


    reload() {
        this.setState({
            isLoaded: false
        });
        this.toggleForm();
        this.fetchPatients();
    }

    insertForm = ()=>{
    	this.formType="insert";
    	this.toggleForm();
    }
    
    deleteForm = ()=>{
    	this.formType="delete";
    	this.toggleForm();
    }
    
    updateForm = ()=>{
    	this.formType="update";
    	this.toggleForm();
    }
    
    render() {
        return (
            <div>
                <CardHeader>
                    <strong> Patient Management </strong>
                </CardHeader>
                <Card>
                    <br/>
                    <Row>
                        <Col sm={{size: '8', offset: 1}}>
                            <Button id='insrt' color="primary" onClick={this.insertForm}>Insert Patient </Button>
                            <Button id='dlt' color="primary" onClick={this.deleteForm}>Delete Patient </Button>
                            <Button id='uptd' color="primary" onClick={this.updateForm}>Update Patient </Button>
                        </Col>
                    </Row>
                    <br/>
                    <Row>
                        <Col sm={{size: '8', offset: 1}}>
                            {this.state.isLoaded && <PatientTable tableData = {this.state.tableData}/>}
                            {this.state.errorStatus > 0 && <APIResponseErrorMessage
                                                            errorStatus={this.state.errorStatus}
                                                            error={this.state.error}
                                                        />   }
                        </Col>
                    </Row>
                </Card>

                <Modal isOpen={this.state.selected} toggle={this.toggleForm}
                       className={this.props.className} size="lg">
                    <ModalHeader toggle={this.toggleForm}> Patient: </ModalHeader>
                    <ModalBody>
                        <PatientForm formType={this.formType} reloadHandler={this.reload}/>
                    </ModalBody>
                </Modal>
            </div>
        )

    }
}


export default PatientContainer;
