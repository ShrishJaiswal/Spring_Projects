import * as React from 'react';
import Box from '@mui/material/Box';
import TextField from '@mui/material/TextField';
import { Container , Paper} from '@mui/material';
import Button from '@mui/material/Button';
import { useState } from 'react';
import { useEffect } from 'react';

export default function BasicTextFields() {
    const paperStyle = {padding: "50px 20px", width:600, margin:"20px auto"};
    const[studentName,setName]=useState('')
    const[studentAddress,setAddress]=useState('')
    const[studentId,setStudentId]=useState('')
    const[students,setStudent]=useState([])

    const deleteHandleClick=(e)=>{
        e.preventDefault()
        const Id = {studentId}
        console.log(Id)

        fetch('http://localhost:7070/student/'+Id.studentId,{
            method:"DELETE"
        }).then(()=>{
            console.log("Deleted successfully")
        })
    }

    const handleClick=(e)=>{
        e.preventDefault()
        const student={studentName, studentAddress}
        console.log(student)

        fetch("http://localhost:7070/student", {
            method:"POST",
            headers:{"Content-Type":"application/json"},
            body:JSON.stringify(student)
        }).then(()=>{
            console.log("New Student Added")
        })
    }

    useEffect(()=>{
        fetch("http://localhost:7070/student")
        .then(res=>res.json())
        .then((result)=>{
            setStudent(result);
        })
    })

  return (
    <Container>
       <Paper elevation={3} style={paperStyle}>
    <Box
      component="form"
      sx={{
        '& > :not(style)': { m: 1},
      }}
      noValidate
      autoComplete="off"
    >

        <h1 style={{color:"blue"}}><u>Student Detail Form:-</u></h1>
        <TextField id="outlined-basic" label="Student Name" variant="outlined" fullWidth
        value={studentName}
        onChange={(e) => setName(e.target.value)}
        />
        <TextField id="outlined-basic" label="Student Address" variant="outlined" fullWidth
        value={studentAddress}
        onChange={(e) => setAddress(e.target.value)}        
        />
        <Button variant="contained" onClick={handleClick}>Submit</Button>
    </Box>
    </Paper>
    
    <Paper elevation={3} style={paperStyle}>
    <Box
      component="form"
      sx={{
        '& > :not(style)': { m: 1},
      }}
      noValidate
      autoComplete="off"
    >

        <h1 style={{color:"blue"}}><u>Delete Student Detail:-</u></h1>
        <TextField id="outlined-basic" label="Student Id" variant="outlined" fullWidth
        value={studentId}
        onChange={(e) => setStudentId(e.target.value)}
        />
        <Button variant="contained" onClick={deleteHandleClick}>Submit</Button>
    </Box>
    </Paper>

    <h1>Students</h1>

    <Paper elevation={3} style={paperStyle}>

      {students.map(student=>(
        <Paper elevation={6} style={{margin:"10px",padding:"15px", textAlign:"left"}} key={student.id}>
         Student Id : {student.studentId}<br/>
         Student Name : {student.studentName}<br/>
         Student Address : {student.studentAddress}

        </Paper>
      ))
}
    </Paper>
    </Container>
  );
}
