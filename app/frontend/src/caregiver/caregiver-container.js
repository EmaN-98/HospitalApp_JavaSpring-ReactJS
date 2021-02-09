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
import CaregiverForm from "./components/caregiver-form";
import * as API_USERS from "./api/caregiver-api"
import CaregiverTable from "./components/caregiver-table";



class CaregiverContainer extends React.Component {

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
        this.fetchCaregivers();
    }

    fetchCaregivers() {
        return API_USERS.getCaregivers((result, status, err) => {

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
        this.fetchCaregivers();
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
                    <strong> Caregiver Management </strong>
                </CardHeader>
                <Card>
                    <br/>
                    <Row>
                        <Col sm={{size: '8', offset: 1}}>
                            <Button color="primary" onClick={this.insertForm}>Insert Caregiver </Button>
                            <Button color="primary" onClick={this.deleteForm}>Delete Caregiver </Button>
                            //<Button color="primary" onClick={this.toggleForm}>Get Caregiver </Button>
                            //<Button color="primary" onClick={this.toggleForm}>Get Caregivers </Button>
                            <Button color="primary" onClick={this.updateForm}>Update Caregiver </Button>
                        </Col>
                    </Row>
                    <br/>
                    <Row>
                        <Col sm={{size: '8', offset: 1}}>
                            {this.state.isLoaded && <CaregiverTable tableData = {this.state.tableData}/>}
                            {this.state.errorStatus > 0 && <APIResponseErrorMessage
                                                            errorStatus={this.state.errorStatus}
                                                            error={this.state.error}
                                                        />   }
                        </Col>
                    </Row>
                </Card>

                <Modal isOpen={this.state.selected} toggle={this.toggleForm}
                       className={this.props.className} size="lg">
                    <ModalHeader toggle={this.toggleForm}> Caregiver: </ModalHeader>
                    <ModalBody>
                        <CaregiverForm formType={this.formType} reloadHandler={this.reload}/>
                    </ModalBody>
                </Modal>
                
                
            </div>
        )

    }
}


export default CaregiverContainer;
