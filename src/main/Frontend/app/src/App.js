import React, { useState, useEffect } from 'react';
import { forwardRef } from 'react';
import Grid from '@material-ui/core/Grid'
import ViewColumn from '@material-ui/icons/ViewColumn';
import MaterialTable from "material-table";
import AddBox from '@material-ui/icons/AddBox';
import {Button} from "@material-ui/core";
import axios from 'axios'

function App() {

    const [data, setData] = useState([]); //table data

    //const [iserror, setIserror] = useState(false)
    //const [errorMessages, setErrorMessages] = useState([])


    var columns = [
        {title: "id", field: "taskId", hidden: true},
        {title: "Task description", field: "taskDescription"},
        {title: "priority", field: "taskPriority"},
        {title: "employee", field: "employee.fullName"}
    ];
    const api = axios.create({
        baseURL: `http://localhost:8080/api`
    })


    useEffect(() => {
        api.get("/tasks")
            .then(res => {
                setData(res.data)
            })
    }, [])

    const handleRowUpdate = (newData, oldData, resolve) => {
        //validation

            api.patch("/users/"+newData.id, newData)
                .then(res => {
                    const dataUpdate = [...data];
                    const index = oldData.tableData.id;
                    dataUpdate[index] = newData;
                    setData([...dataUpdate]);
                    resolve()

                })
                .catch(error => {

                    resolve()

                })



    }


    const handleRowAdd = (newData, resolve) => {
        //validation
            api.post("/users", newData)
                .then(res => {
                    let dataToAdd = [...data];
                    dataToAdd.push(newData);
                    setData(dataToAdd);
                    resolve()
                })
                .catch(error => {

                    resolve()
                })


    }

    const handleRowDelete = (oldData, resolve) => {

        api.delete("/tasks/delete"+oldData.id)
            .then(res => {
                const dataDelete = [...data];
                const index = oldData.tableData.id;
                dataDelete.splice(index, 1);
                setData([...dataDelete]);
                resolve()
            })
            .catch(error => {

                resolve()
            })
    }

    const fetchData = async () => {

    };
    return (
            <div >
                <div battons>
                    <div>
                        <Button variant="containd" className="employee-button" onClick={fetchData}>
                            Сотрудники
                        </Button>
                        <Button variant="containd" className="fetch-button" onClick={fetchData}>
                            Задачи
                        </Button>
                    </div>
                </div>
                <MaterialTable title="Задаачи"
                               columns={columns}
                               data={data}
                               editable={{
                                   onRowUpdate: (newData, oldData) =>
                                       new Promise((resolve) => {
                                           handleRowUpdate(newData, oldData, resolve);
                                       }),
                                   onRowAdd: (newData) =>
                                       new Promise((resolve) => {
                                           handleRowAdd(newData, resolve)
                                       }),
                                   onRowDelete: (oldData) =>
                                       new Promise((resolve) => {
                                           handleRowDelete(oldData, resolve)
                                       }),
                               }}
                />
            </div>
        );

}
//}


export default App;
