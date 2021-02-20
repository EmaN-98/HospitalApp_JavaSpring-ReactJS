import React from 'react'
import logo from './commons/images/icon.png';

import {
    DropdownItem,
    DropdownMenu,
    DropdownToggle,
    Nav,
    Navbar,
    NavbarBrand,
    NavLink,
    UncontrolledDropdown
} from 'reactstrap';
const textStyle = {
    color: 'white',
    textDecoration: 'none'
};

const isDoctorType = function() {
	let typeData = localStorage.getItem('type');
	if(typeData === 'doctor') {
		return true;
	}
	return false;
}


const NavigationBar = () => (
    <div>
        <Navbar color="dark" light expand="md">
            <NavbarBrand href="/">
                <img src={logo} alt="tag" width={"50"}
                     height={"35"} />
            </NavbarBrand>
            <Nav className="mr-auto" navbar>

                <UncontrolledDropdown nav inNavbar>
                    <DropdownToggle style={textStyle} nav caret>
                       Menu
                    </DropdownToggle>
                    <DropdownMenu right >

                    
                        <DropdownItem>
                            <NavLink href="/person">Persons</NavLink>
                        </DropdownItem>
                        
                        <DropdownItem>
                        	<NavLink href="/caregiver">Caregivers</NavLink>
                        </DropdownItem>
                        
                        <DropdownItem>
                    		<NavLink href="/patient">Patients</NavLink>
                    	</DropdownItem>
                    	
                    	<DropdownItem>
                			<NavLink href="/medication">Medication</NavLink>
                		</DropdownItem>
                    </DropdownMenu>
                </UncontrolledDropdown>

            </Nav>
        </Navbar>
    </div>
);

export default NavigationBar
