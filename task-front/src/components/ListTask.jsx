import { Grid } from "@mui/joy";
import Task from "./Task";

const ListTask = ({ list }) => {
    if (!list || !Array.isArray(list.tasks)) {
        console.warn("list o list.tasks no son válidos:", list);
        return null; // o un mensaje de error si prefieres
    }

    return (
        <Grid sx={{
            backgroundColor: 'white',
            margin: '30px'
        }}>
            {list.tasks.map((t, i) => (
                <Task key={i} task={t} />
            ))}
        </Grid>
    );
};

export default ListTask;