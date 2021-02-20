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
//import { Redirect } from 'react-router'
import ReactDOM from 'react-dom';
import createRoutes from '../routes';

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
    	
    }
    
 //   ReactDOM.render(
//		    <Router history={browserHistory} routes={routes} />,
//		    document.getElementById('root')
//		);
    
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

    loginForm = ()=>{
    	this.formType="login";
    	this.toggleForm();
    	
    }
    
    registerForm = ()=>{
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
                            <Button id='loginBtn' color="primary" onClick={this.loginForm}>Login User </Button>
                            <Button id='registerBtn' color="primary" onClick={this.registerForm}>Register User </Button>
                            
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
