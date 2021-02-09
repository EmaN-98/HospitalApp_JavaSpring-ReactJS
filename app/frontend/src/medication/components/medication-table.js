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
        Header: 'SideEffects',
        accessor: 'sideEffects',
    },
    {
        Header: 'Dosage',
        accessor: 'dosage',
    },
    {
        Header: 'Intake_interval',
        accessor: 'intake_interval',
    }
   
];

const filters = [
    {
        accessor: 'name',
    }
];

class MedicationTable extends React.Component {

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

export default MedicationTable;