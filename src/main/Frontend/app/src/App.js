import React, { useState } from 'react';
import ReactDOM from 'react-dom';
import axios from 'axios';
import { makeStyles } from '@material-ui/core/styles';
import Table from '@material-ui/core/Table';
import Button from '@material-ui/core/Button';
import TableBody from '@material-ui/core/TableBody';
import TableCell from '@material-ui/core/TableCell';
import TableContainer from '@material-ui/core/TableContainer';
import TableHead from '@material-ui/core/TableHead';
import TableRow from '@material-ui/core/TableRow';
import Paper from '@material-ui/core/Paper';

//class App extends React.Component {

const useStyles = makeStyles({
    table: {
        minWidth: 650,
    },
});

function createData(name, calories, fat, carbs, protein) {
    return { name, calories, fat, carbs, protein };
}

     function App() {
         const [tasks, setTask]= useState(null);
       const fetchData = async () => {
           const response = await axios.get(
               'http://localhost:8080/api/tasks'
           );
           setTask(response.data);
       };
         const classes = useStyles();
         return (
             <div className="App">

                 {/* Fetch data from API */}
                 <div>
                     <Button variant="containd" className="employee-button" onClick={fetchData}>
                         Сотрудники
                     </Button>
                     <Button variant="containd" className="fetch-button" onClick={fetchData}>
                         Задачи
                     </Button>
                 </div>

                 {/* Display data from API */}
                 <TableContainer component={Paper}>
                     <Table className={classes.table} aria-label="simple table">
                         <TableHead>
                             <TableRow>
                                 <TableCell>Task description</TableCell>
                                 <TableCell align="right">Task priotity</TableCell>
                                 <TableCell align="right">Task performer</TableCell>
                             </TableRow>
                         </TableHead>
                         <TableBody>
                     {tasks &&
                     tasks.map((task, index) => (
                         <TableRow key={task.taskId}>
                             <TableCell component="th" scope="row">
                                 {task.taskDescription}
                             </TableCell>
                             <TableCell align="right">{task.taskPriority}</TableCell>
                             <TableCell align="right">{task.employee.fullName}</TableCell>
                         </TableRow>
                     ))}
                         </TableBody>
                     </Table>
                 </TableContainer>
             </div>
         );
     }


//}
const rootElement = document.getElementById('root');
ReactDOM.render(<App />, rootElement);

export default App;
