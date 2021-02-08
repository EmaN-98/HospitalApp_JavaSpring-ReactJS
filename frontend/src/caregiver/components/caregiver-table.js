import React from "react";
import Table from "../../commons/tables/table";


const columns = [
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
        Header: 'Role',
        accessor: 'role',
    }
];

const filters = [
    {
        accessor: 'name',
    }
];

class CaregiverTable extends React.Component {

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

export default CaregiverTable;