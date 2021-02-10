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



class RolepatientContainer extends React.Component {

    constructor(props) {
        super(props);
        this.toggleForm = this.toggleForm.bind(this);
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
        return API_USERS.getDetailsForPatient((result, status, err) => {

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
        this.fetchRolepatients();
    }

    
    
    render() {
        return (
            <div>
                <CardHeader>
                    <strong> Rolepatient Management </strong>
                </CardHeader>
                <Card>
                    <br/>
//                    <Row>
//                        <Col sm={{size: '8', offset: 1}}>
//                            <Button id='insrt' color="primary" onClick={this.insertForm}>Insert Rolepatient </Button>
//                            <Button id='dlt' color="primary" onClick={this.deleteForm}>Delete Rolepatient </Button>
//                            <Button id='uptd' color="primary" onClick={this.updateForm}>Update Rolepatient </Button>
//                        </Col>
//                    </Row>
                    <br/>
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

                <Modal isOpen={this.state.selected} toggle={this.toggleForm}
                       className={this.props.className} size="lg">
                    <ModalHeader toggle={this.toggleForm}> Rolepatient: </ModalHeader>
                    <ModalBody>
                        <RolepatientForm formType={this.formType} reloadHandler={this.reload}/>
                    </ModalBody>
                </Modal>
            </div>
        )

    }
}


export default RolepatientContainer;
