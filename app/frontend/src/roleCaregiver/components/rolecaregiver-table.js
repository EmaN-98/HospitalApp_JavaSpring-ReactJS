import React from "react";
import Table from "../../commons/tables/table";


const columns = [
	{
        Header: 'ID',
        accessor: 'id',
    },
    {
        Header: 'Name',
        accessor: 'name',
    },
    {
        Header: 'Birthdate',
        accessor: 'birthdate',
    },
    {
        Header: 'Gender',
        accessor: 'gender',
    },
    {
        Header: 'Address',
        accessor: 'address',
    },
    {
        Header: 'Medical_record',
        accessor: 'medical_record',
    },
    {
        Header: 'CaregiverName',
        accessor: 'caregiverName',
    },
    {
        Header: 'DoctorName',
        accessor: 'doctorName',
    },
    {
        Header: 'Role',
        accessor: 'role',
    }
];

const filters = [
    {
        accessor: 'name',
    }
];

class PatientTable extends React.Component {

    constructor(props) {
        super(props);
        this.state = {
            tableData: this.props.tableData
        };
    }

    render() {
        return (
            <Table
            	data={this.state.tableData}
            	columns={columns}
            	search={filters}
            	pageSize={5}
            />
        )
    }
}

export default PatientTable;