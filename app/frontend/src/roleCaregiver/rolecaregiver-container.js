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



class RolecaregiverContainer extends React.Component {

    constructor(props) {
        super(props);
        this.toggleForm = this.toggleForm.bind(this);
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
        return API_USERS.getPatientsForCaregiver((result, status, err) => {

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
        this.fetchRolecaregivers();
    }

    
    
    render() {
        return (
            <div>
                <CardHeader>
                    <strong> Rolecaregiver Management </strong>
                </CardHeader>
                <Card>
                    <br/>
//                    <Row>
//                        <Col sm={{size: '8', offset: 1}}>
//                            <Button id='insrt' color="primary" onClick={this.insertForm}>Insert Rolecaregiver </Button>
//                            <Button id='dlt' color="primary" onClick={this.deleteForm}>Delete Rolecaregiver </Button>
//                            <Button id='uptd' color="primary" onClick={this.updateForm}>Update Rolecaregiver </Button>
//                        </Col>
//                    </Row>
                    <br/>
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

                <Modal isOpen={this.state.selected} toggle={this.toggleForm}
                       className={this.props.className} size="lg">
                    <ModalHeader toggle={this.toggleForm}> Rolecaregiver: </ModalHeader>
                    <ModalBody>
                        <RolecaregiverForm formType={this.formType} reloadHandler={this.reload}/>
                    </ModalBody>
                </Modal>
            </div>
        )

    }
}


export default RolecaregiverContainer;
