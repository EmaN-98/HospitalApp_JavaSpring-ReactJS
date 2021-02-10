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
import LoginForm from "./components/login-form";
import * as API_USERS from "./api/login-api"



class LoginContainer extends React.Component {

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
        //this.fetchLogins();
    }

//    fetchLogins() {
//        return API_USERS.getLogins((result, status, err) => {
//
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
//    }

    toggleForm() {
        this.setState({selected: !this.state.selected});
    }


    reload() {
        this.setState({
            isLoaded: false
        });
        this.toggleForm();
        //this.fetchLogins();
    }

    insertForm = ()=>{
    	this.formType="login";
    	this.toggleForm();
    }
    
    deleteForm = ()=>{
    	this.formType="register";
    	this.toggleForm();
    }
    
    render() {
        return (
            <div>
                <CardHeader>
                    <strong> Login Management </strong>
                </CardHeader>
                <Card>
                    <br/>
                    <Row>
                        <Col sm={{size: '8', offset: 1}}>
                            <Button id='loginBtn' color="primary" onClick={this.insertForm}>Login User </Button>
                            <Button id='registerBtn' color="primary" onClick={this.deleteForm}>Register User </Button>
                            
                        </Col>
                    </Row>
                    
                </Card>

                <Modal isOpen={this.state.selected} toggle={this.toggleForm}
                       className={this.props.className} size="lg">
                    <ModalHeader toggle={this.toggleForm}> Login: </ModalHeader>
                    <ModalBody>
                        <LoginForm formType={this.formType} reloadHandler={this.reload}/>
                    </ModalBody>
                </Modal>
            </div>
        )

    }
}


export default LoginContainer;
