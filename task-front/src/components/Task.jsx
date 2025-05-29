import { Grid, Typography } from "@mui/joy";
import { useEffect, useState } from 'react';
import { Button } from "@mui/joy";
import useWebSocket from "../services/webSocketService";
import { putTask } from '../services/taskService';

const Task = ({ task }) => {
    const [currentTask, setCurrentTask] = useState(task); // usar la prop directamente

    const ws = useWebSocket((data) => {
        console.log(data);
        updateTask(data);
    });

    const updateTask = (updatedTask) => {
        setCurrentTask(updatedTask);
    };

    useEffect(() => {
        updateTask(task); 

        return () => {
            ws.close();
        };
    }, [task]); 

    return (
        <Grid sx={{ height: '50px', width: '100%' }}>
            <Typography>{currentTask?.name}</Typography>
            <Button
                onClick={() => {
                    if (!currentTask) return;
                    const updatedTask = {
                        id: currentTask.id,
                        name: currentTask.name,
                        description: currentTask.description,
                        notes: currentTask.notes,
                        priority: currentTask.priority,
                        listId: currentTask.listId - 1,
                    };
                    console.log(updatedTask)
                    putTask(updatedTask);
                }}
            >
                Anterior
            </Button>
        </Grid>
    );
};

export default Task;